package controller.commands;

import model.Image;

public class HFlip implements Command {
  @Override
  public Image applyCommand(Image image) {
    return image.flipImageHorizontally();
  }
}
