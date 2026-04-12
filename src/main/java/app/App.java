package app;

import module.calculation.CalculationModule;
import module.grade.GradeModule;
import module.input.InputModule;
import module.input.ScoreInput;
import module.status.StatusModule;
import module.validation.ValidationModule;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ValidationModule validationModule = new ValidationModule();
        CalculationModule calculationModule = new CalculationModule(validationModule);
        GradeModule gradeModule = new GradeModule();
        StatusModule statusModule = new StatusModule();
        InputModule inputModule = new InputModule(scanner);

        boolean running = true;

        while (running) {
            printMenu();
            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    ScoreInput input = inputModule.readScores();
                    double nilaiAkhir = calculationModule.hitungNilaiAkhir(
                            input.getNilaiTugas(),
                            input.getNilaiUts(),
                            input.getNilaiUas()
                    );

                    if (nilaiAkhir < 0) {
                        System.out.println("Input tidak valid. Pastikan nilai 0-100 dan tidak semuanya 0.");
                        break;
                    }

                    String grade = gradeModule.getGrade(nilaiAkhir);
                    String status = statusModule.getStatus(nilaiAkhir);

                    System.out.println("Nilai Akhir : " + String.format("%.2f", nilaiAkhir));
                    System.out.println("Grade       : " + grade);
                    System.out.println("Status      : " + status);
                    break;
                case "0":
                    running = false;
                    System.out.println("Program selesai.");
                    break;
                default:
                    System.out.println("Pilihan tidak dikenal. Silakan pilih menu yang tersedia.");
                    break;
            }

            System.out.println();
        }

        scanner.close();
    }

    private static void printMenu() {
        System.out.println("=== Program Pengolahan Nilai Mahasiswa ===");
        System.out.println("1. Input nilai mahasiswa");
        System.out.println("0. Keluar");
        System.out.print("Pilih menu: ");
    }
}
