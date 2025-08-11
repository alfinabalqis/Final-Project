# Sistem Integrasi Lengkap - Struktur Data & Algoritma

## Deskripsi Proyek
Proyek akhir ini mengimplementasikan empat struktur data utama dalam satu sistem aplikasi berbasis Java:
1. **Hash Table (HashMap)** - untuk manajemen data mahasiswa
2. **Binary Search Tree (BST)** - untuk indexing dan pengurutan
3. **Graph** - untuk sistem navigasi kampus dengan algoritma Dijkstra
4. **Expression Tree** - untuk evaluasi ekspresi matematika

## Tim Pengembang
| Nama                            | NIM        |
|---------------------------------|------------|
| Horas Marolop Amsal Siregar     | 2802608864 |
| Alfina Balqis Nurzaharani       | 2802582152 |
| Egi Nugraha                     | 2802597854 |

## Struktur Data yang Diimplementasikan

### 1. Hash Table (HashMap)
**File:** `MahasiswaService.java`
- **Fungsi:** Manajemen data mahasiswa dengan pencarian cepat
- **Kompleksitas:** O(1) rata-rata untuk operasi CRUD
- **Fitur:**
  - Tambah mahasiswa baru
  - Update data mahasiswa
  - Hapus mahasiswa
  - Pencarian berdasarkan NIM
  - Tampilkan semua data

### 2. Binary Search Tree (BST)
**File:** `MahasiswaBST.java`
- **Fungsi:** Indexing dan pengurutan data mahasiswa
- **Kompleksitas:** O(log n) untuk operasi pencarian
- **Fitur:**
  - Insert, search, delete operations
  - Inorder traversal untuk pengurutan
  - Index sekunder untuk data mahasiswa

### 3. Graph dengan Algoritma Dijkstra
**File:** `MahasiswaGraph.java`
- **Fungsi:** Sistem navigasi kampus
- **Kompleksitas:** O((V+E) log V) untuk algoritma Dijkstra
- **Fitur:**
  - Representasi lokasi kampus sebagai vertex
  - Jalur antar lokasi sebagai edge dengan weight (jarak)
  - Algoritma Dijkstra untuk mencari jalur terpendek
  - 10 lokasi kampus (A-J) dengan jarak dalam meter

### 4. Expression Tree
**File:** `ExpressionTree.java`
- **Fungsi:** Evaluasi ekspresi matematika
- **Kompleksitas:** O(n) untuk konstruksi dan evaluasi
- **Fitur:**
  - Parsing ekspresi matematika ke tree structure
  - Support operator: +, -, *, /, ^
  - Support parentheses
  - Visualisasi struktur tree
  - Multiple traversal methods (inorder, preorder, postorder)

## Model Data
**File:** `Mahasiswa.java`
- Representasi data mahasiswa dengan atribut:
  - NIM (Nomor Induk Mahasiswa)
  - Nama
  - IPK (Indeks Prestasi Kumulatif)
  - Jurusan

## Cara Menjalankan Program

### Kompilasi
```bash
javac *.java
```

### Menjalankan Program Utama
```bash
java SistemIntegrasiLengkap
```

## Fitur Utama

### 1. Sistem Manajemen Data Mahasiswa
- **Tambah Mahasiswa:** Menambahkan data mahasiswa baru
- **Update Mahasiswa:** Memperbarui data mahasiswa yang ada
- **Hapus Mahasiswa:** Menghapus data mahasiswa
- **Cari Mahasiswa:** Pencarian berdasarkan NIM dengan perbandingan Hash Table vs BST
- **Tampilkan Data:** Menampilkan semua data terurut berdasarkan NIM
- **Benchmark:** Perbandingan performa Hash Table vs BST

### 2. Sistem Navigasi Kampus
- **Cari Jalur Terpendek:** Implementasi algoritma Dijkstra
- **Tampilkan Lokasi:** Daftar semua lokasi kampus
- **Struktur Graph:** Visualisasi adjacency list
- **Demo Algoritma:** Contoh penggunaan untuk berbagai rute
- **Benchmark:** Analisis performa algoritma

### 3. Sistem Expression Tree
- **Evaluasi Ekspresi:** Input ekspresi matematika dan dapatkan hasil
- **Demo Expression Tree:** Contoh evaluasi berbagai ekspresi
- **Struktur Tree:** Visualisasi tree structure
- **Analisis Kompleksitas:** Penjelasan kompleksitas algoritma
- **Benchmark:** Perbandingan performa evaluasi

### 4. Analisis Perbandingan Struktur Data
- **Kelebihan dan Kekurangan:** Setiap struktur data
- **Rekomendasi Penggunaan:** Kapan menggunakan struktur data tertentu
- **Analisis Kompleksitas:** Perbandingan efisiensi

## Contoh Output

### Sistem Manajemen Mahasiswa
```
=== TAMBAH MAHASISWA BARU ===
Masukkan NIM: 12345001
Masukkan Nama: Andi Pratama
Masukkan IPK (0.00 - 4.00): 3.75
Masukkan Jurusan: Teknik Informatika
Berhasil menambahkan mahasiswa: NIM: 12345001, Nama: Andi Pratama, IPK: 3.75, Jurusan: Teknik Informatika
```

### Sistem Navigasi Kampus
```
=== JALUR TERPENDEK DITEMUKAN ===
Jalur: A → B → C → E → F
Jarak total: 320 meter
(0.3 km)

Detail rute:
1. A - Gerbang Utama Kampus
2. B - Parkiran Motor
3. C - Gedung Rektorat
4. E - Kantin
5. F - Gedung Fakultas Teknik
```

### Sistem Expression Tree
```
=== EVALUASI EKSPRESI MATEMATIKA ===
Masukkan ekspresi matematika: (3 + 5) * 2

=== HASIL EVALUASI ===
Ekspresi: (3 + 5) * 2
Hasil: 16.0
Waktu evaluasi: 0.123456 ms

=== STRUKTUR EXPRESSION TREE ===
└── *
    ├── +
    │   ├── 3
    │   └── 5
    └── 2
```

## Analisis Kompleksitas

### Hash Table (HashMap)
- **Pencarian:** O(1) rata-rata
- **Insert/Delete:** O(1) rata-rata
- **Memory:** O(n)
- **Kelebihan:** Pencarian sangat cepat
- **Kekurangan:** Tidak mempertahankan urutan

### Binary Search Tree
- **Pencarian:** O(log n) - O(n) (tergantung balance)
- **Insert/Delete:** O(log n) - O(n)
- **Memory:** O(n)
- **Kelebihan:** Data terurut, efisien untuk range queries
- **Kekurangan:** Performa menurun jika tidak seimbang

### Graph (Dijkstra)
- **Kompleksitas Waktu:** O((V+E) log V)
- **Kompleksitas Ruang:** O(V)
- **Kelebihan:** Optimal untuk shortest path
- **Kekurangan:** Kompleksitas tinggi untuk graph besar

### Expression Tree
- **Konstruksi:** O(n)
- **Evaluasi:** O(n)
- **Memory:** O(n)
- **Kelebihan:** Evaluasi ekspresi kompleks yang efisien
- **Kekurangan:** Overhead untuk ekspresi sederhana

## Data Sample

### Data Mahasiswa (15 mahasiswa)
Program dilengkapi dengan 15 data mahasiswa sample untuk testing:
- NIM: 12345001-12345015
- Jurusan: Teknik Informatika, Sistem Informasi, Teknik Komputer
- IPK: 3.25 - 3.95

### Data Lokasi Kampus (10 lokasi)
- A: Gerbang Utama Kampus
- B: Parkiran Motor
- C: Gedung Rektorat
- D: Perpustakaan
- E: Kantin
- F: Gedung Fakultas Teknik
- G: Lapangan Basket
- H: Asrama Mahasiswa
- I: Gedung Laboratorium
- J: Masjid Kampus

### Data Ekspresi Matematika
Contoh ekspresi untuk testing:
- `(3 + 5) * 2`
- `10 / 2 + 3 * 4`
- `(15 - 7) / 2 + 5`
- `2 ^ 3 + 4 * 2`
- `(20 + 5) / 5 - 2`

## Benchmark dan Analisis Performa

Program menyediakan fitur benchmark untuk:
1. **Perbandingan Hash Table vs BST:** 1000 operasi pencarian
2. **Benchmark Graph Algorithms:** Waktu eksekusi Dijkstra untuk berbagai rute
3. **Benchmark Expression Tree:** Waktu evaluasi berbagai ekspresi

## Kesimpulan

Sistem ini berhasil mengimplementasikan empat struktur data utama dengan fitur lengkap:
- **Hash Table:** Efisien untuk pencarian cepat data mahasiswa
- **BST:** Optimal untuk indexing dan pengurutan
- **Graph:** Fleksibel untuk masalah navigasi dan pathfinding
- **Expression Tree:** Efisien untuk evaluasi ekspresi matematika

Setiap struktur data memiliki kelebihan dan kekurangan masing-masing, dan pemilihan struktur data yang tepat bergantung pada kebutuhan aplikasi.

## File yang Dihasilkan
- `SistemIntegrasiLengkap.java` - Program utama
- `Mahasiswa.java` - Model data mahasiswa
- `MahasiswaService.java` - Service layer dengan Hash Table
- `MahasiswaBST.java` - Implementasi Binary Search Tree
- `MahasiswaGraph.java` - Implementasi Graph dan algoritma Dijkstra
- `ExpressionTree.java` - Implementasi Expression Tree
- `README.md` - Dokumentasi lengkap