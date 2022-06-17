package controller.commands;

import model.Image;

/**
 * This class is an implementation of the Command interface. It provides a method to flip
 * a given image horizontally.
 */
public class HFlip implements Command {
  /**
   * Flips ths given image horizontally.
   * @param image the image to flip
   * @return a new Image that is the horizontal flipped version of the given image
   */
  @Override
  public Image applyCommand(Image image) {
    return image.flipImageHorizontally();
  }
}
