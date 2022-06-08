import org.junit.Test;
import org.w3c.dom.Text;

import java.io.IOException;

import view.TextView;
import view.View;

import static org.junit.Assert.assertEquals;

/**
 * This class is used to test the ViewImpl class. It ensures that all constructors and methods
 * work as intended and that exceptions are thrown when necessary.
 */
public class ViewImplTest {

  @Test
  public void testConstructorGivenValidAppendable() {
    Appendable destination = new StringBuilder();
    View view = new TextView(destination);
    try {
      view.renderMessage("test");
    } catch (IOException e) {
      // do nothing
    }
    assertEquals("test", destination.toString());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testConstructorGivenInvalidAppendable() {
    new TextView(null);
  }
}
