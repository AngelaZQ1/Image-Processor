package controller;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

import model.Image;
import model.ImageImpl;
import view.View;

public class ControllerImpl implements Controller {
  private final View view;
  private final Readable inputSource;
  private HashMap<String, Image> listOfImages;

  public ControllerImpl(View view, Readable input) {
    this.view = view;
    this.inputSource = input;
    this.listOfImages = new HashMap<>();
  }

  @Override
  public void run() throws IOException {
    Scanner sc = new Scanner(inputSource);
    String userInput;
    this.view.renderMessage("Hello, welcome to our image processor.\n");
    this.view.showOptions();
    while (true) {
      userInput = sc.next();

      switch (userInput) {
        case "load":
          boolean validFilePath = false;
          while (!validFilePath) { // keep asking user for input while the filePath is invalid
            try {
              Image newImage = ImageUtil.readPPM(sc.next());
              String fileName = sc.next();
              this.listOfImages.put(fileName, newImage);
              validFilePath = true;
            } catch (FileNotFoundException ignore) {
              // filepath was invalid, keep asking for input
              this.view.renderMessage("Invalid file path. Try again.\n");
            }
          }
          this.view.renderMessage("Success! Image loaded.\n");
          break;
        case "save":
          String filePath = sc.next();
          Image image = this.getImageFromName(sc.next());
          BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
          writer.write(writePPM(image).toString());
          writer.close();
          this.view.renderMessage("Success! Image saved. \n");
          break;
        case "visualize-red":
          try {
            Image newImage = this.getImageFromName(sc.next()).visualizeRedChannel();
            // add the resulting image to the hashmap according to the given image name
            this.listOfImages.put(sc.next(), newImage);
          } catch (IOException e) {
            break; // tell the user and ask for more input
          }
          this.view.renderMessage("Success! Image greyscsaled by red hue.\n");
          break;
        case "green-component":
          try {
            Image newImage = this.getImageFromName(sc.next()).visualizeGreenChannel();
            // add the resulting image to the hashmap according to the given image name
            this.listOfImages.put(sc.next(), newImage);
          } catch (IOException e) {
            break; // tell the user and ask for more input
          }
          this.view.renderMessage("Success! Image greyscasdfaled by green hue.\n");
          break;
        case "blue-component":
          try {
            Image newImage = this.getImageFromName(sc.next()).visualizeBlueChannel();
            // add the resulting image to the hashmap according to the given image name
            this.listOfImages.put(sc.next(), newImage);
          } catch (IOException e) {
            break; // tell the user and ask for more input
          }
          this.view.renderMessage("Success! Image greyscaled by blue hue.\n");
          break;
        case "value":
          try {
            Image newImage = this.getImageFromName(sc.next()).visualizeValue();
            // add the resulting image to the hashmap according to the given image name
            this.listOfImages.put(sc.next(), newImage);
          } catch (IOException e) {
            break; // tell the user and ask for more input
          }
          this.view.renderMessage("Success! Image greyscaled by value.\n");
          break;
        case "intensity":
          try {
            Image newImage = this.getImageFromName(sc.next()).visualizeIntensity();
            // add the resulting image to the hashmap according to the given image name
            this.listOfImages.put(sc.next(), newImage);
          } catch (IOException e) {
            break; // tell the user and ask for more input
          }
          this.view.renderMessage("Success! Image greyscaled by intensity.\n");
          break;
        case "luma":
          try {
            Image newImage = this.getImageFromName(sc.next()).visualizeLuma();
            // add the resulting image to the hashmap according to the given image name
            this.listOfImages.put(sc.next(), newImage);
          } catch (IOException e) {
            break; // tell the user and ask for more input
          }
          this.view.renderMessage("Success! Image greyscsaled by luma.\n");
          break;
        case "vertical-flip":
          try {
            Image newImage = this.getImageFromName(sc.next()).flipImageVertically();
            // add the resulting image to the hashmap according to the given image name
            this.listOfImages.put(sc.next(), newImage);
          } catch (IOException e) {
            break; // tell the user and ask for more input
          }
          this.view.renderMessage("Success! Image flipped vertically.\n");
          break;
        case "horizontal-flip":
          try {
            Image newImage = this.getImageFromName(sc.next()).flipImageHorizontally();
            // add the resulting image to the hashmap according to the given image name
            this.listOfImages.put(sc.next(), newImage);
          } catch (IOException e) {
            break; // tell the user and ask for more input
          }
          this.view.renderMessage("Success! Image flipped horizontally.\n");
          break;
        case "brighten":
          try {
            int brightenBy = sc.nextInt();
            String imageName = sc.next();
            Image newImage = this.getImageFromName(imageName).brightenImage(brightenBy);
            // add the resulting image to the hashmap according to the given image name
            this.listOfImages.put(sc.next(), newImage);
          } catch (IOException e) {
            break; // tell the user and ask for more input
          }
          this.view.renderMessage("Success! Image brightened.\n");
          break;
        case "darken":
          try {
            int darkenBy = sc.nextInt();
            String imageName = sc.next();
            Image newImage = this.getImageFromName(imageName).darkenImage(darkenBy);
            // add the resulting image to the hashmap according to the given image name
            this.listOfImages.put(sc.next(), newImage);
          } catch (IOException e) {
            break; // tell the user and ask for more input
          }
          this.view.renderMessage("Success! Image darkened.\n");
          break;
        default:
          view.renderMessage("Unknown command. Please try again.\n");
      }
    }


  }
}
