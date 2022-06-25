import org.junit.Test;

import controller.Features;
import controller.GUIController;
import controller.MockGUIController;
import view.GUIView;
import view.JFrameView;
import view.MockGUIView;

import static org.junit.Assert.assertEquals;

/**
 * This class tests that the GUIController and JFrameView classes communicate as intended.
 * This class uses mocks to test that the correct methods in each class are called.
 */
public class FeaturesTest {

  @Test
  public void testControllerSetView() {
    GUIController controller = new GUIController();
    StringBuilder log = new StringBuilder();
    MockGUIView mockView = new MockGUIView(log);

    controller.setView(mockView);
    assertEquals("addFeatures", log.toString());
  }

  @Test
  public void testControllerUpdateImage() {
    StringBuilder log = new StringBuilder();
    GUIView mockView = new MockGUIView(log);

    GUIController controller = new GUIController();
    controller.setView(mockView);
    assertEquals("addFeatures", log.toString());
    controller.updateImage(null);
    assertEquals("addFeatures" +
            "updateImage", log.toString());
  }

  @Test
  public void testAddFeatures() {
    GUIView view = new JFrameView("Test");
    StringBuilder log = new StringBuilder();
    Features mockController = new MockGUIController(log);
    view.addFeatures(mockController);

    assertEquals("redComp" +
            "greenComp" +
            "blueComp" +
            "darken" +
            "brighten" +
            "vFlip" +
            "hFlip" +
            "value" +
            "intensity" +
            "luma" +
            "blur" +
            "sharpen" +
            "grayscale" +
            "sepia", log.toString());
  }

  @Test
  public void testGreenComp() {

  }

  @Test
  public void testBlueComp() {

  }

  @Test
  public void testDarken() {

  }

  @Test
  public void testBrighten() {

  }

  @Test
  public void testVFlip() {

  }

  @Test
  public void testHFlip() {

  }

  @Test
  public void testValue() {

  }

  @Test
  public void testIntensity() {

  }

  @Test
  public void testLuma() {

  }

  @Test
  public void testBlur() {

  }

  @Test
  public void testSharpen() {

  }

  @Test
  public void testGrayscale() {

  }

  @Test
  public void testSepia() {

  }

  @Test
  public void testLoad() {

  }

  @Test
  public void testSave() {

  }

}