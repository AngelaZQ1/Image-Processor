package model;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * This class represents an implementation of the Image interface. It offers ways to visualize
 * and manipulate an image.
 */
public class ImageImpl implements Image {
  private List<List<Pixel>> image;
  private int numCols;
  private int numRows;
  private final int maxValue;

  /**
   * Creates an ImageImpl object with the given image and max value of the image's channels.
   * @param image the given image to use
   * @param maxValue the max value of any channel
   */
  public ImageImpl(List<List<Pixel>> image, int maxValue) {
    this.image = image;
    this.numRows = image.size();
    this.numCols = image.get(0).size();
    this.maxValue = maxValue;
  }

  // helper method for visualizing images in grayscale.
  // Takes in a function that changes the channels of a pixel
  private Image visualizeHelper(Function<Pixel, Pixel> func) {
    List<List<Pixel>> newImage = new ArrayList<>();
    for (List<Pixel> row : image) {
      List<Pixel> newRow = new ArrayList<>();
      for (Pixel p : row) {
        newRow.add(func.apply(p));
      }
      newImage.add(newRow);
    }
    return new ImageImpl(newImage, maxValue);
  }

  @Override
  public Image visualizeRedChannel() {
    return visualizeHelper((pixel -> pixel.redScale()));
  }

  @Override
  public Image visualizeGreenChannel() {
    return visualizeHelper((pixel -> pixel.greenScale()));
  }

  @Override
  public Image visualizeBlueChannel() {
    return visualizeHelper((pixel -> pixel.blueScale()));
  }

  @Override
  public Image visualizeValue() {
    return visualizeHelper((pixel -> pixel.value()));
  }

  @Override
  public Image visualizeIntensity() {
    return visualizeHelper((pixel -> pixel.intensity()));
  }

  @Override
  public Image visualizeLuma() {
    return visualizeHelper((pixel -> pixel.luma()));
  }

  @Override
  public Image flipImageVertically() {
    List<List<Pixel>> newImage = new ArrayList<>();
    for (int i = 1; i <= numRows; i++) {
      newImage.add(image.get(numRows - i));
    }
    return new ImageImpl(newImage, maxValue);
  }

  @Override
  public Image flipImageHorizontally() {
    List<List<Pixel>> newImage = new ArrayList<>();
    for (int i = 0; i < numRows; i++) {
      List<Pixel> newRow = new ArrayList<>();
      for (int j = 1; j <= numCols; j++) {
        newRow.add(image.get(i).get(numCols - j));
      }
      newImage.add(newRow);
    }
    return new ImageImpl(newImage, maxValue);
  }

  @Override
  public Image brightenImage(int value) {
    return visualizeHelper(p -> p.changeColor(value, value, value));
  }

  @Override
  public Image darkenImage(int value) {
    return visualizeHelper(p -> p.changeColor(-value, -value, -value));
  }

  public Image blur() {
    // TODO blur
    return null;
  }

  public Image sharpen() {
    // TODO sharpen
    return null;
  }

  public Image grayscaleColorTransform(double red, double green, double blue) {
    return visualizeHelper(p -> p.grayscaleColorTransform(red, green, blue));
  }

  @Override
  public int getWidth() {
    return numCols;
  }

  @Override
  public int getHeight() {
    return numRows;
  }

  @Override
  public int getMaxValue() {
    return maxValue;
  }

  @Override
  public Pixel getPixel(int row, int col) {
    List<Pixel> temp = image.get(row);
    return temp.get(col);
  }

}
