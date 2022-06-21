package controller;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.FileInputStream;

import javax.imageio.ImageIO;

import model.Image;
import model.ImageImpl;
import model.Pixel;
import model.PixelImpl;


/**
 * This class contains utility methods to read a PPM image from file and simply print its contents.
 * Feel free to change this method as required.
 */
public class ImageUtil {

  /**
   * Turns an Image to a Java Image.
   * @param image the Image to turn into a Java Image
   * @return a Image from java.awt.Image
   */
  public static java.awt.Image imageToImage(Image image) {
    return imageToBufferedImage(image);
  }

  /**
   * Read an image from the given filePath.
   * @param filePath the path to use to read the image
   * @return an Image representing the image read.
   * @throws IOException if the image's extension is not supported
   */
  public static Image readImage(String filePath) throws IOException {
    String extension = "";

    int i = filePath.lastIndexOf('.');
    if (i > 0) {
      extension = filePath.substring(i + 1);
    }

    switch (extension) {
      case "ppm":
        return readPPM(filePath);
      case "jpg":
      case "jpeg":
      case "png":
      case "bmp":
        return readJpgPngBmp(filePath);
      default:
        throw new IOException("Image type not supported. Image must have a PPM, JPG, JPEG, PNG," +
                " or BMP extension.");
    }
  }

  /**
   * Save the given image to the given filepath.
   *
   * @param filePath the location to save the given image
   * @param image    the image to save
   * @throws IOException if the image extension is not supported
   */
  public static void saveImage(String filePath, Image image) throws IOException {
    String extension = "";

    int i = filePath.lastIndexOf('.');
    if (i > 0) {
      extension = filePath.substring(i + 1);
    }

    switch (extension) {
      case "ppm":
        writePPM(filePath, image);
        break;
      case "jpg":
        ImageIO.write(imageToBufferedImage(image), "jpg", new File(filePath));
        break;
      case "jpeg":
        ImageIO.write(imageToBufferedImage(image), "jpeg", new File(filePath));
        break;
      case "png":
        ImageIO.write(imageToBufferedImage(image), "png", new File(filePath));
        break;
      case "bmp":
        ImageIO.write(imageToBufferedImage(image), "bmp", new File(filePath));
        break;
      default:
        throw new IOException("Image type not supported. Image must have a PPM, JPG, JPEG, PNG,"
                + " or BMP extension.");
    }
  }

  // Reads a JPG, JPEG, PNG, or BMP file from the given filepath and returns
  // an ImageImpl representation of the image.
  // throws IOException if the filepath is invalid
  private static Image readJpgPngBmp(String filePath) throws IOException {

    BufferedImage bufferedImage = ImageIO.read(new File(filePath));
    List<List<Pixel>> pixels = new ArrayList<>();

    for (int r = 0; r < bufferedImage.getHeight(); r++) {
      List<Pixel> row = new ArrayList<>();
      for (int c = 0; c < bufferedImage.getWidth(); c++) {
        Color color = new Color(bufferedImage.getRGB(c, r));
        Pixel pixelToAdd = new PixelImpl(
                color.getRed(), color.getGreen(), color.getBlue(), 255);
        row.add(pixelToAdd);
      }
      pixels.add(row);
    }
    return new ImageImpl(pixels, 255);
  }

  /**
   * Read an image file in the PPM format and print the colors.
   *
   * @param filePath the path of the file.
   * @return the image
   * @throws FileNotFoundException if the filename could not be found
   */
  private static Image readPPM(String filePath) throws FileNotFoundException {
    Scanner sc;

    sc = new Scanner(new FileInputStream(filePath));

    StringBuilder builder = new StringBuilder();
    // read the file line by line, and populate a string. This will throw away any comment lines
    while (sc.hasNextLine()) {
      String s = sc.nextLine();
      if (s.charAt(0) != '#') {
        builder.append(s + System.lineSeparator());
      }
    }

    //now set up the scanner to read from the string we just built
    sc = new Scanner(builder.toString());

    String token;

    token = sc.next();
    if (!token.equals("P3")) {
      System.out.println("Invalid PPM file: plain RAW file should begin with P3");
    }
    int width = sc.nextInt();
    // System.out.println("Width of image: " + width);
    int height = sc.nextInt();
    // System.out.println("Height of image: " + height);
    int maxValue = sc.nextInt();
    // System.out.println("Maximum value of a color in this file (usually 255): " + maxValue);

    // initialize image's list of list of pixels
    List<List<Pixel>> imageArrayList = new ArrayList<>();
    for (int i = 0; i < height; i++) {
      List<Pixel> row = new ArrayList<>();
      for (int j = 0; j < width; j++) {
        int r = sc.nextInt();
        int g = sc.nextInt();
        int b = sc.nextInt();
        row.add(new PixelImpl(r, g, b, maxValue));
        // System.out.println("Color of pixel (" + j + "," + i + "): " + r + "," + g + "," + b);
      }
      imageArrayList.add(row);
    }
    return new ImageImpl(imageArrayList, maxValue);
  }


  // helper method to turn an image into PPM format
  private static void writePPM(String filePath, Image image) throws IOException {
    StringBuilder fileString = new StringBuilder();
    fileString.append("P3 ");
    fileString.append(image.getWidth()).append(" ");
    fileString.append(image.getHeight()).append(" ");
    fileString.append(image.getMaxValue()).append("\n");
    for (int i = 0; i < image.getHeight(); i++) {
      for (int j = 0; j < image.getWidth(); j++) {
        Pixel p = image.getPixel(i, j);
        fileString.append(p.getRed()).append(" ");
        fileString.append(p.getGreen()).append(" ");
        fileString.append(p.getBlue()).append(" ");
      }
      fileString.append("\n");
    }
    BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
    writer.write(fileString.toString());
    writer.close();
  }

  // helper method to turn an Image into a BufferedImage
  private static BufferedImage imageToBufferedImage(Image image) {
    BufferedImage bufferedImage =
            new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_RGB);
    for (int r = 0; r < bufferedImage.getHeight(); r++) {
      for (int c = 0; c < bufferedImage.getWidth(); c++) {
        Pixel pixel = image.getPixel(r, c);
        bufferedImage.setRGB(c, r,
                new Color(pixel.getRed(), pixel.getGreen(), pixel.getBlue()).getRGB());
      }
    }
    return bufferedImage;
  }

}

