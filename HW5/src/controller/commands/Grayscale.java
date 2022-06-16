package controller.commands;

import model.Image;

public class Grayscale implements Command {
  private int red;
  private int green;
  private int blue;

  public Grayscale(int r, int g, int b) {
    this.red = r;
    this.green = g;
    this.blue = b;
  }

  @Override
  public Image applyCommand(Image image) {
    return image.grayscaleColorTransform(red, green, blue);
  }
}
