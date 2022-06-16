package controller.commands;

import model.Image;

public class redComponent implements Command {
  @Override
  public void applyCommand(Image image) {

    Image newImage = this.getImageFromName(sc.next()).visualizeRedChannel();
  }
}
