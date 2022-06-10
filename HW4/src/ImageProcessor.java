import java.io.IOException;
import java.io.InputStreamReader;

import controller.Controller;
import controller.ControllerImpl;
import view.TextView;

/**
 * This class represents an image processing program. It offers functionality that enables the
 * user to edit images.
 */
public class ImageProcessor {
  /**
   * The main method that runs when the program is started.
   * @param args the arguments used when starting the program
   * @throws IOException if output cannot be transmitted
   */
  public static void main(String[] args) throws IOException {
    Controller controller = new ControllerImpl(new TextView(), new InputStreamReader(System.in));
    controller.run();
  }
}