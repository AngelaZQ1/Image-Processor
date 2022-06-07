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





}
