/*
  CafeWall.java
  Assignment: CafeWall
  Purpose: Concepts include graphics, DrawingPanel module,
           drawing shapes with graphics and for loops
  @version 11/9/16
 */

import java.awt.*;

public class CafeWall {
   // Class draws rows and grids and attempts to create a cafe wall illusion using black and white squares.
   private static final int MOTAR = 2;
   public static void main(String[] args) {
      DrawingPanel panel = new DrawingPanel(650, 400);
      Graphics pen = panel.getGraphics();
      panel.setBackground(Color.GRAY);
      
      drawRow(pen, 0, 0, 8, 20);
      drawRow(pen, 50, 70, 10, 30);
      drawGrid(pen, 10, 150, 10, 20, 0);
      drawGrid(pen, 250, 200, 6, 25, 10);
      drawGrid(pen, 425, 180, 10, 20, 10);
      drawGrid(pen, 400, 20, 4, 35, 35);
      
   }
   
   private static void drawGrid(Graphics pen, int xPos, int yPos, int gridSize, int squareSize, int altLen) {
      // Draw a grid, or several rows, given size of the grid, x and y positions, and alternating x position spacings between rows.
      for (int i = 1; i <= gridSize; i++) {
         if (i % 2 != 0) {
            drawRow(pen, xPos, yPos + (squareSize + MOTAR) * (i - 1), gridSize, squareSize);
         }
         else {
            // Alt length push alternate rows forward to create illusion
            drawRow(pen, xPos + altLen, yPos + (squareSize + 2) * (i - 1), gridSize, squareSize);
         }
      }
   }
   
   private static void drawRow(Graphics pen, int xPos, int yPos, int x, int squareSize) {
      // Draw a row of alternating squares (white, black), given number of squares in row and x and y positions.
      for (int i = 1; i <= x; i++) {
         if (i % 2 != 0) {
            blackSquare(pen, xPos + squareSize * (i - 1), yPos, squareSize);
         }
         else {
            whiteSquare(pen, xPos + squareSize * (i - 1), yPos, squareSize);
         }
      }
   }
   
   private static void whiteSquare(Graphics pen, int xPos, int yPos, int size) {
   // Method draws a white square given x and y positions and size.
      pen.setColor(Color.WHITE);
      pen.fillRect(xPos, yPos, size, size);
   }
   
   private static void blackSquare(Graphics pen, int xPos, int yPos, int size) {
      // Method draws a black square with an X, given x and y positions and size.
      pen.setColor(Color.BLACK);
      pen.fillRect(xPos, yPos, size, size);
      // Draw X in the middle of square
      pen.setColor(Color.BLUE);
      pen.drawLine(xPos, yPos, xPos + size - 1, yPos + size - 1);  // From top left to bottom right
      pen.drawLine(xPos, yPos + size - 1, xPos + size - 1, yPos);  // From bottom left to top right
   }
}
