/**
 * SpaceNeedle.java
 * Assignment: Project 2: Space Needle
 * Purpose: This assignment practiced for loops,  
 *          using methods and structure to reduce
 *          redundancy and create patterns.
 * @version 10/13/16
 */

public class SpaceNeedle {
   private static final int SIZE = 4;

   public static void main (String[] args) {
      drawHead();
      drawBody();
      drawBase();
   }
   
   private static void drawHead() {
      drawNeedle();
      drawBase();
      System.out.println();
      for (int i = 1; i <= SIZE; i++) {
         for (int s = 1; s <= i * 2; s++) {
            System.out.print(" ");
         }
         System.out.print("\\_");
         for (int j = 1; j <= (SIZE * 3 - 1) - 2 * i; j++) {
            System.out.print("/\\");
         }
         System.out.print("_/");
         System.out.println();
      }
      drawNeedle();
   }
   
   private static void drawBase() {
      for (int i = 1; i <= SIZE; i++) {
         for (int s = 1; s <= 3 * (SIZE - i); s++) {
            System.out.print(" ");
         }
         System.out.print("__");
         System.out.print("/");
         for (int j = 0; j <= 3 * (i - 1) - 1; j++) {
            System.out.print(":");
         }
         System.out.print("||");
         for (int k = 1; k <= 3 * (i - 1); k++) {
            System.out.print(":");
         }
         System.out.print("\\");
         System.out.print("__");
         System.out.println();
      }
      drawSplitLine();
   }
   
   private static void drawBody() {
      for (int i = 1; i <= Math.pow(SIZE, 2); i++) {
         for (int j = 1; j <= 2 * SIZE + 1; j++) {
            System.out.print(" ");
         }
         System.out.print("|");
         for (int k = 1; k <= SIZE - 2; k++) {
            System.out.print("%");
         }
         System.out.print("||");
         for (int k = 1; k <= SIZE - 2; k++) {
            System.out.print("%");
         }
         System.out.print("|");
         System.out.println();
      }
   }
   
   private static void drawNeedle() {
      for (int i = 1; i <= SIZE; i++) {
         for (int s = 1; s <= 3 * SIZE; s++) {
            System.out.print(" ");
         }
         System.out.println("||");
      }
   }
   
   private static void drawSplitLine() {
      System.out.print("|");
      for (int i = 1; i <= 6 * SIZE; i++) {
         System.out.print("\"");
      }
      System.out.print("|");
   }
}
