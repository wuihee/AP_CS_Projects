import java.awt.*;
import java.io.*;
import java.util.*;

/**
 * BabyNames.java
 * Assignment: Baby Names
 * Purpose: This assignment practices the use of Scanners and reading from files.
 *          In addition, the use of DrawingPanel is also employed along with
 *          concepts of structural decomposition.
 *
 * @version 5/3/2017
 */

public class BabyNames {

    private static final int STARTING_YEAR = 1890;
    private static final int LEGEND_HEIGHT = 30;
    private static final int DECADES = 13;
    private static final int DECADE_WIDTH = LEGEND_HEIGHT * 2;
    private static final int SCREEN_WIDTH = 780;
    private static final int SCREEN_HEIGHT = 500 + 2 * LEGEND_HEIGHT;

    public static void main(String[] args) throws FileNotFoundException {
        Scanner console = new Scanner(System.in);
        Scanner namesFile = new Scanner(new File("names.txt"));
        Scanner meaningsFile = new Scanner(new File("meanings.txt"));

        introduction();
        String inputName = getName(console);
        String namePopularity = getFileData(namesFile, inputName);
        String nameMeaning = getFileData(meaningsFile, inputName);

        if (namePopularity.equals("")) {
            System.out.println("\"" + inputName + "\" " + "not found.");
        }
        else {
            System.out.println(namePopularity);
            System.out.println(nameMeaning);
            DrawingPanel panel = new DrawingPanel(SCREEN_WIDTH, SCREEN_HEIGHT);
            Graphics pen = panel.getGraphics();
            drawGraph(pen);
            drawData(pen, inputName, namePopularity, nameMeaning);
        }
    }

    private static void introduction() {
        // Introduces program with instructional information.
        System.out.println("This program allows you to search through");
        System.out.println("data from the Social Security Administration");
        System.out.println("to see how popular a name has been since 1980.");
        System.out.println();
    }

    private static String getName(Scanner console) {
        // Receives and formats user's name.
        System.out.print("Name: ");
        return console.next();
    }

    private static String getFileData(Scanner file, String inputName) {
        // Get file data for user's name.
        while (file.hasNext()) {
            String line = file.nextLine();
            if (line.toUpperCase().contains(inputName.toUpperCase())) {
                return line;
            }
        }
        return "";
    }

    private static void drawGraph(Graphics pen) {
        // Draw the static structure of graph (no values).
        // Draw legend bars.
        pen.setColor(Color.LIGHT_GRAY);
        pen.fillRect(0, 0, SCREEN_WIDTH, LEGEND_HEIGHT);
        pen.fillRect(0, SCREEN_HEIGHT - LEGEND_HEIGHT, SCREEN_WIDTH, LEGEND_HEIGHT);

        // Decade intervals.
        pen.setColor(Color.BLACK);
        for (int i = 0; i < DECADES; i++) {
            pen.drawString("" + (STARTING_YEAR + 10 * i), DECADE_WIDTH * i, SCREEN_HEIGHT - 8);
        }
    }

    private static void drawData(Graphics pen, String inputName, String namePopularity, String nameMeaning) {
        // Draw values on the graph (based on name data).

        // Name meanings.
        pen.setColor(Color.BLACK);
        pen.drawString(nameMeaning, 0, 16);

        // Get bar color (based on gender).
        Color barColor;
        if (namePopularity.toUpperCase().contains(" M ")) {
            barColor = Color.BLUE;
        }
        else {
            barColor = Color.PINK;
        }
        
        // Get and draw data.
        String data = namePopularity.substring(inputName.length() + 3);  // 'inputName.length() + 3' is the space before the values.
        Scanner lineReader = new Scanner(data);
        int rank;
        double barHeight;
        int xPos;
        int yPos;
        int count = 0;

        while (lineReader.hasNext()) {
            pen.setColor(barColor);
            rank = lineReader.nextInt();
            xPos = count * 60;
            if (rank == 0) {
                yPos = SCREEN_HEIGHT - LEGEND_HEIGHT;
            }
            else {
                yPos = LEGEND_HEIGHT + rank / 2;
            }
            if (rank == 0) {
                barHeight = 0;
            }
            else {
                barHeight = SCREEN_HEIGHT - LEGEND_HEIGHT - yPos;
            }
            pen.fillRect(xPos, yPos, DECADE_WIDTH / 2, (int) barHeight);
            pen.setColor(Color.BLACK);
            pen.drawString("" + rank, xPos, yPos);
            count++;
        }
    }
}
