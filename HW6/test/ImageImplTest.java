import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import controller.ImageUtil;
import model.Image;
import model.ImageImpl;
import model.Pixel;
import model.PixelImpl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

/**
 * This class is used to test the methods of the ImageImpl class. It ensures that all constructors
 * and methods work as intended.
 */
public class ImageImplTest {

  // test that the constructor initializes its image field correctly
  @Test
  public void testConstructor() {
    List<Pixel> row = new ArrayList<>();
    row.add(new PixelImpl(1,2,3, 255));
    row.add(new PixelImpl(1,2,3, 255));
    List<List<Pixel>> temp = new ArrayList<>();
    temp.add(row);
    temp.add(row);
    Image testImage = new ImageImpl(temp, 255);
    assertEquals(new PixelImpl(1, 2, 3, 255),
            testImage.getPixel(0, 0));
    assertEquals(255, testImage.getMaxValue());
  }

  // helper method that compares each component from each pixel from a given original image
  // with those from given edited image using the given function
  private boolean compareEachPixelToValueHelper(Image original, Image edited,
                                                Function<Pixel, Integer> func) {
    for (int row = 0; row < original.getHeight(); row++) {
      for (int col = 0; col < original.getWidth(); col++) {
        Pixel originalPixel = original.getPixel(row, col);
        Pixel editedPixel = edited.getPixel(row, col);
        int valueToCompare = func.apply(originalPixel);
        return (editedPixel.getRed() == valueToCompare
                && editedPixel.getGreen() == valueToCompare
                && editedPixel.getBlue() == valueToCompare);
      }
    }
    return false;
  }

  // test visualizing an image in grayscale using its red channel
  @Test
  public void testVisualizeRed() {
    try {
      Image originalImage = ImageUtil.readImage("res/fourPixels.ppm");
      Image grayscaleImage = originalImage.visualizeRedChannel();
      assertTrue(compareEachPixelToValueHelper(originalImage, grayscaleImage, Pixel::getRed));
    } catch (IOException e) {
      fail("IOException was thrown");
    }
  }

  // test visualizing an image in grayscale using its green channel
  @Test
  public void testVisualizeGreen() {
    try {
      Image originalImage = ImageUtil.readImage("res/fourPixels.ppm");
      Image grayscaleImage = originalImage.visualizeGreenChannel();
      assertTrue(compareEachPixelToValueHelper(originalImage, grayscaleImage, Pixel::getGreen));
    } catch (IOException e) {
      fail("IOException was thrown");
    }
  }

  // test visualizing an image in grayscale using its blue channel
  @Test
  public void testVisualizeBlue() {
    try {
      Image originalImage = ImageUtil.readImage("res/fourPixels.ppm");
      Image grayscaleImage = originalImage.visualizeBlueChannel();
      assertTrue(compareEachPixelToValueHelper(originalImage, grayscaleImage, Pixel::getBlue));
    } catch (IOException e) {
      fail("IOException was thrown");
    }
  }

  // test visualizing an image in grayscale using its value
  @Test
  public void testVisualizeValue() {
    try {
      Image originalImage = ImageUtil.readImage("res/fourPixels.ppm");
      Image grayscaleImage = originalImage.visualizeValue();
      assertTrue(compareEachPixelToValueHelper(originalImage, grayscaleImage,
          p -> Math.max(p.getRed(), Math.max(p.getGreen(), p.getBlue()))));
    } catch (IOException e) {
      fail("IOException was thrown");
    }
  }

  // test visualizing an image in grayscale using its intensity
  @Test
  public void testVisualizeIntensity() {
    try {
      Image originalImage = ImageUtil.readImage("res/fourPixels.ppm");
      Image grayscaleImage = originalImage.visualizeIntensity();
      assertTrue(compareEachPixelToValueHelper(originalImage, grayscaleImage,
          p -> (p.getRed() + p.getGreen() + p.getBlue()) / 3));
    } catch (IOException e) {
      fail("IOException was thrown");
    }
  }

  // test visualizing an image in grayscale using its luma
  @Test
  public void testVisualizeLuma() {
    try {
      Image originalImage = ImageUtil.readImage("res/fourPixels.ppm");
      Image grayscaleImage = originalImage.visualizeLuma();
      assertTrue(compareEachPixelToValueHelper(originalImage, grayscaleImage,
          p -> (int) ((p.getRed() * 0.2126)
                      + (p.getGreen() * 0.7152)
                      + (p.getBlue() * 0.0722))));
    } catch (IOException e) {
      fail("IOException was thrown");
    }
  }

  // test flipping an image vertically
  @Test
  public void testFlipVertically() {
    try {
      Image image = ImageUtil.readImage("res/fourPixels.ppm");
      Image flippedImage = image.flipImageVertically();
      assertEquals(new PixelImpl(255, 0, 51, 255),
              flippedImage.getPixel(0, 0));
      assertEquals(new PixelImpl(0, 65, 0, 255),
              flippedImage.getPixel(0, 1));
      assertEquals(new PixelImpl(1, 1, 1, 255),
              flippedImage.getPixel(1, 0));
      assertEquals(new PixelImpl(252, 253, 252, 255),
              flippedImage.getPixel(1, 1));
    } catch (IOException e) {
      fail("IOException was thrown");
    }
  }

  // test flipping an image horizontally
  @Test
  public void testFlipHorizontally() {
    try {
      Image image = ImageUtil.readImage("res/fourPixels.ppm");
      Image flippedImage = image.flipImageHorizontally();
      assertEquals(new PixelImpl(252, 253, 252, 255),
              flippedImage.getPixel(0, 0));
      assertEquals(new PixelImpl(1, 1, 1, 255),
              flippedImage.getPixel(0, 1));
      assertEquals(new PixelImpl(0, 65, 0, 255),
              flippedImage.getPixel(1, 0));
      assertEquals(new PixelImpl(255, 0, 51, 255),
              flippedImage.getPixel(1, 1));
    } catch (IOException e) {
      fail("IOException was thrown");
    }
  }

  // test brightening an image
  @Test
  public void testBrighten() {
    try {
      Image originalImage = ImageUtil.readImage("res/fourPixels.ppm");
      Image brightenedImage = originalImage.brighten(50);
      for (int row = 0; row < originalImage.getHeight(); row++) {
        for (int col = 0; col < originalImage.getWidth(); col++) {
          Pixel originalPixel = originalImage.getPixel(row, col);
          Pixel editedPixel = brightenedImage.getPixel(row, col);
          assertEquals(editedPixel.getRed(), Math.min(255, originalPixel.getRed() + 50));
          assertEquals(editedPixel.getGreen(), Math.min(255, originalPixel.getGreen() + 50));
          assertEquals(editedPixel.getBlue(), Math.min(255, originalPixel.getBlue() + 50));
        }
      }
    } catch (IOException e) {
      fail("IOException was thrown");
    }
  }

  // test darkening an image
  @Test
  public void testDarken() {
    try {
      Image originalImage = ImageUtil.readImage("res/fourPixels.ppm");
      Image darkenedImage = originalImage.darken(50);
      for (int row = 0; row < originalImage.getHeight(); row++) {
        for (int col = 0; col < originalImage.getWidth(); col++) {
          Pixel originalPixel = originalImage.getPixel(row, col);
          Pixel editedPixel = darkenedImage.getPixel(row, col);
          assertEquals(editedPixel.getRed(), Math.max(0, originalPixel.getRed() - 50));
          assertEquals(editedPixel.getGreen(), Math.max(0, originalPixel.getGreen() - 50));
          assertEquals(editedPixel.getBlue(), Math.max(0, originalPixel.getBlue() - 50));
        }
      }
    } catch (IOException e) {
      fail("IOException was thrown");
    }
  }

  // test blurring an image
  @Test
  public void testBlur() {
    try {
      Image image = ImageUtil.readImage("res/fourPixels.ppm");
      Image blurredImage = image.blur();
      assertEquals(new PixelImpl(63, 35, 38, 255),
              blurredImage.getPixel(0, 0));
      assertEquals(new PixelImpl(79, 71, 66, 255),
              blurredImage.getPixel(0, 1));
      assertEquals(new PixelImpl(79, 24, 28, 255),
              blurredImage.getPixel(1, 0));
      assertEquals(new PixelImpl(63, 47, 37, 255),
              blurredImage.getPixel(1, 1));
    } catch (IOException e) {
      fail("IOException was thrown");
    }
  }

  // test sharpening an image
  @Test
  public void testSharpen() {
    try {
      Image image = ImageUtil.readImage("res/fourPixels.ppm");
      Image sharpenedImage = image.sharpen();
      assertEquals(new PixelImpl(127, 80, 76, 255),
              sharpenedImage.getPixel(0, 0));
      assertEquals(new PixelImpl(255, 255, 255, 255),
              sharpenedImage.getPixel(0, 1));
      assertEquals(new PixelImpl(255, 79, 114, 255),
              sharpenedImage.getPixel(1, 0));
      assertEquals(new PixelImpl(127, 128, 76, 255),
              sharpenedImage.getPixel(1, 1));
    } catch (IOException e) {
      fail("IOException was thrown");
    }
  }

  // test visualizing an image in grayscale using color transformations
  @Test
  public void testGrayscaleColorTransform() {
    try {
      Image originalImage = ImageUtil.readImage("res/fourPixels.ppm");
      Image grayscaleImage = originalImage.visualizeLuma();
      assertTrue(compareEachPixelToValueHelper(originalImage, grayscaleImage,
              p -> (int) ((p.getRed() * 0.2126)
                      + (p.getGreen() * 0.7152)
                      + (p.getBlue() * 0.0722))));
    } catch (IOException e) {
      fail("IOException was thrown");
    }
  }

  // test getting the sepia tone of an image
  @Test
  public void testSepia() {
    try {
      Image image = ImageUtil.readImage("res/fourPixels.ppm");
      Image sepiaImage = image.sepia();
      assertEquals(new PixelImpl(1, 1, 0, 255),

              sepiaImage.getPixel(0, 0));
      assertEquals(new PixelImpl(255, 255, 236, 255),
              sepiaImage.getPixel(0, 1));
      assertEquals(new PixelImpl(109, 97, 76, 255),
              sepiaImage.getPixel(1, 0));
      assertEquals(new PixelImpl(49, 44, 34, 255),
              sepiaImage.getPixel(1, 1));
    } catch (IOException e) {
      fail("IOException was thrown");
    }
  }

  // test getting the width of an image
  @Test
  public void testGetWidth() {
    try {
      Image image = ImageUtil.readImage("res/fourPixels.ppm");
      assertEquals(2, image.getWidth());
    } catch (IOException e) {
      fail("IOException was thrown");
    }
  }

  // test getting the height of an image
  @Test
  public void getHeight() {
    try {
      Image image = ImageUtil.readImage("res/fourPixels.ppm");
      assertEquals(2, image.getHeight());
    } catch (IOException e) {
      fail("IOException was thrown");
    }
  }

  // test getting the max value of an image
  @Test
  public void getMaxValue() {
    try {
      Image image = ImageUtil.readImage("res/fourPixels.ppm");
      assertEquals(255, image.getMaxValue());
    } catch (IOException e) {
      fail("IOException was thrown");
    }
  }

  // test getting pixels
  @Test
  public void testGetPixel() {
    try {
      Image image = ImageUtil.readImage("res/fourPixels.ppm");
      assertEquals(new PixelImpl(1, 1, 1, 255),
              image.getPixel(0, 0));
      assertEquals(new PixelImpl(252, 253, 252, 255),
              image.getPixel(0, 1));
      assertEquals(new PixelImpl(255, 0, 51, 255),
              image.getPixel(1, 0));
      assertEquals(new PixelImpl(0, 65, 0, 255),
              image.getPixel(1, 1));
    } catch (IOException e) {
      fail("IOException was thrown");
    }
  }

  // test getting the red distribution
  @Test
  public void testGetRedDistribution() {
    try {
      Image image = ImageUtil.readImage("res/fourPixels.ppm");
      Map<Integer, Integer> redMap = image.getRedDistribution();
      assertTrue(redMap.get(2) == 0);
      assertTrue(redMap.get(0) == 1);
      assertTrue(redMap.get(252) == 1);
      assertTrue(redMap.get(255) == 1);
      assertTrue(redMap.get(10) == 0);
      assertTrue(redMap.get(20) == 0);
      assertTrue(redMap.get(1) == 1);
    } catch (IOException e) {
      fail("IOException was thrown");
    }
  }


  // test getting the green distribution
  @Test
  public void testGetGreenDistribution() {
    try {
      Image image = ImageUtil.readImage("res/fourPixels.ppm");
      Map<Integer, Integer> greenMap = image.getGreenDistribution();
      assertTrue(greenMap.get(253) == 1);
      assertTrue(greenMap.get(1) == 1);
      assertTrue(greenMap.get(0) == 1);
      assertTrue(greenMap.get(65) == 1);
      assertTrue(greenMap.get(255) == 0);
      assertTrue(greenMap.get(20) == 0);
      assertTrue(greenMap.get(2) == 0);
    } catch (IOException e) {
      fail("IOException was thrown");
    }
  }

  // test getting the blue distribution
  @Test
  public void testGetBlueDistribution() {
    try {
      Image image = ImageUtil.readImage("res/fourPixels.ppm");
      Map<Integer, Integer> blueMap = image.getBlueDistribution();
      assertTrue(blueMap.get(252) == 1);
      assertTrue(blueMap.get(1) == 1);
      assertTrue(blueMap.get(0) == 1);
      assertTrue(blueMap.get(65) == 0);
      assertTrue(blueMap.get(51) == 1);
      assertTrue(blueMap.get(20) == 0);
      assertTrue(blueMap.get(2) == 0);
    } catch (IOException e) {
      fail("IOException was thrown");
    }
  }

  // test getting the intensity distribution
  @Test
  public void testGetIntensityDistribution() {
    try {
      Image image = ImageUtil.readImage("res/fourPixels.ppm");
      Map<Integer, Integer> intensityMap = image.getIntensityDistribution();
      assertTrue(intensityMap.get(252) == 1);
      assertTrue(intensityMap.get(21) == 1);
      assertTrue(intensityMap.get(102) == 1);
      assertTrue(intensityMap.get(252) == 1);
      assertTrue(intensityMap.get(51) == 0);
      assertTrue(intensityMap.get(20) == 0);
      assertTrue(intensityMap.get(2) == 0);
    } catch (IOException e) {
      fail("IOException was thrown");
    }
  }

}
