import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;

/**
 * Service class untuk mengelola data mahasiswa menggunakan Hash Table (HashMap)
 * Implementasi struktur data Hash Table untuk pencarian, penambahan, dan penghapusan data mahasiswa
 */
public class MahasiswaService {
    // Hash Table utama dengan NIM sebagai key dan Mahasiswa sebagai value
    private HashMap<String, Mahasiswa> dataMahasiswa;
    
    /**
     * Constructor untuk inisialisasi Hash Table
     */
    public MahasiswaService() {
        this.dataMahasiswa = new HashMap<>();
    }
    
    /**
     * Menambahkan mahasiswa baru ke dalam Hash Table
     * Kompleksitas waktu: O(1) rata-rata
     * @param mahasiswa Objek mahasiswa yang akan ditambahkan
     * @return true jika berhasil ditambahkan, false jika NIM sudah ada
     */
    public boolean tambahMahasiswa(Mahasiswa mahasiswa) {
        String nim = mahasiswa.getNim();
        
        // Cek apakah NIM sudah ada (duplikasi key)
        if (dataMahasiswa.containsKey(nim)) {
            System.out.println("Error: Mahasiswa dengan NIM " + nim + " sudah terdaftar!");
            return false;
        }
        
        // Tambahkan ke Hash Table utama
        dataMahasiswa.put(nim, mahasiswa);
        
        System.out.println("Berhasil menambahkan mahasiswa: " + mahasiswa);
        return true;
    }
    
    /**
     * Mencari mahasiswa berdasarkan NIM
     * Kompleksitas waktu: O(1) rata-rata
     * @param nim Nomor Induk Mahasiswa yang dicari
     * @return Objek Mahasiswa jika ditemukan, null jika tidak
     */
    public Mahasiswa cariByNim(String nim) {
        return dataMahasiswa.get(nim);
    }
    
    /**
     * Memperbarui data mahasiswa
     * Kompleksitas waktu: O(1) rata-rata
     * @param nim NIM mahasiswa yang akan diupdate
     * @param mahasiswaBaru Data mahasiswa yang baru
     * @return true jika berhasil diupdate, false jika NIM tidak ditemukan
     */
    public boolean updateMahasiswa(String nim, Mahasiswa mahasiswaBaru) {
        if (!dataMahasiswa.containsKey(nim)) {
            System.out.println("Error: Mahasiswa dengan NIM " + nim + " tidak ditemukan!");
            return false;
        }
        
        // Update data utama
        dataMahasiswa.put(nim, mahasiswaBaru);
        
        System.out.println("Berhasil memperbarui data mahasiswa: " + mahasiswaBaru);
        return true;
    }
    
    /**
     * Menghapus mahasiswa berdasarkan NIM
     * Kompleksitas waktu: O(1) rata-rata
     * @param nim NIM mahasiswa yang akan dihapus
     * @return true jika berhasil dihapus, false jika NIM tidak ditemukan
     */
    public boolean hapusMahasiswa(String nim) {
        Mahasiswa mahasiswa = dataMahasiswa.get(nim);
        if (mahasiswa == null) {
            System.out.println("Error: Mahasiswa dengan NIM " + nim + " tidak ditemukan!");
            return false;
        }
        
        // Hapus dari Hash Table utama
        dataMahasiswa.remove(nim);
        
        System.out.println("Berhasil menghapus mahasiswa: " + mahasiswa);
        return true;
    }
    
    /**
     * Menampilkan semua mahasiswa yang terdaftar
     * Kompleksitas waktu: O(n) dimana n adalah jumlah mahasiswa
     */
    public void tampilkanSemuaMahasiswa() {
        if (dataMahasiswa.isEmpty()) {
            System.out.println("Belum ada data mahasiswa yang terdaftar.");
            return;
        }
        
        System.out.println("\n=== DAFTAR SEMUA MAHASISWA ===");
        System.out.println("----------------------------------------");
        
        for (Mahasiswa mahasiswa : dataMahasiswa.values()) {
            System.out.println(mahasiswa);
        }
        System.out.println("----------------------------------------");
    }
}
