package controller.commands;

import model.Image;

public class Blur implements Command {
  @Override
  public Image applyCommand(Image image) {
    return image.blur();
  }
}
