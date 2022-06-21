package view;


import controller.Features;

public interface GUIView {

  void updateImage(model.Image image);

  void updateRedHistogram(Histogram histogram);

  void updateGreenHistogram(Histogram histogram);

  void updateBlueHistogram(Histogram histogram);

  void updateIntensityHistogram(Histogram histogram);

  void addFeatures(Features features);
}
