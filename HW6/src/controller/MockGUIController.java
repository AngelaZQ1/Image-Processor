package controller;

import model.Image;

/**
 * This class represents a mock GUIController. It implements Features and used
 * used to test that its methods are called correctly.
 */
public class MockGUIController implements Features {
  private final StringBuilder log;

  public MockGUIController(StringBuilder log) {
    this.log = log;
  }

  @Override
  public void updateImage(Image image) {
    log.append("updateImage");
  }

  @Override
  public void redComp() {
    log.append("redComp");
  }

  @Override
  public void greenComp() {
    log.append("greenComp");
  }

  @Override
  public void blueComp() {
    log.append("blueComp");
  }

  @Override
  public void darken() {
    log.append("darken");
  }

  @Override
  public void brighten() {
    log.append("brighten");
  }

  @Override
  public void vFlip() {
    log.append("vFLip");
  }

  @Override
  public void hFlip() {
    log.append("hFlip");
  }

  @Override
  public void value() {
    log.append("value");
  }

  @Override
  public void intensity() {
    log.append("intensity");
  }

  @Override
  public void luma() {
    log.append("luma");
  }

  @Override
  public void blur() {
    log.append("blur");
  }

  @Override
  public void sharpen() {
    log.append("sharpen");
  }

  @Override
  public void grayscale() {
    log.append("grayscale");
  }

  @Override
  public void sepia() {
    log.append("sepia");
  }

  @Override
  public void load() {
    log.append("load");
  }

  @Override
  public void save() {
    log.append("save");
  }

  @Override
  public void exit() {
    log.append("exit");
  }
}
