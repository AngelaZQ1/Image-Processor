package controller;

import java.io.IOException;
import java.nio.file.InvalidPathException;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;

import controller.commands.BlueComponent;
import controller.commands.Blur;
import controller.commands.Brighten;
import controller.commands.Command;
import controller.commands.Darken;
import controller.commands.Grayscale;
import controller.commands.GreenComponent;
import controller.commands.HFlip;
import controller.commands.Intensity;
import controller.commands.Luma;
import controller.commands.RedComponent;
import controller.commands.Sepia;
import controller.commands.Sharpen;
import controller.commands.VFlip;
import controller.commands.Value;
import model.Image;
import view.View;

/**
 * This class represents an implementation of the Controller interface.
 * It enables the user to enter several commands to load, edit, and save an image.
 * INVARIANT: view is not null
 * INVARIANT: inputSource is not null
 */
public class ControllerImpl implements Controller {
  private final View view;
  private final Readable inputSource;
  private final Map<String, Image> listOfImages;

  /**
   * Creates a ControllerImpl object with the given view and input source.
   *
   * @param view  the given view to output to
   * @param input the input source for commands
   * @throws IllegalArgumentException if any of the given arguments are null
   */
  public ControllerImpl(View view, Readable input) throws IllegalArgumentException {
    if (view == null || input == null) {
      throw new IllegalArgumentException("The View and Readable cannot be null");
    }
    this.view = view;
    this.inputSource = input;
    this.listOfImages = new HashMap<>();
  }

  /**
   * Creates a ControllerImpl object with the given view, input source,
   * name of the starting image, and a starting image. Allows for creation of image processor
   * with image preloaded.
   *
   * @param view  the given view to output to
   * @param input the input source for commands
   * @param name  the name to use to refer to the given image
   * @param image the given image
   * @throws IllegalArgumentException if the view or input are null
   */
  public ControllerImpl(View view, Readable input, String name, Image image) {
    this(view, input);
    this.listOfImages.put(name, image);
  }

  @Override
  public void run() throws IOException {
    Scanner sc = new Scanner(inputSource);
    this.view.renderMessage("Hello, welcome to our image processor.\n");
    this.view.showOptions();

    // a map from a string to a function that takes a scanner and returns a command
    Map<String, Function<Scanner, Command>> knownCommands = new HashMap<>();
    knownCommands.put("red-component", (Scanner s) -> new RedComponent());
    knownCommands.put("green-component", (Scanner s) -> new GreenComponent());
    knownCommands.put("blue-component", (Scanner s) -> new BlueComponent());
    knownCommands.put("value", (Scanner s) -> new Value());
    knownCommands.put("intensity", (Scanner s) -> new Intensity());
    knownCommands.put("luma", (Scanner s) -> new Luma());
    knownCommands.put("vertical-flip", (Scanner s) -> new VFlip());
    knownCommands.put("horizontal-flip", (Scanner s) -> new HFlip());
    knownCommands.put("brighten", (Scanner s) -> new Brighten(s.nextInt()));
    knownCommands.put("darken", (Scanner s) -> new Darken(s.nextInt()));
    knownCommands.put("blur", (Scanner s) -> new Blur());
    knownCommands.put("sharpen", (Scanner s) -> new Sharpen());
    knownCommands.put("grayscale", (Scanner s) -> new Grayscale(s.nextInt(), s.nextInt(), s.nextInt()));
    knownCommands.put("sepia", (Scanner s) -> new Sepia());


    String userCommand;
    String fileName;

    while (sc.hasNext()) { // if the user has more input
      Command c;  // create a command object
      userCommand = sc.next(); // get the user's command

      if (userCommand.equalsIgnoreCase("q")) {
        this.view.renderMessage("Program Quit!");
        return;
      }

      if (userCommand.equals("load")) {
        loadHelper(sc);
      } else if (userCommand.equals("save")) {
        this.saveHelper(sc);
      } else {
        String imageName = sc.next();
        String nameToSaveImageAs = sc.next();
        Image imageToUse = this.getImageFromName(imageName); // get the image to work on

        // get the value of the key (the users input) which is the command object we want
        Function<Scanner, Command> cmd = knownCommands.getOrDefault(userCommand, null);
        c = cmd.apply(sc); // get the command object using the user's input
        Image newImage = c.applyCommand(imageToUse); // run that command object

        this.listOfImages.put(nameToSaveImageAs, newImage); // add image and image name to hashmap
      }
    }
  }

  // helper method to handle the load command. Puts the given image and image name in the Map
  // throws an IOException if the view is unable to transmit output
  private void loadHelper(Scanner sc) throws IOException {
    boolean validFilePath = false;
    while (!validFilePath) { // keep asking user for input while the filePath is invalid
      try {
        Image newImage = ImageUtil.readImage(sc.next()); // get the image to work on
        String fileName = sc.next(); // get name of image to work on
        this.listOfImages.put(fileName, newImage); // add image and image name to hashmap
        validFilePath = true;
      } catch (IOException e) {
        this.view.renderMessage("Invalid file path. Try again.\n");
      }
    }
    this.view.renderMessage("Success! Image loaded.\n");
  }


  // helper method to handle the saving an image to a destination
  // throws an IOException if the view is unable to transmit output
  private void saveHelper(Scanner sc) throws IOException {
    String filePath = "";
    boolean validFp = false;
    while (!validFp) {
      filePath = sc.next();
      try { // keep trying to get a valid file path to save image to
        Paths.get(filePath);
        validFp = true;
      } catch (InvalidPathException e) {
        this.view.renderMessage("Invalid file path. Try again.\n");
      }
    }
    Image image = null;
    boolean validName = false;
    while (!validName) { // keep trying to get a valid image name from the hashmap
      String fileName = sc.next();
      image = this.getImageFromName(fileName);
      if (image != null) {
        validName = true;
      }
    }
    try {
      new ImageUtil().saveImage(filePath, image);
      this.view.renderMessage("Success! Image saved.\n");
    } catch (IOException ignore) {
      this.view.renderMessage(ignore.getMessage() + "\nInvalid file path. Image Not Saved");
    }
  }

  // gets the image from the hashmap from the given imageName
  // throws an IOException if there is an issue rendering the message to the user
  private Image getImageFromName(String imageName) throws IOException {
    // if the image with this name doesn't exist in the hashmap
    if (this.listOfImages.get(imageName) == null) {
      this.view.renderMessage("Invalid image name. Please try again.\n");
    }
    // return the image corresponding to the image name
    return this.listOfImages.get(imageName);
  }


//      while (true) {
//      userInput = sc.next();
//      if (userInput.equalsIgnoreCase("q")) {
//        this.view.renderMessage("Program Quit!");
//        return;
//      }
//      switch (userInput) {
//        case "load":
//          boolean validFilePath = false;
//          while (!validFilePath) { // keep asking user for input while the filePath is invalid
//            try {
//              Image newImage = ImageUtil.readImage(sc.next()); // get the image to work on
//              String fileName = sc.next(); // get name of image to work on
//              this.listOfImages.put(fileName, newImage); // add image and image name to hashmap
//              validFilePath = true;
//            } catch (IOException e) {
//              this.view.renderMessage("Invalid file path. Try again.\n");
//            }
//          }
//          this.view.renderMessage("Success! Image loaded.\n");
//          break;
//        case "save":
//          String filePath = "";
//          boolean validFp = false;
//          while (!validFp) {
//            filePath = sc.next();
//            try { // keep trying to get a valid file path to save image to
//              Paths.get(filePath);
//              validFp = true;
//            } catch (InvalidPathException e) {
//              this.view.renderMessage("Invalid file path. Try again.\n");
//            }
//          }
//          Image image = null;
//          boolean validName = false;
//          while (!validName) { // keep trying to get a valid image name from the hashmap
//            String fileName = sc.next();
//            image = this.getImageFromName(fileName);
//            if (image != null) {
//              validName = true;
//            }
//          }
//          try {
//            new ImageUtil().saveImage(filePath, image);
//            this.view.renderMessage("Success! Image saved.\n");
//          } catch (IOException ignore) {
//            this.view.renderMessage(ignore.getMessage() + "\nImage Not Saved");
//          }
//          break;
//        case "red-component":
//          try {
//            Image newImage = this.getImageFromName(sc.next()).visualizeRedChannel();
//            // add the resulting image to the hashmap according to the given image name
//            this.listOfImages.put(sc.next(), newImage);
//          } catch (IOException e) {
//            break; // tell the user and ask for more input
//          }
//          this.view.renderMessage("Success! Image greyscaled by red hue.\n");
//          break;
//        case "green-component":
//          try {
//            Image newImage = this.getImageFromName(sc.next()).visualizeGreenChannel();
//            // add the resulting image to the hashmap according to the given image name
//            this.listOfImages.put(sc.next(), newImage);
//          } catch (IOException e) {
//            break; // tell the user and ask for more input
//          }
//          this.view.renderMessage("Success! Image grayscaled by green hue.\n");
//          break;
//        case "blue-component":
//          try {
//            Image newImage = this.getImageFromName(sc.next()).visualizeBlueChannel();
//            // add the resulting image to the hashmap according to the given image name
//            this.listOfImages.put(sc.next(), newImage);
//          } catch (IOException e) {
//            break; // tell the user and ask for more input
//          }
//          this.view.renderMessage("Success! Image greyscaled by blue hue.\n");
//          break;
//        case "value":
//          try {
//            Image newImage = this.getImageFromName(sc.next()).visualizeValue();
//            // add the resulting image to the hashmap according to the given image name
//            this.listOfImages.put(sc.next(), newImage);
//          } catch (IOException e) {
//            break; // tell the user and ask for more input
//          }
//          this.view.renderMessage("Success! Image greyscaled by value.\n");
//          break;
//        case "intensity":
//          try {
//            Image newImage = this.getImageFromName(sc.next()).visualizeIntensity();
//            // add the resulting image to the hashmap according to the given image name
//            this.listOfImages.put(sc.next(), newImage);
//          } catch (IOException e) {
//            break; // tell the user and ask for more input
//          }
//          this.view.renderMessage("Success! Image greyscaled by intensity.\n");
//          break;
//        case "luma":
//          try {
//            Image newImage = this.getImageFromName(sc.next()).visualizeLuma();
//            // add the resulting image to the hashmap according to the given image name
//            this.listOfImages.put(sc.next(), newImage);
//          } catch (IOException e) {
//            break; // tell the user and ask for more input
//          }
//          this.view.renderMessage("Success! Image greyscaled by luma.\n");
//          break;
//        case "vertical-flip":
//          try {
//            Image newImage = this.getImageFromName(sc.next()).flipImageVertically();
//            // add the resulting image to the hashmap according to the given image name
//            this.listOfImages.put(sc.next(), newImage);
//          } catch (IOException e) {
//            break; // tell the user and ask for more input
//          }
//          this.view.renderMessage("Success! Image flipped vertically.\n");
//          break;
//        case "horizontal-flip":
//          try {
//            Image newImage = this.getImageFromName(sc.next()).flipImageHorizontally();
//            // add the resulting image to the hashmap according to the given image name
//            this.listOfImages.put(sc.next(), newImage);
//          } catch (IOException e) {
//            break; // tell the user and ask for more input
//          }
//          this.view.renderMessage("Success! Image flipped horizontally.\n");
//          break;
//        case "brighten":
//          try {
//            int brightenBy = sc.nextInt();
//            String imageName = sc.next();
//            Image newImage = this.getImageFromName(imageName).brightenImage(brightenBy);
//            // add the resulting image to the hashmap according to the given image name
//            this.listOfImages.put(sc.next(), newImage);
//          } catch (IOException e) {
//            break; // tell the user and ask for more input
//          }
//          this.view.renderMessage("Success! Image brightened.\n");
//          break;
//        case "darken":
//          try {
//            int darkenBy = sc.nextInt();
//            String imageName = sc.next();
//            Image newImage = this.getImageFromName(imageName).darkenImage(darkenBy);
//            // add the resulting image to the hashmap according to the given image name
//            this.listOfImages.put(sc.next(), newImage);
//          } catch (IOException e) {
//            break; // tell the user and ask for more input
//          }
//          this.view.renderMessage("Success! Image darkened.\n");
//          break;
//        case "blur":
//          try {
//            Image newImage = this.getImageFromName(sc.next()).blur();
//            // add the resulting image to the hashmap according to the given image name
//            this.listOfImages.put(sc.next(), newImage);
//          } catch (IOException e) {
//            break; // tell the user and ask for more input
//          }
//          this.view.renderMessage("Success! Image blurred.\n");
//          break;
//        case "sharpen":
//          try {
//            Image newImage = this.getImageFromName(sc.next()).sharpen();
//            // add the resulting image to the hashmap according to the given image name
//            this.listOfImages.put(sc.next(), newImage);
//          } catch (IOException e) {
//            break; // tell the user and ask for more input
//          }
//          this.view.renderMessage("Success! Image sharpened.\n");
//          break;
//        case "grayscale":
//          try {
//            Image newImage = this.getImageFromName(sc.next())
//                    .grayscaleColorTransform(.2126, .7152, .0722);
//            // add the resulting image to the hashmap according to the given image name
//            this.listOfImages.put(sc.next(), newImage);
//          } catch (IOException e) {
//            break; // tell the user and ask for more input
//          }
//          this.view.renderMessage("Success! Image grayscaled.\n");
//          break;
//        case "sepia":
//          try {
//            Image newImage = this.getImageFromName(sc.next()).sepia();
//            // add the resulting image to the hashmap according to the given image name
//            this.listOfImages.put(sc.next(), newImage);
//          } catch (IOException e) {
//            break; // tell the user and ask for more input
//          }
//          this.view.renderMessage("Success! Image sepiaed.\n");
//          break;
//        default:
//          view.renderMessage("Unknown command. Please try again.\n");
//      }
//    }


}
