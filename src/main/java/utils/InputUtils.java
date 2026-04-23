package utils;

import java.util.Scanner;

// Utility for getting input from user
public class InputUtils {

    // Declaration
    ValidationModule utilsValidation = new ValidationModule();

    // Input : String prompt for text before inputing
    // Output : Scan input float from user keyboard
    // used for getting numeric data from user
    public float inputFloat(String prompt) {
        // Create scanner once per method call, not per loop iteration
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println(prompt);

            // Check if there's input available
            if (!scanner.hasNextLine()) {
                throw new java.util.NoSuchElementException(
                    "No more input available"
                );
            }

            String line = scanner.nextLine().trim();

            try {
                float input = Float.parseFloat(line);

                // Validate the input is in range (0-100)
                if (utilsValidation.isValid(input)) {
                    return input;
                }
                // If not valid, loop will continue to ask again
            } catch (NumberFormatException e) {
                System.out.println("Input harus berupa angka!");
                // Loop will continue to retry
            }
        }
        // Note: Scanner is not closed to avoid closing System.in
    }

    // Input : String prompt for text before inputing
    // Output : Scan string input from user keyboard
    // used for getting string data from user
    public String inputString(String prompt) {
        System.out.println(prompt);
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        System.out.println("\n");
        // Note: Scanner is not closed to avoid closing System.in
        return input;
    }
}
