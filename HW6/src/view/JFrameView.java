package view;

import javax.swing.*;

import java.awt.*;
import java.io.IOException;

import controller.Features;

import controller.ImageUtil;
import model.Image;

public class JFrameView extends JFrame implements GUIView {
  private final JLabel imageLabel, openFilePath, saveFilePath;
  private JPanel redHistogram, greenHistogram, blueHistogram, intensityHistogram;
  private final JButton redButton, greenButton, blueButton, darkenButton, brightenButton,
  flipVerticallyButton, flipHorizontallyButton, valueButton, intensityButton, lumaButton,
  blurButton, sharpenButton, grayscaleButton, sepiaButton, exitButton, loadButton, saveButton;

  public JFrameView(String caption) {
    super(caption);

    setSize(900, 700);
    setLocation(0, 0);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // this.setResizable(false);
    // this.setMinimumSize(new Dimension(300,300));

    this.setLayout(new GridLayout(0, 3));

    // image panel
    JPanel imagePanel = new JPanel();
    //a border around the panel with a caption
    imagePanel.setBorder(BorderFactory.createTitledBorder("Current Image:"));
    this.add(imagePanel);

    // the current scrollable image
    imageLabel = new JLabel(new ImageIcon());
    JScrollPane imageScrollPane = new JScrollPane(imageLabel);
    imageScrollPane.setPreferredSize(new Dimension(500, 500));
    imagePanel.add(imageScrollPane);

    // histograms
    redHistogram = new Histogram();
    this.add(redHistogram);
    greenHistogram = new Histogram();
    this.add(greenHistogram);
    blueHistogram = new Histogram();
    this.add(blueHistogram);
    intensityHistogram = new Histogram();
    this.add(intensityHistogram);

    redButton = new JButton("Red Component");
    this.add(redButton);

    greenButton = new JButton("Green Component");
    this.add(greenButton);

    blueButton = new JButton("Blue Component");
    this.add(blueButton);

    darkenButton = new JButton("Darken");
    this.add(darkenButton);

    brightenButton = new JButton("Brighten");
    this.add(brightenButton);

    flipVerticallyButton = new JButton("Flip Vertically");
    this.add(flipVerticallyButton);

    flipHorizontallyButton = new JButton("Flip Horizontally");
    this.add(flipHorizontallyButton);

    valueButton = new JButton("Grayscale Using Value");
    this.add(valueButton);

    intensityButton = new JButton("Grayscale Using Intensity");
    this.add(intensityButton);

    lumaButton = new JButton("Grayscale Using Luma");
    this.add(lumaButton);

    blurButton = new JButton("Blur");
    this.add(blurButton);

    sharpenButton = new JButton("Sharpen");
    this.add(sharpenButton);

    grayscaleButton = new JButton("Grayscale");
    this.add(grayscaleButton);

    sepiaButton = new JButton("Sepia");
    this.add(sepiaButton);

    exitButton = new JButton("Exit");
    this.add(exitButton);

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
  public void updateRedHistogram(Histogram histogram) {
    this.redHistogram = histogram;
  }

  // TODO implement this
  @Override
  public void updateGreenHistogram(Histogram histogram) {
    this.greenHistogram = histogram;
  }

  // TODO implement this
  @Override
  public void updateBlueHistogram(Histogram histogram) {
    this.blueHistogram = histogram;
  }

  // TODO implement this
  @Override
  public void updateIntensityHistogram(Histogram histogram) {
    this.intensityHistogram = histogram;
  }


}
