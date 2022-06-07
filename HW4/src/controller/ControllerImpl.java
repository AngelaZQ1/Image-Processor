package controller;

import java.util.HashMap;
import java.util.Scanner;

import model.Image;
import model.ImageImpl;
import view.View;

public class ControllerImpl implements Controller {

  private Image image;
  private final View view;
  private final Readable inputSource;
  private HashMap<String, Image> images;

  public ControllerImpl(Image image, View view, Readable input) {
    this.image = image;
    this.view = view;
    this.inputSource = input;
    this.images = new HashMap<>();
  }

  @Override
  public void run() {
    Scanner sc = new Scanner(inputSource);
    boolean run = true;
    String userInput;
    while(run) {
      userInput = sc.next();

      switch (userInput) {
        case "load":
          String filePath = sc.next();
          Image image = controller.ImageUtil.readPPM(filePath);

          break;
        case "save":

          break;
        case "visualize-red":
          image.visualizeRedChannel();
          break;
        case "visualize-green":
          image.visualizeGreenChannel();
          break;
        case "visualize-blue":
          image.visualizeBlueChannel();
          break;
        case "visualize-value":
          image.visualizeValue();
          break;
        case "visualize-intensity":
          image.visualizeIntensity();
          break;
        case "visualize-luma":
          image.visualizeLuma();
          break;
        case "vertical-flip":
          image.flipImageVertically();
          break;
        case "horizontal-flip":
          image.flipImageHorizontally();
          break;
        case "brighten":
          image.brightenImage(sc.nextInt());
          break;
        case "darken":
          image.darkenImage(sc.nextInt());
          break;
        default:

      }
    }


  }
}
