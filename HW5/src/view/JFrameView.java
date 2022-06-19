package view;

import javax.swing.*;

import java.awt.*;

import controller.commands.RedComponent;

public class JFrameView extends JFrame implements GUIView {
  private JLabel imageLabel, openFilePath, saveFilePath;
  private JPanel redHistogram, greenHistogram, blueHistogram, intensityHistogram;
  private JButton redButton, greenButton, blueButton, darkenButton, brightenButton,
  flipVerticallyButton, flipHorizontallyButton, valueButton, intensityButton, lumaButton,
  blurButton, sharpenButton, grayscaleButton, sepiaButton, exitButton, loadButton, saveButton;

  public JFrameView(String caption) {
    super(caption);

    setSize(1000, 500);
    setLocation(200, 200);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // this.setResizable(false);
    // this.setMinimumSize(new Dimension(300,300));

    this.setLayout(new FlowLayout());

    // image with a scrollbar
//    imageLabel.setMaximumSize(null);
    imageLabel = new JLabel();
    JScrollPane imageScrollPane = new JScrollPane();
    imageLabel.setIcon(new ImageIcon("res/fourPixels.jpg"));
    imageScrollPane.setPreferredSize(new Dimension(500, 500));
    imageLabel.add(imageScrollPane);
    this.add(imageLabel);

    // histograms
    redHistogram = new Histogram();
    this.add(redHistogram);
    greenHistogram = new Histogram();
    this.add(greenHistogram);
    blueHistogram = new Histogram();
    this.add(blueHistogram);
    intensityHistogram = new Histogram();
    this.add(intensityHistogram);

    //red comp
    redButton = new JButton("Red Component");
    redButton.setActionCommand("Red Component Button");
    this.add(blurButton);

    //green comp
    greenButton = new JButton("Green Component");
    greenButton.setActionCommand("Green Component Button");
    this.add(blurButton);

    //blue comp
    blueButton = new JButton("Blue Component");
    blueButton.setActionCommand("Blue Component Button");
    this.add(blurButton);

    //darken
    darkenButton = new JButton("Darken");
    darkenButton.setActionCommand("Darken Button");
    this.add(blurButton);

    //brighten
    brightenButton = new JButton("Brighten");
    brightenButton.setActionCommand("Brighten Button");
    this.add(blurButton);

    //vflip
    flipVerticallyButton = new JButton("Flip Vertically");
    flipVerticallyButton.setActionCommand("Flip Vertically Button");
    this.add(blurButton);

    //hflip
    flipHorizontallyButton = new JButton("Flip Horizontally");
    flipHorizontallyButton.setActionCommand("Flip Horizontally Button");
    this.add(blurButton);

    //value
    valueButton = new JButton("Grayscale Using Value");
    valueButton.setActionCommand("Grayscale Using Value Button");
    this.add(blurButton);

    //intensity
    intensityButton = new JButton("Grayscale Using Intensity");
    intensityButton.setActionCommand("Grayscale Using Intensity Button");
    this.add(blurButton);

    //luma
    lumaButton = new JButton("Grayscale Using Luma");
    lumaButton.setActionCommand("Grayscale Using Luma Button");
    this.add(blurButton);

    //blur button
    blurButton = new JButton("Blur");
    blurButton.setActionCommand("Blur Button");
    this.add(blurButton);

    //sharpen
    sharpenButton = new JButton("Sharpen");
    sharpenButton.setActionCommand("Sharpen Button");
    this.add(sharpenButton);

    //grayscale
    grayscaleButton = new JButton("Grayscale");
    grayscaleButton.setActionCommand("Grayscale Button");
    this.add(grayscaleButton);

    //sepia
    sepiaButton = new JButton("Sepia");
    sepiaButton.setActionCommand("Sepia Button");
    this.add(sepiaButton);

    //exit
    exitButton = new JButton("Exit");
    exitButton.setActionCommand("Exit Button");
    this.add(exitButton);


    // dialogue box for saving and loading
    JPanel dialogBoxesPanel = new JPanel();
    dialogBoxesPanel.setBorder(BorderFactory.createTitledBorder("Dialog boxes"));
    dialogBoxesPanel.setLayout(new BoxLayout(dialogBoxesPanel, BoxLayout.PAGE_AXIS));
    this.add(dialogBoxesPanel);

    // load button
    JPanel openFilePanel = new JPanel();
    openFilePanel.setLayout(new FlowLayout());
    dialogBoxesPanel.add(openFilePanel);
    JButton fileOpenButton = new JButton("Open a file");
    fileOpenButton.setActionCommand("Open file");
    openFilePanel.add(fileOpenButton);
    openFilePath = new JLabel("File path will appear here");
    openFilePanel.add(openFilePath);

    // save button
    saveButton = new JButton("Load Image");
    saveButton.setActionCommand("Load Image Button");
    this.add(saveButton);

    JPanel saveFilePanel = new JPanel();
    saveFilePanel.setLayout(new FlowLayout());
    dialogBoxesPanel.add(saveFilePanel);
    JButton fileSaveButton = new JButton("Save a file");
    fileSaveButton.setActionCommand("Save file");
    saveFilePanel.add(fileSaveButton);
    saveFilePath = new JLabel("File path will appear here");
    saveFilePanel.add(saveFilePath);

    pack();
    setVisible(true);

  }

  @Override
  public void addFeatures() {
    // FIXME how to pass in the current image to the command object?
    redButton.addActionListener(evt -> new RedComponent().applyCommand());
//    toggleButton.addActionListener(evt -> features.toggleColor());
//    blurButton.addActionListener(evt -> features.exitProgram());
  }

  @Override
  public void updateImage(model.Image image) {
    imageLabel.setIcon(new ImageIcon((Image) image));
  }

  @Override
  public void updateRedHistogram(Histogram histogram) {
    this.redHistogram = histogram;
  }
  @Override
  public void updateGreenHistogram(Histogram histogram) {
    this.greenHistogram = histogram;
  }
  @Override
  public void updateBlueHistogram(Histogram histogram) {
    this.blueHistogram = histogram;
  }
  @Override
  public void updateIntensityHistogram(Histogram histogram) {
    this.intensityHistogram = histogram;
  }


}
