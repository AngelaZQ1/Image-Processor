package view;

import java.io.IOException;

/**
 * This class is an implementation of the View interface. It offers functionality to allow
 * the display of messages to the user.
 */
public class TextView implements View {
  private final Appendable destination;

  /**
   * The default constructor that creates a TextView object and uses System.out
   * as the destination.
   */
  public TextView() {
    this.destination = System.out;
  }

  /**
   * A Constructor that creates a TextView object using the given appendable as its destination.
   *
   * @param destination the given Appendable
   * @throws IllegalArgumentException if the given Appendable is null
   */
  public TextView(Appendable destination) throws IllegalArgumentException {
    if (destination == null) {
      throw new IllegalArgumentException("The given Appendable can not be null");
    }
    this.destination = destination;
  }

  @Override
  public void renderMessage(String message) throws IOException {
    this.destination.append(message);
  }

  @Override
  public void showOptions() throws IOException {
    this.destination.append("Available Commands:\n");
    this.destination.append("Load Image: load image-path image-name\n");
    this.destination.append("Save Image: save image-path image-name\n");
    this.destination.append("Red-Component: red-component image-name dest-image-name\n");
    this.destination.append("Green-Component: green-component image-name dest-image-name\n");
    this.destination.append("Blue-Component: blue-component image-name dest-image-name\n");
    this.destination.append("Value: value image-name dest-image-name\n");
    this.destination.append("Luma: luma image-name dest-image-name\n");
    this.destination.append("Intensity: intensity image-name dest-image-name\n");
    this.destination.append("Horizontal Flip: horizontal-flip image-name dest-image-name\n");
    this.destination.append("Vertical Flip: vertical-flip image-name dest-image-name\n");
    this.destination.append("Brighten: Brighten increment image-name dest-image-name\n");
    this.destination.append("Darken: darken increment image-name dest-image-name\n");
    this.destination.append("Sharpen: sharpen image-name dest-image-name\n");
    this.destination.append("Blur: blur image-name dest-image-name\n");
    this.destination.append("Grayscale: grayscale image-name dest-image-name\n");
    this.destination.append("Sepia: sepia image-name dest-image-name\n");
    this.destination.append("To Quit: q or Q\n");
  }
}
