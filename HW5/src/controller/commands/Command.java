package controller.commands;

import model.Image;

/**
 * This interface represents a command that can be applied to Images. All implementing classes
 * contain one method that applies a command to a given image depending on the class used.
 */
public interface Command {
  /**
   * Apply a command on the given image.
   * @param image the image to use.
   * @return a new Image that is the given image with the Command applied to it
   */
  Image applyCommand(Image image);
}
