package controller.commands;

import model.Image;


/**
 * This class is an implementation of the Command interface. It provides a method to grayscale
 * the given image.
 */
public class Grayscale implements Command {

  /**
   * Grayscales the given image using this object's values.
   * @param image the image to grayscale
   * @return a new Image that is the grayscaled version of the given image
   */
  @Override
  public Image applyCommand(Image image) {
    return image.grayscaleColorTransform();
  }

  @Override
  public String getMessage() {
    return "Success! Image grayscaled.\n";
  }
}
