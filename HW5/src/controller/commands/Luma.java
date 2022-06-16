package controller.commands;

import model.Image;

public class Luma implements Command {
  @Override
  public Image applyCommand(Image image) {
    return image.visualizeLuma();
  }
}
