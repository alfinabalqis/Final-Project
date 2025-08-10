/**
 * Kelas model untuk representasi data mahasiswa
 * Digunakan dalam implementasi Hash Table untuk Sistem Manajemen Data Mahasiswa
 */
public class Mahasiswa {
    private String nim;
    private String nama;
    private double ipk;
    private String jurusan;
    
    /**
     * Constructor untuk membuat objek Mahasiswa
     * @param nim Nomor Induk Mahasiswa (sebagai key utama)
     * @param nama Nama lengkap mahasiswa
     * @param ipk Indeks Prestasi Kumulatif
     * @param jurusan Program studi mahasiswa
     */
    public Mahasiswa(String nim, String nama, double ipk, String jurusan) {
        this.nim = nim;
        this.nama = nama;
        this.ipk = ipk;
        this.jurusan = jurusan;
    }
    
    // Getter methods
    public String getNim() {
        return nim;
    }
    
    public String getNama() {
        return nama;
    }
    
    public double getIpk() {
        return ipk;
    }
    
    public String getJurusan() {
        return jurusan;
    }
    
    // Setter methods
    public void setNama(String nama) {
        this.nama = nama;
    }
    
    public void setIpk(double ipk) {
        this.ipk = ipk;
    }
    
    public void setJurusan(String jurusan) {
        this.jurusan = jurusan;
    }
    
    /**
     * Override toString untuk menampilkan informasi mahasiswa
     * @return String representasi dari objek Mahasiswa
     */
    @Override
    public String toString() {
        return String.format("NIM: %s, Nama: %s, IPK: %.2f, Jurusan: %s", 
                           nim, nama, ipk, jurusan);
    }
    
    /**
     * Override equals untuk perbandingan objek berdasarkan NIM
     * @param obj Objek yang akan dibandingkan
     * @return true jika NIM sama, false jika tidak
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Mahasiswa mahasiswa = (Mahasiswa) obj;
        return nim.equals(mahasiswa.nim);
    }
    
    /**
     * Override hashCode untuk konsistensi dengan equals
     * @return hash code berdasarkan NIM
     */
    @Override
    public int hashCode() {
        return nim.hashCode();
    }
}
