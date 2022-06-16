package controller.commands;

import model.Image;

public class Sepia implements Command {
  @Override
  public Image applyCommand(Image image) {
    return image.sepia();
  }
}
