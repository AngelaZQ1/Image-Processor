import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.StringReader;

import controller.Controller;
import controller.ControllerImpl;
import controller.ImageUtil;
import model.Image;
import model.MockImage;
import view.MockView;
import view.TextView;
import view.View;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * This class is used to test the methods of the ControllerImpl class. It ensures that all
 * constructors and methods work as intended.
 */
public class ControllerImplTest {

  // test that the constructor does not throw errors when valid argument are given and used
  @Test
  public void testConstructors() {
    View view = new TextView();
    Readable in = new StringReader("q");
    Controller controller = new ControllerImpl(view, in);
    try {
      view.renderMessage("test");
    } catch (IOException e) {
      fail("An IOException should not have been thrown");
    }
    Image image = null;
    try {
      image = ImageUtil.readPPM("res/fourPixels.ppm");
    } catch (FileNotFoundException ignore) {
      // do nothing
    }
    Controller otherController = new ControllerImpl(view, in, "name", image);
    try {
      view.renderMessage("test");
    } catch (IOException e) {
      fail("An IOException should not have been thrown");
    }
  }

  // test that the constructor throws exceptions when given null arguments
  @Test
  public void testConstructorNullArguments() {
    View view = new TextView();
    Readable in = new StringReader("q");
    try {
      new ControllerImpl(view, null);
      fail("An IOException should have been thrown");
    } catch (IllegalArgumentException e) {
      // do nothing
    }
    try {
      new ControllerImpl(null, in);
      fail("An IOException should have been thrown");
    } catch (IllegalArgumentException e) {
      // do nothing
    }
    try {
      new ControllerImpl(null, null);
      fail("An IOException should have been thrown");
    } catch (IllegalArgumentException e) {
      // do nothing
    }
  }

  // test that the correct methods in Image are called when the controller uses it
  @Test
  public void testRunMockModel() {
    StringBuilder log = new StringBuilder();
    MockImage mock = new MockImage(log);
    try {
      View view = new TextView();
      Readable input = new StringReader(
              "red-component image image " +
              "green-component image image " +
              "blue-component image image " +
              "value image image " +
              "intensity image image " +
              "luma image image " +
              "vertical-flip image image " +
              "horizontal-flip image image " +
              "brighten 10 image image " +
              "darken 10 image image " +
              "save res/testMock.ppm image " +
              "q");
      Controller controller = new ControllerImpl(view, input, "image", mock);
      controller.run();
    } catch (IOException e) {
      fail("An IOException was thrown");
    }
    String expected = "visualize red\n" +
            "visualize green\n" +
            "visualize blue\n" +
            "visualize value\n" +
            "visualize intensity\n" +
            "visualize luma\n" +
            "flip vertically\n" +
            "flip horizontally\n" +
            "Brighten by 10\n" +
            "darken by 10\n";
    assertEquals(expected, log.toString());
  }

  // test that the correct methods in the view are called when the controller calls the methods
  @Test
  public void testRunMockView() {
    StringBuilder viewLog = new StringBuilder();
    try {
      ImageUtil.readPPM("res/fourPixels.ppm");
    } catch (FileNotFoundException e) {
      fail("A FileNotFoundException was thrown");
    }
    View view = new MockView(viewLog);
    Readable input = new StringReader("load res/fourPixels.ppm koala q");
    Controller controller = new ControllerImpl(view, input);
    try {
      controller.run();
    } catch (IOException e) {
      fail("An IOException was thrown");
    }
    assertEquals("message: Hello, welcome to our image processor.\n" +
            "show options" +
            "message: Success! Image loaded.\n" +
            "message: Program Quit!", viewLog.toString());
  }

}

















