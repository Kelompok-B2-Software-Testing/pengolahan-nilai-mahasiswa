# Program Pengolahan Nilai Mahasiswa

Aplikasi Java console modular untuk menghitung nilai akhir, grade, dan status kelulusan mahasiswa.

## Fitur
- Input nilai tugas, UTS, dan UAS berulang (menu loop).
- Validasi input (0–100, tidak semua 0).
- Perhitungan nilai akhir dengan bobot.
- Penentuan grade dan status kelulusan.
- Struktur modular yang mudah diuji dengan unit test.

## Teknologi
- Java 11+
- Maven
- JUnit 5

## Struktur Proyek
- `src/main/java/app/App.java`
- `src/main/java/module/input/InputModule.java`
- `src/main/java/module/input/ScoreInput.java`
- `src/main/java/module/validation/ValidationModule.java`
- `src/main/java/module/calculation/CalculationModule.java`
- `src/main/java/module/grade/GradeModule.java`
- `src/main/java/module/status/StatusModule.java`
- `src/test/java/module/validation/ValidationModuleTest.java`
- `src/test/java/module/calculation/CalculationModuleTest.java`
- `src/test/java/module/grade/GradeModuleTest.java`
- `src/test/java/module/status/StatusModuleTest.java`

## Cara Menjalankan
1. Build project:
    mvn -q -DskipTests package
2. Jalankan aplikasi:
    java -cp target/classes app.App

## Menjalankan Unit Test
    mvn -q test

## Aturan Perhitungan
- Nilai akhir = (0.3 * tugas) + (0.3 * uts) + (0.4 * uas)
- Grade:
  - A: ≥ 85
  - B: 70–84
  - C: 60–69
  - D: 50–59
  - E: < 50
- Status:
  - Lulus: ≥ 60
  - Tidak Lulus: < 60

## Catatan
Semua modul dirancang agar mudah diuji dan tidak bergantung langsung pada input/output.