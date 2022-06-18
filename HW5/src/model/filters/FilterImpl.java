package model.filters;

import model.Image;
import model.Pixel;
import model.PixelImpl;

/**
 * This class represents functionality to filter pixels. It does so by applying its kernel
 * represented by a 2D Array to a given pixel.
 */
public class FilterImpl implements Filter {

  // uses this object's kernel to create a new Pixel
  @Override
  public Pixel applyKernelToPixel(Image image, double[][] kernel, int pixelRow, int pixelCol)
          throws IllegalArgumentException {

    int kernelHeight = kernel.length;
    int kernelWidth = kernel[0].length;

    if (kernelHeight % 2 == 0 || kernelWidth % 2 == 0) {
      throw new IllegalArgumentException("Kernel Must have odd dimensions.");
    }

    // center of kernel
    int centerRow = kernelHeight / 2;
    int centerCol = kernelWidth / 2;

    double sumRedComp = 0;
    double sumGreenComp = 0;
    double sumBlueComp = 0;

    Pixel correspondingPixelInImage = new PixelImpl(255, 255, 255, 255);
    for (int r = 0; r < kernelHeight; r++) {
      for (int c = 0; c < kernelWidth; c++) {
        // if the pixel in the image that "overlaps" with the current pixel in the kernel
        // is out of bounds, break
        if ((pixelRow + (r - centerRow) < 0)
                || (pixelCol + (c - centerCol) < 0)
                || (pixelRow + (r - centerRow) >= image.getHeight())
                || (pixelCol + (c - centerCol) >= image.getWidth())) {
          // skip that pixel
        } else {
          // else get that pixel
          correspondingPixelInImage = image.getPixel(
                  pixelRow + (r - centerRow),
                  pixelCol + (c - centerCol));
          // multiply the value in the kernel with the red/green/blue component to get the new Pixel
          // and sum the values up
          sumRedComp += (kernel[r][c] * correspondingPixelInImage.getRed());
          sumGreenComp += (kernel[r][c] * correspondingPixelInImage.getGreen());
          sumBlueComp += (kernel[r][c] * correspondingPixelInImage.getBlue());
        }
      }
    }
    return new PixelImpl((int) sumRedComp, (int) sumGreenComp, (int) sumBlueComp, 255);
  }

  @Override
  public Pixel filterValue(Pixel p) {
    int value = Math.max(Math.max(p.getRed(), p.getGreen()), p.getBlue());
    return new PixelImpl(value, value, value, p.getMaxValue());
  }

  @Override
  public Pixel filterIntensity(Pixel p) {
    int intensity = (p.getRed() + p.getGreen() + p.getBlue()) / 3;
    return new PixelImpl(intensity, intensity, intensity, p.getMaxValue());
  }

  @Override
  public Pixel filterLuma(Pixel p) {
    double luma = (0.2126 * p.getRed()) + (0.7152 * p.getGreen()) + (0.0722 * p.getBlue());
    return new PixelImpl((int) luma, (int) luma, (int) luma, p.getMaxValue());
  }

  @Override
  public Pixel filterRed(Pixel p) {
    return new PixelImpl(p.getRed(), p.getRed(), p.getRed(), p.getMaxValue());
  }

  @Override
  public Pixel filterGreen(Pixel p) {
    return new PixelImpl(p.getGreen(), p.getGreen(), p.getGreen(), p.getMaxValue());
  }

  @Override
  public Pixel filterBlue(Pixel p) {
    return new PixelImpl(p.getBlue(), p.getBlue(), p.getBlue(), p.getMaxValue());
  }

  @Override
  public Pixel brighten(Pixel p, int value) {
    return p.changeColor(value, value, value);
  }

  @Override
  public Pixel darken(Pixel p, int value) {
    return p.changeColor(-value, -value, -value);
  }

  @Override
  public Pixel filterGrey(Pixel p) {
    return filterLuma(p);
  }

  @Override
  public Pixel sepia(Pixel p) {
    double newRed = .393 * p.getRed() + .769 * p.getGreen() + .189 * p.getBlue();
    double newGreen = .349 * p.getRed() + .686 * p.getGreen() + .168 * p.getBlue();
    double newBlue = .272 * p.getRed() + .534 * p.getGreen() + .131 * p.getBlue();
    return new PixelImpl((int) newRed, (int) newGreen, (int) newBlue, 255);
  }
}
