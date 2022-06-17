package controller.commands;

import model.Image;

/**
 * This class is an implementation of the Command interface. It provides a method to get the
 * red component of a given image.
 */
public class RedComponent implements Command {
  /**
   * Grayscale an image using its red component.
   * @param image the image to grayscale
   * @return a new Image that is the red-grayscaled version of the given image
   */
  @Override
  public Image applyCommand(Image image) {
    return image.visualizeRedChannel();
  }
}
