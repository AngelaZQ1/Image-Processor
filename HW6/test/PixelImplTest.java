import org.junit.Before;
import org.junit.Test;

import model.Pixel;
import model.PixelImpl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * This class is used to test the methods of the PixelImpl class. It ensures that all constructors
 * and methods work as intended.
 */
public class PixelImplTest {
  private Pixel pixel;

  @Before
  public void init() {
    pixel = new PixelImpl(0, 0, 0, 255);
  }

  // test that the constructor works
  @Test
  public void testConstructor() {
    init();
    assertEquals(new PixelImpl(3, 5, 7, 255),
            pixel.changeColor(3, 5, 7));
  }

  // test that changing a pixel's color works when increasing or decreasing the color values
  @Test
  public void testChangeColor() {
    init();

    // test increasing each color value
    assertEquals(new PixelImpl(3, 5, 7, 255),
            pixel.changeColor(3, 5, 7));

    // test that the pixel's values cap at the max value when increasing the color over 255
    assertEquals(new PixelImpl(255, 255, 255, 255),
            pixel.changeColor(300, 300, 300));

    // test decreasing each color value
    assertEquals(new PixelImpl(15, 10, 0, 255),
            new PixelImpl(20, 20, 20, 255)
                    .changeColor(-5, -10, -20));

    // test that the pixels values becomes 0 when decreasing the color values below 0
    assertEquals(new PixelImpl(0, 0, 0, 255),
            pixel.changeColor(-300, -300, -300));
  }

  // test that getRed returns the Pixel's red component
  @Test
  public void testGetRed() {
    assertEquals(0, pixel.getRed());
  }

  // test that getGreen returns the Pixel's green component
  @Test
  public void testGetGreen() {
    assertEquals(0, pixel.getGreen());
  }

  // test that getBlue returns the Pixel's blue component
  @Test
  public void testGetBlue() {
    assertEquals(0, pixel.getBlue());
  }

  // test that the equals method returns true when comparing two Pixels that have the same fields
  @Test
  public void testEquals() {
    init();
    Pixel pixel2 = new PixelImpl(0, 0, 0, 255);
    assertTrue(pixel.equals(pixel2));

    // test that different max values are different pixels
    assertFalse(pixel.equals(new PixelImpl(3, 5, 7, 10)));
  }
}
