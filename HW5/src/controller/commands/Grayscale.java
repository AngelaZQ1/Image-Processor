package controller.commands;

import model.Image;


/**
 * This class is an implementation of the Command interface. It provides a method to grayscale
 * the given image using the object's red, green, and blue values.
 */
public class Grayscale implements Command {
  private final int red;
  private final int green;
  private final int blue;

  /**
   * Creates a Grayscale object with the given components.
   * @param r the red value to use in grayscaling
   * @param g the green value to use in grayscaling
   * @param b the blue value to use in grayscaling
   */
  public Grayscale(int r, int g, int b) {
    this.red = r;
    this.green = g;
    this.blue = b;
  }

  /**
   * Grayscales the given image using this object's values.
   * @param image the image to grayscale
   * @return a new Image that is the grayscaled version of the given image
   */
  @Override
  public Image applyCommand(Image image) {
    return image.grayscaleColorTransform(red, green, blue);
  }
}
