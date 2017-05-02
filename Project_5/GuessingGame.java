/*
GuessingGame.java
Assignment: Guessing Game
Purpose: Assignment incorporates concepts of loops
         and psuedorandom numbers.

@version 12/14/16
 */

import java.util.*;

public class GuessingGame {
   public static final int MAX_NUM = 100;  // Sets guessing range.
   public static void main(String[] args) {
      Scanner console = new Scanner(System.in);
      boolean gameOver = false;
      int totalGames = 0;
      int totalGuesses = 0;
      int leastGuesses = 9999;
      
      introduceGame();
      while (gameOver == false) {
         int guesses = playGame(console);
         gameOver = gameState(console);
         totalGames++;
         totalGuesses += guesses;
         if (guesses < leastGuesses) {
            leastGuesses = guesses;
         }
      }
      getResults(totalGames, totalGuesses, leastGuesses);
   }
   
   public static int playGame(Scanner console) {
      int randomNum = getRandom();
      int guess = 0;  // Useer guess
      int guesses = 0;  // Number of guesses
      
      System.out.println("I'm thinking of a number between 1 and " + MAX_NUM);
      while (guess != randomNum) {
         guess = userInput(console, "Your Guess: ");
         if (guess < randomNum) {
            System.out.println("It's higher");
         }
         else if (guess > randomNum) {
            System.out.println("It's lower");
         }
         guesses++;
      }
      if (guesses == 1) {
         System.out.println("Wow, you got it right on your first try, that's a 1 in " + MAX_NUM + " chance!");
      }
      else {
         System.out.println("You got it right in " + guesses + " guesses!");
      }
      return guesses;
   }
   
   public static int getRandom() {
      // Generates a random number between 1 and MAX_NUM
      int num = (int) (MAX_NUM * Math.random());
      return num;
   }
   
   public static int userInput(Scanner console, String text) {
      // Gets a user int input
      System.out.print(text);
      int input = console.nextInt();
      return input;
   }
   
   public static boolean gameState(Scanner console) {
      // Determines if the user still wishes to play
      System.out.print("Do you want to continue playing? ");
      String input = console.next();
      char letter = input.charAt(0);
      if (letter == 'Y' || letter == 'y') {
         System.out.println();
         return false;
      }
      else {
         System.out.println();
         return true;
      }
   }
   
   public static void introduceGame() {
      // Haiku
      System.out.println("Guess any number");
      System.out.println("Between the selected range");
      System.out.println("Good luck with guessing");
      System.out.println();
   }
   
   public static void getResults(int totalGames, int totalGuesses, int leastGuesses) {
      // Print stats
      System.out.println("Total Games: " + totalGames);
      System.out.println("Total Guesses: " + totalGuesses);
      System.out.println("Guesses/Games: " + ((float) totalGuesses / totalGames));
      System.out.println("Best Game: " + leastGuesses + " Guesses");
   }
}
