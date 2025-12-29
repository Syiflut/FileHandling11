package com.example.filehandling11;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

//1. Penggunaan ENUM untuk status Buku
enum StatusBuku {
    TERSEDIA, DIPINJAM
}

class Buku {
    String judul;
    String pengarang;
    int tahun; // Akan diolah dengan Wrapper Class
    StatusBuku status;

    Buku(String judul, String pengarang, int tahun, StatusBuku status) {
        this.judul = judul;
        this.pengarang = pengarang;
        this.tahun = tahun;
        this.status = status;
    }

    @Override
    public String toString() {
        return judul + " | " + pengarang + " | " + tahun + " | " + status;
    }
}

public class StudiKasusPBO {
    static final String NAMA_FILE = "perpustakaan.txt";

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int pilihan;

        do {
            System.out.println("\n=== MENU PERPUSTAKAAN ===");
            System.out.println("1. Tambah Buku (Simpan ke File)");
            System.out.println("2. Tampilkan Semua Buku (Baca File)");
            System.out.println("3. Cari Buku");
            System.out.println("4. pinjam buku (update status)");
            System.out.println("0. Keluar");
            System.out.print("Pilih: ");
            pilihan = input.nextInt();
            input.nextLine(); //membersihkan enter

            switch (pilihan) {
                case 1 -> tambahBuku(input);
                case 2 -> tampilkanSemuaBuku();
                case 3 -> cariBuku(input);
                case 4 -> pinjamBuku(input);
            }
        } while (pilihan != 0);
    }
    //Fungsi 1: Menyimpan data ke file (APPEND MODE)
    static void tambahBuku(Scanner input) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(NAMA_FILE, true))) {
            System.out.println("Judul: ");
            String judul = input.nextLine();
            System.out.println("Pengarang: ");
            String pengarang = input.nextLine();
            System.out.println(" Tahun Tertib: ");
            String tahunStr = input.nextLine();

            //Menggunakan Wrapper Class untuk konversi
            Integer tahun = Integer.valueOf(tahunStr);

            //Default status menggunakan Enum
            StatusBuku status = StatusBuku.TERSEDIA;

            writer.write(judul + "," + pengarang + "," + tahun + "," + status);
            writer.newLine(); //membuat baris baru

            System.out.println("Buku '" + judul + "'berhasil disimpan dengan status: " + status);
        } catch (IOException e) {
            System.out.println("Gagal menyimpan: " + e.getMessage());
        }
    }

    static void tampilkanSemuaBuku() {
        System.out.println("\n--- DATA PERPUSTAKAAN ---");
        System.out.printf("%-20s | %-15s | %-6s | %-10s\n", "JUDUL", "PENGARANG", "TAHUN", "STATUS");
        System.out.println("------------------------------------------------------------");

        try (BufferedReader reader = new BufferedReader(new FileReader(NAMA_FILE))) {
            String baris;
            while ((baris = reader.readLine()) != null) {
                // Pecah string berdasarkan koma
                String[] data = baris.split(",");
                if (data.length == 4) {
                    // Menampilkan data dengan rapi
                    System.out.printf("%-20s | %-15s | %-6s | %-10s\n", data[0], data[1], data[2], data[3]);
                }
            }
        } catch (IOException e) {
            System.out.println("Belum ada data buku.");
        }
    }

    //FUNGSI 3 : Mencari buku berdasarkan judul
    static void cariBuku(Scanner input) {
        System.out.println("Masukkan judul yang dicari: ");
        String cari = input.nextLine();
        boolean ditemukan = false;

        try (BufferedReader reader = new BufferedReader(new FileReader(NAMA_FILE))) {
            String baris;
            while ((baris = reader.readLine()) != null) {
                if (baris.toLowerCase().contains(cari.toLowerCase())) {
                    System.out.println("Ditemukan -> " + baris);
                    ditemukan = true;
                }
            }
            if (!ditemukan) System.out.println("Buku tidak ditemukan.");
        } catch (IOException e) {
            System.out.println("Gagal membaca File.");
        }
    }

    //FUNGSI 4 : Peminjaman buku
    static void pinjamBuku(Scanner input) {
        ArrayList<String> semuaData = new ArrayList<>();
        System.out.println("Masukkan judul buku yang ingin dipinjam: ");
        String cari = input.nextLine();
        boolean berhasilUpdate = false;

        // Tahap 1: Baca semua data ke List
        try (BufferedReader reader = new BufferedReader(new FileReader(NAMA_FILE))) {
            String baris;
            while ((baris = reader.readLine()) != null) {
                String[] data = baris.split(",");
                // jika jduul cocok dan status masih TERSEDIA
                if (data[0].equalsIgnoreCase(cari) && data[3].equals("TERSEDIA")) {
                    //ubah status menggunakan enum DIPINJAM
                    baris = data[0] + "," + data[1] + "," + data[2] + "," + StatusBuku.DIPINJAM;
                    berhasilUpdate = true;
                }
                semuaData.add(baris);
            }
        } catch (IOException e) {
            System.out.println("Gagal membaca data");
        }

        //tahap 2: tulis ulang ke file (Overwrite - tanpa parameter 'true')
        if (berhasilUpdate) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(NAMA_FILE))) {
                for (String b : semuaData) {
                    writer.write(b);
                    writer.newLine();
                }
                System.out.println(" Berhasil! Status buku '" + cari + "' sekarang Dipinjam ");
            } catch (IOException e) {
                System.out.println("Gagal memperbarui file.");
            }
        } else {
            System.out.println(" buku tidak ditemukan atau sudah di pinjam.");
        }
    }
}