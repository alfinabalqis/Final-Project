import java.util.Scanner;

public class SistemManajemenMahasiswa {
    private static MahasiswaService service = new MahasiswaService();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        inisialisasiDataSample();
        clearScreen();

        System.out.println("==========================================================");
        System.out.println("    SISTEM MANAJEMEN DATA MAHASISWA  ");
        System.out.println("==========================================================");

        boolean running = true;

        while (running) {
            tampilkanMenu();
            int pilihan = getInputInteger("Pilih menu (1-6): ");

            switch (pilihan) {
                case 1:
                    tambahMahasiswa();
                    break;
                case 2:
                    updateMahasiswa();
                    break;
                case 3:
                    hapusMahasiswa();
                    break;
                case 4:
                    cariMahasiswaByNimBST();
                    break;
                case 5:
                    tampilkanSemuaData();
                    break;
                case 6:
                    System.out.println("\n=== TERIMA KASIH ===");
                    running = false;
                    break;
                default:
                    System.out.println("Pilihan tidak valid! Silakan pilih 1-6.");
            }

            if (running) {
                System.out.println("\nTekan Enter untuk melanjutkan...");
                scanner.nextLine();
                clearScreen();
            }
        }

        scanner.close();
    }

    private static void tampilkanMenu() {
        System.out.println("1. Tambah Mahasiswa");
        System.out.println("2. Update Mahasiswa");
        System.out.println("3. Hapus Mahasiswa");
        System.out.println("4. Cari Mahasiswa (berdasarkan NIM)");
        System.out.println("5. Tampilkan Semua Data");
        System.out.println("6. Keluar");
        System.out.println();
    }

    /**
     * Fungsi untuk menambah mahasiswa baru
     */
    private static void tambahMahasiswa() {
        System.out.println("\n=== TAMBAH MAHASISWA BARU ===");
        
        String nim = getInputString("Masukkan NIM: ");
        String nama = getInputString("Masukkan Nama: ");
        double ipk = getInputDoubleDenganValidasi("Masukkan IPK (0.00 - 4.00): ");
        String jurusan = getInputString("Masukkan Jurusan: ");
        
        // Validasi IPK
        if (ipk < 0.0 || ipk > 4.0) {
            System.out.println("Error: IPK harus berada dalam rentang 0.00 - 4.00");
            return;
        }
        
        Mahasiswa mahasiswa = new Mahasiswa(nim, nama, ipk, jurusan);
        service.tambahMahasiswa(mahasiswa);
    }

    /**
     * Fungsi untuk mencari mahasiswa berdasarkan NIM
     */
    private static void cariMahasiswaByNimBST() {
        System.out.println("\n=== CARI MAHASISWA BERDASARKAN NIM ===");
        String nim = getInputString("Masukkan NIM yang dicari: ");
        
        long startTime = System.nanoTime();
        Mahasiswa mahasiswa = service.cariByNimBST(nim);
        long endTime = System.nanoTime();
        
        if (mahasiswa != null) {
            System.out.println("\nMahasiswa ditemukan:");
            System.out.println("  " + mahasiswa);
        } else {
            System.out.println("\nMahasiswa dengan NIM " + nim + " tidak ditemukan.");
        }
        
        System.out.printf("Waktu pencarian: %.6f ms\n", (endTime - startTime) / 1_000_000.0);
    }

    /**
     * Fungsi untuk mengupdate data mahasiswa
     */
    private static void updateMahasiswa() {
        System.out.println("\n=== UPDATE DATA MAHASISWA ===");
        String nim = getInputString("Masukkan NIM mahasiswa yang akan diupdate: ");
        
        Mahasiswa mahasiswaLama = service.cariByNim(nim);
        if (mahasiswaLama == null) {
            System.out.println("Mahasiswa dengan NIM " + nim + " tidak ditemukan.");
            return;
        }
        
        System.out.println("\nData saat ini:");
        System.out.println("  " + mahasiswaLama);
        System.out.println("\nMasukkan data baru (kosongkan jika tidak ingin mengubah):");
        
        String nama = getInputStringOptional("Nama baru [" + mahasiswaLama.getNama() + "]: ");
        if (nama.isEmpty()) nama = mahasiswaLama.getNama();
        
        String ipkStr = getInputStringOptional("IPK baru [" + mahasiswaLama.getIpk() + "]: ");
        double ipk = ipkStr.isEmpty() ? mahasiswaLama.getIpk() : Double.parseDouble(ipkStr);
        
        String jurusan = getInputStringOptional("Jurusan baru [" + mahasiswaLama.getJurusan() + "]: ");
        if (jurusan.isEmpty()) jurusan = mahasiswaLama.getJurusan();
        
        Mahasiswa mahasiswaBaru = new Mahasiswa(nim, nama, ipk, jurusan);
        service.updateMahasiswa(nim, mahasiswaBaru);
    }
    
    /**
     * Fungsi untuk menghapus mahasiswa
     */
    private static void hapusMahasiswa() {
        System.out.println("\n=== HAPUS DATA MAHASISWA ===");
        String nim = getInputString("Masukkan NIM mahasiswa yang akan dihapus: ");
        
        Mahasiswa mahasiswa = service.cariByNim(nim);
        if (mahasiswa == null) {
            System.out.println("Mahasiswa dengan NIM " + nim + " tidak ditemukan.");
            return;
        }
        
        System.out.println("\nData yang akan dihapus:");
        System.out.println("  " + mahasiswa);
        
        String konfirmasi = getInputString("Apakah Anda yakin ingin menghapus? (y/n): ");
        if (konfirmasi.equalsIgnoreCase("y") || konfirmasi.equalsIgnoreCase("yes")) {
            service.hapusMahasiswa(nim);
        } else {
            System.out.println("Penghapusan dibatalkan.");
        }
    }

    /**
     * Fungsi untuk menampilkan semua data mahasiswa
     */
    private static void tampilkanSemuaData() {
        System.out.println();
        service.tampilkanSemuaMahasiswaTerurutNim();
    }

    /**
     * Inisialisasi data sample untuk testing
     */
    private static void inisialisasiDataSample() {
        service.tambahMahasiswa(new Mahasiswa("12345001", "Andi Pratama", 3.75, "Teknik Informatika"));
        service.tambahMahasiswa(new Mahasiswa("12345002", "Sari Dewi", 3.90, "Sistem Informasi"));
        service.tambahMahasiswa(new Mahasiswa("12345003", "Budi Santoso", 3.25, "Teknik Informatika"));
        service.tambahMahasiswa(new Mahasiswa("12345004", "Maya Sari", 3.80, "Teknik Komputer"));
        service.tambahMahasiswa(new Mahasiswa("12345005", "Rizki Ahmad", 3.60, "Sistem Informasi"));
        service.tambahMahasiswa(new Mahasiswa("12345006", "Diana Putri", 3.95, "Teknik Informatika"));
        service.tambahMahasiswa(new Mahasiswa("12345007", "Agus Wijaya", 3.40, "Teknik Komputer"));
        service.tambahMahasiswa(new Mahasiswa("12345008", "Lina Maharani", 3.85, "Sistem Informasi"));
    }

    // === Utilities input & UI ===
    private static String getInputString(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().trim();
    }

    private static String getInputStringOptional(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().trim();
    }

    private static int getInputInteger(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                String input = scanner.nextLine().trim();
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Error: Masukkan angka yang valid!");
            }
        }
    }

    private static double getInputDoubleDenganValidasi(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                String input = scanner.nextLine().trim();
                double v = Double.parseDouble(input);
                if (v < 0.0 || v > 4.0) {
                    System.out.println("Error: IPK harus berada dalam rentang 0.00 - 4.00");
                    continue;
                }
                return v;
            } catch (NumberFormatException e) {
                System.out.println("Error: Masukkan angka desimal yang valid!");
            }
        }
    }

    private static void clearScreen() {
        System.out.print("\033[2J\033[H");
        System.out.flush();
    }
}
