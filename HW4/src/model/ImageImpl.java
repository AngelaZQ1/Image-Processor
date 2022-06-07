package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * This class represents an implementation of the Image interface. It offers ways to visualize
 * and manipulate an image.
 */
public class ImageImpl implements Image {
  HashMap<String, Image> listOfImages;
  List<List<Pixel>> image;
  int numCols;
  int numRows;

  public ImageImpl(List<List<Pixel>> image) {
    this.image = image;
    this.numRows = image.size();
    this.numCols = image.get(0).size();
  }

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
    return new ImageImpl(newImage);
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
    return new ImageImpl(newImage);
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
    return new ImageImpl(newImage);
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
    return new ImageImpl(newImage);
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
    return new ImageImpl(newImage);
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
    return new ImageImpl(newImage);
  }

  @Override
  public Image flipImageVertically() {
    List<List<Pixel>> newImage = new ArrayList<>();
    for (int i = 0; i < numRows; i++) {
      newImage.add(image.get(numRows - 1));
    }
    return new ImageImpl(newImage);
  }

  @Override
  public Image flipImageHorizontally() {
    List<List<Pixel>> newImage = new ArrayList<>();
    for (int i = 0; i < numRows; i++) {
      List<Pixel> newRow = new ArrayList<>();
      for (int j = 1; j <= numRows; j++) {
        newRow.add(image.get(i).get(numRows - j));
      }
      newImage.add(newRow);
    }
    return new ImageImpl(newImage);
  }

  @Override
  public Image brightenImage(int value) {
    List<List<Pixel>> newImage = new ArrayList<>();
    for (List<Pixel> row : image) {
      List<Pixel> newRow = new ArrayList<>();
      for (Pixel pixel : row) {
        newRow.add(pixel.changeColor(value, value, value));
      }
      newImage.add(row);
    }
    return new ImageImpl(newImage);
  }

  @Override
  public Image darkenImage(int value) {
    List<List<Pixel>> newImage = new ArrayList<>();
    for (List<Pixel> row : image) {
      List<Pixel> newRow = new ArrayList<>();
      for (Pixel pixel : row) {
        newRow.add(pixel.changeColor(-value, -value, -value));
      }
      newImage.add(row);
    }
    return new ImageImpl(newImage);
  }
}
