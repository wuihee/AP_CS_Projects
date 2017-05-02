import java.io.*;
import java.util.*;

public class CompareFiles {
    public static void main(String[] args) throws FileNotFoundException {
        // Get two files
        Scanner console = new Scanner(System.in);
        System.out.print("File 1: ");
        Scanner file1 = new Scanner(new File(console.next()));
        System.out.print("File 2: ");
        Scanner file2 = new Scanner(new File(console.next()));
        compareFiles(file1, file2);
    }

    private static void compareFiles(Scanner file1, Scanner file2) {
        System.out.println("Differences:");
        String line1;
        String line2;
        while (file1.hasNext() && file2.hasNext()) {
            line1 = file1.nextLine();
            line2 = file2.nextLine();
            if (!line1.equals(line2)) {
                System.out.println("File 1: " + line1);
                System.out.println("File 2: " + line2);
                System.out.println();
            }
        }
    }
}
