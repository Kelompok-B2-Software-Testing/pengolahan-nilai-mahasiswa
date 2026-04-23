# Sistem Pengolahan Nilai Mahasiswa

Aplikasi Java untuk menghitung dan menentukan grade nilai mahasiswa berdasarkan nilai Tugas, UTS, dan UAS.

## Deskripsi Proyek

Sistem ini merupakan aplikasi console-based yang menerima input nilai mahasiswa (Tugas, UTS, UAS), menghitung nilai akhir, dan menentukan grade serta status kelulusan mahasiswa.

**Formula Nilai Akhir:**
- Nilai Akhir = (Tugas x 40%) + (UTS x 30%) + (UAS x 30%)

**Kriteria Grade:**
- A: >= 85
- B: >= 70
- C: >= 60
- D: >= 50
- E: < 50

**Status Kelulusan:**
- Lulus: Nilai Akhir >= 60
- Tidak Lulus: Nilai Akhir < 60

## Arsitektur Sistem

### Diagram Kelas

Sistem ini dibangun menggunakan arsitektur berlapis (layered architecture) dengan pemisahan tanggung jawab yang jelas antar komponen.

![Class Diagram](Class%20Diagram.drawio.png)

### Struktur Package

```
src/main/java/
├── app/               # Application Entry Point
├── data/              # Data Models & Enumerations
├── domain/            # Business Logic & Domain Models
└── utils/             # Utility Classes
```

### Penjelasan Layer

#### 1. App Layer
Package `app` berisi entry point aplikasi.

**App**
- Class utama yang menjalankan aplikasi
- Berisi method `main()` sebagai starting point program
- Bertanggung jawab membuat instance GradingMahasiswa dan menjalankannya

#### 2. Data Layer
Package `data` berisi model data dan enumerasi.

**State (Enumeration)**
- Mendefinisikan state aplikasi: Input, Recap, Running, None
- Digunakan untuk state management dalam aplikasi

#### 3. Domain Layer
Package `domain` berisi logika bisnis utama aplikasi.

**GradingMahasiswa**
- Controller utama aplikasi
- Mengorkestrasikan alur kerja keseluruhan aplikasi
- Mengelola komponen: StateMachine, Screen, NilaiMahasiswa, ServiceGrade
- Method utama: `Run()` untuk menjalankan aplikasi

**Screen**
- Bertanggung jawab atas interaksi dengan user
- Mengelola input dan output ke console
- Method: `InputNilai()` untuk menerima input, `RekapNilai()` untuk menampilkan hasil
- Menggunakan InputUtils untuk membaca input user

**NilaiMahasiswa**
- Model data untuk menyimpan nilai mahasiswa
- Attributes: tugas, uts, uas, nilaiAkhir
- Method: getter untuk setiap attribute, `getNilaiAkhir()` untuk menghitung nilai akhir

**ServiceGrade**
- Service untuk menentukan grade dan status kelulusan
- Method: `getGrade()` untuk mendapatkan huruf grade, `getStatus()` untuk mendapatkan status lulus/tidak lulus
- Mengimplementasikan business rules untuk grading

#### 4. Utils Layer
Package `utils` berisi class-class utility.

**StateMachine**
- Mengelola state aplikasi
- Attributes: StateNow
- Method: `getStateNow()`, `setStateNow()` untuk mengakses dan mengubah state

**InputUtils**
- Utility untuk membaca input dari user
- Method: `inputFloat()` untuk membaca angka, `inputString()` untuk membaca teks
- Mengintegrasikan validasi input menggunakan ValidationModule

**ValidationModule**
- Memvalidasi input nilai (range 0-100)
- Method: `isValid()` untuk validasi public, `isInRange()` untuk validasi internal
- Memastikan input berada dalam rentang yang valid

### Relasi Antar Komponen

**Composition (Kepemilikan Kuat)**
- GradingMahasiswa memiliki StateMachine dan Screen
- Screen memiliki InputUtils dan ServiceGrade
- InputUtils memiliki ValidationModule

**Association (Penggunaan)**
- GradingMahasiswa menggunakan NilaiMahasiswa
- Screen membuat instance NilaiMahasiswa

**Dependency (Ketergantungan)**
- App bergantung pada GradingMahasiswa
- StateMachine bergantung pada enum State

## Teknologi yang Digunakan

- **Java**: JDK 11
- **Build Tool**: Apache Maven 3.8+
- **Testing Framework**: JUnit 5 (Jupiter)
- **Test Report**: Maven Surefire Plugin

## Cara Menjalankan Aplikasi

### Prerequisites

- JDK 11 atau lebih tinggi
- Apache Maven 3.8 atau lebih tinggi

### Compile & Run

```bash
# Compile project
mvn clean compile

# Run aplikasi
mvn exec:java -Dexec.mainClass="app.App"
```

### Menggunakan Aplikasi

1. Jalankan aplikasi
2. Masukkan nilai Tugas (0-100)
3. Masukkan nilai UTS (0-100)
4. Masukkan nilai UAS (0-100)
5. Sistem akan menampilkan:
   - Nilai Akhir
   - Grade (A/B/C/D/E)
   - Status Kelulusan (Lulus/Tidak Lulus)

## Testing

### Menjalankan Semua Test

```bash
mvn clean test
```

### Struktur Test

```
src/test/java/
├── InputUtils/           # Test untuk InputUtils class
├── NilaiMahasiswa/       # Test untuk NilaiMahasiswa class
├── ServiceGrade/         # Test untuk ServiceGrade class
└── ValidationModule/     # Test untuk ValidationModule class
```

### Coverage Test

Proyek ini memiliki 154 test cases yang mencakup:

**InputUtils Tests (33 tests)**
- Valid input scenarios
- Invalid input dengan retry
- Boundary value testing
- Decimal number handling

**NilaiMahasiswa Tests (45 tests)**
- Getter methods (getTugas, getUts, getUas)
- Nilai akhir calculation logic
- Different score combinations

**ServiceGrade Tests (54 tests)**
- Grade determination (A, B, C, D, E)
- Status determination (Lulus/Tidak Lulus)
- Boundary conditions

**ValidationModule Tests (22 tests)**
- Valid range (0-100)
- Invalid ranges (negative, > 100)
- Edge cases

### Test Reports

Setelah menjalankan test, report tersedia di:

**XML Reports**
```
test-reports/xml/TEST-*.xml
```

**HTML Reports**
```
test-reports/html/test-report.html
```

Untuk membuka HTML report, gunakan:

```bash
# Windows
start test-reports/html/test-report.html

# Linux/Mac
open test-reports/html/test-report.html
```

Atau gunakan script otomatis:

```bash
# Windows
run-test-view-report.bat
```

## Struktur Project

```
pengolahan-nilai-mahasiswa/
├── src/
│   ├── main/java/
│   │   ├── app/
│   │   │   └── App.java
│   │   ├── data/
│   │   │   └── State.java
│   │   ├── domain/
│   │   │   ├── GradingMahasiswa.java
│   │   │   ├── NilaiMahasiswa.java
│   │   │   ├── Screen.java
│   │   │   └── ServiceGrade.java
│   │   └── utils/
│   │       ├── InputUtils.java
│   │       ├── StateMachine.java
│   │       └── ValidationModule.java
│   └── test/java/
│       ├── InputUtils/
│       ├── NilaiMahasiswa/
│       ├── ServiceGrade/
│       └── ValidationModule/
├── test-reports/
│   ├── html/
│   └── xml/
├── pom.xml
├── Class Diagram.drawio
├── Class Diagram.drawio.png
├── TEST-GUIDE.md
├── VIEW-REPORT.md
└── README.md
```

## Build Configuration

Project menggunakan Maven dengan konfigurasi:

**Compiler Settings**
- Source: Java 11
- Target: Java 11
- Encoding: UTF-8

**Plugins**
- maven-compiler-plugin: 3.15.0
- maven-surefire-plugin: 3.2.5
- maven-surefire-report-plugin: 3.2.5
- maven-antrun-plugin: 3.1.0

## Validasi Input

Sistem memvalidasi input dengan aturan:
- Nilai harus berupa angka (float)
- Rentang nilai: 0 - 100
- Input non-numerik akan ditolak dengan pesan error
- Input di luar rentang akan ditolak dengan pesan error
- User dapat mengulangi input hingga valid

## Contoh Output

```
Input nilai tugas
75
Input nilai uts
80
Input nilai uas
85

Hasil Grading

B
Lulus
```

## Lisensi

Proyek ini dibuat untuk keperluan pembelajaran Software Testing.

## Kontributor

Project ini dikembangkan sebagai bagian dari mata kuliah Software Testing.

---

Untuk informasi lebih lanjut tentang testing, lihat [TEST-GUIDE.md](TEST-GUIDE.md)

Untuk melihat test reports, lihat [VIEW-REPORT.md](VIEW-REPORT.md)