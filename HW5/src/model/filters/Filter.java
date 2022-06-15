package model.filters;

import model.Pixel;

/**
 * This interface represents filters that can be applied to images.
 */
public interface Filter {
  /**
   * Applies the kernel to a pixel in an image.
   * @return the resulting filtered Pixel
   */
  Pixel applyKernelToPixel();
}
