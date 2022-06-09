package model;

/**
 * This interface represents a pixel in an image and offers methods that return a new pixel
 * that differs from the original pixel in some way.
 */
public interface Pixel {

  /**
   * Returns a new pixel by adding the given values to the original pixel's color values.
   * The original pixel does not change.
   * @param r red color value
   * @param g green color value
   * @param b blue color value
   * @return the new pixel with the changed color
   */
  public Pixel changeColor(int r, int g, int b);

  /**
   * Returns a new pixel whose 3 components are this pixel's highest component.
   * @return a new Pixel that is the value-scaled version of this pixel.
   */
  public Pixel value();

  /**
   * Returns a new pixel whose 3 components are the average of this pixel's 3 components.
   * @return a new Pixel that is the intensity-scaled version of this pixel.
   */
  public Pixel intensity();

  /**
   * Returns a new pixel that is the luma-scaled version of this pixel.
   * @return a new Pixel that is the luma-scaled version of this pixel.
   */
  public Pixel luma();

  /**
   * Returns a new pixel whose 3 components are this pixel's red component.
   * @return a new Pixel that is the red-scaled version of this pixel.
   */
  public Pixel redScale();

  /**
   * Returns a new pixel whose 3 components are this pixel's blue component.
   * @return a new Pixel that is the blue-scaled version of this pixel.
   */
  public Pixel blueScale();

  /**
   * Returns a new pixel whose 3 components are this pixel's green component.
   * @return a new Pixel that is the green-scaled version of this pixel.
   */
  public Pixel greenScale();

  /**
   * Returns the red component for this pixel.
   * @return int representing the level of red in the pixel color.
   */
  public int getRed();

  /**
   * Returns the green component for this pixel.
   * @return int representing the level of green in the pixel color.
   */
  public int getGreen();

  /**
   * Returns the blue component for this pixel.
   * @return int representing the level of blue in the pixel color.
   */
  public int getBlue();

  /**
   * Returns the max value for this pixel.
   * @return the max vale
   */
  public int getMaxValue();

  /**
   * Determines if the given pixel is the same as this pixel by comparing each field.
   * @return if the given pixel is the same as this pixel.
   */
  public boolean equals(Object obj);
}
