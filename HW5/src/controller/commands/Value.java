package controller.commands;

import model.Image;

public class Value implements Command {
  @Override
  public Image applyCommand(Image image) {
    return image.visualizeValue();
  }
}
