package model;

/**
 * This interface represents a pixel in an image and offers methods that return a new pixel
 * that differs from the original pixel in some way.
 */
public interface Pixel {

  /**
   * Returns a new pixel by adding the given values to the original pixel's color values.
   * The original pixel does not change.
   *
   * @param r red color value
   * @param g green color value
   * @param b blue color value
   * @return the new pixel with the changed color
   */
  Pixel changeColor(int r, int g, int b);

  /**
   * Returns the red component for this pixel.
   *
   * @return int representing the level of red in the pixel color.
   */
  int getRed();

  /**
   * Returns the green component for this pixel.
   *
   * @return int representing the level of green in the pixel color.
   */
  int getGreen();

  /**
   * Returns the blue component for this pixel.
   *
   * @return int representing the level of blue in the pixel color.
   */
  int getBlue();

  /**
   * Returns the max value for this pixel.
   *
   * @return the max vale
   */
  int getMaxValue();

  /**
   * Determines if the given pixel is the same as this pixel by comparing each field.
   *
   * @return if the given pixel is the same as this pixel.
   */
  boolean equals(Object obj);

  /**
   * Create a hashcode for this Pixel.
   *
   * @return the hashcode for this Pixel.
   */
  int hashCode();
}
