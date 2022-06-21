package controller;


import model.Image;

public interface Features {

  public void updateImage(Image image);

  public void redComp();

  public void greenComp();

  public void blueComp();

  public void darken();

  public void brighten();

  public void vFlip();

  public void hFlip();

  public void value();

  public void intensity();

  public void luma();

  public void blur();

  public void sharpen();

  public void grayscale();

  public void sepia();

  public void load();

  public void save();

  public void exit();
}
