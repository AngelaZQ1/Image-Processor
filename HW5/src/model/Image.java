package model;

/**
 * This interface represents an image that can be manipulated.
 */
public interface Image {

  /**
   * Visualize this image in grayscale using the red channel.
   *
   * @return the resulting image in grayscale
   */
  Image visualizeRedChannel();

  /**
   * Visualize this image in grayscale using the blue channel.
   *
   * @return the resulting image in grayscale
   */
  Image visualizeBlueChannel();

  /**
   * Visualize this image in grayscale using the green channel.
   *
   * @return the resulting image in grayscale
   */
  Image visualizeGreenChannel();

  /**
   * Visualize this image in grayscale using its value.
   *
   * @return the resulting image
   */
  Image visualizeValue();

  /**
   * Visualize this image in grayscale using its intensity.
   *
   * @return the resulting image
   */
  Image visualizeIntensity();

  /**
   * Visualize this image in grayscale using its luma.
   *
   * @return the resulting image
   */
  Image visualizeLuma();

  /**
   * Flip this image vertically.
   *
   * @return the resulting image
   */
  Image flipImageVertically();

  /**
   * Flip this image horizontally.
   *
   * @return the resulting image
   */
  Image flipImageHorizontally();

  /**
   * Brighten this image by increasing each RGB value by the given value. Each value caps at 255.
   *
   * @param value the given value to increase each RGB value by
   * @return the resulting image
   */
  Image brightenImage(int value);

  /**
   * Darken this image by decreasing each RGB value by the given value. Each value caps at 255.
   *
   * @param value the given value to decrease each RGB value by
   * @return the resulting image
   */
  Image darkenImage(int value);

  /**
   * Blurs this image with the use of a kernel.
   *
   * @return the resulting image
   */
  Image blur();

  /**
   * Sharpens this image with the use of a kernel.
   *
   * @return the resulting image
   */
  Image sharpen();

  /**
   * Grayscales this image by performing a color transformation on each channel.
   *
   * @param red   the value to multiply each red component by
   * @param green the value to multiply each green component by
   * @param blue  the value to multiply each blue component by
   * @return the resulting image
   */
  Image grayscaleColorTransform(double red, double green, double blue);

  /**
   * Produces a sepia-toned version of this Image.
   *
   * @return the resulting image
   */
  Image sepia();

  /**
   * Gives the width of the image.
   *
   * @return int representing the width of the image.
   */
  int getWidth();

  /**
   * Gives the height of the image.
   *
   * @return int representing the height of the image.
   */
  int getHeight();

  /**
   * Gives the max color value of the image.
   *
   * @return int representing the max color value of the image.
   */
  int getMaxValue();

  /**
   * Gives the pixel at the given location on the image.
   *
   * @param row the row index of the pixel.
   * @param col the column index of the pixel.
   * @return the Pixel at the given location
   */
  Pixel getPixel(int row, int col);

}
