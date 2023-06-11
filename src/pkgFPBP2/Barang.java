package pkgFPBP2;

public class Barang {

    String nama;
    int harga;

    Barang(String n, int h) {
        nama = n;
        harga = h;
    }

    public String getNama() {
        return nama;
    }

    public int getHarga() {
        return harga;
    }
    
    public void setHarga(int h){
        harga = h;
    }
}
