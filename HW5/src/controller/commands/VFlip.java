package controller.commands;

import model.Image;

public class VFlip implements Command {
  @Override
  public Image applyCommand(Image image) {
    return image.flipImageVertically();
  }
}
