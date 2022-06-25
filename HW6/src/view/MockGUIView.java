package view;

import java.util.Map;

import controller.Features;
import model.Image;
import view.GUIView;
import view.JFrameView;

/**
 * This class represents a mock View. It is used to test that its methods are called and with
 * the correct arguments.
 */
public class MockGUIView extends JFrameView {
  private final StringBuilder log;

  /**
   * Creates a MockGUIView object with the given StringBuilder as the log.
   * @param log the StringBuilder to use as the log
   */
  public MockGUIView(StringBuilder log) {
    super("");
    this.log = log;
  }

  /**
   * Ensures that the updateImage method is called correctly by appending "updateImage" to
   * this mock's log.
   * @param image the given image, ignored
   */
  @Override
  public void updateImage(Image image) {
    log.append("updateImage");
  }

  /**
   * Ensures that the addFeatures method is called correctly by appending "addFeatures" to
   * this mock's log.
   * @param features the given Featured object, ignored
   */
  @Override
  public void addFeatures(Features features) {
    log.append("addFeatures");
  }
}
