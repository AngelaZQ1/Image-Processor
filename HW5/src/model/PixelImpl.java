package model;

import java.util.Objects;

/**
 * This class represents a pixel on an image. This pixel has red, green, and blue values along
 * with a maxValue.
 * INVARIANT: red is between 0 and maxValue (inclusive)
 * INVARIANT: green is between 0 and maxValue (inclusive)
 * INVARIANT: blue is between 0 and maxValue (inclusive)
 */
public class PixelImpl implements Pixel {
  private final int red;
  private final int green;
  private final int blue;
  private final int maxValue;

  /**
   * Creates a pixel given its rgb values and max value.
   *
   * @param red      red color value
   * @param green    green color value
   * @param blue     blue color value
   * @param maxValue the maximum value for a channel
   */
  public PixelImpl(int red, int green, int blue, int maxValue) {
    this.red = red;
    this.green = green;
    this.blue = blue;
    this.maxValue = maxValue;
  }

  @Override
  public Pixel changeColor(int r, int g, int b) {
    int newRed;
    int newGreen;
    int newBlue;

    // prevent any values from going over maxValue or below 0
    if (r > 0) {
      newRed = Math.min(this.red + r, this.maxValue);
    } else {
      newRed = Math.max(this.red + r, 0);
    }
    if (g > 0) {
      newGreen = Math.min(this.green + g, this.maxValue);
    } else {
      newGreen = Math.max(this.green + g, 0);
    }
    if (b > 0) {
      newBlue = Math.min(this.blue + b, this.maxValue);
    } else {
      newBlue = Math.max(this.blue + b, 0);
    }
    return new PixelImpl(newRed, newGreen, newBlue, maxValue);
  }

  @Override
  public Pixel value() {
    int value = Math.max(Math.max(this.red, this.green), this.blue);
    return new PixelImpl(value, value, value, maxValue);
  }

  @Override
  public Pixel intensity() {
    int intensity = (this.red + this.green + this.blue) / 3;
    return new PixelImpl(intensity, intensity, intensity, maxValue);
  }

  @Override
  public Pixel luma() {
    return grayscaleColorTransform(0.2126, 0.7152, 0.0722);
  }

  @Override
  public Pixel grayscaleColorTransform(double red, double green, double blue) {
    double grayScaledComponentValue = (red * this.red) + (green * this.green) + (blue * this.blue);
    return new PixelImpl((int) grayScaledComponentValue,
            (int) grayScaledComponentValue,
            (int) grayScaledComponentValue,
            maxValue);
  }

  @Override
  public Pixel sepia() {
    double newRed = .393 * this.red + .769 * this.green + .189 * this.blue;
    double newGreen = .349 * this.red + .686 * this.green + .168 * this.blue;
    double newBlue = .272 * this.red + .534 * this.green + .131 * this.blue;
    return new PixelImpl((int) newRed, (int) newGreen, (int) newBlue, 255);
  }

  @Override
  public Pixel redScale() {
    return new PixelImpl(this.red, this.red, this.red, maxValue);
  }

  @Override
  public Pixel greenScale() {
    return new PixelImpl(this.green, this.green, this.green, maxValue);
  }

  @Override
  public Pixel blueScale() {
    return new PixelImpl(this.blue, this.blue, this.blue, maxValue);
  }

  @Override
  public int getRed() {
    return this.red;
  }

  @Override
  public int getGreen() {
    return this.green;
  }

  @Override
  public int getBlue() {
    return this.blue;
  }

  @Override
  public int getMaxValue() {
    return maxValue;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == this) {
      return true;
    }
    if (!(obj instanceof PixelImpl)) {
      return false;
    }
    Pixel pixel = (Pixel) obj;
    return (pixel.getRed() == this.getRed()
            && pixel.getGreen() == this.getGreen()
            && pixel.getBlue() == this.getBlue())
            && pixel.getMaxValue() == this.maxValue;
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.red, this.green, this.blue);
  }


}
