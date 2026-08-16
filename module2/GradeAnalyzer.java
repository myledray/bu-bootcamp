import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
 
public class GradeAnalyzer {
    static int invalidCount = 0; 
    public static void main(String[] args) {
        // Step 1: read scores from file
        String filename = "scores.txt";
        invalidCount = 0;
        ArrayList<Integer> scores = readScores(filename);
        // Step 2: calculate statistics
        double average = calculateAverage(scores);


        // Step 5: Find the Highest and Lowest Scores
        int highest = Integer.MIN_VALUE;
        int lowest = Integer.MAX_VALUE;

        for (int score : scores) {
            if (score > highest) highest = score;
            if (score < lowest) lowest = score;
        }

        // Step 3: write and print report
        writeReport(scores, average, highest, lowest, "report.txt");
    }

    // Step 3: Implement readScores
    // Returns a list of valid scores read from the file
    public static ArrayList<Integer> readScores(String filename) {
        // your code here
        ArrayList<Integer> scores = new ArrayList<>();

    try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
        String line;
        while ((line = reader.readLine()) != null) {
            String s = line.trim();
            if (s.isEmpty()) {
                continue;
            }
            try {
                int number = Integer.parseInt(s);
                scores.add(number);
            } catch (NumberFormatException e) {
                invalidCount++;
            }
        }
    } catch (IOException e) {  // ← Now it's correctly paired with the try
        System.out.println("Could not read file: " + e.getMessage());
    }
    return scores;
    }

    // Step 4: Implement calculateAverage
    // Returns the average of a list of scores, or 0.0 if the list is empty
    public static double calculateAverage(ArrayList<Integer> scores) {
        // your code here
        if (scores.isEmpty()) {
            return 0.0;
        }
        double sum = 0;
        for (int n : scores ) sum += n;
        return sum / scores.size();
    } 

    // Step 7: Implement writeReport
    // Writes and prints the report
    public static void writeReport(ArrayList<Integer> scores,
                                   double avg, int high, int low,
                                   String outputFile) {
        // your code here
        // Calculate grade bands
        int countA = 0, countB = 0, countC = 0, countD = 0, countF = 0;
        for (int score : scores) {
            if (score >= 90) countA++;
            else if (score >= 80) countB++;
            else if (score >= 70) countC++;
            else if (score >= 60) countD++;
            else countF++;
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            String header = "=== GRADE REPORT ===";
            writer.write(header + "\n");
            System.out.println(header);

            writer.write(String.format("Total scores processed: %d%n", scores.size()));
            System.out.println(String.format("Total scores processed: %d", scores.size()));
            writer.write(String.format("Invalid lines skipped: %d%n", invalidCount));
            System.out.println(String.format("Invalid lines skipped: %d", invalidCount));
            
            //Grade Stats
            writer.write(String.format("Average score: %.2f%n", avg));
            System.out.println(String.format("Average score: %.2f", avg));

            writer.write(String.format("Highest score: %d%n", high));
            System.out.println(String.format("Highest score: %d", high));

            writer.write(String.format("Lowest score: %d%n", low));
            System.out.println(String.format("Lowest score: %d", low));

            writer.write(String.format("Total scores: %d%n", scores.size()));
            System.out.println(String.format("Total scores: %d", scores.size()));

            //Grade Bands
            writer.write("\nGrade Distribution:\n");
            System.out.println("\nGrade Distribution:");

            writer.write(String.format("A (90-100): %d%n", countA));
            System.out.println(String.format("A (90-100): %d", countA));

            writer.write(String.format("B (80-89):  %d%n", countB));
            System.out.println(String.format("B (80-89):  %d", countB));

            writer.write(String.format("C (70-79):  %d%n", countC));
            System.out.println(String.format("C (70-79):  %d", countC));

            writer.write(String.format("D (60-69):  %d%n", countD));
            System.out.println(String.format("D (60-69):  %d", countD));

            writer.write(String.format("F (0-59):   %d%n", countF));
            System.out.println(String.format("F (0-59):   %d", countF));

        } catch (IOException e) {
            System.out.println("Could not write report: " + e.getMessage());
        }

    }
} 
