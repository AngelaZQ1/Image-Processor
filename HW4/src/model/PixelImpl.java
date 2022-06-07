package model;

/**
 * This class represents a pixel on an image. This pixel can be changed according to color.
 */
public class PixelImpl implements Pixel {

  private int red;
  private int green;
  private int blue;

  /**
   * Creates a pixel given its rgb values.
   * @param red red color value
   * @param green green color value
   * @param blue blue color value
   */
  public PixelImpl(int red, int green, int blue) {
    this.red = red;
    this.green = green;
    this.blue = blue;
  }

  @Override
  public Pixel changeColor(int r, int g, int b) {
    return new PixelImpl(red += r, green += g, blue += b);
  }

  @Override
  public Pixel value() {
    int value = Math.max(Math.max(red, green), blue);
    return new PixelImpl(value, value, value);
  }

  @Override
  public Pixel intensity() {
    int intensity = (red + green + blue) / 3;
    return new PixelImpl(intensity, intensity, intensity);
  }

  @Override
  public Pixel luma() {
    double luma = (0.2126 * red) + (0.7152 * green) + (0.0722 * blue);
    return new PixelImpl((int) luma, (int) luma, (int) luma);
  }

  @Override
  public Pixel redScale() {
    return new PixelImpl(red, red, red);
  }

  @Override
  public Pixel greenScale() {
    return new PixelImpl(green, green, green);
  }

  @Override
  public Pixel blueScale() {
    return new PixelImpl(blue, blue, blue);
  }

}
