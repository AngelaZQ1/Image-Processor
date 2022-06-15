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
    // TODO accept command line arguments like "-file name-of-script.txt" to run the script and exit
      // should be in res file
    // TODO update script
    // TODO create jar file and put in the res folder
    // TODO At least one example source image in png/jpg/bmp/ppm format, its blurred, sharpened, greyscaled and sepia-ed versions in a res/ folder
    // TODO Updated class diagram
    // TODO Created EnhancedImageImpl and EnhancedImage interface
    // TODO Created EnhancedPixelImpl and EnhancedPixel interface
    // TODO update README
    // TODO USEME file in root submission folder
      //  "summarize which script commands are supported by your application, examples of using them and conditions if any"
  }
}