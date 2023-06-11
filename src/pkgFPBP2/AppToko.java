package pkgFPBP2;

import java.util.Scanner;

public class AppToko {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //daftar barang yg dijual
        Barang brg1 = new Barang("Ayam Geprek", 10000);
        Barang brg2 = new Barang("Penyetan Bebek", 15000);
        Barang brg3 = new Barang("Ayam Kecap", 12000);
        Barang brg4 = new Barang("Es Teh", 4000);
        Barang brg5 = new Barang("Es Jeruk", 5000);

        //data member toko
        Password pass = new Password();
        int id1 = 123;
        int id2 = 234;
        int id3 = 345;
        int id, pin;

        //daftar antrian yg masuk ke toko
        DaftarTransaksi jual = new DaftarTransaksi();
        int pilih = 0, pilih2 = 0, pilih3 = 0, pilih4 = 0;
        int kode = 100, jumlah;

        do {
            System.out.println("\n<<<=== Omah Kopi ===>>>");
            System.out.println("1. Pembeli");
            System.out.println("2. Member");
            System.out.println("3. Admin");
            System.out.println("4. Pemilik");
            System.out.println("5. Exit");
            System.out.print("Pilih = ");
            pilih = sc.nextInt();
            System.out.println("");
            switch (pilih) {
                case 1:
                    //Pembeli
                    kode++;
                    DaftarTransaksi beli = new DaftarTransaksi();
                    System.out.print("Masukkan Nama = ");
                    String nama = sc.next();
                    do {
                        System.out.println("Akun Pembeli");
                        System.out.println("1. Tambah");
                        System.out.println("2. Hapus");
                        System.out.println("3. Lihat");
                        System.out.println("4. Kembali");
                        System.out.print("Pilih = ");
                        pilih2 = sc.nextInt();
                        switch (pilih2) {
                            case 1:
                                Transaksi br = null;
                                System.out.println("Daftar Menu");
                                System.out.println("------------------------------");
                                System.out.println("No.   Nama Menu       Harga");
                                System.out.println("------------------------------");
                                System.out.printf("%-5s %-15s %s%n", "1.", brg1.getNama(), brg1.getHarga());
                                System.out.printf("%-5s %-15s %s%n", "2.", brg2.getNama(), brg2.getHarga());
                                System.out.printf("%-5s %-15s %s%n", "3.", brg3.getNama(), brg3.getHarga());
                                System.out.printf("%-5s %-15s %s%n", "4.", brg4.getNama(), brg4.getHarga());
                                System.out.printf("%-5s %-15s %s%n", "5.", brg5.getNama(), brg5.getHarga());
                                System.out.print("Pilih = ");
                                pilih3 = sc.nextInt();
                                System.out.print("Jumlah = ");
                                jumlah = sc.nextInt();
                                if (pilih3 == 1) {
                                    br = new Transaksi(String.valueOf(kode), nama, brg1, jumlah, 0);
                                } else if (pilih3 == 2) {
                                    br = new Transaksi(String.valueOf(kode), nama, brg2, jumlah, 0);
                                } else if (pilih3 == 3) {
                                    br = new Transaksi(String.valueOf(kode), nama, brg3, jumlah, 0);
                                } else if (pilih3 == 4) {
                                    br = new Transaksi(String.valueOf(kode), nama, brg4, jumlah, 0);
                                } else if (pilih3 == 5) {
                                    br = new Transaksi(String.valueOf(kode), nama, brg5, jumlah, 0);
                                }
                                beli.tambahTransaksi(br);
                                System.out.println("");
                                break;
                            case 2:
                                beli.lihatTransaksi();
                                System.out.print("Hapus Nomor = ");
                                int hapus = sc.nextInt();
                                beli.hapusTransaksi(hapus);
                                System.out.println("");
                                break;
                            case 3:
                                beli.lihatTransaksi();
                                System.out.println("");
                                break;
                            case 4:
                                if (beli.getFront() != null && beli.getRear() != null) {
                                    jual.sambungTransaksi(beli.getFront(), beli.getRear());
                                }
                                System.out.println("Selamat datang kembali..");
                                System.out.println("");
                                break;
                        }
                    } while (pilih2 != 4);
                    break;
                case 2:
                    //Member
                    boolean valid = false;
                    do {
                        System.out.print("ID = ");
                        id = sc.nextInt();
                        System.out.print("PIN = ");
                        pin = sc.nextInt();
                        if (id == id1 && pin == pass.getPass1()) {
                            valid = true;
                        } else if (id == id2 && pin == pass.getPass2()) {
                            valid = true;
                        } else if (id == id3 && pin == pass.getPass3()) {
                            valid = true;
                        }
                        if (valid == false) {
                            System.out.println("ID/PIN Salah!");
                        }
                    } while (valid != true);
                    if (valid == true) {
                        System.out.println("Selamat Datang Member..");
                        kode++;
                        beli = new DaftarTransaksi();
                        do {
                            System.out.println("Akun Member");
                            System.out.println("1. Tambah");
                            System.out.println("2. Hapus");
                            System.out.println("3. Lihat");
                            System.out.println("4. Ubah Password");
                            System.out.println("5. Kembali");
                            System.out.print("Pilih = ");
                            pilih2 = sc.nextInt();
                            switch (pilih2) {
                                case 1:
                                    Transaksi br = null;
                                    System.out.println("Daftar Menu");
                                    System.out.println("------------------------------");
                                    System.out.println("No.   Nama Menu       Harga");
                                    System.out.println("------------------------------");
                                    System.out.printf("%-5s %-15s %s%n", "1.", brg1.getNama(), brg1.getHarga());
                                    System.out.printf("%-5s %-15s %s%n", "2.", brg2.getNama(), brg2.getHarga());
                                    System.out.printf("%-5s %-15s %s%n", "3.", brg3.getNama(), brg3.getHarga());
                                    System.out.printf("%-5s %-15s %s%n", "4.", brg4.getNama(), brg4.getHarga());
                                    System.out.printf("%-5s %-15s %s%n", "5.", brg5.getNama(), brg5.getHarga());
                                    System.out.print("Pilih = ");
                                    pilih3 = sc.nextInt();
                                    System.out.print("Jumlah = ");
                                    jumlah = sc.nextInt();
                                    if (pilih3 == 1) {
                                        br = new Transaksi(String.valueOf(kode), String.valueOf(id), brg1, jumlah, 0);
                                    } else if (pilih3 == 2) {
                                        br = new Transaksi(String.valueOf(kode), String.valueOf(id), brg2, jumlah, 0);
                                    } else if (pilih3 == 3) {
                                        br = new Transaksi(String.valueOf(kode), String.valueOf(id), brg3, jumlah, 0);
                                    } else if (pilih3 == 4) {
                                        br = new Transaksi(String.valueOf(kode), String.valueOf(id), brg4, jumlah, 0);
                                    } else if (pilih3 == 5) {
                                        br = new Transaksi(String.valueOf(kode), String.valueOf(id), brg5, jumlah, 0);
                                    }
                                    beli.tambahTransaksiMember(br);
                                    System.out.println("");
                                    break;
                                case 2:
                                    beli.lihatTransaksi();
                                    System.out.print("Hapus Nomor = ");
                                    int hapus = sc.nextInt();
                                    beli.hapusTransaksi(hapus);
                                    System.out.println("");
                                    break;
                                case 3:
                                    //menampilkan daftar belanja dan diskon
                                    beli.lihatTransaksiMember();
                                    System.out.println("");
                                    break;
                                case 4:
                                    System.out.print("PIN Lama = ");
                                    pin = sc.nextInt();
                                    int pin2;
                                    if (id == id1 && pin == pass.getPass1()) {
                                        System.out.println("PIN Baru =");
                                        pin2 = sc.nextInt();
                                        pass.setPass1(pin2);
                                        System.out.println("PIN berhasil diubah");
                                    } else if (id == id2 && pin == pass.getPass2()) {
                                        System.out.println("PIN Baru =");
                                        pin2 = sc.nextInt();
                                        System.out.println("PIN berhasil diubah");
                                    } else if (id == id3 && pin == pass.getPass3()) {
                                        System.out.println("PIN Baru =");
                                        pin2 = sc.nextInt();
                                        System.out.println("PIN berhasil diubah");
                                    } else {
                                        System.out.println("PIN Salah!");
                                    }
                                    
                                    break;
                                case 5:
                                    if (beli.getFront() != null && beli.getRear() != null) {
                                        jual.sambungTransaksi(beli.getFront(), beli.getRear());
                                    }
                                    System.out.println("Selamat datang kembali..");
                                    System.out.println("");
                                    break;
                            }
                        } while (pilih2 != 5);
                    }
                    break;
                case 3:
                    //Admin
                    System.out.println("Akun Admin");
//                    jual.lihatTransaksi();
                    //memproses setiap transaksi yang belum diproses
                    Transaksi t = jual.getFront();
                    do {
                        jual.lihatProsesTransaksi();
                        if (t.getStatus() == 0) {
                            System.out.println("Kode : " + t.getKode());
                            System.out.println("Pembeli : " + t.getPembeli());
                            System.out.println("Barang : " + t.getBarang().getNama());
                            System.out.println("Jumlah : " + t.getJumlah());
                            System.out.println("-Pilih Aksi-");
                            System.out.println("1. Diproses");
                            System.out.println("2. Selesai");
                            System.out.print("Pilih = ");

                            int aksi = sc.nextInt();
                            if (aksi == 1) {
                                jual.prosesTransaksi(t);
                                System.out.println("Berasil diproses..");
                            } else {
                                break;
                            }
                        }
                        t = t.next;
                    } while (t != null);
                    System.out.println("");
                    break;
                case 4:
                    //Pemilik
                    System.out.println("Transaksi Diproses : " + jual.lihatDiproses());
                    System.out.println("Pemasukan : " + jual.lihatPemasukan());

                    do {
                        System.out.println("Akun Pemilik");
                        System.out.println("1. Ubah Harga");
                        System.out.println("2. Daftar Laporan");
                        System.out.println("3. Daftar Laporan Member");
                        System.out.println("4. Grafik Penjualan");
                        System.out.println("5. Kembali");
                        System.out.print("Pilih = ");
                        pilih4 = sc.nextInt();
                        switch (pilih4) {
                            case 1:
                                sc.nextLine(); // Membersihkan newline character dari input sebelumnya
                                System.out.print("Nama Barang yang akan diubah harganya: ");
                                String namaBarang = sc.nextLine();
                                System.out.print("Harga Baru: ");
                                int hargaBaru = sc.nextInt();

                                jual.ubahHargaBarang(namaBarang, hargaBaru);
                                System.out.println("");
                                break;
                            case 2:
                                jual.lihatTransaksi();
                                jual.laporanPenjualanHarian();
                                System.out.println("");
                                break;
                            case 3:
                                jual.totalBiayaBelanjaMember();
                                System.out.println("");
                                break;
                            case 4:
                                System.out.println("Transaksi Diproses: " + jual.lihatDiproses());
                                System.out.println("Pemasukan: " + jual.lihatPemasukan());
                                jual.lihatGrafikPenjualan();
                                System.out.println("");
                                break;
                            case 5:
                                System.out.println("Selamat Tinggal Pemilik..\n");
                                break;
                        }

                    } while (pilih4 != 5);
                    break;
                case 5:
                    System.out.println("Terima kasih...");
                    break;
            }
        } while (pilih != 5);
    }
}
