package view;


import controller.Features;
import model.Image;

public interface GUIView {

  void updateImage(String filepath);

  void updateImage(Image image);

  void updateRedHistogram(Histogram histogram);

  void updateGreenHistogram(Histogram histogram);

  void updateBlueHistogram(Histogram histogram);

  void updateIntensityHistogram(Histogram histogram);

  void addFeatures(Features features);

  void setOpenFilePath(String filePath);

  void setSaveFilePath(String filePath);
}
