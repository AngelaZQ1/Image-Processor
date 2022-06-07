package model;

/**
 * Represents a pixel in an image and contains a red, green, and blue value.
 */
public interface Pixel {

  /**
   * Changes the color of the pixel given the difference in rgb values.
   * @param r red color value
   * @param g green color value
   * @param b blue color value
   */
  public Pixel changeColor(int r, int g, int b);

  /**
   * Gives a new pixel that is the value-scaled version of the current pixel
   * @return Pixel that is the value-scaled version of this pixel
   */
  public Pixel value();

  /**
   * Gives a new pixel that is the intensity-scaled version of the current pixel
   * @return Pixel that is the intensity-scaled version of this pixel
   */
  public Pixel intensity();

  /**
   * Gives a new pixel that is the luma-scaled version of the current pixel
   * @return Pixel that is the luma-scaled version of this pixel
   */
  public Pixel luma();

  /**
   * Gives a new pixel that is the red-scaled version of the current pixel
   * @return Pixel that is the red-scaled version of this pixel
   */
  public Pixel redScale();

  /**
   * Gives a new pixel that is the blue-scaled version of the current pixel
   * @return Pixel that is the blue-scaled version of this pixel
   */
  public Pixel blueScale();

  /**
   * Gives a new pixel that is the green-scaled version of the current pixel
   * @return Pixel that is the green-scaled version of this pixel
   */
  public Pixel greenScale();

}
