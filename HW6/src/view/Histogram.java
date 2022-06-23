package view;


import java.awt.*;
import java.util.Map;

import javax.swing.*;


public class Histogram extends JPanel {
  // HashMap of the 256 colors and the number of occurences
  private final Map<Integer, Integer> colors;
  private final String color;

  public Histogram(Map<Integer, Integer> colors, String color) {
    this.colors = colors;
    this.color = color;
  }

  @Override
  protected void paintComponent(Graphics g) {
    if (colors == null) {
      g.setColor(Color.black);
      g.fillRect(0, 0, 50, 50);
      return; // No display if count is null
    }

    super.paintComponent(g);

    // Find the panel size and bar width and interval dynamically
    int width = getWidth();
    int height = getHeight();
    int barWidth = 1;

    // x is the start position for the first bar in the histogram
    int x = 10;

    // Draw bottom line of histogram
    g.drawLine(10, height - 19, width - 10, height - 19);

    // Get Max occurrence of any value
    int maxOccur = 0;
    for (var hue : colors.entrySet()) {
      maxOccur = Math.max(maxOccur, hue.getValue());
    }

    // Draw bars
    for (var hue : colors.entrySet()) {
      // Find the bar height
      int barHeight = hue.getValue() / 256;
      if ((hue.getValue() / maxOccur) > 0) {
        // System.out.println("Percent: " + (hue.getValue() / maxOccur));
      }
      switch (this.color) {
        case "red":
          g.setColor(Color.red);
          break;
        case "green":
          g.setColor(Color.green);
          break;
        case "blue":
          g.setColor(Color.blue);
          break;
        case "intensity":
          g.setColor(Color.black);
      }
      g.drawRect(x, height - 20 - barHeight, barWidth, barHeight);
      g.fillRect(x, height - 20 - barHeight, barWidth, barHeight);
      x += (barWidth + 2);
      // System.out.println(color + " " + hue.getKey()+ ": " + hue.getValue());
    }
    g.setColor(Color.black);
    switch (this.color) {
      case "red":
        g.drawString("Red Values", 10, height - 5);
        break;
      case "green":
        g.drawString("Green Values", 10, height - 5);
        break;
      case "blue":
        g.drawString("Blue Values", 10, height - 5);
        break;
      case "intensity":
        g.drawString("Intensity Values", 10, height - 5);
    }
  }

  /** Override getPreferredSize */
  public Dimension getPreferredSize() {
    return new Dimension(300, 300);
  }
}