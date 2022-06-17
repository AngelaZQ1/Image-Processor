package controller.commands;

import model.Image;

/**
 * This class is an implementation of the Command interface. It provides a method to grayscale
 * a given image using its green component.
 */
public class GreenComponent implements Command {
  /**
   * Grayscale the given image using its green component.
   * @param image the image to grayscale
   * @return a new Image that is the grayscaled version of the given image
   */
  @Override
  public Image applyCommand(Image image) {
    return image.visualizeGreenChannel();
  }
}
