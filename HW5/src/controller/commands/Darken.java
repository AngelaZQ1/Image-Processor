package controller.commands;

import model.Image;

/**
 * This class is an implementation of the Command interface. It provides a method to darken
 * the given image.
 */
public class Darken implements Command {
  private final int value;

  /**
   * Creates a Darken object with the given value to darken images by.
   * @param value the amount to darken images by
   */
  public Darken(int value) {
    this.value = value;
  }

  /**
   * Darkens the given image using this object's value.
   * @param image the image to darken
   * @return a new Image that is the given image darkened
   */
  @Override
  public Image applyCommand(Image image) {
    return image.darken(value);
  }
}
