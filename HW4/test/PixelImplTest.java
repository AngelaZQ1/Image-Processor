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

  // test that the value() method returns a new pixel with each component being the initial
  // pixel's highest component
  @Test
  public void testValue() {
    init();
    assertEquals(new PixelImpl(0, 0, 0, 255), pixel.value());
    assertEquals(new PixelImpl(4, 4, 4, 255),
            new PixelImpl(2, 4, 4, 255).value());
    assertEquals(new PixelImpl(255, 255, 255, 255),
            new PixelImpl(255, 255, 255, 255).value());
  }

  // test that the intensity() method returns a new pixel with each component being the average
  // of the initial pixel's 3 components
  @Test
  public void testIntensity() {
    assertEquals(new PixelImpl(4, 4, 4, 255),
            new PixelImpl(2, 4, 6, 255).intensity());
    assertEquals(new PixelImpl(0, 0, 0, 255),
            new PixelImpl(0, 0, 0, 255).intensity());
  }

  @Test
  public void testLuma() {
    assertEquals(new PixelImpl(4, 4, 4, 255),
            new PixelImpl(4, 4, 4, 255).luma());
    assertEquals(new PixelImpl(50, 30, 70, 255),
            new PixelImpl(50, 50, 50, 255).luma());
  }

  @Test
  public void testRedScale() {
    assertEquals(new PixelImpl(245, 24, 104, 255),
            new PixelImpl(245, 245, 245, 255).redScale());
    assertEquals(new PixelImpl(41, 240, 165, 255),
            new PixelImpl(41, 41, 41, 255).redScale());
  }

  @Test
  public void testGreenScale() {
    assertEquals(new PixelImpl(245, 24, 104, 255),
            new PixelImpl(24, 24, 24, 255).greenScale());
    assertEquals(new PixelImpl(41, 240, 165, 255),
            new PixelImpl(240, 240, 240, 255).greenScale());
  }

  @Test
  public void testBlueScale() {
    assertEquals(new PixelImpl(245, 24, 104, 255),
            new PixelImpl(104, 104, 104, 255).blueScale());
    assertEquals(new PixelImpl(41, 240, 165, 255),
            new PixelImpl(165, 165, 165, 255).blueScale());
  }

  @Test
  public void testGetRed() {
    assertEquals(0, pixel.getRed());
  }

  @Test
  public void testGetGreen() {
    assertEquals(0, pixel.getGreen());
  }

  @Test
  public void testGetBlue() {
    assertEquals(0, pixel.getBlue());
  }

  @Test
  public void testEquals() {
    init();
    Pixel pixel2 = new PixelImpl(0, 0, 0, 255);
    assertTrue(pixel.equals(pixel2));

    // test that different max values are different pixels
    assertFalse(pixel.equals(new PixelImpl(3, 5, 7, 10)));
  }
}
