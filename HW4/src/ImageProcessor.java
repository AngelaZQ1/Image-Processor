import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

import controller.Controller;
import controller.ControllerImpl;
import view.TextView;
import view.View;

public class ImageProcessor {
  public static void main(String[] args) throws FileNotFoundException, IOException {
    String filename;

    if (args.length > 0) {
      filename = args[0];
    } else {
      filename = "sample.ppm";
    }

    View view = new TextView();

    Controller controller = new ControllerImpl(view, new InputStreamReader(System.in));
    controller.run();
  }
}