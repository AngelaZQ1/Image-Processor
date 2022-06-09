package view;

import java.io.IOException;

/**
 * This class represents a mock view for testing purposes. It ensures that
 * the correct arguments are being passed into its methods.
 */
public class MockView implements View {
  private final StringBuilder log;

  /**
   * Creates a MockView object with the given StringBuilder.
   *
   * @param log the StringBuilder to use to log values
   */
  public MockView(StringBuilder log) {
    this.log = log;
  }

  /**
   * Tests that this method is called with the correct argument by appending the given message
   * to this mock's log.
   *
   * @param message the message to append to the log
   */
  @Override
  public void renderMessage(String message) throws IOException {
    log.append("message: " + message);
  }

  /**
   * Tests that this method is called by appending "show options" to this mock's log.
   */
  @Override
  public void showOptions() throws IOException {
    log.append("show options");
  }
}
