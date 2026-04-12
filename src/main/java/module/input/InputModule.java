package module.input;

import java.util.Scanner;

public class InputModule {
    private final Scanner scanner;

    public InputModule(Scanner scanner) {
        this.scanner = scanner;
    }

    public ScoreInput readScores() {
        double tugas = readDouble("Masukkan nilai tugas (0-100): ");
        double uts = readDouble("Masukkan nilai UTS (0-100): ");
        double uas = readDouble("Masukkan nilai UAS (0-100): ");
        return new ScoreInput(tugas, uts, uas);
    }

    private double readDouble(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine();
            try {
                return Double.parseDouble(input.trim());
            } catch (NumberFormatException ex) {
                System.out.println("Input tidak valid. Masukkan angka.");
            }
        }
    }
}
