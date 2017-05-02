/*
DNA.java
Assignment: Project 7
Purpose: To practice writing arrays and procedural code.
@version: 3/8/17
 */

import java.io.*;
import java.util.*;

public class DNA {
    private static final int MIN_CODONS = 4;
    private static final double MIN_PERCENT_MASS = 30.0;
    private static final char[] NUCLEOTIDE_TYPES = {'A', 'C', 'G', 'T'};
    private static final int CODON_LEN = 3;
    private static final String[] STOP_CODONS = {"TAA", "TAG", "TGA"};
    private static final String START_CODON = "ATG";
    private static final double[] NUCLEOTIDE_MASSES = {135.128, 111.103, 151.128, 125.107};  // A, C, G, T respectively.

    public static void main(String[] args) throws FileNotFoundException {
        // Initializing input and output files.
        Scanner console = new Scanner(System.in);
        Scanner input = new Scanner(getFile(console, "Enter input file? "));
        PrintStream output = new PrintStream(getFile(console, "Enter output file? "));

        // Collect all input from input file and sends it to "finalOutput" method.
        while (input.hasNext()) {
            String name = input.nextLine();
            String nucleotides = input.nextLine().toUpperCase();
            int[] nCount = countNucleotides(nucleotides);
            double[] nMassPercentages = massPercentage(nCount);
            String[] nCodons = countCodons(nucleotides);
            boolean proteinEncoded = encodesProtein(nMassPercentages, nCodons);
            finalOutput(output, name, nucleotides, nCount, nMassPercentages, nCodons, proteinEncoded);
        }
    }

    private static void finalOutput(PrintStream output, String name, String nucleotides, int[] nCount, double[] nMassPercentages, String[] nCodons, boolean proteinEncoded) {
        // Formats output and prints to output file.
        output.println("Name: " + name);
        output.println("Nucleotides: " + nucleotides);
        output.println("Nucleotide counts: " + Arrays.toString(nCount));
        output.println("Mass percentages: " + Arrays.toString(nMassPercentages));
        output.println("Codons: " + Arrays.toString(nCodons));
        output.println("Encodes a protein: " + (proteinEncoded ? "yes" : "no"));
        output.println();
    }

    private static File getFile(Scanner console, String text) throws FileNotFoundException {
        // Prompts user for file name and returns File object.
        System.out.print(text);
        return new File(console.next());
    }

    private static int[] countNucleotides(String nucleotides) {
        // Count the number of respective nucleotides.
        int[] count = new int[4];  // Indexes: 0, 1, 2, 3 -> A, C, G, T respectively.
        // HashMap that references indexes (0, 1, 2, 3) with nucleotide (A, C, G, T) values.
        HashMap<Character, Integer> nReference = new HashMap<>();
        for (int i = 0; i < NUCLEOTIDE_TYPES.length; i++) {
            nReference.put(NUCLEOTIDE_TYPES[i], i);
        }

        for (int i = 0; i < nucleotides.length(); i++) {
            count[nReference.get(nucleotides.charAt(i))]++;  // Increment respective nucleotide count.
        }

        return count;
    }

    private static double[] massPercentage(int[] nCount) {
        // Calculate the mass percentages of each individual nucleotide.
        double[] nTotalMasses = new double[NUCLEOTIDE_TYPES.length];
        double[] nPercentageMasses = new double[NUCLEOTIDE_TYPES.length];
        double totalMass = 0.0;
        double nMass;

        for (int i = 0; i < NUCLEOTIDE_TYPES.length; i++) {
            nMass = nCount[i] * NUCLEOTIDE_MASSES[i];
            totalMass += nMass;
            nTotalMasses[i] = nMass;
        }
        for (int i = 0; i < NUCLEOTIDE_TYPES.length; i++) {
            double percentage =  nTotalMasses[i] / totalMass * 100;
            // Round to 2-decimal places.
            percentage = Math.round(percentage * 10);
            percentage = percentage / 10;
            nPercentageMasses[i] = percentage;
        }

        return nPercentageMasses;
    }

    private static String[] countCodons(String nucleotides) {
        // Count the number of codons in the string of nucleotides.
        int numCodons = nucleotides.length() / CODON_LEN;
        String[] nCodons = new String[numCodons];

        for (int i = 0; i < numCodons; i++) {
            nCodons[i] = nucleotides.substring(i * CODON_LEN, (i + 1) * CODON_LEN);
        }

        return nCodons;
    }

    private static boolean encodesProtein(double[] nPercentageMass, String[] nCodons) {
        // Identifies constraints that encodes proteins and returns true or false.
        boolean[] conditions = new boolean[4];  // Number of test cases.
        conditions[0] = nCodons.length >= MIN_CODONS;
        conditions[1] = Objects.equals(nCodons[0], START_CODON);
        conditions[2] = Arrays.asList(STOP_CODONS).contains(nCodons[nCodons.length - 1]);
        conditions[3] = nPercentageMass[1] + nPercentageMass[2] >= MIN_PERCENT_MASS;

        for (int i = 0; i <= conditions.length - 1; i++) {
            if (!conditions[i]) {
                return false;
            }
        }
        return true;
    }
}
