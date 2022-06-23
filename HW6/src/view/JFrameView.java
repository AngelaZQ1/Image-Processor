package view;

import javax.swing.*;

import java.awt.*;
import java.io.IOException;
import java.util.Map;

import controller.Features;

import controller.ImageUtil;
import model.Image;

public class JFrameView extends JFrame implements GUIView {
  private final JLabel imageLabel, openFilePath, saveFilePath;
  private JPanel histogramsSection;
  private JPanel redHistogram;
  private JPanel greenHistogram;
  private JPanel blueHistogram;
  private JPanel intensityHistogram;
  private final JButton redButton, greenButton, blueButton, darkenButton, brightenButton,
  flipVerticallyButton, flipHorizontallyButton, valueButton, intensityButton, lumaButton,
  blurButton, sharpenButton, grayscaleButton, sepiaButton, exitButton, loadButton, saveButton;

  public JFrameView(String caption) {
    super(caption);

    setSize(1400, 700);
    setLocation(0, 0);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    this.setLayout(new BorderLayout());

    // histograms
    histogramsSection = new JPanel();
    histogramsSection.setLayout(new BoxLayout(histogramsSection, BoxLayout.PAGE_AXIS));
    histogramsSection.setPreferredSize(new Dimension(800, 300));
    redHistogram = new Histogram(null, "");
    histogramsSection.add(redHistogram);
    greenHistogram = new Histogram(null, "");
    histogramsSection.add(greenHistogram);
    blueHistogram = new Histogram(null, "");
    histogramsSection.add(blueHistogram);
    intensityHistogram = new Histogram(null, "");
    histogramsSection.add(intensityHistogram);

    this.add(histogramsSection, BorderLayout.LINE_START);

    // TOP SECTION

    JPanel topSection = new JPanel();
    topSection.setLayout(new FlowLayout());

    // dialogue box for saving and loading
    JPanel dialogBoxesPanel = new JPanel();
    dialogBoxesPanel.setBorder(BorderFactory.createTitledBorder("Load/Save Image"));
    dialogBoxesPanel.setLayout(new BoxLayout(dialogBoxesPanel, BoxLayout.PAGE_AXIS));
    this.add(dialogBoxesPanel);

    // load button
    JPanel openFilePanel = new JPanel();
    openFilePanel.setLayout(new FlowLayout());

    dialogBoxesPanel.add(openFilePanel);

    loadButton = new JButton("Open a file");
    openFilePanel.add(loadButton);
    openFilePath = new JLabel("File path will appear here");
    openFilePanel.add(openFilePath);

    // save button
    JPanel saveFilePanel = new JPanel();
    saveFilePanel.setLayout(new FlowLayout());

    dialogBoxesPanel.add(saveFilePanel);

    saveButton = new JButton("Save a file");
    saveFilePanel.add(saveButton);
    saveFilePath = new JLabel("File path will appear here");
    saveFilePanel.add(saveFilePath);

    // exit button
    exitButton = new JButton("Exit");
    this.add(exitButton);

    topSection.add(dialogBoxesPanel);
    topSection.add(exitButton);

    this.add(topSection, BorderLayout.PAGE_START);

    // IMAGE MIDDLE SECTION
    
    // image panel
    JPanel imagePanel = new JPanel();
    //a border around the panel with a caption
    imagePanel.setBorder(BorderFactory.createTitledBorder("Current Image:"));
    imagePanel.setSize(500, 500);
    this.add(imagePanel, BorderLayout.CENTER);

    // the current scrollable image
    imageLabel = new JLabel(new ImageIcon());
    JScrollPane imageScrollPane = new JScrollPane(imageLabel);
    imageScrollPane.setPreferredSize(new Dimension(500, 500));
    imagePanel.add(imageScrollPane);

    // BUTTONS
    JPanel buttonsSection = new JPanel();
    buttonsSection.setLayout(new GridLayout(7, 2));

    redButton = new JButton("Red Component");
    buttonsSection.add(redButton);
    greenButton = new JButton("Green Component");
    buttonsSection.add(greenButton);
    blueButton = new JButton("Blue Component");
    buttonsSection.add(blueButton);
    darkenButton = new JButton("Darken");
    buttonsSection.add(darkenButton);
    brightenButton = new JButton("Brighten");
    buttonsSection.add(brightenButton);
    flipVerticallyButton = new JButton("Flip Vertically");
    buttonsSection.add(flipVerticallyButton);
    flipHorizontallyButton = new JButton("Flip Horizontally");
    buttonsSection.add(flipHorizontallyButton);
    valueButton = new JButton("Grayscale Using Value");
    buttonsSection.add(valueButton);
    intensityButton = new JButton("Grayscale Using Intensity");
    buttonsSection.add(intensityButton);
    lumaButton = new JButton("Grayscale Using Luma");
    buttonsSection.add(lumaButton);
    blurButton = new JButton("Blur");
    buttonsSection.add(blurButton);
    sharpenButton = new JButton("Sharpen");
    buttonsSection.add(sharpenButton);
    grayscaleButton = new JButton("Grayscale");
    buttonsSection.add(grayscaleButton);
    sepiaButton = new JButton("Sepia");
    buttonsSection.add(sepiaButton);

    this.add(buttonsSection, BorderLayout.LINE_END);

    pack();
    setVisible(true);

  }

  @Override
  public void addFeatures(Features features) {
    redButton.addActionListener(evt -> features.redComp());
    greenButton.addActionListener(evt -> features.greenComp());
    blueButton.addActionListener(evt -> features.blueComp());
    darkenButton.addActionListener(evt -> features.darken());
    brightenButton.addActionListener(evt -> features.brighten());
    flipVerticallyButton.addActionListener(evt -> features.vFlip());
    flipHorizontallyButton.addActionListener(evt -> features.hFlip());
    valueButton.addActionListener(evt -> features.value());
    intensityButton.addActionListener(evt -> features.intensity());
    lumaButton.addActionListener(evt -> features.luma());
    blurButton.addActionListener(evt -> features.blur());
    sharpenButton.addActionListener(evt -> features.sharpen());
    grayscaleButton.addActionListener(evt -> features.grayscale());
    sepiaButton.addActionListener(evt -> features.sepia());
    loadButton.addActionListener(evt -> features.load());
    saveButton.addActionListener(evt -> features.save());
    exitButton.addActionListener(evt -> features.exit());
  }
  public void setOpenFilePath(String filepath) {
    this.openFilePath.setText(filepath);
  }

  public void setSaveFilePath(String filePath) {
    this.saveFilePath.setText(filePath);
  }

  /**
   * Updates the image shown to the Image using the given filepath.
   * @param filepath the file path of the new Image to show
   */
  @Override
  public void updateImage(String filepath) {
    try {
      Image image = ImageUtil.readImage(filepath);
      this.imageLabel.setIcon(new ImageIcon(ImageUtil.imageToImage(image)));
    } catch (IOException e) {
      System.out.println("IOException");
    }
  }

  /**
   * Updates the image shown to the given Image.
   * @param image the new Image show
   */
  @Override
  public void updateImage(Image image) {
    this.imageLabel.setIcon(new ImageIcon(ImageUtil.imageToImage(image)));
  }

  // TODO implement this
  @Override
  public void updateRedHistogram(Map<Integer, Integer> distributionOfRedValues) {
    this.histogramsSection.removeAll();
    this.redHistogram = new Histogram(distributionOfRedValues, "red");
    this.histogramsSection.add(redHistogram);
  }


  // TODO implement this
  @Override
  public void updateGreenHistogram(Map<Integer, Integer> distributionOfGreenValues) {
    this.greenHistogram = new Histogram(distributionOfGreenValues, "green");
    this.histogramsSection.add(greenHistogram);
  }

  // TODO implement this
  @Override
  public void updateBlueHistogram(Map<Integer, Integer> distributionOfBlueValues) {
    this.blueHistogram = new Histogram(distributionOfBlueValues, "blue");
    this.histogramsSection.add(blueHistogram);
  }

  // TODO implement this
  @Override
  public void updateIntensityHistogram(Map<Integer, Integer> distributionOfIntensityValues) {
    this.intensityHistogram = new Histogram(distributionOfIntensityValues, "intensity");
    this.histogramsSection.add(intensityHistogram);
  }



}
