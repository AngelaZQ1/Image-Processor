package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * This class represents an implementation of the Image interface. It offers ways to visualize
 * and manipulate an image.
 */
public class ImageImpl implements Image {
  private List<List<Pixel>> image;
  private int numCols;
  private int numRows;
  private int maxValue;

  public ImageImpl(List<List<Pixel>> image, int maxValue) {
    this.image = image;
    this.numRows = image.size();
    this.numCols = image.get(0).size();
    this.maxValue = maxValue;
  }

  // TODO abstract these
  @Override
  public Image visualizeRedChannel() {
    List<List<Pixel>> newImage = new ArrayList<>();
    for (List<Pixel> row : image) {
      List<Pixel> newRow = new ArrayList<>();
      for (Pixel p : row) {
        newRow.add(p.redScale());
      }
      newImage.add(newRow);
    }
    return new ImageImpl(newImage, maxValue);
  }

  @Override
  public Image visualizeGreenChannel() {
    List<List<Pixel>> newImage = new ArrayList<>();
    for (List<Pixel> row : image) {
      List<Pixel> newRow = new ArrayList<>();
      for (Pixel p : row) {
        newRow.add(p.greenScale());
      }
      newImage.add(newRow);
    }
    return new ImageImpl(newImage, maxValue);
  }

  @Override
  public Image visualizeBlueChannel() {
    List<List<Pixel>> newImage = new ArrayList<>();
    for (List<Pixel> row : image) {
      List<Pixel> newRow = new ArrayList<>();
      for (Pixel p : row) {
        newRow.add(p.blueScale());
      }
      newImage.add(newRow);
    }
    return new ImageImpl(newImage, maxValue);
  }

  @Override
  public Image visualizeValue() {
    List<List<Pixel>> newImage = new ArrayList<>();
    for (List<Pixel> row : image) {
      List<Pixel> newRow = new ArrayList<>();
      for (Pixel p : row) {
        newRow.add(p.value());
      }
      newImage.add(newRow);
    }
    return new ImageImpl(newImage, maxValue);
  }

  @Override
  public Image visualizeIntensity() {
    List<List<Pixel>> newImage = new ArrayList<>();
    for (List<Pixel> row : image) {
      List<Pixel> newRow = new ArrayList<>();
      for (Pixel p : row) {
        newRow.add(p.intensity());
      }
      newImage.add(newRow);
    }
    return new ImageImpl(newImage, maxValue);
  }

  @Override
  public Image visualizeLuma() {
    List<List<Pixel>> newImage = new ArrayList<>();
    for (List<Pixel> row : image) {
      List<Pixel> newRow = new ArrayList<>();
      for (Pixel p : row) {
        newRow.add(p.luma());
      }
      newImage.add(newRow);
    }
    return new ImageImpl(newImage, maxValue);
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
    List<List<Pixel>> newImage = new ArrayList<>();
    for (List<Pixel> row : image) {
      List<Pixel> newRow = new ArrayList<>();
      for (Pixel pixel : row) {
        newRow.add(pixel.changeColor(value, value, value));
      }
      newImage.add(newRow);
    }
    return new ImageImpl(newImage, maxValue);
  }

  @Override
  public Image darkenImage(int value) {
    List<List<Pixel>> newImage = new ArrayList<>();
    for (List<Pixel> row : image) {
      List<Pixel> newRow = new ArrayList<>();
      for (Pixel pixel : row) {
        newRow.add(pixel.changeColor(-value, -value, -value));
      }
      newImage.add(newRow);
    }
    return new ImageImpl(newImage, maxValue);
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
