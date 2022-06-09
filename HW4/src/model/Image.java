package model;

/**
 * This interface represents an image that can be manipulated.
 */
public interface Image {

  /**
   * Visualize this image in grayscale using the red channel.
   * @return the resulting image in grayscale
   */
  public Image visualizeRedChannel();

  /**
   * Visualize this image in grayscale using the green channel.
   * @return the resulting image in grayscale
   */
  public Image visualizeGreenChannel();

  /**
   * Visualize this image in grayscale using the blue channel.
   * @return the resulting image in grayscale
   */
  public Image visualizeBlueChannel();

  /**
   * Visualize this image in grayscale using its value.
   * @return the resulting image
   */
  public Image visualizeValue();

  /**
   * Visualize this image in grayscale using its intensity.
   * @return the resulting image
   */
  public Image visualizeIntensity();

  /**
   * Visualize this image in grayscale using its luma.
   * @return the resulting image
   */
  public Image visualizeLuma();

  /**
   * Flip this image vertically.
   * @return the resulting image
   */
  public Image flipImageVertically();

  /**
   * Flip this image horizontally.
   * @return the resulting image
   */
  public Image flipImageHorizontally();

  /**
   * Brighten this image by increasing each RGB value by the given value. Each value caps at 255.
   * @param value the given value to increase each RGB value by
   * @return the resulting image
   */
  public Image brightenImage(int value);

  /**
   * Darken this image by decreasing each RGB value by the given value. Each value caps at 255.
   * @param value the given value to decrease each RGB value by
   * @return the resulting image
   */
  public Image darkenImage(int value);

  /**
   * Gives the width of the image.
   * @return int representing the width of the image.
   */
  public int getWidth();

  /**
   * Gives the height of the image.
   * @return int representing the height of the image.
   */
  public int getHeight();

  /**
   * Gives the max color value of the image.
   * @return int representing the max color value of the image.
   */
  public int getMaxValue();

  /**
   * Gives the pixel at the given location on the image.
   * @param row the row index of the pixel.
   * @param col the column index of the pixel.
   * @return the Pixel at the given location
   */
  public Pixel getPixel(int row, int col);

}
