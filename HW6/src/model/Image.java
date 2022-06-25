package model;

import java.util.Map;

/**
 * This interface represents an image that can be manipulated. Manipulations include visualizing
 * each channel, grayscaling, flipping, darkening and brightening, and blurring and
 * sharpening the Image.
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
  Image brighten(int value);

  /**
   * Darken this image by decreasing each RGB value by the given value. Each value caps at 255.
   *
   * @param value the given value to decrease each RGB value by
   * @return the resulting image
   */
  Image darken(int value);

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
   * @return the resulting image
   */
  Image grayscaleColorTransform();

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

  /**
   * Get the distribution of red values in this Image as a Map from the value to the number
   * of Pixels with that value as its red component.
   * @return a map of values representing the red distribution
   */
  Map<Integer, Integer> getRedDistribution();

  /**
   * Get the distribution of green values in this Image as a Map from the value to the number
   * of Pixels with that value as its green component.
   * @return a map of values representing the green distribution
   */
  Map<Integer, Integer> getGreenDistribution();

  /**
   * Get the distribution of blue values in this Image as a Map from the value to the number
   * of Pixels with that value as its blue component.
   * @return a map of values representing the blue distribution
   */
  Map<Integer, Integer> getBlueDistribution();

  /**
   * Get the distribution of intensity values in this Image as a Map from the value to the number
   * of Pixels with that value as its intensity.
   * @return a map of values representing the intensity
   */
  Map<Integer, Integer> getIntensityDistribution();
}
