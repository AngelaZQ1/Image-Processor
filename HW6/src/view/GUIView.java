package view;


import java.util.Map;

import javax.swing.*;

import controller.Features;
import model.Image;

public interface GUIView {

  void updateImage(String filepath);

  void updateImage(Image image);

  void updateRedHistogram(Map<Integer, Integer> distributionOfRedValues);

  void updateGreenHistogram(Map<Integer, Integer> distributionOfGreenValues);

  void updateBlueHistogram(Map<Integer, Integer> distributionOfBlueValues);

  void updateIntensityHistogram(Map<Integer, Integer> distributionOfIntensityValues);

  void addFeatures(Features features);

  void setOpenFilePath(String filePath);

  void setSaveFilePath(String filePath);
}
