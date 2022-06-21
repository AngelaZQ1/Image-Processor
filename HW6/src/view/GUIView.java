package view;


import java.util.Map;

import javax.swing.*;

import controller.Features;
import model.Image;

public interface GUIView {

  void updateImage(String filepath);

  void updateImage(Image image);

  JPanel updateRedHistogram(Map<Integer, Integer> distributionOfRedValues);

  JPanel updateGreenHistogram(Map<Integer, Integer> distributionOfGreenValues);

  JPanel updateBlueHistogram(Map<Integer, Integer> distributionOfBlueValues);

  JPanel updateIntensityHistogram(Map<Integer, Integer> distributionOfIntensityValues);

  void addFeatures(Features features);

  void setOpenFilePath(String filePath);

  void setSaveFilePath(String filePath);
}
