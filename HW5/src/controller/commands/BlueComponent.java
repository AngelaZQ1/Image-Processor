package controller.commands;

import model.Image;

public class BlueComponent implements Command {
  @Override
  public Image applyCommand(Image image) {
    return image.visualizeBlueChannel();
  }
}
