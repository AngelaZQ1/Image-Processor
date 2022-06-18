package controller.commands;

import model.Image;

/**
 * This class is an implementation of the Command interface. It provides a method to return
 * the sepia-toned verison of an image.
 */
public class Sepia implements Command {
  /**
   * Sepia-tone the given image.
   * @param image the image to use
   * @return a new Image that is the sepia-toned version of the given image
   */
  @Override
  public Image applyCommand(Image image) {
    return image.sepia();
  }

  @Override
  public String getMessage() {
    return "Success! Image sepiaed.\n";
  }
}
