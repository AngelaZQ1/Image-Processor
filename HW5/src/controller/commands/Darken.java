package controller.commands;

import model.Image;

public class Darken implements Command {
  private int value;

  public Darken(int value) {
    this.value = value;
  }

  @Override
  public Image applyCommand(Image image) {
    return image.darken(value);
  }
}
