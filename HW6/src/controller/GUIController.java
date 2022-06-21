package controller;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

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
import view.GUIView;

public class GUIController implements Features {
  private Image image;
  private GUIView view;

  public GUIController() {
    this.image = null;
  }

  public void setView(GUIView v) {
    view = v;
    view.addFeatures(this);
  }

  private void applyCommandAndUpdateImage(Command command) {
    Image newImage = command.applyCommand(this.image);
    this.view.updateImage(newImage);
    this.updateImage(newImage);

    Map<Integer, Integer> distributionOfRedValues = this.image.getRedDistribution();
    Map<Integer, Integer> distributionOfGreenValues = this.image.getGreenDistribution();
    Map<Integer, Integer> distributionOfBlueValues = this.image.getBlueDistribution();
    this.view.updateRedHistogram(distributionOfRedValues);
    this.view.updateGreenHistogram(distributionOfGreenValues);
    this.view.updateBlueHistogram(distributionOfBlueValues);
  }

  @Override
  public void updateImage(Image image) {
    this.image = image;
  }

  @Override
  public void redComp() {
    this.applyCommandAndUpdateImage(new RedComponent());
  }

  @Override
  public void greenComp() {
    this.applyCommandAndUpdateImage(new GreenComponent());
  }

  @Override
  public void blueComp() {
    this.applyCommandAndUpdateImage(new BlueComponent());
  }

  @Override
  public void darken() {
    this.applyCommandAndUpdateImage(new Darken(25));
  }

  @Override
  public void brighten() {
    this.applyCommandAndUpdateImage(new Brighten(25));
  }

  @Override
  public void vFlip() {
    this.applyCommandAndUpdateImage(new VFlip());
  }

  @Override
  public void hFlip() {
    this.applyCommandAndUpdateImage(new HFlip());
  }

  @Override
  public void value() {
    this.applyCommandAndUpdateImage(new Value());
  }

  @Override
  public void intensity() {
    this.applyCommandAndUpdateImage(new Intensity());
  }

  @Override
  public void luma() {
    this.applyCommandAndUpdateImage(new Luma());
  }

  @Override
  public void blur() {
    this.applyCommandAndUpdateImage(new Blur());
  }

  @Override
  public void sharpen() {
    this.applyCommandAndUpdateImage(new Sharpen());
  }

  @Override
  public void grayscale() {
    this.applyCommandAndUpdateImage(new Grayscale());
  }

  @Override
  public void sepia() {
    this.applyCommandAndUpdateImage(new Sepia());
  }

  @Override
  public void load() {
    final JFileChooser fchooser = new JFileChooser(".");
    FileNameExtensionFilter filter = new FileNameExtensionFilter(
            "jpeg", "jpg", "ppm", "bmp", "png");
    fchooser.setFileFilter(filter);

    File f = null;
    int retvalue = fchooser.showOpenDialog((Component) view);
    if (retvalue == JFileChooser.APPROVE_OPTION) {
      f = fchooser.getSelectedFile();
      view.setOpenFilePath(f.getAbsolutePath());
    }
    view.updateImage(f.getAbsolutePath());
    try {
      this.image = ImageUtil.readImage(f.getAbsolutePath());
    } catch (IOException e) {
      System.out.println("IOException");
    }
  }

  @Override
  public void save() {
    final JFileChooser fchooser = new JFileChooser(".");
    int retvalue = fchooser.showSaveDialog((Component) view);
    File f = null;
    if (retvalue == JFileChooser.APPROVE_OPTION) {
      f = fchooser.getSelectedFile();
      view.setSaveFilePath(f.getAbsolutePath());
    }
    try {
      ImageUtil.saveImage(f.getAbsolutePath(), this.image);
    } catch (IOException e) {
      System.out.println(f.getAbsolutePath());
    }
  }

  @Override
  public void exit() {
    System.exit(0);
  }
}
