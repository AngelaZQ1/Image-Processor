package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * This class represents a mock view for testing purposes. It ensures that
 * the correct arguments are being passed into its methods.
 */
public class MockImage implements Image {
  private final StringBuilder log;
  private final Image fakeImage;

  /**
   * Creates a MockImage object with the given StringBuilder.
   *
   * @param log the StringBuilder to use to log values
   */
  public MockImage(StringBuilder log) {
    this.log = Objects.requireNonNull(log);
    List<Pixel> row = new ArrayList<>();
    row.add(new PixelImpl(1, 2, 3, 255));
    row.add(new PixelImpl(1, 2, 3, 255));
    List<List<Pixel>> temp = new ArrayList<>();
    temp.add(row);
    temp.add(row);
    this.fakeImage = new ImageImpl(temp, 255);
  }

  /**
   * Tests that this method is called by appending "visualize red" to this mock's log.
   *
   * @return null
   */
  @Override
  public Image visualizeRedChannel() {
    log.append("visualize red\n");
    return this;
  }

  /**
   * Tests that this method is called by appending "visualize green" to this mock's log.
   *
   * @return null
   */
  @Override
  public Image visualizeGreenChannel() {
    log.append("visualize green\n");
    return this;
  }

  /**
   * Tests that this method is called by appending "visualize blue" to this mock's log.
   *
   * @return null
   */
  @Override
  public Image visualizeBlueChannel() {
    log.append("visualize blue\n");
    return this;
  }

  /**
   * Tests that this method is called by appending "visualize value" to this mock's log.
   *
   * @return null
   */
  @Override
  public Image visualizeValue() {
    log.append("visualize value\n");
    return this;
  }

  /**
   * Tests that this method is called by appending "visualize intensity" to this mock's log.
   *
   * @return null
   */
  @Override
  public Image visualizeIntensity() {
    log.append("visualize intensity\n");
    return this;
  }

  /**
   * Tests that this method is called by appending "visualize luma" to this mock's log.
   *
   * @return null
   */
  @Override
  public Image visualizeLuma() {
    log.append("visualize luma\n");
    return this;
  }

  /**
   * Tests that this method is called by appending "flip vertically" to this mock's log.
   *
   * @return null
   */
  @Override
  public Image flipImageVertically() {
    log.append("flip vertically\n");
    return this;
  }

  /**
   * Tests that this method is called by appending "flip horizontally" to this mock's log.
   *
   * @return null
   */
  @Override
  public Image flipImageHorizontally() {
    log.append("flip horizontally\n");
    return this;
  }

  /**
   * Tests that this method is called with the correct argument by appending the given value
   * to this mock's log.
   *
   * @param value the value to append
   * @return null
   */
  @Override
  public Image brighten(int value) {
    log.append("Brighten by " + value + "\n");
    return this;
  }

  /**
   * Tests that this method is called with the correct argument by appending the given value
   * to this mock's log.
   *
   * @param value the value to append
   * @return null
   */
  @Override
  public Image darken(int value) {
    log.append("darken by " + value + "\n");
    return fakeImage;
  }

  @Override
  public Image blur() {
    log.append("Blur\n");
    return this;
  }

  @Override
  public Image sharpen() {
    log.append("sharpen\n");
    return this;
  }

  @Override
  public Image grayscaleColorTransform() {
    log.append("grayscale\n");
    return this;
  }

  @Override
  public Image sepia() {
    log.append("sepia\n");
    return this;
  }

  /**
   * Tests that this method is called by appending "get width" to this mock's log.
   *
   * @return null
   */
  @Override
  public int getWidth() {
    log.append("get width\n");
    return 1;
  }

  /**
   * Tests that this method is called by appending "get height" to this mock's log.
   *
   * @return 0
   */
  @Override
  public int getHeight() {
    log.append("get height\n");
    return 1;
  }

  /**
   * Tests that this method is called by appending "get max value" to this mock's log.
   *
   * @return 0
   */
  @Override
  public int getMaxValue() {
    log.append("get max value\n");
    return 1;
  }

  /**
   * Tests that this method is called with the correct arguments by appending the given row and col
   * to this mock's log.
   *
   * @param row the row value to append
   * @param col the column value to append
   * @return null
   */
  @Override
  public Pixel getPixel(int row, int col) {
    log.append("get pixel from row \n" + row + " col " + col);
    return null;
  }
}
