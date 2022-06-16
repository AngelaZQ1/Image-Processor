package controller.commands;

import model.Image;

public class Intensity implements Command {
  @Override
  public Image applyCommand(Image image) {
    return image.visualizeIntensity();
  }
}
