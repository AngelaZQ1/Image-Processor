package controller.commands;

import model.Image;


/**
 * This class is an implementation of the Command interface. It provides a method to gryascale
 * a given image using its luma.
 */
public class Luma implements Command {

  /**
   * Grayscale the given image using its luma.
   * @param image the image to grayscale
   * @return a new Image that is the grayscaled version of the given image
   */
  @Override
  public Image applyCommand(Image image) {
    return image.visualizeLuma();
  }

  @Override
  public String getMessage() {
    return "Success! Image grayscaled by luma.\n";
  }
}
