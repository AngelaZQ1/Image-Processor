package view;


import java.awt.*;
import java.util.HashMap;
import java.util.Map;

import javax.swing.*;


public class Histogram extends JPanel {
  // HashMap of the 256 colors and the number of occurences
  private Map<Integer, Integer> colors;

  public Histogram(Map<Integer, Integer> colors) {
    this.colors = colors;
  }

  @Override
  protected void paintComponent(Graphics g) {
    if (colors == null) return; // No display if count is null

    super.paintComponent(g);

    // Find the panel size and bar width and interval dynamically
    int width = getWidth();
    int height = getHeight();
    int barWidth = (width - 40) / 256;

    // x is the start position for the first bar in the histogram
    int x = 30;

    g.setColor(Color.PINK);
    g.fillRect(0, 0, width, height / 2);
    g.setColor(Color.blue);
    g.fillRect(0, height / 2, width, height / 2);

    for (var hue : colors.entrySet()) {
      // Find the bar height
      int barHeight = hue.getValue();
    }

//    for (int i = 0; i < count.length; i++) {
//      // Find the bar height
//      int barHeight =
//              (int)(((double)count[i] / (double)maxCount) * (height - 55));
//
//      // Display a bar (i.e. rectangle)
//      g.drawRect(x, height - 45 - barHeight, individualWidth,
//              barHeight);
//
//      // Display a letter under the base line
//      g.drawString((char)(65 + i) + "", x, height - 30);
//
//      // Move x for displaying the next character
//      x += interval;
//    }
  }

  /** Override getPreferredSize */
  public Dimension getPreferredSize() {
    return new Dimension(300, 300);
  }
}