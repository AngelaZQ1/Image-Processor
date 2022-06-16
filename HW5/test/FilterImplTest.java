import org.junit.Before;
import org.junit.Test;

import model.Pixel;
import model.PixelImpl;
import model.filters.FilterImpl;

import static org.junit.Assert.*;

public class FilterImplTest {

  Pixel pixel;

  @Before
  public void init() {
    pixel = new PixelImpl(0, 0, 0, 255);
  }

  // test that the value() method returns a new pixel with each component being the initial
  // pixel's highest component
  @Test
  public void testValue() {
    init();
    assertEquals(new PixelImpl(0, 0, 0, 255),
            new FilterImpl().filterValue(pixel));
    assertEquals(new PixelImpl(4, 4, 4, 255),
            new FilterImpl().filterValue(new PixelImpl(2, 4, 4, 255)));
    assertEquals(new PixelImpl(255, 255, 255, 255),
            new FilterImpl().filterValue(
                    new PixelImpl(255, 255, 255, 255)));
  }

  // test that the intensity() method returns a new pixel with each component being the average
  // of the initial pixel's 3 components
  @Test
  public void testIntensity() {
    assertEquals(new PixelImpl(4, 4, 4, 255),
            new FilterImpl().filterIntensity(
                    new PixelImpl(2, 4, 6, 255)));
    assertEquals(new PixelImpl(0, 0, 0, 255),
            new FilterImpl().filterIntensity(
                    new PixelImpl(0, 0, 0, 255)));
  }

  // test that the luma() method returns a pixel that is correctly grayscaled
  @Test
  public void testLuma() {
    assertEquals(new PixelImpl(4, 4, 4, 255),
            new FilterImpl().filterLuma(new PixelImpl(4, 4, 4, 255)));
    assertEquals(new PixelImpl(4, 4, 4, 255),
            new FilterImpl().filterLuma(new PixelImpl(5, 5, 5, 255)));
  }

  // test that the grayscaleColorTransform() method returns a pixel that is correctly grayscaled
  @Test
  public void testGrayscaleColorTransform() {
    assertEquals(new PixelImpl(2, 2, 2, 255),
            new FilterImpl().filterGrey(new PixelImpl(1, 2, 3, 255),
                    .2, .3, .5));
  }

  // test that applying the sepia() method returns a pixel with the correct components
  @Test
  public void testSepia() {
    assertEquals(new PixelImpl(24, 22, 17, 255),
            new FilterImpl().sepia(new PixelImpl(10, 20, 30, 255)));
  }

  @Test
  public void testRedScale() {
    assertEquals(new PixelImpl(245, 245, 245, 255),
            new FilterImpl().filterRed(new PixelImpl(245, 24, 104, 255)));
    assertEquals(new PixelImpl(41, 41, 41, 255),
            new FilterImpl().filterRed(new PixelImpl(41, 240, 165, 255)));
  }

  @Test
  public void testGreenScale() {
    assertEquals(new PixelImpl(24, 24, 24, 255),
            new FilterImpl().filterGreen(
                    new PixelImpl(245, 24, 104, 255)));
    assertEquals(new PixelImpl(240, 240, 240, 255),
            new FilterImpl().filterGreen(
                    new PixelImpl(41, 240, 165, 255)));
  }

  @Test
  public void testBlueScale() {
    assertEquals(new PixelImpl(104, 104, 104, 255),
            new FilterImpl().filterBlue(new PixelImpl(245, 24, 104, 255)));
    assertEquals( new PixelImpl(165, 165, 165, 255),
            new FilterImpl().filterBlue(new PixelImpl(41, 240, 165, 255)));
  }

}