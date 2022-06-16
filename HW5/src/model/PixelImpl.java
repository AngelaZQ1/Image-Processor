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
  protected final int red;
  protected final int green;
  protected final int blue;
  protected final int maxValue;

  /**
   * Creates a PixelImpl with the given RGB values and max value.
   *
   * @param red      red color value
   * @param green    green color value
   * @param blue     blue color value
   * @param maxValue the maximum value for a channel
   */
  public PixelImpl(int red, int green, int blue, int maxValue) {
    // Update: cap pixel value given at maxValue
    if (red > 0) {
      this.red = Math.min(red, maxValue);
    } else {
      this.red = 0;
    }
    if (green > 0) {
      this.green = Math.min(green, maxValue);
    } else {
      this.green = 0;
    }
    if (blue > 0) {
      this.blue = Math.min(blue, maxValue);
    } else {
      this.blue = 0;
    }
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
