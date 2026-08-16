
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class fileread {

    public static void main(String[] args) {
        String filename = "numbers.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String s = line.trim();
                try {
                    int number = Integer.parseInt(s);
                    System.out.println("Read number: " + number);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid number format: " + s);
                }
            }
        } catch (IOException e) {
            System.out.println("Could not read file: " + e.getMessage());
        }
    }
}