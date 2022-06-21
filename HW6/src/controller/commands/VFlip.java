package controller.commands;

import model.Image;

/**
 * This class is an implementation of the Command interface. It provides a method to flip
 * a given image.
 */
public class VFlip implements Command {
  /**
   * Flips the given image.
   * @param image the image to flip
   * @return A new image that is the given image flipped
   */
  @Override
  public Image applyCommand(Image image) {
    return image.flipImageVertically();
  }

  @Override
  public String getMessage() {
    return "Success! Image flipped vertically.\n";
  }
}
