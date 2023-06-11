package pkgFPBP2;

import java.util.HashMap;
import java.util.Map;

public class DaftarTransaksi {

    Transaksi front, rear;
    int jumlah;

    public DaftarTransaksi() {
        front = rear = null;
        jumlah = 0;
    }

    public Transaksi getFront() {
        return front;
    }

    public Transaksi getRear() {
        return rear;
    }

    public void tambahTransaksi(Transaksi baru) {
        if (rear == null) {
            front = rear = baru;
        } else {
            rear.next = baru;
            rear = baru;
        }
        System.out.println("Penambahan sukses");
    }

    public void tambahTransaksiMember(Transaksi baru) {
        if (rear == null) {
            front = rear = baru;
        } else {
            rear.next = baru;
            rear = baru;
        }

        // Menerapkan diskon 5% pada harga barang untuk pembeli member
        int hargaBarang = baru.getBarang().getHarga();
        int diskon = (int) (hargaBarang * 0.05);
        int hargaSetelahDiskon = hargaBarang - diskon;
        baru.getBarang().setHarga(hargaSetelahDiskon);

        System.out.println("Penambahan sukses");
    }

    public void lihatProsesTransaksi() {
        System.out.println("Daftar Transaksi:");
        int i = 1;
// Lakukan iterasi melalui transaksi dan tampilkan hanya transaksi dengan status 0
        for (Transaksi t = front; t != null; t = t.next) {
            if (t.getStatus() == 0) { // Cek apakah status transaksi adalah 0 (belum diproses)
                System.out.printf(i+". ");
                System.out.printf(t.getKode()+" - ");
                System.out.printf(t.getPembeli()+" - ");
                System.out.printf(t.getBarang().getNama()+" - ");
                System.out.printf(t.getJumlah()+" - ");
                System.out.println(t.getStatus());
                i++;
            }
        }

    }

    public void lihatTransaksi() {
        int i = 1;
        System.out.println("Daftar Transaksi:");
// Lakukan iterasi melalui transaksi dan tampilkan hanya transaksi dengan status 0
        for (Transaksi t = front; t != null; t = t.next) {
            System.out.printf(i+". ");
                System.out.printf(t.getKode()+" - ");
                System.out.printf(t.getPembeli()+" - ");
                System.out.printf(t.getBarang().getNama()+" - ");
                System.out.printf(t.getJumlah()+" - ");
                System.out.println(t.getStatus());
            i++;
        }

    }

    public void lihatTransaksiMember() {
        int i = 1;
        System.out.println("Daftar Transaksi Member:");
        for (Transaksi t = front; t != null; t = t.next) {
            System.out.printf(i+". ");
                System.out.printf(t.getKode()+" - ");
                System.out.printf(t.getPembeli()+" - ");
                System.out.printf(t.getBarang().getNama()+" - ");
                System.out.printf(t.getJumlah()+" - ");
                System.out.println(t.getStatus());
            i++;
        }
        
    }

    public void hapusTransaksi(int nomor) {
        Transaksi t = front;
        Transaksi prev = null;
        int i = 1;
        //hapus posisi depan
        if (nomor == 1) {
            if (t.next == null) {
                front = rear = null;
            } else {
                front = front.next;
                t.next = null;
            }
            System.out.println("[" + t.getBarang().getNama() + "] dihapus..");
        } else {
            for (; t != null; t = t.next) {
                if (i == nomor) {
                    break;
                }
                i++;
                prev = t;
            }
            //yg dihapus di ujung belakang
            if (t.next == null) {
                rear = prev;
                rear.next = null;
            } else {
                prev.next = t.next;
                t.next = null;
            }
            System.out.println("[" + t.getBarang().getNama() + "] dihapus..");
        }
    }

    public void sambungTransaksi(Transaksi depan, Transaksi belakang) {
        // sambungkan transaksi
        if (rear == null) { // transaksi toko masih kosong
            front = depan;
            rear = belakang;
        } else {
            rear.next = depan;

            // Update posisi rear ke belakang
            while (rear.next != null) {
                rear = rear.next;
            }

            // Update posisi rear ke belakang setelah transaksi
            rear = belakang;
        }
    }

    public void prosesTransaksi(Transaksi t) {
        t.setStatus(1);
    }

    public int lihatDiproses() {
        Transaksi t = front;
        int proses = 0;
        for (; t != null; t = t.next) {
            if (t.getStatus() == 1) {
                proses++;
            }
        }
        return proses;
    }

    public int lihatPemasukan() {
        Transaksi t = front;
        int nominal = 0;
        for (; t != null; t = t.next) {
            if (t.getStatus() == 1) {
                nominal = nominal + t.getBarang().getHarga() * t.getJumlah();
            }
        }
        return nominal;
    }

    public void ubahHargaBarang(String namaBarang, int hargaBaru) {
        Transaksi t = front;
        while (t != null) {
            if (t.getBarang().getNama().equals(namaBarang)) {
                t.getBarang().setHarga(hargaBaru);
                System.out.println("Harga barang '" + namaBarang + "' berhasil diubah menjadi " + hargaBaru);
                return;
            }
            t = t.next;
        }
        System.out.println("Barang '" + namaBarang + "' tidak ditemukan.");
    }

    public void laporanPenjualanHarian() {
        // Buat objek untuk menyimpan nilai penjualan harian untuk setiap barang
        HashMap<String, Integer> nilaiPenjualan = new HashMap<>();

        // Lakukan iterasi melalui transaksi untuk menghitung total penjualan harian untuk setiap jenis barang
        for (Transaksi t = front; t != null; t = t.next) {
            if (t.getStatus() == 1) { // Cek apakah transaksi sudah diproses
                String namaBarang = t.getBarang().getNama();
                int hargaBarang = t.getBarang().getHarga();
                int jumlahBarang = t.getJumlah();
                int nilai = hargaBarang * jumlahBarang;

                // Periksa apakah nama barang sudah ada dalam daftar penjualan harian
                if (nilaiPenjualan.containsKey(namaBarang)) {
                    // Jika sudah ada, tambahkan nilai penjualan harian yang baru ke nilai yang sudah ada
                    int nilaiLama = nilaiPenjualan.get(namaBarang);
                    nilaiPenjualan.put(namaBarang, nilaiLama + nilai);
                } else {
                    // Jika belum ada, tambahkan nama barang dan nilai penjualan harian ke daftar
                    nilaiPenjualan.put(namaBarang, nilai);
                }
            }
        }

        // Tampilkan daftar laporan penjualan harian untuk setiap jenis barang
        System.out.println("Laporan Penjualan Harian:");
        for (String namaBarang : nilaiPenjualan.keySet()) {
            int nilaiPenjualanHarian = nilaiPenjualan.get(namaBarang);
            System.out.printf("%-15s %d%n", namaBarang ,":"+ nilaiPenjualanHarian);
        }

    }

    public void totalBiayaBelanjaMember() {
        Transaksi t = front;
        HashMap<String, Integer> totalBiaya = new HashMap<>();

        // Menghitung total biaya belanja untuk setiap pembeli Member
        while (t != null) {
            if (t.getStatus() == 1) { // Transaksi dengan status 1 menandakan Member
                String pembeli = t.getPembeli();
                int biaya = t.getBarang().getHarga() * t.getJumlah();

                // Menambahkan biaya belanja ke total biaya untuk pembeli yang bersangkutan
                if (totalBiaya.containsKey(pembeli)) {
                    biaya += totalBiaya.get(pembeli);
                }
                totalBiaya.put(pembeli, biaya);
            }
            t = t.next;
        }

        // Menampilkan daftar total biaya belanja untuk setiap pembeli Member
        System.out.println("Total Biaya Belanja Member:");
        for (String pembeli : totalBiaya.keySet()) {
            System.out.println("------------------------");
            System.out.printf("Pembeli: %s%n", pembeli);
            System.out.printf("Total Biaya: %d%n", totalBiaya.get(pembeli));
            System.out.println("------------------------");
        }
    }

    public void lihatGrafikPenjualan() {
        Map<String, Integer> penjualan = new HashMap<>();
        // Menghitung total penjualan untuk setiap barang
        for (Transaksi t = front; t != null; t = t.next) {
            if (t.getStatus() == 1) {
                String namaBarang = t.getBarang().getNama();
                int jumlah = t.getJumlah();
                int harga = t.getBarang().getHarga();
                int total = jumlah * harga;
                penjualan.put(namaBarang, penjualan.getOrDefault(namaBarang, 0) + total);
            }
        }
        // Menampilkan grafik penjualan untuk setiap barang
        System.out.println("Grafik Penjualan:");
        for (Map.Entry<String, Integer> entry : penjualan.entrySet()) {
            String namaBarang = entry.getKey();
            int totalPenjualan = entry.getValue();
            int grafikSkala = (totalPenjualan / 10000) * 10000;
            int grafikJumlah = grafikSkala / 10000;
            String grafik = "X".repeat(grafikJumlah);
            System.out.printf("%-15s %s (%d)%n", namaBarang, ":" + grafik, grafikSkala);
        }
    }
}
