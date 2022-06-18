package controller.commands;

import model.Image;

/**
 * This interface represents a command that can be applied to Images. All implementing classes
 * contain two methods: applyCommand that applies itself to the given image and returns a new Image
 * with the filter applied and getMessage to return the success message to show to the user.
 */
public interface Command {
  /**
   * Apply a command on the given image.
   * @param image the image to use.
   * @return a new Image that is the given image with the Command applied to it
   */
  Image applyCommand(Image image);

  /**
   * Returns a success message used to indicate that the filter was successfully applied.
   * @return the String message
   */
  String getMessage();
}
