import java.io.*;
import java.util.Scanner;

 class FileStreamExample {
    public static void main(String[] args) {
        String filename = "example.txt";
        String content = "Hello, this is a file handling example in Java.";

        // Step 1: Create and Write into the file
        try (FileWriter fileWriter = new FileWriter(filename)) {
            fileWriter.write(content);
            System.out.println("Content written to file successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred during file writing: " + e.getMessage());
        }

        // Step 2: Read from file using FileReader
        System.out.println("\nReading file using FileReader:");
        try (FileReader fileReader = new FileReader(filename)) {
            int character;
            while ((character = fileReader.read()) != -1) {
                System.out.print((char) character);
            }
        } catch (IOException e) {
            System.out.println("An error occurred during file reading with FileReader: " + e.getMessage());
        }

        // Step 3: Read from file using BufferedReader
        System.out.println("\n\nReading file using BufferedReader:");
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("An error occurred during file reading with BufferedReader: " + e.getMessage());
        }

        // Step 4: Read from file using Scanner
        System.out.println("\nReading file using Scanner:");
        try (Scanner scanner = new Scanner(new File(filename))) {
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred during file reading with Scanner: " + e.getMessage());
        }
    }
}
