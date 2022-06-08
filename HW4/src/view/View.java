package view;

import java.io.IOException;

/**
 * This interface represents the operations that deal with sending messages to the user.
 */
public interface View {


  /**
   * Sends the given message to the user through an Appendable.
   * @param message the message to send
   * @throws IOException if there is an error sending the output
   */
  public void renderMessage(String message) throws IOException;

  /**
   * Shows the possible commands the user can input.
   * @throws IOException if there is an error sending the output
   */
  public void showOptions() throws IOException;

}
