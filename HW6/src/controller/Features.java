package controller;

import model.Image;

/**
 * This interface represents everything that can change the program.
 * E.g. updating the shown image, using the commands, exiting the program.
 */
public interface Features {

  /**
   * Update the image shown to the user using the given Image.
   * @param image the new image to show
   */
  void updateImage(Image image);

  /**
   * Grayscale the current image with the red component.
   */
  void redComp();

  /**
   * Grayscale the current image with the green component.
   */
  void greenComp();

  /**
   * Grayscale the current image with the blue component.
   */
  void blueComp();

  /**
   * Darken the current image by 25.
   */
  void darken();

  /**
   * Brighten the current image by 25.
   */
  void brighten();

  /**
   * Flip the current image vertically.
   */
  void vFlip();

  /**
   * Flip the current image horizontally.
   */
  void hFlip();

  /**
   * Grayscale the current image using its value.
   */
  void value();

  /**
   * Grayscale the current image using its intensity.
   */
  void intensity();

  /**
   * Grayscale the current image using its luma.
   */
  void luma();

  /**
   * Blur the current image.
   */
  void blur();

  /**
   * Sharpen the current image.
   */
  void sharpen();

  /**
   * Grayscale the current image.
   */
  void grayscale();

  /**
   * Turn the current image sepia-toned.
   */
  void sepia();

  /**
   * Load a new image.
   */
  void load();

  /**
   * Save the current image.
   */
  void save();

  /**
   * Exit the program.
   */
  void exit();
}
