/*
  Doodle.java
  Assignment: Doodle
  Purpose: Concepts include graphics, DrawingPanel module,
           drawing shapes with graphics and for loops
  @version 11/9/16
 */

import java.awt.*;

public class Doodle {
    private static final Color BROWN = new Color(82, 41, 17);
    private static final Color DARK_BROWN = new Color(88, 27, 14);
    private static final Color DARK_GRAY = new Color(117, 117, 117);
    private static final Color LAVA_RED = new Color(230, 35, 35);
    private static final int SCREEN_WIDTH = 300;
    private static final int SCREEN_HEIGHT = 300;

    public static void main(String[] args) {
        DrawingPanel panel = new DrawingPanel(300, 300);
        Graphics pen = panel.getGraphics();

        drawMountain(pen);
        drawSmoke(pen);
        drawLava(pen);
    }
   
    private static void drawMountain(Graphics pen) {
        // Create different shades of mountain
        int segHeight = 10;  // segHeight refers to the height of each layer.
        int spacing = 10;  // Distance between the edge of the screen and the mountain (bottom of the screen).
        int slope = 5; // Difference in lengths of layers

        for (int i = 1; i <= 20; i++) {
            pen.setColor(BROWN);
            pen.fillRect(spacing + i * slope, SCREEN_HEIGHT - i * segHeight, SCREEN_WIDTH - 2 * spacing - i * 2 * slope, segHeight);
            pen.setColor(DARK_BROWN);
            pen.fillRect(SCREEN_WIDTH / 2 + slope * (i - 1), 90 + segHeight * i, 40, segHeight);
        }
    }

    private static void drawLava(Graphics pen) {
        // Create different shades of lava and create algorithm
        pen.setColor(LAVA_RED);

        pen.fillRect(115, 100, 15, 75);
        pen.fillRect(105, 165, 15, 75);
        pen.fillRect(95, 220, 15, 85);
        pen.fillRect(70, 250, 25, 15);
        pen.fillRect(60, 260, 15, 30);
        pen.fillRect(30, 285, 45, 15);

        pen.fillRect(130, 100, 15, 200);

        pen.fillRect(160, 100, 15, 60);
        pen.fillRect(170, 150, 15, 60);
        pen.fillRect(180, 150, 15, 100);
        pen.fillRect(190, 250, 15, 50);
        pen.fillRect(190, 285, 65, 15);
    }

    private static void drawSmoke(Graphics pen) {
        int xPos = 110;  // X position of where the smoke starts.
        int yPos = 90;  // Y position of where the smoke starts.
        int segX = 80;  // Length of each smoke "segment".
        int segY = 10;  // Height of each smoke "segment".
        int segIncreaseX = 10;  // Increase in each smoke segment.
        int segShiftX = 5;  // Number of pixels each segment shifts to the right each loop.

        for (int i = 1; i <= 10; i++) {
            // Light gray part
            pen.setColor(Color.GRAY);
            pen.fillRect(xPos + segShiftX * (i - 1), yPos - segY * (i - 1), segX + segIncreaseX * (i - 1), segY);
            // Dark gray part
            pen.setColor(DARK_GRAY);
            pen.fillRect(xPos + segX / 2 + segShiftX * (i - 1), yPos - segY * (i - 1), segX / 2 + segIncreaseX * (i - 1), segY);
        }
    }
}