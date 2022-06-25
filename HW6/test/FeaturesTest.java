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
    StringBuilder log = new StringBuilder();
    MockGUIView view = new MockGUIView(log);
    Features mockController = new MockGUIController(log);
    view.addFeatures(mockController);

    assertEquals("addFeatures", log.toString());
  }

  @Test
  public void testRedComp() {
    StringBuilder log = new StringBuilder();
    MockGUIController controller = new MockGUIController(log);
    controller.redComp();
    assertEquals("redComp", log.toString());
  }

  @Test
  public void testGreenComp() {
    StringBuilder log = new StringBuilder();
    MockGUIController controller = new MockGUIController(log);
    controller.greenComp();
    assertEquals("greenComp", log.toString());
  }

  @Test
  public void testBlueComp() {
    StringBuilder log = new StringBuilder();
    MockGUIController controller = new MockGUIController(log);
    controller.blueComp();
    assertEquals("blueComp", log.toString());
  }

  @Test
  public void testDarken() {
    StringBuilder log = new StringBuilder();
    MockGUIController controller = new MockGUIController(log);
    controller.darken();
    assertEquals("darken", log.toString());
  }

  @Test
  public void testBrighten() {
    StringBuilder log = new StringBuilder();
    MockGUIController controller = new MockGUIController(log);
    controller.brighten();
    assertEquals("brighten", log.toString());
  }

  @Test
  public void testVFlip() {
    StringBuilder log = new StringBuilder();
    MockGUIController controller = new MockGUIController(log);
    controller.vFlip();
    assertEquals("vFlip", log.toString());
  }

  @Test
  public void testHFlip() {
    StringBuilder log = new StringBuilder();
    MockGUIController controller = new MockGUIController(log);
    controller.hFlip();
    assertEquals("hFlip", log.toString());
  }

  @Test
  public void testValue() {
    StringBuilder log = new StringBuilder();
    MockGUIController controller = new MockGUIController(log);
    controller.value();
    assertEquals("value", log.toString());
  }

  @Test
  public void testIntensity() {
    StringBuilder log = new StringBuilder();
    MockGUIController controller = new MockGUIController(log);
    controller.intensity();
    assertEquals("intensity", log.toString());
  }

  @Test
  public void testLuma() {
    StringBuilder log = new StringBuilder();
    MockGUIController controller = new MockGUIController(log);
    controller.luma();
    assertEquals("luma", log.toString());
  }

  @Test
  public void testBlur() {
    StringBuilder log = new StringBuilder();
    MockGUIController controller = new MockGUIController(log);
    controller.blur();
    assertEquals("blur", log.toString());
  }

  @Test
  public void testSharpen() {
    StringBuilder log = new StringBuilder();
    MockGUIController controller = new MockGUIController(log);
    controller.sharpen();
    assertEquals("sharpen", log.toString());
  }

  @Test
  public void testGrayscale() {
    StringBuilder log = new StringBuilder();
    MockGUIController controller = new MockGUIController(log);
    controller.grayscale();
    assertEquals("grayscale", log.toString());
  }

  @Test
  public void testSepia() {
    StringBuilder log = new StringBuilder();
    MockGUIController controller = new MockGUIController(log);
    controller.sepia();
    assertEquals("sepia", log.toString());
  }

  @Test
  public void testLoad() {
    StringBuilder log = new StringBuilder();
    MockGUIController controller = new MockGUIController(log);
    controller.load();
    assertEquals("load", log.toString());
  }

  @Test
  public void testSave() {
    StringBuilder log = new StringBuilder();
    MockGUIController controller = new MockGUIController(log);
    controller.save();
    assertEquals("save", log.toString());
  }

}