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
      newRed = Math.min(red + r, this.maxValue);
    } else {
      newRed = Math.max(red + r, 0);
    }
    if (g > 0) {
      newGreen = Math.min(green + g, this.maxValue);
    } else {
      newGreen = Math.max(green + g, 0);
    }
    if (b > 0) {
      newBlue = Math.min(blue + b, this.maxValue);
    } else {
      newBlue = Math.max(blue + b, 0);
    }
    return new PixelImpl(newRed, newGreen, newBlue, maxValue);
  }

  @Override
  public Pixel value() {
    int value = Math.max(Math.max(red, green), blue);
    return new PixelImpl(value, value, value, maxValue);
  }

  @Override
  public Pixel intensity() {
    int intensity = (red + green + blue) / 3;
    return new PixelImpl(intensity, intensity, intensity, maxValue);
  }

  @Override
  public Pixel luma() {
    double luma = (0.2126 * red) + (0.7152 * green) + (0.0722 * blue);
    return new PixelImpl((int) luma, (int) luma, (int) luma, maxValue);
  }

  @Override
  public Pixel redScale() {
    return new PixelImpl(red, red, red, maxValue);
  }

  @Override
  public Pixel greenScale() {
    return new PixelImpl(green, green, green, maxValue);
  }

  @Override
  public Pixel blueScale() {
    return new PixelImpl(blue, blue, blue, maxValue);
  }

  @Override
  public int getRed() {
    return red;
  }

  @Override
  public int getGreen() {
    return green;
  }

  @Override
  public int getBlue() {
    return blue;
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
