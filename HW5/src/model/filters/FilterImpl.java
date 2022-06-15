package model.filters;

import model.Image;
import model.Pixel;
import model.PixelImpl;

/**
 * This class represents abstractions between filtering methods.
 */
public class FilterImpl implements Filter {
  protected Image image;
  protected double[][] kernel;
  protected int pixelRow;
  protected int pixelCol;

  public FilterImpl(Image image, double[][] kernel, int pixelRow, int pixelCol) {
    this.image = image;
    this.kernel = kernel;
    this.pixelRow = pixelRow;
    this.pixelCol = pixelCol;
  }

  // uses this object's kernel to create a new Pixel
  @Override
  public Pixel applyKernelToPixel() {
    int kernelHeight = this.kernel.length;
    int kernelWidth = this.kernel[0].length;

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
}
