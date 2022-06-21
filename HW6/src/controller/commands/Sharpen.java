package controller.commands;

import model.Image;

/**
 * This class is an implementation of the Command interface. It provides a method to sharpen
 * a given image.
 */
public class Sharpen implements Command {

  /**
   * Sharpens the given image.
   * @param image the image to sharpen
   * @return a new Image that is the given image sharpened
   */
  @Override
  public Image applyCommand(Image image) {
    return image.sharpen();
  }

  @Override
  public String getMessage() {
    return "Success! Image sharpened.\n";
  }
}
