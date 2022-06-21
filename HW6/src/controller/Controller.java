package controller;

import java.io.IOException;

/**
 * This interface represents the controller of an image processor. It handles all user inputs.
 */
public interface Controller {
  /**
   * Runs the image processor.
   *
   * @throws IOException if there is any issue transmitting output
   */
  void run() throws IOException;
}
