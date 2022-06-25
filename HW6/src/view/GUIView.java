package view;

import java.util.Map;

import controller.Features;
import model.Image;

/**
 * This interface represents a way to show the user a GUI for an image processor.
 * It provides methods to update the current image shown, update the four histograms,
 * add a Features object representing the callback methods to handle button clicks,
 * and a way to update the displayed file path for opening or saving an image.
 */
public interface GUIView {

  /**
   * Update the shown image using the given filepath as the new image.
   * @param filepath the file path of the new image to show
   */
  void updateImage(String filepath);

  /**
   * Update the shown image using the given image.
   * @param image the new image to show
   */
  void updateImage(Image image);

  /**
   * Update the shown red histogram using the given distribution of red values.
   * @param distributionOfRedValues the given distribution of red values.
   */
  void updateRedHistogram(Map<Integer, Integer> distributionOfRedValues);

  /**
   * Update the shown green histogram using the given distribution of green values.
   * @param distributionOfGreenValues the given distribution of green values.
   */
  void updateGreenHistogram(Map<Integer, Integer> distributionOfGreenValues);

  /**
   * Update the shown blue histogram using the given distribution of blue values.
   * @param distributionOfBlueValues the given distribution of blue values.
   */
  void updateBlueHistogram(Map<Integer, Integer> distributionOfBlueValues);

  /**
   * Update the shown intensity histogram using the given distribution of intensity values.
   * @param distributionOfIntensityValues the given distribution of intensity values.
   */
  void updateIntensityHistogram(Map<Integer, Integer> distributionOfIntensityValues);

  /**
   * Provide an object of an implementation of the Features interface that contains
   * callback methods.
   * @param features the object that will handle action events
   */
  void addFeatures(Features features);

  /**
   * Display the given filepath that represents the location of the image to load.
   * @param filePath the filepath to display
   */
  void setOpenFilePath(String filePath);

  /**
   * Display the given filepath that represents the location to save the image to.
   * @param filePath the filepath to display
   */
  void setSaveFilePath(String filePath);
}
