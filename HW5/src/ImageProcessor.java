import java.io.FileReader;
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
   *
   * @param args the arguments used when starting the program
   * @throws IOException if output cannot be transmitted
   */
  public static void main(String[] args) throws IOException {
    Controller controller;
    if (args[0].equals("-file")) {
      String filePath = args[1];
      controller = new ControllerImpl(new TextView(), new FileReader(filePath));
    } else {
      controller = new ControllerImpl(new TextView(), new InputStreamReader(System.in));
    }
    controller.run();


    // TODO At least one example source image in png/jpg/bmp/ppm format, its blurred, sharpened, greyscaled and sepia-ed versions in a res/ folder
    // TODO update README
    // TODO create jar file and put in the res folder
  }
}