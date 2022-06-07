import java.io.FileNotFoundException;
import java.io.InputStreamReader;

import controller.Controller;
import controller.ControllerImpl;
import controller.ImageUtil;
import model.Image;

public class ImageProcessor {
  public static void main(String[] args) throws FileNotFoundException {
    String filename;

    if (args.length > 0) {
      filename = args[0];
    } else {
      filename = "sample.ppm";
    }

    Image image = ImageUtil.readPPM(filename);

    Controller controller = new ControllerImpl(controller.ImageUtil.readPPM(filename),
            view, new InputStreamReader(System.in));
    controller.run();
  }
}