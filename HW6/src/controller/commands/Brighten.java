package controller.commands;

import model.Image;

/**
 * This class is an implementation of the Command interface. It provides a method to brighten
 * the given image.
 */
public class Brighten implements Command {
  private final int value;

  /**
   * Create a new Brighten object with the given value as the amount to brighten an Image by.
   * @param value the value to brighten images by
   */
  public Brighten(int value) {
    this.value = value;
  }

  /**
   * Brightens the given image using this objects' value.
   * @param image the image to use.
   * @return a new Image that is the given Image brightened
   */
  @Override
  public Image applyCommand(Image image) {
    return image.brighten(value);
  }

  @Override
  public String getMessage() {
    return "Success! Image brightened by " + value + ".\n";
  }
}
