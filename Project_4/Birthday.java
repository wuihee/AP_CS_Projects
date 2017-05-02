/*
Birthday.java
Assignment: Birthday (non-leap year)
Purpose: This program uses println() to print text  
         practices program structure and reduces redundancy
         It additionally employs streaming from files

@version 9/21/16
 */

import java.util.*;
import java.io.*;

public class Birthday {
   public static final int[] DAYS_IN_MONTHS = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
   public static void main(String[] args) {
      Scanner console = new Scanner(System.in);
      System.out.println("This program tells you how many days it will be until your next birthday.");
      System.out.println();
      System.out.println("Please enter today's date: ");
      int currentDay = getDate(console);
      System.out.println();
      System.out.println("Please enter your birthday: ");
      int birthday = getDate(console);
      System.out.println();
      
      daysFromBirthday(currentDay, birthday);
      readFile("fun_fact_list.txt", birthday);
   }
   
   public static void readFile(String fileName, int birthday) {
      /*
      I managed to get a bunch of dates online and copy and pasted them to a file.
      I then used a program to delete all dates that were redundant and deleted the dates in front of each line.
      */
      int counter = 0;
      String line;
      
      try {
         FileReader fileReader = new FileReader(fileName);
         BufferedReader bufferedReader = new BufferedReader(fileReader);
         while ((line = bufferedReader.readLine()) != null) {
            counter++;
            if (counter == birthday) {
               System.out.println("Did you know that your birthday is on " + line + "!");
            }
         }
         bufferedReader.close();         
      }
		catch (FileNotFoundException e) {
			System.out.println("Your file was not found.");
		}
		catch (IOException e) {
			System.out.println("Error reading file");
		}
   }
   
   public static void daysFromBirthday(int currentDay, int birthday) {
      if (birthday > currentDay) {
         System.out.println("Your birthday will be in " + (birthday - currentDay) + " days!");
      }
      else if (currentDay > birthday) {
         System.out.println("Your birthday will be in " + (365 + birthday - currentDay) + " days!");
      }
      else {
         System.out.println("Happy Birthday!");
      }
   }
   
   public static int getDate(Scanner console) {
      int month = getInput(console, "What is the month (1-12)? ");
      int day = getInput(console, "What is the day (1-31)? ");
      int totalDay = 0;
      for (int i = 0; i < month - 1; i++) {
         totalDay += DAYS_IN_MONTHS[i];
      }
      totalDay += day;
      System.out.println(month + "/" + day + " is day #" + totalDay + " of 365");
      return totalDay;
   }
   
   public static int getInput(Scanner console, String text) {
      System.out.print(text);
      int userInput = console.nextInt();
      return userInput;
   }
}