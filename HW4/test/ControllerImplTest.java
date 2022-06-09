import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.StringReader;

import controller.Controller;
import controller.ControllerImpl;
import controller.ImageUtil;
import model.Image;
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
  @Test
  public void testConstructor() {
    View view = new TextView();
    Readable in = new StringReader("q");
    Controller controller = new ControllerImpl(view, in);
    try {
      view.renderMessage("test");
    } catch (IOException e) {
      fail("An IOException should not have been thrown");
    }
  }

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

  @Test
  public void testRunMockModel() {
    View view = new TextView();
    Readable input = new StringReader("load res/Koala.ppm koala q");
    Controller controller = new ControllerImpl(view, input);
    // FIXME no way to input a model, how to test?
    try {
      controller.run();
    } catch (IOException e) {
      fail("An IOException was thrown");
    }
  }

  @Test
  public void testRunMockView() {
    StringBuilder viewLog = new StringBuilder();
    try {
      Image image = ImageUtil.readPPM("res/Koala.ppm");
    } catch (FileNotFoundException e) {
      fail("A FileNotFoundException was thrown");
    }
    View view = new MockView(viewLog);
    Readable input = new StringReader("load res/Koala.ppm koala q");
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
