import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionScenarios {
    public static void main(String[] args) {
        // Scenario a) ArrayIndexOutOfBoundsException
        try {
            int[] arr = new int[3];
            arr[5] = 10; // This will throw ArrayIndexOutOfBoundsException
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Caught ArrayIndexOutOfBoundsException: " + e.getMessage());
        }

        // Scenario b) NullPointerException
        try {
            String str = null;
            System.out.println(str.length()); // This will throw NullPointerException
        } catch (NullPointerException e) {
            System.out.println("Caught NullPointerException: " + e.getMessage());
        }

        // Scenario c) ArithmeticException
        try {
            int result = 10 / 0; // This will throw ArithmeticException (division by zero)
        } catch (ArithmeticException e) {
            System.out.println("Caught ArithmeticException: " + e.getMessage());
        }

        // Scenario d) NumberFormatException
        try {
            String invalidNumber = "abc";
            int num = Integer.parseInt(invalidNumber); // This will throw NumberFormatException
        } catch (NumberFormatException e) {
            System.out.println("Caught NumberFormatException: " + e.getMessage());
        }

        // Scenario e) ClassCastException
        try {
            Object obj = Integer.valueOf(100);
            String str = (String) obj; // This will throw ClassCastException
        } catch (ClassCastException e) {
            System.out.println("Caught ClassCastException: " + e.getMessage());
        }

        // Scenario f) InputMismatchException
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter an integer: ");
            int number = scanner.nextInt(); // This will throw InputMismatchException if input is not an integer
        } catch (InputMismatchException e) {
            System.out.println("Caught InputMismatchException: " + e.getMessage());
        }

        // Scenario g) IllegalStateException
        try {
            Scanner scanner = new Scanner(System.in);
            scanner.close(); // Close the scanner
            scanner.nextInt(); // Trying to use scanner after closing it will throw IllegalStateException
        } catch (IllegalStateException e) {
            System.out.println("Caught IllegalStateException: " + e.getMessage());
        }
    }
}
