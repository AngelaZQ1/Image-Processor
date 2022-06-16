package controller.commands;

import model.Image;

public class GreenComponent implements Command {
  @Override
  public Image applyCommand(Image image) {
    return image.visualizeGreenChannel();
  }
}
