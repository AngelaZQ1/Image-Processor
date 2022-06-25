package view;

import javax.swing.*;

import java.awt.*;
import java.io.IOException;
import java.util.Map;

import controller.Features;

import controller.ImageUtil;
import model.Image;

/**
 * This class represents an implementation of the GUIView. It shows an interface
 * to the user that consists of the image being worked on, four histograms representing
 * the distribution of the image's components, and buttons that enable the user to manipulate
 * the image, save/load, and exit the program.
 */
public class JFrameView extends JFrame implements GUIView {
  private final JLabel imageLabel;
  private final JLabel openFilePath;
  private final JLabel saveFilePath;
  private JPanel histogramsSection;
  private JPanel redHistogram;
  private JPanel greenHistogram;
  private JPanel blueHistogram;
  private JPanel intensityHistogram;
  private final JButton redButton;
  private final JButton greenButton;
  private final JButton blueButton;
  private final JButton darkenButton;
  private final JButton brightenButton;
  private final JButton flipVerticallyButton;
  private final JButton flipHorizontallyButton;
  private final JButton valueButton;
  private final JButton intensityButton;
  private final JButton lumaButton;
  private final JButton blurButton;
  private final JButton sharpenButton;
  private final JButton grayscaleButton;
  private final JButton sepiaButton;
  private final JButton exitButton;
  private final JButton loadButton;
  private final JButton saveButton;

  /**
   * Creates a new JFrameView object with the given string as the caption of the frame.
   * Sets the size of the window to be 1400 pixels wide and 700 pixels tall.
   * Adds all components to the GUI.
   *
   * @param caption the title of the frame
   */
  public JFrameView(String caption) {
    super(caption);

    setSize(1800, 700);
    setLocation(0, 0);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    this.setLayout(new BorderLayout());

    // histograms
    histogramsSection = new JPanel();
    histogramsSection.setBorder(BorderFactory.createTitledBorder("Histograms:"));
    histogramsSection.setLayout(new BoxLayout(histogramsSection, BoxLayout.PAGE_AXIS));
    histogramsSection.setPreferredSize(new Dimension(580, 300));
    redHistogram = new Histogram(null, "red");
    greenHistogram = new Histogram(null, "green");
    blueHistogram = new Histogram(null, "blue");
    intensityHistogram = new Histogram(null, "intensity");
    histogramsSection.add(redHistogram);
    histogramsSection.add(greenHistogram);
    histogramsSection.add(blueHistogram);
    histogramsSection.add(intensityHistogram);
    histogramsSection.setAlignmentY(Component.CENTER_ALIGNMENT);

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

    loadButton = new JButton("Load Image");
    openFilePanel.add(loadButton);
    openFilePath = new JLabel("File path will appear here");
    openFilePanel.add(openFilePath);

    // save button
    JPanel saveFilePanel = new JPanel();
    saveFilePanel.setLayout(new FlowLayout());

    dialogBoxesPanel.add(saveFilePanel);

    saveButton = new JButton("Save Image");
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
    imagePanel.setSize(1100,1100);
    this.add(imagePanel, BorderLayout.CENTER);

    // the current scrollable image
    imageLabel = new JLabel(new ImageIcon());
    JScrollPane imageScrollPane = new JScrollPane(imageLabel);
    imageScrollPane.setPreferredSize(new Dimension(800, 800));
    imagePanel.add(imageScrollPane);

    // BUTTONS
    JPanel buttonsSection = new JPanel();
    buttonsSection.setLayout(new GridLayout(7, 2));
    buttonsSection.setPreferredSize(new Dimension(280, 2000));

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
    valueButton = new JButton("Grayscale\nUsing Value");
    valueButton.setText("<html><center>" + "Grayscale" + "<br>" + "Using Value" +
            "</center></html>");
    buttonsSection.add(valueButton);
    intensityButton = new JButton("Grayscale\nUsing Intensity");
    intensityButton.setText("<html><center>" + "Grayscale" + "<br>" + "Using Intensity" +
            "</center></html>");
    buttonsSection.add(intensityButton);
    lumaButton = new JButton("Grayscale\nUsing Luma");
    lumaButton.setText("<html><center>" + "Grayscale" + "<br>" + "Using Luma" +
            "</center></html>");
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
   *
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
   *
   * @param image the new Image show
   */
  @Override
  public void updateImage(Image image) {
    this.imageLabel.setIcon(new ImageIcon(ImageUtil.imageToImage(image)));
  }

  @Override
  public void updateRedHistogram(Map<Integer, Integer> distributionOfRedValues) {
    this.histogramsSection.removeAll();
    this.redHistogram = new Histogram(distributionOfRedValues, "red");
    this.histogramsSection.add(redHistogram);
  }


  @Override
  public void updateGreenHistogram(Map<Integer, Integer> distributionOfGreenValues) {
    this.greenHistogram = new Histogram(distributionOfGreenValues, "green");
    this.histogramsSection.add(greenHistogram);
  }

  @Override
  public void updateBlueHistogram(Map<Integer, Integer> distributionOfBlueValues) {
    this.blueHistogram = new Histogram(distributionOfBlueValues, "blue");
    this.histogramsSection.add(blueHistogram);
  }

  @Override
  public void updateIntensityHistogram(Map<Integer, Integer> distributionOfIntensityValues) {
    this.intensityHistogram = new Histogram(distributionOfIntensityValues, "intensity");
    this.histogramsSection.add(intensityHistogram);
    this.histogramsSection.revalidate();
  }
}
