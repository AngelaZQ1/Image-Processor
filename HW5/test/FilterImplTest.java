import org.junit.Test;

import java.io.IOException;

import controller.ImageUtil;
import model.Image;
import model.Pixel;
import model.PixelImpl;
import model.filters.FilterImpl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * This class is used to test the methods of the FilterImpl class. It ensures that all filter
 * methods produce the correct Pixel when applied a filter.
 */
public class FilterImplTest {

  // test that applying a kernel to a Pixel produces a Pixel with the correct componenets
  @Test
  public void testApplyKernelToPixel() {
    Image image = null;
    double[][] kernel = {{.1, .2, .1}, {.2, .4, .2}, {.1, .2, .1}};
    try {
      image = ImageUtil.readImage("res/fourPixels.ppm");
    } catch (IOException e) {
      fail("IOException was thrown");
    }
    Pixel pixel = new FilterImpl().applyKernelToPixel(image, kernel, 1, 1);
    assertEquals(101, pixel.getRed());
    assertEquals(76, pixel.getGreen());
    assertEquals(60, pixel.getBlue());
    assertEquals(255, pixel.getMaxValue());

  }

  // test that the value() method returns a new pixel with each component being the initial
  // pixel's highest component
  @Test
  public void testValue() {
    Pixel pixel = new PixelImpl(0, 0, 0, 255);
    assertEquals(new PixelImpl(0, 0, 0, 255),
            new FilterImpl().filterValue(pixel));
    assertEquals(new PixelImpl(4, 4, 4, 255),
            new FilterImpl().filterValue(new PixelImpl(2, 4, 4, 255)));
    assertEquals(new PixelImpl(255, 255, 255, 255),
            new FilterImpl()
                    .filterValue(new PixelImpl(255, 255, 255, 255)));
  }

  // test that the filterIntensity method returns a new Pixel with each component being the average
  // of the initial Pixel's 3 components
  @Test
  public void testIntensity() {
    assertEquals(new PixelImpl(4, 4, 4, 255), new FilterImpl()
            .filterIntensity(new PixelImpl(2, 4, 6, 255)));
    assertEquals(new PixelImpl(0, 0, 0, 255), new FilterImpl()
            .filterIntensity(new PixelImpl(0, 0, 0, 255)));
  }

  // test that the filterLuma method returns a Pixel that is correctly grayscaled
  @Test
  public void testLuma() {
    assertEquals(new PixelImpl(4, 4, 4, 255), new FilterImpl()
            .filterLuma(new PixelImpl(4, 4, 4, 255)));
    assertEquals(new PixelImpl(4, 4, 4, 255), new FilterImpl()
            .filterLuma(new PixelImpl(5, 5, 5, 255)));
  }

  // test that the filterRed method returns a Pixel that is correctly grayscaled
  @Test
  public void testRedScale() {
    assertEquals(new PixelImpl(245, 245, 245, 255), new FilterImpl()
            .filterRed(new PixelImpl(245, 24, 104, 255)));
    assertEquals(new PixelImpl(41, 41, 41, 255), new FilterImpl()
            .filterRed(new PixelImpl(41, 240, 165, 255)));
  }

  // test that the filterGreen method returns a Pixel that is correctly grayscaled
  @Test
  public void testGreenScale() {
    assertEquals(new PixelImpl(24, 24, 24, 255), new FilterImpl()
            .filterGreen(new PixelImpl(245, 24, 104, 255)));
    assertEquals(new PixelImpl(240, 240, 240, 255), new FilterImpl()
            .filterGreen(new PixelImpl(41, 240, 165, 255)));
  }

  // test that the filterBlue method returns a Pixel that is correctly grayscaled
  @Test
  public void testBlueScale() {
    assertEquals(new PixelImpl(104, 104, 104, 255), new FilterImpl()
            .filterBlue(new PixelImpl(245, 24, 104, 255)));
    assertEquals( new PixelImpl(165, 165, 165, 255), new FilterImpl()
            .filterBlue(new PixelImpl(41, 240, 165, 255)));
  }

  // test that the brighten method returns a Pixel that is brightened by the given value
  // tests that a pixel's components do not end up higher than its max value
  @Test
  public void testBrighten() {
    assertEquals(new PixelImpl(60, 70, 255, 255), new FilterImpl()
            .brighten(new PixelImpl(50, 60, 250, 255), 10));
  }

  // test that the darken method returns a Pixel that is darkened by the given value
  // tests that a pixel's components do not end up lower than 0
  @Test
  public void testDarken() {
    assertEquals(new PixelImpl(0, 0, 10, 255), new FilterImpl()
            .darken(new PixelImpl(0, 5, 20, 255), 10));
  }

  // test that the filterGrey method returns a Pixel that is correctly grayscaled
  @Test
  public void testGrey() {
    assertEquals(new PixelImpl(4, 4, 4, 255), new FilterImpl()
            .filterLuma(new PixelImpl(4, 4, 4, 255)));
    assertEquals(new PixelImpl(4, 4, 4, 255), new FilterImpl()
            .filterLuma(new PixelImpl(5, 5, 5, 255)));
  }

  // test that the sepia method returns a Pixel with the correct components
  @Test
  public void testSepia() {
    assertEquals(new PixelImpl(24, 22, 17, 255), new FilterImpl()
            .sepia(new PixelImpl(10, 20, 30, 255)));
  }
}
