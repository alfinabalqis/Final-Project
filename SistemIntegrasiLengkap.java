import java.util.*;
import java.util.regex.Pattern;

/**
 * SISTEM INTEGRASI LENGKAP - STRUKTUR DATA & ALGORITMA
 * 
 * Implementasi lengkap struktur data:
 * 1. Hash Table (HashMap) - untuk manajemen data mahasiswa
 * 2. Binary Search Tree (BST) - untuk indexing dan pengurutan
 * 3. Graph - untuk sistem navigasi kampus dengan algoritma Dijkstra
 * 4. Expression Tree - untuk evaluasi ekspresi matematika
 * 
 * Tim:
 * - Horas Marolop Amsal Siregar (2802608864)
 * - Alfina Balqis Nurzaharani (2802582152)
 * - Egi Nugraha (2802597854)
 */
public class SistemIntegrasiLengkap {
    private static MahasiswaService mahasiswaService = new MahasiswaService();
    private static MahasiswaGraph navigasiGraph = new MahasiswaGraph();
    private static ExpressionTree expressionTree = new ExpressionTree();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        inisialisasiDataSample();
        clearScreen();

        System.out.println("==========================================================");
        System.out.println("    SISTEM INTEGRASI LENGKAP - STRUKTUR DATA & ALGORITMA");
        System.out.println("==========================================================");
        System.out.println("Implementasi: Hash Table, BST, Graph, dan Expression Tree");
        System.out.println("==========================================================");

        boolean running = true;

        while (running) {
            tampilkanMenuUtama();
            int pilihan = getInputInteger("Pilih sistem (1-5): ");

            switch (pilihan) {
                case 1:
                    jalankanSistemManajemenMahasiswa();
                    break;
                case 2:
                    jalankanSistemNavigasiKampus();
                    break;
                case 3:
                    jalankanSistemExpressionTree();
                    break;
                case 4:
                    analisisPerbandinganStrukturData();
                    break;
                case 5:
                    System.out.println("\n=== TERIMA KASIH ===");
                    running = false;
                    break;
                default:
                    System.out.println("Pilihan tidak valid! Silakan pilih 1-5.");
            }

            if (running) {
                System.out.println("\nTekan Enter untuk kembali ke menu utama...");
                scanner.nextLine();
                clearScreen();
            }
        }

        scanner.close();
    }

    private static void tampilkanMenuUtama() {
        System.out.println("\n=== MENU UTAMA ===");
        System.out.println("1. Sistem Manajemen Data Mahasiswa (Hash Table + BST)");
        System.out.println("2. Sistem Navigasi Kampus (Graph + Dijkstra)");
        System.out.println("3. Sistem Expression Tree (Evaluasi Matematika)");
        System.out.println("4. Analisis Perbandingan Struktur Data");
        System.out.println("5. Keluar");
        System.out.println();
    }

    // === SISTEM MANAJEMEN MAHASISWA ===
    private static void jalankanSistemManajemenMahasiswa() {
        boolean running = true;

        while (running) {
            clearScreen();
            System.out.println("==========================================================");
            System.out.println("    SISTEM MANAJEMEN DATA MAHASISWA");
            System.out.println("==========================================================");
            System.out.println("Struktur Data: Hash Table (HashMap) + Binary Search Tree");
            System.out.println("==========================================================");

            tampilkanMenuMahasiswa();
            int pilihan = getInputInteger("Pilih menu (1-8): ");

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
                    cariMahasiswaByNim();
                    break;
                case 5:
                    tampilkanSemuaData();
                    break;
                case 6:
                    perbandinganHashTableVsBST();
                    break;
                case 7:
                    benchmarkStrukturData();
                    break;
                case 8:
                    running = false;
                    break;
                default:
                    System.out.println("Pilihan tidak valid! Silakan pilih 1-8.");
            }

            if (running) {
                System.out.println("\nTekan Enter untuk melanjutkan...");
                scanner.nextLine();
            }
        }
    }

    private static void tampilkanMenuMahasiswa() {
        System.out.println("\n1. Tambah Mahasiswa");
        System.out.println("2. Update Mahasiswa");
        System.out.println("3. Hapus Mahasiswa");
        System.out.println("4. Cari Mahasiswa (berdasarkan NIM)");
        System.out.println("5. Tampilkan Semua Data");
        System.out.println("6. Perbandingan Hash Table vs BST");
        System.out.println("7. Benchmark Struktur Data");
        System.out.println("8. Kembali ke Menu Utama");
        System.out.println();
    }

    // === SISTEM NAVIGASI KAMPUS ===
    private static void jalankanSistemNavigasiKampus() {
        boolean running = true;

        while (running) {
            clearScreen();
            System.out.println("==========================================================");
            System.out.println("    SISTEM NAVIGASI KAMPUS");
            System.out.println("==========================================================");
            System.out.println("Struktur Data: Graph + Algoritma Dijkstra");
            System.out.println("==========================================================");

            tampilkanMenuNavigasi();
            int pilihan = getInputInteger("Pilih menu (1-7): ");

            switch (pilihan) {
                case 1:
                    cariJalurTerpendek();
                    break;
                case 2:
                    tampilkanSemuaLokasi();
                    break;
                case 3:
                    tampilkanStrukturGraph();
                    break;
                case 4:
                    demoAlgoritmaDijkstra();
                    break;
                case 5:
                    analisisKompleksitasGraph();
                    break;
                case 6:
                    benchmarkGraphAlgorithms();
                    break;
                case 7:
                    running = false;
                    break;
                default:
                    System.out.println("Pilihan tidak valid! Silakan pilih 1-7.");
            }

            if (running) {
                System.out.println("\nTekan Enter untuk melanjutkan...");
                scanner.nextLine();
            }
        }
    }

    private static void tampilkanMenuNavigasi() {
        System.out.println("\n1. Cari Jalur Terpendek");
        System.out.println("2. Tampilkan Semua Lokasi");
        System.out.println("3. Tampilkan Struktur Graph");
        System.out.println("4. Demo Algoritma Dijkstra");
        System.out.println("5. Analisis Kompleksitas Graph");
        System.out.println("6. Benchmark Algoritma Graph");
        System.out.println("7. Kembali ke Menu Utama");
        System.out.println();
    }

    // === SISTEM EXPRESSION TREE ===
    private static void jalankanSistemExpressionTree() {
        boolean running = true;

        while (running) {
            clearScreen();
            System.out.println("==========================================================");
            System.out.println("    SISTEM EXPRESSION TREE");
            System.out.println("==========================================================");
            System.out.println("Struktur Data: Binary Tree untuk Evaluasi Ekspresi Matematika");
            System.out.println("==========================================================");

            tampilkanMenuExpressionTree();
            int pilihan = getInputInteger("Pilih menu (1-6): ");

            switch (pilihan) {
                case 1:
                    evaluasiEkspresiMatematika();
                    break;
                case 2:
                    demoExpressionTree();
                    break;
                case 3:
                    tampilkanStrukturTree();
                    break;
                case 4:
                    analisisKompleksitasExpressionTree();
                    break;
                case 5:
                    benchmarkExpressionTree();
                    break;
                case 6:
                    running = false;
                    break;
                default:
                    System.out.println("Pilihan tidak valid! Silakan pilih 1-6.");
            }

            if (running) {
                System.out.println("\nTekan Enter untuk melanjutkan...");
                scanner.nextLine();
            }
        }
    }

    private static void tampilkanMenuExpressionTree() {
        System.out.println("\n1. Evaluasi Ekspresi Matematika");
        System.out.println("2. Demo Expression Tree");
        System.out.println("3. Tampilkan Struktur Tree");
        System.out.println("4. Analisis Kompleksitas Expression Tree");
        System.out.println("5. Benchmark Expression Tree");
        System.out.println("6. Kembali ke Menu Utama");
        System.out.println();
    }

    // === IMPLEMENTASI FUNGSI-FUNGSI MANAJEMEN MAHASISWA ===
    private static void tambahMahasiswa() {
        System.out.println("\n=== TAMBAH MAHASISWA BARU ===");

        String nim = getInputString("Masukkan NIM: ");
        String nama = getInputString("Masukkan Nama: ");
        double ipk = getInputDoubleDenganValidasi("Masukkan IPK (0.00 - 4.00): ");
        String jurusan = getInputString("Masukkan Jurusan: ");

        if (ipk < 0.0 || ipk > 4.0) {
            System.out.println("Error: IPK harus berada dalam rentang 0.00 - 4.00");
            return;
        }

        Mahasiswa mahasiswa = new Mahasiswa(nim, nama, ipk, jurusan);
        mahasiswaService.tambahMahasiswa(mahasiswa);
    }

    private static void cariMahasiswaByNim() {
        System.out.println("\n=== CARI MAHASISWA BERDASARKAN NIM ===");
        String nim = getInputString("Masukkan NIM yang dicari: ");

        // Perbandingan waktu pencarian Hash Table vs BST
        System.out.println("\n--- Pencarian dengan Hash Table ---");
        long startTime = System.nanoTime();
        Mahasiswa mahasiswaHash = mahasiswaService.cariByNim(nim);
        long endTime = System.nanoTime();

        if (mahasiswaHash != null) {
            System.out.println("Mahasiswa ditemukan: " + mahasiswaHash);
        } else {
            System.out.println("Mahasiswa dengan NIM " + nim + " tidak ditemukan.");
        }
        System.out.printf("Waktu pencarian Hash Table: %.6f ms\n", (endTime - startTime) / 1_000_000.0);

        System.out.println("\n--- Pencarian dengan BST ---");
        startTime = System.nanoTime();
        Mahasiswa mahasiswaBST = mahasiswaService.cariByNimBST(nim);
        endTime = System.nanoTime();

        if (mahasiswaBST != null) {
            System.out.println("Mahasiswa ditemukan: " + mahasiswaBST);
        } else {
            System.out.println("Mahasiswa dengan NIM " + nim + " tidak ditemukan.");
        }
        System.out.printf("Waktu pencarian BST: %.6f ms\n", (endTime - startTime) / 1_000_000.0);
    }

    private static void updateMahasiswa() {
        System.out.println("\n=== UPDATE DATA MAHASISWA ===");
        String nim = getInputString("Masukkan NIM mahasiswa yang akan diupdate: ");

        Mahasiswa mahasiswaLama = mahasiswaService.cariByNim(nim);
        if (mahasiswaLama == null) {
            System.out.println("Mahasiswa dengan NIM " + nim + " tidak ditemukan.");
            return;
        }

        System.out.println("\nData saat ini:");
        System.out.println("  " + mahasiswaLama);
        System.out.println("\nMasukkan data baru (kosongkan jika tidak ingin mengubah):");

        String nama = getInputStringOptional("Nama baru [" + mahasiswaLama.getNama() + "]: ");
        if (nama.isEmpty())
            nama = mahasiswaLama.getNama();

        String ipkStr = getInputStringOptional("IPK baru [" + mahasiswaLama.getIpk() + "]: ");
        double ipk = ipkStr.isEmpty() ? mahasiswaLama.getIpk() : Double.parseDouble(ipkStr);

        String jurusan = getInputStringOptional("Jurusan baru [" + mahasiswaLama.getJurusan() + "]: ");
        if (jurusan.isEmpty())
            jurusan = mahasiswaLama.getJurusan();

        Mahasiswa mahasiswaBaru = new Mahasiswa(nim, nama, ipk, jurusan);
        mahasiswaService.updateMahasiswa(nim, mahasiswaBaru);
    }

    private static void hapusMahasiswa() {
        System.out.println("\n=== HAPUS DATA MAHASISWA ===");
        String nim = getInputString("Masukkan NIM mahasiswa yang akan dihapus: ");

        Mahasiswa mahasiswa = mahasiswaService.cariByNim(nim);
        if (mahasiswa == null) {
            System.out.println("Mahasiswa dengan NIM " + nim + " tidak ditemukan.");
            return;
        }

        System.out.println("\nData yang akan dihapus:");
        System.out.println("  " + mahasiswa);

        String konfirmasi = getInputString("Apakah Anda yakin ingin menghapus? (y/n): ");
        if (konfirmasi.equalsIgnoreCase("y") || konfirmasi.equalsIgnoreCase("yes")) {
            mahasiswaService.hapusMahasiswa(nim);
        } else {
            System.out.println("Penghapusan dibatalkan.");
        }
    }

    private static void tampilkanSemuaData() {
        System.out.println();
        mahasiswaService.tampilkanSemuaMahasiswaTerurutNim();
    }

    private static void perbandinganHashTableVsBST() {
        System.out.println("\n=== PERBANDINGAN HASH TABLE vs BST ===");
        System.out.println("Menjalankan benchmark pencarian untuk 1000 operasi...");

        // Benchmark Hash Table
        long startTime = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            mahasiswaService.cariByNim("12345001");
        }
        long endTime = System.nanoTime();
        double hashTableTime = (endTime - startTime) / 1_000_000.0;

        // Benchmark BST
        startTime = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            mahasiswaService.cariByNimBST("12345001");
        }
        endTime = System.nanoTime();
        double bstTime = (endTime - startTime) / 1_000_000.0;

        System.out.printf("Hash Table: %.3f ms untuk 1000 operasi\n", hashTableTime);
        System.out.printf("BST: %.3f ms untuk 1000 operasi\n", bstTime);

        if (hashTableTime < bstTime) {
            System.out.printf("Hash Table %.2fx lebih cepat dari BST\n", bstTime / hashTableTime);
        } else {
            System.out.printf("BST %.2fx lebih cepat dari Hash Table\n", hashTableTime / bstTime);
        }
    }

    private static void benchmarkStrukturData() {
        System.out.println("\n=== BENCHMARK STRUKTUR DATA ===");
        System.out.println("Mengukur performa operasi CRUD untuk berbagai ukuran data...");

        String[] testNims = { "12345001", "12345002", "12345003", "12345004", "12345005" };

        System.out.println("\n--- Operasi Pencarian ---");
        for (String nim : testNims) {
            long startTime = System.nanoTime();
            mahasiswaService.cariByNim(nim);
            long endTime = System.nanoTime();
            System.out.printf("Hash Table - NIM %s: %.3f ms\n", nim, (endTime - startTime) / 1_000_000.0);

            startTime = System.nanoTime();
            mahasiswaService.cariByNimBST(nim);
            endTime = System.nanoTime();
            System.out.printf("BST - NIM %s: %.3f ms\n", nim, (endTime - startTime) / 1_000_000.0);
        }
    }

    // === IMPLEMENTASI FUNGSI-FUNGSI NAVIGASI KAMPUS ===
    private static void cariJalurTerpendek() {
        System.out.println("\n=== CARI JALUR TERPENDEK ===");

        navigasiGraph.tampilkanSemuaLokasi();

        String titikAwal = getInputString("Masukkan kode lokasi awal (A-J): ").toUpperCase();
        String titikTujuan = getInputString("Masukkan kode lokasi tujuan (A-J): ").toUpperCase();

        if (!isValidLokasi(titikAwal) || !isValidLokasi(titikTujuan)) {
            System.out.println("Error: Kode lokasi tidak valid! Gunakan A-J.");
            return;
        }

        if (titikAwal.equals(titikTujuan)) {
            System.out.println("Lokasi awal dan tujuan sama!");
            return;
        }

        long startTime = System.nanoTime();
        MahasiswaGraph.PathResult result = navigasiGraph.dijkstra(titikAwal, titikTujuan);
        long endTime = System.nanoTime();

        if (result != null) {
            result.tampilkanHasil();
        } else {
            System.out.println("Tidak ada jalur yang ditemukan dari " + titikAwal + " ke " + titikTujuan);
        }

        System.out.printf("\nWaktu eksekusi algoritma Dijkstra: %.6f ms\n",
                (endTime - startTime) / 1_000_000.0);
    }

    private static void tampilkanSemuaLokasi() {
        navigasiGraph.tampilkanSemuaLokasi();
    }

    private static void tampilkanStrukturGraph() {
        System.out.println("\n=== STRUKTUR GRAPH KAMPUS ===");
        System.out.println("Graph menggunakan adjacency list representation");
        System.out.println("Setiap node merepresentasikan lokasi kampus");
        System.out.println("Edge merepresentasikan jalur dengan jarak dalam meter");
        System.out.println();

        navigasiGraph.tampilkanAdjacencyList();

        System.out.println("\n=== ANALISIS STRUKTUR DATA GRAPH ===");
        System.out.println("• Vertex (Node): Lokasi-lokasi kampus");
        System.out.println("• Edge: Jalur antar lokasi dengan weight (jarak)");
        System.out.println("• Undirected Graph: Jalur dua arah");
        System.out.println("• Adjacency List: Efisien untuk graph sparse");
        System.out.println("• Algoritma Dijkstra: O((V+E) log V) dengan Priority Queue");
    }

    private static void demoAlgoritmaDijkstra() {
        System.out.println("\n=== DEMO ALGORITMA DIJKSTRA ===");
        System.out.println("Menampilkan beberapa contoh pencarian jalur terpendek:");

        String[][] testCases = {
                { "A", "F" }, // Gerbang ke Fakultas Teknik
                { "B", "H" }, // Parkiran ke Asrama
                { "C", "J" }, // Rektorat ke Masjid
                { "D", "I" }, // Perpustakaan ke Laboratorium
                { "E", "G" } // Kantin ke Lapangan Basket
        };

        for (String[] testCase : testCases) {
            String start = testCase[0];
            String end = testCase[1];

            System.out.println("\n--- Test Case: " + start + " → " + end + " ---");

            long startTime = System.nanoTime();
            MahasiswaGraph.PathResult result = navigasiGraph.dijkstra(start, end);
            long endTime = System.nanoTime();

            if (result != null) {
                System.out.println("Jalur: " + String.join(" → ", result.path));
                System.out.println("Jarak: " + result.totalDistance + " meter");
            } else {
                System.out.println("Tidak ada jalur ditemukan");
            }

            System.out.printf("Waktu: %.3f ms\n", (endTime - startTime) / 1_000_000.0);
        }
    }

    private static void analisisKompleksitasGraph() {
        System.out.println("\n=== ANALISIS KOMPLEKSITAS GRAPH ===");
        System.out.println("• Kompleksitas waktu: O((V+E) log V)");
        System.out.println("• Kompleksitas ruang: O(V)");
        System.out.println("• Priority Queue: Memastikan vertex dengan jarak terpendek diproses terlebih dahulu");
        System.out.println("• Optimal untuk graph dengan edge weight positif");
        System.out.println("• V = jumlah vertex, E = jumlah edge");
    }

    private static void benchmarkGraphAlgorithms() {
        System.out.println("\n=== BENCHMARK ALGORITMA GRAPH ===");
        System.out.println("Mengukur performa algoritma Dijkstra untuk berbagai rute...");

        String[][] testRoutes = {
                { "A", "F" }, { "B", "H" }, { "C", "J" }, { "D", "I" }, { "E", "G" }
        };

        for (String[] route : testRoutes) {
            long startTime = System.nanoTime();
            navigasiGraph.dijkstra(route[0], route[1]);
            long endTime = System.nanoTime();
            System.out.printf("Rute %s → %s: %.3f ms\n", route[0], route[1], (endTime - startTime) / 1_000_000.0);
        }
    }

    // === IMPLEMENTASI FUNGSI-FUNGSI EXPRESSION TREE ===
    private static void evaluasiEkspresiMatematika() {
        System.out.println("\n=== EVALUASI EKSPRESI MATEMATIKA ===");
        System.out.println("Masukkan ekspresi matematika (contoh: (3 + 5) * 2)");

        String ekspresi = getInputString("Ekspresi: ");

        try {
            long startTime = System.nanoTime();
            double hasil = expressionTree.evaluate(ekspresi);
            long endTime = System.nanoTime();

            System.out.println("\n=== HASIL EVALUASI ===");
            System.out.println("Ekspresi: " + ekspresi);
            System.out.println("Hasil: " + hasil);
            System.out.printf("Waktu evaluasi: %.6f ms\n", (endTime - startTime) / 1_000_000.0);

            // Tampilkan struktur tree
            System.out.println("\n=== STRUKTUR EXPRESSION TREE ===");
            expressionTree.printTree();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void demoExpressionTree() {
        System.out.println("\n=== DEMO EXPRESSION TREE ===");
        System.out.println("Menampilkan beberapa contoh evaluasi ekspresi matematika:");

        String[] testExpressions = {
                "(3 + 5) * 2",
                "10 / 2 + 3 * 4",
                "(15 - 7) / 2 + 5",
                "2 ^ 3 + 4 * 2",
                "(20 + 5) / 5 - 2"
        };

        for (String expr : testExpressions) {
            System.out.println("\n--- Ekspresi: " + expr + " ---");
            try {
                long startTime = System.nanoTime();
                double hasil = expressionTree.evaluate(expr);
                long endTime = System.nanoTime();

                System.out.println("Hasil: " + hasil);
                System.out.printf("Waktu: %.3f ms\n", (endTime - startTime) / 1_000_000.0);

            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    private static void tampilkanStrukturTree() {
        System.out.println("\n=== STRUKTUR EXPRESSION TREE ===");
        System.out.println("Expression Tree menggunakan struktur binary tree");
        System.out.println("• Leaf nodes: Operand (angka)");
        System.out.println("• Internal nodes: Operator (+, -, *, /, ^)");
        System.out.println("• Traversal inorder: Menampilkan ekspresi dalam bentuk infix");
        System.out.println("• Evaluasi: Menggunakan postorder traversal");
        System.out.println();

        // Demo dengan ekspresi sederhana
        String demoExpr = "(3 + 5) * 2";
        System.out.println("Contoh struktur tree untuk: " + demoExpr);
        try {
            expressionTree.evaluate(demoExpr);
            expressionTree.printTree();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void analisisKompleksitasExpressionTree() {
        System.out.println("\n=== ANALISIS KOMPLEKSITAS EXPRESSION TREE ===");
        System.out.println("• Konstruksi tree: O(n) dimana n adalah panjang ekspresi");
        System.out.println("• Evaluasi: O(n) menggunakan postorder traversal");
        System.out.println("• Traversal inorder: O(n) untuk menampilkan ekspresi");
        System.out.println("• Memory usage: O(n) untuk menyimpan tree");
        System.out.println("• Keuntungan: Evaluasi ekspresi kompleks yang efisien");
        System.out.println("• Aplikasi: Calculator, compiler, interpreter");
    }

    private static void benchmarkExpressionTree() {
        System.out.println("\n=== BENCHMARK EXPRESSION TREE ===");
        System.out.println("Mengukur performa evaluasi untuk berbagai ekspresi...");

        String[] testExprs = {
                "(3 + 5) * 2",
                "10 / 2 + 3 * 4",
                "(15 - 7) / 2 + 5",
                "2 ^ 3 + 4 * 2",
                "(20 + 5) / 5 - 2"
        };

        for (String expr : testExprs) {
            long startTime = System.nanoTime();
            try {
                expressionTree.evaluate(expr);
            } catch (Exception e) {
                // Ignore errors for benchmark
            }
            long endTime = System.nanoTime();
            System.out.printf("Ekspresi '%s': %.3f ms\n", expr, (endTime - startTime) / 1_000_000.0);
        }
    }

    // === ANALISIS PERBANDINGAN STRUKTUR DATA ===
    private static void analisisPerbandinganStrukturData() {
        clearScreen();
        System.out.println("==========================================================");
        System.out.println("    ANALISIS PERBANDINGAN STRUKTUR DATA");
        System.out.println("==========================================================");

        System.out.println("\n=== 1. HASH TABLE (HashMap) ===");
        System.out.println("Kelebihan:");
        System.out.println("• Pencarian, penambahan, penghapusan: O(1) rata-rata");
        System.out.println("• Efisien untuk data yang besar");
        System.out.println("• Tidak memerlukan pengurutan");
        System.out.println("• Ideal untuk key-value storage");
        System.out.println("\nKekurangan:");
        System.out.println("• Tidak mempertahankan urutan");
        System.out.println("• Collision dapat mempengaruhi performa");
        System.out.println("• Memory overhead untuk hash function");

        System.out.println("\n=== 2. BINARY SEARCH TREE (BST) ===");
        System.out.println("Kelebihan:");
        System.out.println("• Data terurut secara otomatis");
        System.out.println("• Pencarian, penambahan, penghapusan: O(log n)");
        System.out.println("• Efisien untuk range queries");
        System.out.println("• Memory efficient");
        System.out.println("\nKekurangan:");
        System.out.println("• Performa O(n) jika tree tidak seimbang");
        System.out.println("• Kompleksitas implementasi");
        System.out.println("• Tidak optimal untuk data yang sudah terurut");

        System.out.println("\n=== 3. GRAPH ===");
        System.out.println("Kelebihan:");
        System.out.println("• Fleksibel untuk representasi relasi kompleks");
        System.out.println("• Algoritma pathfinding (Dijkstra, BFS, DFS)");
        System.out.println("• Cocok untuk network analysis");
        System.out.println("• Dapat merepresentasikan berbagai jenis relasi");
        System.out.println("\nKekurangan:");
        System.out.println("• Kompleksitas algoritma tinggi");
        System.out.println("• Memory usage untuk adjacency list/matrix");
        System.out.println("• Tidak efisien untuk operasi sederhana");

        System.out.println("\n=== 4. EXPRESSION TREE ===");
        System.out.println("Kelebihan:");
        System.out.println("• Evaluasi ekspresi matematika yang efisien");
        System.out.println("• Struktur yang jelas untuk ekspresi kompleks");
        System.out.println("• Mudah untuk optimasi");
        System.out.println("• Cocok untuk compiler dan interpreter");
        System.out.println("\nKekurangan:");
        System.out.println("• Overhead untuk ekspresi sederhana");
        System.out.println("• Kompleksitas parsing ekspresi");
        System.out.println("• Memory usage untuk tree structure");

        System.out.println("\n=== REKOMENDASI PENGGUNAAN ===");
        System.out.println("• Hash Table: Untuk pencarian cepat berdasarkan key");
        System.out.println("• BST: Untuk data yang perlu diurutkan dan range queries");
        System.out.println("• Graph: Untuk masalah yang melibatkan relasi dan pathfinding");
        System.out.println("• Expression Tree: Untuk evaluasi ekspresi matematika kompleks");
    }

    // === UTILITIES ===
    private static void inisialisasiDataSample() {
        // Data mahasiswa yang lebih banyak untuk testing
        mahasiswaService.tambahMahasiswa(new Mahasiswa("12345001", "Andi Pratama", 3.75, "Teknik Informatika"));
        mahasiswaService.tambahMahasiswa(new Mahasiswa("12345002", "Sari Dewi", 3.90, "Sistem Informasi"));
        mahasiswaService.tambahMahasiswa(new Mahasiswa("12345003", "Budi Santoso", 3.25, "Teknik Informatika"));
        mahasiswaService.tambahMahasiswa(new Mahasiswa("12345004", "Maya Sari", 3.80, "Teknik Komputer"));
        mahasiswaService.tambahMahasiswa(new Mahasiswa("12345005", "Rizki Ahmad", 3.60, "Sistem Informasi"));
        mahasiswaService.tambahMahasiswa(new Mahasiswa("12345006", "Diana Putri", 3.95, "Teknik Informatika"));
        mahasiswaService.tambahMahasiswa(new Mahasiswa("12345007", "Agus Wijaya", 3.40, "Teknik Komputer"));
        mahasiswaService.tambahMahasiswa(new Mahasiswa("12345008", "Lina Maharani", 3.85, "Sistem Informasi"));
        mahasiswaService.tambahMahasiswa(new Mahasiswa("12345009", "Fajar Ramadhan", 3.70, "Teknik Informatika"));
        mahasiswaService.tambahMahasiswa(new Mahasiswa("12345010", "Nina Safitri", 3.88, "Sistem Informasi"));
        mahasiswaService.tambahMahasiswa(new Mahasiswa("12345011", "Hendra Kusuma", 3.55, "Teknik Komputer"));
        mahasiswaService.tambahMahasiswa(new Mahasiswa("12345012", "Ratna Sari", 3.92, "Teknik Informatika"));
        mahasiswaService.tambahMahasiswa(new Mahasiswa("12345013", "Doni Prasetyo", 3.30, "Sistem Informasi"));
        mahasiswaService.tambahMahasiswa(new Mahasiswa("12345014", "Yuni Astuti", 3.78, "Teknik Komputer"));
        mahasiswaService.tambahMahasiswa(new Mahasiswa("12345015", "Bambang Setiawan", 3.65, "Teknik Informatika"));
    }

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

    private static boolean isValidLokasi(String kode) {
        return kode.matches("[A-J]");
    }

    private static void clearScreen() {
        System.out.print("\033[2J\033[H");
        System.out.flush();
    }
}

/**
 * Expression Tree untuk evaluasi ekspresi matematika
 */
class ExpressionTree {
    private Node root;

    private static class Node {
        String value;
        Node left, right;

        Node(String value) {
            this.value = value;
        }
    }

    public double evaluate(String expression) {
        // Parse dan build tree
        root = buildTree(expression);
        return evaluateNode(root);
    }

    private Node buildTree(String expression) {
        // Implementasi sederhana untuk parsing ekspresi
        // Dalam implementasi nyata, gunakan shunting yard algorithm
        expression = expression.replaceAll("\\s+", "");

        // Handle kasus sederhana: (a op b)
        if (expression.startsWith("(") && expression.endsWith(")")) {
            expression = expression.substring(1, expression.length() - 1);
        }

        // Cari operator dengan prioritas terendah
        int parenCount = 0;
        int lowestPriority = Integer.MAX_VALUE;
        int lowestPriorityIndex = -1;

        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (c == '(')
                parenCount++;
            else if (c == ')')
                parenCount--;
            else if (parenCount == 0 && isOperator(c)) {
                int priority = getPriority(c);
                if (priority <= lowestPriority) {
                    lowestPriority = priority;
                    lowestPriorityIndex = i;
                }
            }
        }

        if (lowestPriorityIndex != -1) {
            Node node = new Node(String.valueOf(expression.charAt(lowestPriorityIndex)));
            node.left = buildTree(expression.substring(0, lowestPriorityIndex));
            node.right = buildTree(expression.substring(lowestPriorityIndex + 1));
            return node;
        } else {
            // Leaf node (number)
            return new Node(expression);
        }
    }

    private boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/' || c == '^';
    }

    private int getPriority(char op) {
        switch (op) {
            case '^':
                return 3;
            case '*':
            case '/':
                return 2;
            case '+':
            case '-':
                return 1;
            default:
                return 0;
        }
    }

    private double evaluateNode(Node node) {
        if (node.left == null && node.right == null) {
            return Double.parseDouble(node.value);
        }

        double leftVal = evaluateNode(node.left);
        double rightVal = evaluateNode(node.right);

        switch (node.value) {
            case "+":
                return leftVal + rightVal;
            case "-":
                return leftVal - rightVal;
            case "*":
                return leftVal * rightVal;
            case "/":
                return leftVal / rightVal;
            case "^":
                return Math.pow(leftVal, rightVal);
            default:
                throw new IllegalArgumentException("Unknown operator: " + node.value);
        }
    }

    public void printTree() {
        if (root == null) {
            System.out.println("Tree kosong");
            return;
        }
        printTreeRecursive(root, "", true);
    }

    private void printTreeRecursive(Node node, String prefix, boolean isLeft) {
        if (node != null) {
            System.out.println(prefix + (isLeft ? "└── " : "┌── ") + node.value);
            printTreeRecursive(node.left, prefix + (isLeft ? "    " : "│   "), true);
            printTreeRecursive(node.right, prefix + (isLeft ? "    " : "│   "), false);
        }
    }
}
