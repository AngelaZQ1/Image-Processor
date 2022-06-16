package controller.commands;

import model.Image;

public class RedComponent implements Command {
  @Override
  public Image applyCommand(Image image) {
    return image.visualizeRedChannel();
  }
}
