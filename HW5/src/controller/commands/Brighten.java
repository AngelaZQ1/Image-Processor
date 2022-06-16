package controller.commands;

import model.Image;

public class Brighten implements Command {
  private int value;
  public Brighten(int value) {
    this.value = value;
  }
  @Override
  public Image applyCommand(Image image) {
    return image.brighten(value);
  }
}
