package controller.commands;

import model.Image;

/**
 * This class is an implementation of the Command interface. It provides a method to grayscale
 * the given image using its blue component.
 */
public class BlueComponent implements Command {

  /**
   * Grayscales the given Image using its blue component.
   * @param image the image to use.
   * @return a new Image that is the grayscaled version of the given image
   */
  @Override
  public Image applyCommand(Image image) {
    return image.visualizeBlueChannel();
  }

  @Override
  public String getMessage() {
    return "Success! Image grayscaled by blue component.\n";
  }
}
