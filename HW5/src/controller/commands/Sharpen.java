package controller.commands;

import model.Image;

public class Sharpen implements Command {
  @Override
  public Image applyCommand(Image image) {
    return image.sharpen();
  }
}
