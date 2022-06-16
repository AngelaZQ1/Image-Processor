package controller.commands;

import model.Image;

public interface Command {
  Image applyCommand(Image image);
}
