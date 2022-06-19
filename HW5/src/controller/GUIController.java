package controller;

import java.util.HashMap;
import java.util.Map;

import model.Image;
import view.GUIView;

public class GUIController {
  private final Map<String, Image> listOfImages;
  private GUIView view;

  public GUIController() {
    this.listOfImages = new HashMap<>();
  }

  public void setView(GUIView v) {
    view = v;
    //provide view with all the callbacks
    view.addFeatures();
  }


//  @Override
//  public void exitProgram() {
//    System.exit(0);
//  }
}
