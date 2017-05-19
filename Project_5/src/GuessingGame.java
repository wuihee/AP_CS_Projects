/*
GuessingGame.java
Assignment: Guessing Game
Purpose: Assignment incorporates concepts of loops
         and psuedorandom numbers.

@version 12/14/16
 */

import java.util.*;

public class GuessingGame {
    private static final int MAX_NUM = 100;  // Sets guessing range.
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        boolean gameOver = false;
        int totalGames = 0;
        int totalGuesses = 0;
        int leastGuesses = 9999;

        introduceGame();
        while (!gameOver) {
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

    private static int playGame(Scanner console) {
        int randomNum = getRandom();
        int guess = 0;  // User guess
        int guesses = 0;  // Number of guesses

        System.out.println("I'm thinking of a number between 1 and " + MAX_NUM);
        while (guess != randomNum) {
            guess = userInput(console);
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

    private static int getRandom() {
        // Generates a random number between 1 and MAX_NUM
        return (int) (MAX_NUM * Math.random());
    }

    private static int userInput(Scanner console) {
        // Gets a user int input
        System.out.print("Your Guess: ");
        return console.nextInt();
    }

    private static boolean gameState(Scanner console) {
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

    private static void introduceGame() {
        // Haiku
        System.out.println("Guess any number");
        System.out.println("Between the selected range");
        System.out.println("Good luck with guessing");
        System.out.println();
    }

    private static void getResults(int totalGames, int totalGuesses, int leastGuesses) {
        // Print stats
        System.out.println("Total Games: " + totalGames);
        System.out.println("Total Guesses: " + totalGuesses);
        System.out.println("Guesses/Games: " + ((float) totalGuesses / totalGames));
        System.out.println("Best Game: " + leastGuesses + " Guesses");
    }
}
