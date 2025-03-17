package id.ac.ub.papb.recycler1;

public class Mahasiswa {
    private String nim;
    private String nama;

    // Konstruktor kosong untuk Firebase
    public Mahasiswa() {
    }

    // Konstruktor utama
    public Mahasiswa(String nim, String nama) {
        this.nim = nim;
        this.nama = nama;
    }

    // Getter
    public String getNim() {
        return nim;
    }

    public String getNama() {
        return nama;
    }

    // Setter (Tambahkan ini)
    public void setNim(String nim) {
        this.nim = nim;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }
}
