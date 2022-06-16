package model.filters;

import model.Image;
import model.Pixel;

/**
 * This interface represents filters that can be applied to images.
 */
public interface Filter {
  /**
   * Applies the kernel to a pixel in an image.
   * @param image given image
   * @param kernel kernel that should be used to filter
   * @param pixelRow row of pixel
   * @param pixelCol column of pixel
   * @return
   */
  Pixel applyKernelToPixel(Image image, double[][] kernel, int pixelRow, int pixelCol);

  /**
   * Returns a new pixel whose 3 components are this pixel's highest component.
   *
   * @param p given pixel to be filtered
   * @return a new Pixel that is the value-scaled version of this pixel.
   */
  Pixel filterValue(Pixel p);

  /**
   * Returns a new pixel whose 3 components are the average of this pixel's 3 components.
   *
   * @param p given pixel to be filtered
   * @return a new Pixel that is the intensity-scaled version of this pixel.
   */
  Pixel filterIntensity(Pixel p);

  /**
   * Returns a new pixel that is the luma-scaled version of this pixel.
   *
   * @param p given pixel to be filtered
   * @return a new Pixel that is the luma-scaled version of this pixel.
   */
  Pixel filterLuma(Pixel p);

  /**
   * Returns a new pixel whose 3 components are this pixel's red component.
   *
   * @param p given pixel to be filtered
   * @return a new Pixel that is the red-scaled version of this pixel.
   */
  Pixel filterRed(Pixel p);

  /**
   * Returns a new pixel whose 3 components are this pixel's green component.
   *
   * @param p given pixel to be filtered
   * @return a new Pixel that is the green-scaled version of this pixel.
   */
  Pixel filterGreen(Pixel p);

  /**
   * Returns a new pixel whose 3 components are this pixel's blue component.
   *
   * @param p given pixel to be filtered
   * @return a new Pixel that is the blue-scaled version of this pixel.
   */
  Pixel filterBlue(Pixel p);

  /**
   * Returns a new pixel that is brightened by the given value
   *
   * @param p given pixel to be filtered
   * @param value degree to which to brighten
   * @return
   */
  Pixel brighten(Pixel p, int value);

  /**
   * returns a new pixel that is darkened by the given value
   *
   * @param p given pixel to be filtered
   * @param value degreen to which to darken
   * @return
   */
  Pixel darken(Pixel p, int value);

  /**
   * Return a new pixel that is the grayscaled version of this pixel using the given color
   * transformation values.
   *
   * @param p     the pixel to transform
   * @param red   the value to multiply this Pixel's red component by
   * @param green the value to multiply this Pixel's green component by
   * @param blue  the value to multiply this Pixel's blue component by
   * @return a new Pixel that is the grayscaled version of this Pixel
   */
  Pixel filterGrey(Pixel p, double red, double green, double blue);

  /**
   * Returns a new pixel that is the sepia-toned version of this Pixel.
   *
   * @return a new pixel that is the sepia-toned version of this Pixel.
   */
  Pixel sepia(Pixel p);

}
