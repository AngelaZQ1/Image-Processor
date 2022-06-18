package model;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import model.filters.FilterImpl;

/**
 * This class represents an implementation of the Image interface. It offers ways to visualize
 * and manipulate an image such as grayscaling, flipping, brightening, darkening, and applying
 * filters.
 */
public class ImageImpl implements Image {
  private final List<List<Pixel>> image;
  private final int numCols;
  private final int numRows;
  private final int maxValue;

  /**
   * Creates an ImageImpl object with the given image and max value of the image's channels.
   *
   * @param image    the given image to use
   * @param maxValue the max value of any channel
   */
  public ImageImpl(List<List<Pixel>> image, int maxValue) {
    this.image = image;
    this.numRows = image.size();
    this.numCols = image.get(0).size();
    this.maxValue = maxValue;
  }

  // helper method for visualizing images in grayscale by applying the given filter to
  // each pixel
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
    return visualizeHelper(p -> new FilterImpl().filterRed(p));
  }

  @Override
  public Image visualizeGreenChannel() {
    return visualizeHelper(p -> new FilterImpl().filterGreen(p));
  }

  @Override
  public Image visualizeBlueChannel() {
    return visualizeHelper(p -> new FilterImpl().filterBlue(p));
  }

  @Override
  public Image visualizeValue() {
    return visualizeHelper(p -> new FilterImpl().filterValue(p));
  }

  @Override
  public Image visualizeIntensity() {
    return visualizeHelper(p -> new FilterImpl().filterIntensity(p));
  }

  @Override
  public Image visualizeLuma() {
    return visualizeHelper(p -> new FilterImpl().filterLuma(p));
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
  public Image brighten(int value) {
    return visualizeHelper(p -> p.changeColor(value, value, value));
  }

  @Override
  public Image darken(int value) {
    return visualizeHelper(p -> p.changeColor(-value, -value, -value));
  }

  // helper method for abstracting filtering methods that use a kernel
  // takes in a kernel to use on each pixel and returns a new filtered Image
  private Image filterHelper(double[][] kernel) {
    List<List<Pixel>> newImage = new ArrayList<>();
    for (int row = 0; row < this.image.size(); row++) {

      List<Pixel> newRow = new ArrayList<>();
      for (int col = 0; col < this.image.get(row).size(); col++) {
        // apply the new filter to each pixel
        newRow.add(new FilterImpl().applyKernelToPixel(this, kernel, row, col));
      }
      newImage.add(newRow);
    }
    return new ImageImpl(newImage, maxValue);
  }

  @Override
  public Image blur() {
    double[][] blurKernel = {{1.0 / 16, 1.0 / 8, 1.0 / 16},
        {1.0 / 8, 1.0 / 4, 1.0 / 8},
        {1.0 / 16, 1.0 / 8, 1.0 / 16}};
    return filterHelper(blurKernel);
  }

  @Override
  public Image sharpen() {
    double[][] sharpenKernel = {{-1.0 / 8, -1.0 / 8, -1.0 / 8, -1.0 / 8, -1.0 / 8},
        {-1.0 / 8, 1.0 / 4, 1.0 / 4, 1.0 / 4, -1.0 / 8},
        {-1.0 / 8, 1.0 / 4, 1.0, 1.0 / 4, -1.0 / 8},
        {-1.0 / 8, 1.0 / 4, 1.0 / 4, 1.0 / 4, -1.0 / 8},
        {-1.0 / 8, -1.0 / 8, -1.0 / 8, -1.0 / 8, -1.0 / 8}};
    return filterHelper(sharpenKernel);
  }

  @Override
  public Image grayscaleColorTransform() {
    return visualizeHelper(p -> new FilterImpl().filterGrey(p));
  }

  @Override
  public Image sepia() {
    return visualizeHelper(p -> new FilterImpl().sepia(p));
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
