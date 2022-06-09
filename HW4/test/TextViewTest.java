import org.junit.Test;

import java.io.IOException;

import view.TextView;
import view.View;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * This class is used to test the ViewImpl class. It ensures that all constructors and methods
 * work as intended and that exceptions are thrown when necessary.
 */
public class TextViewTest {

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
  public void testConstructorThrowsIllegalArgumentException() {
    new TextView(null);
  }

  @Test
  public void testRenderMessageSuccess() {
    try {
      View view = new TextView();
      view.renderMessage("test");
    } catch (IOException e) {
      fail("An IOException should not have been thrown");
    }
  }

  @Test
  public void testRenderMessageThrowsIOException() {
    View view = new TextView(new CorruptAppendable());
    try {
      view.renderMessage("test");
      fail("An IOException should have been thrown");
    } catch (IOException e) {
      // do nothing
    }
  }

  @Test
  public void testShowOptions() {
    Appendable destination = new StringBuilder();
    View view = new TextView(destination);
    try {
      view.showOptions();
      assertEquals("Available Commands:\n" +
              "Load Image: load image-path image-name\n" +
              "Save Image: save image-path image-name\n" +
              "Red-Component: red-component image-name dest-image-name\n" +
              "Green-Component: green-component image-name dest-image-name\n" +
              "Blue-Component: blue-component image-name dest-image-name\n" +
              "Value: value image-name dest-image-name\n" +
              "Luma: luma image-name dest-image-name\n" +
              "Intensity: intensity image-name dest-image-name\n" +
              "Horizontal Flip: horizontal-flip image-name dest-image-name\n" +
              "Vertical Flip: vertical-flip image-name dest-image-name\n" +
              "Brighten: brighten increment image-name dest-image-name\n" +
              "Darken: darken increment image-name dest-image-name\n" +
              "To Quit: q or Q\n", destination.toString());
    } catch (IOException e) {
      fail("An IOException should have been thrown");
    }
  }

  @Test
  public void testShowOptionsThrowsIOException() {
    View view = new TextView(new CorruptAppendable());
    try {
      view.showOptions();
      fail("An IOException should have been thrown");
    } catch (IOException e) {
      // do nothing
    }

  }
}
