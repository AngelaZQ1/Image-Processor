package controller;

import java.util.HashMap;
import java.util.Map;

import javax.swing.*;

import controller.commands.BlueComponent;
import controller.commands.Blur;
import controller.commands.Brighten;
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
import view.GUIView;

public class GUIController implements Features {
  private final Image image;
  private GUIView view;

  public GUIController() {
    this.image = null;
  }

  public void setView(GUIView v) {
    view = v;
    //provide view with all the callbacks
    view.addFeatures(this);
  }

  public void updateImage() {

  }

  @Override
  public void redComp() {
    new RedComponent().applyCommand(this.image);
  }

  @Override
  public void greenComp() {
    new GreenComponent().applyCommand(this.image);
  }

  @Override
  public void blueComp() {
    new BlueComponent().applyCommand(this.image);
  }

  @Override
  public void darken() {
    new Darken(25).applyCommand(this.image);
  }

  @Override
  public void brighten() {
    new Brighten(25).applyCommand(this.image);
  }

  @Override
  public void vFlip() {
    new VFlip().applyCommand(this.image);
  }

  @Override
  public void hFlip() {
    new HFlip().applyCommand(this.image);
  }

  @Override
  public void value() {
    new Value().applyCommand(this.image);
  }

  @Override
  public void intensity() {
    new Intensity().applyCommand(this.image);
  }

  @Override
  public void luma() {
    new Luma().applyCommand(this.image);
  }

  @Override
  public void blur() {
    new Blur().applyCommand(this.image);
  }

  @Override
  public void sharpen() {
    new Sharpen().applyCommand(this.image);
  }

  @Override
  public void grayscale() {
    new Grayscale().applyCommand(this.image);
  }

  @Override
  public void sepia() {
    new Sepia().applyCommand(this.image);
  }

  @Override
  public void load() {
    new RedComponent().applyCommand(this.image);
  }

  @Override
  public void save() {
    new RedComponent().applyCommand(this.image);
  }

  @Override
  public void exit() {
    System.exit(0);
  }
}
