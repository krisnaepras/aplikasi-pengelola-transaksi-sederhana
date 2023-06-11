package pkgFPBP2;

public class Transaksi {

    String kode;
    String pembeli;
    Barang barang;
    int jumlahBrg;
    int status;
    Transaksi next;

    Transaksi(String k, String p, Barang b, int j, int s) {
        kode = k;
        pembeli = p;
        barang = b;
        jumlahBrg = j;
        status = s;
        next = null;
    }

    public void setStatus(int s) {
        status = s;
    }

    public String getKode() {
        return kode;
    }

    public String getPembeli() {
        return pembeli;
    }

    public Barang getBarang() {
        return barang;
    }

    public int getJumlah() {
        return jumlahBrg;
    }

    public int getStatus() {
        return status;
    }

    
}
