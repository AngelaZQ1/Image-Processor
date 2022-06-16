package controller.commands;

import model.Image;

public interface Command {
  void applyCommand(Image image);
}
