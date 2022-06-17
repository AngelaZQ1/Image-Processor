package controller.commands;

import model.Image;

/**
 * This class is an implementation of the Command interface. It provides a method to return
 * the grayscaled version of an image using its value.
 */
public class Value implements Command {
  /**
   * Grayscale this image using its value.
   * @param image the image to grayscale
   * @return A new image representing the grayscaled version of the given image
   */
  @Override
  public Image applyCommand(Image image) {
    return image.visualizeValue();
  }
}
