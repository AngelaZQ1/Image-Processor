package controller.commands;

import model.Image;

/**
 * This class is an implementation of the Command interface. It provides a method to blur
 * the given image.
 */
public class Blur implements Command {

  /**
   * Blurs the given image.
   * @param image the image to use.
   * @return a new Image that is the given Image blurred.
   */
  @Override
  public Image applyCommand(Image image) {
    return image.blur();
  }

  @Override
  public String getMessage() {
    return "Success! Image blurred.\n";
  }
}
