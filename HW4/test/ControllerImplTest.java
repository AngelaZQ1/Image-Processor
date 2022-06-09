import org.junit.Test;

import java.io.IOException;
import java.io.StringReader;

import controller.Controller;
import controller.ControllerImpl;
import view.TextView;
import view.View;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * This class is used to test the methods of the ControllerImpl class. It ensures that all
 * constructors and methods work as intended.
 */
public class ControllerImplTest {
  // TODO ControllerImpl tests
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

  }

  @Test
  public void testRunMockView() {

  }
}
