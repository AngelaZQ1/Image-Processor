import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

import controller.Controller;
import controller.ControllerImpl;
import controller.GUIController;
import view.JFrameView;
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
    GUIController guiController;
    if (args.length > 0 && args[0].equals("-file")) {
      String filePath = args[1];
      controller = new ControllerImpl(new TextView(), new FileReader(filePath));
      controller.run();
    } else if (args.length > 0 && args[0].equals("-text")) {
      controller = new ControllerImpl(new TextView(), new InputStreamReader(System.in));
      controller.run();
    }
    else {
      guiController = new GUIController();
      guiController.setView(new JFrameView("Image Processor"));
    }
  }
}