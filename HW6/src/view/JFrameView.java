package view;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.*;
import java.io.File;

import controller.Features;

public class JFrameView extends JFrame implements GUIView {
  private JLabel imageLabel, openFilePath, saveFilePath;
  private JPanel redHistogram, greenHistogram, blueHistogram, intensityHistogram;
  private JButton redButton, greenButton, blueButton, darkenButton, brightenButton,
  flipVerticallyButton, flipHorizontallyButton, valueButton, intensityButton, lumaButton,
  blurButton, sharpenButton, grayscaleButton, sepiaButton, exitButton, loadButton, saveButton;
  private Image currentImage;

  public JFrameView(String caption) {
    super(caption);

    setSize(900, 700);
    setLocation(0, 0);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // this.setResizable(false);
    // this.setMinimumSize(new Dimension(300,300));

    this.setLayout(new GridLayout(0, 3));

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
    this.add(redButton);

    //green comp
    greenButton = new JButton("Green Component");
    greenButton.setActionCommand("Green Component Button");
    this.add(greenButton);

    //blue comp
    blueButton = new JButton("Blue Component");
    blueButton.setActionCommand("Blue Component Button");
    this.add(blueButton);

    //darken
    darkenButton = new JButton("Darken");
    darkenButton.setActionCommand("Darken Button");
    this.add(darkenButton);

    //brighten
    brightenButton = new JButton("Brighten");
    brightenButton.setActionCommand("Brighten Button");
    this.add(brightenButton);

    //vflip
    flipVerticallyButton = new JButton("Flip Vertically");
    flipVerticallyButton.setActionCommand("Flip Vertically Button");
    this.add(flipVerticallyButton);

    //hflip
    flipHorizontallyButton = new JButton("Flip Horizontally");
    flipHorizontallyButton.setActionCommand("Flip Horizontally Button");
    this.add(flipHorizontallyButton);

    //value
    valueButton = new JButton("Grayscale Using Value");
    valueButton.setActionCommand("Grayscale Using Value Button");
    this.add(valueButton);

    //intensity
    intensityButton = new JButton("Grayscale Using Intensity");
    intensityButton.setActionCommand("Grayscale Using Intensity Button");
    this.add(intensityButton);

    //luma
    lumaButton = new JButton("Grayscale Using Luma");
    lumaButton.setActionCommand("Grayscale Using Luma Button");
    this.add(lumaButton);

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
    loadButton = new JButton("Load Image");
    loadButton.setActionCommand("Load Image Button");
    this.add(loadButton);

    JPanel openFilePanel = new JPanel();
    openFilePanel.setLayout(new FlowLayout());
    dialogBoxesPanel.add(openFilePanel);
    JButton fileOpenButton = new JButton("Open a file");
    fileOpenButton.setActionCommand("Open file");
    openFilePanel.add(fileOpenButton);
    openFilePath = new JLabel("File path will appear here");
    openFilePanel.add(openFilePath);

    // save button
    saveButton = new JButton("Save Image");
    saveButton.setActionCommand("Save Image Button");
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
    loadButton.addActionListener(evt -> load());
    saveButton.addActionListener(evt -> save());
    exitButton.addActionListener(evt -> features.exit());
  }

  private void load() {
    final JFileChooser fchooser = new JFileChooser(".");
    FileNameExtensionFilter filter = new FileNameExtensionFilter(
            "JPG & GIF Images", "jpg", "gif");
    fchooser.setFileFilter(filter);
    int retvalue = fchooser.showOpenDialog(this);
    if (retvalue == JFileChooser.APPROVE_OPTION) {
      File f = fchooser.getSelectedFile();
      openFilePath.setText(f.getAbsolutePath());
    }
  }

  private void save() {
    final JFileChooser fchooser = new JFileChooser(".");
    int retvalue = fchooser.showSaveDialog(this);
    if (retvalue == JFileChooser.APPROVE_OPTION) {
      File f = fchooser.getSelectedFile();
      saveFilePath.setText(f.getAbsolutePath());
    }
  }

  // TODO implement this
  @Override
  public void updateImage(model.Image image) {
    imageLabel.setIcon(new ImageIcon((Image) image));
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
