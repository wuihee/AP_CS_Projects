/*
 * Song.java
 * Assignment: Cumulative Song
 * Purpose: This program uses println() to print text  
 *          practices program structure and reduces redundancy
 *          It additionally employs streaming from files
 *
 * @version 9/21/16
 */

import java.io.*;

public class Song {
	public static void main(String[] args) {
		printSong("Song.txt");
		print("");
		printCustomVerse();
	}
	
	public static void printSong(String fileName) {
		// Method reads entire song from song.txt file and prints line by line instead of manually printing.
      // Reduces redundancy.
		String line;  // Temporarily stores file lines.
		
		try {
			FileReader fileReader = new FileReader(fileName);
			BufferedReader bufferedReader = new BufferedReader(fileReader); // Reads text from a character-input stream
			
         // Read every line until nothing left
			while ((line = bufferedReader.readLine()) != null) {
				print(line);
			}
			
			bufferedReader.close();
		}
		catch (FileNotFoundException e) {
			print("Your song was not found :(");
		}
      // Requirement
		catch (IOException e) {
			print("Error reading file");
		}
	}
	
	public static void printCustomVerse() {
      // 6th Verse -> manually typing is not redundant as I do not ever repeat it.
		print("Hey homies, my code is gonna rock this place");
		print("With a method named main and a curly brace");
      print("And print the whole song from a file.");
		print("I put a semicolon at the end of each line");
		print("You haters never seen code that looked so fine");
      print("Also, I don't use JGrasp, Ecllipse is way better.");
	}
	
	public static void print(String text) {
		// Typing System.out.println sucks (Python > Java)
      // Reduces redundancy
		System.out.println(text);
	}
}
