package com.example.filehandling11;

import java.util.ArrayList;

public class WrapperClass {
    public static void main(String[] args) {
        //1. Membuat ArrayList String (Input)
        ArrayList<String> ListString = new ArrayList<>();

        //Manambah List (autoboxing)
        ListString.add("10");
        ListString.add("20");
        ListString.add("30");

        //2. Membuat ArrayList Integer (Target)
        ArrayList<Integer> ListInteger = new ArrayList<>();

        //3. Proses Konversi menggunakan perulangan
        for (String s : ListString) {
            // Menggunakan valueOf karena targetnya adalah objek Integer
            Integer angka = Integer.valueOf(s);
            ListInteger.add(angka);
        }

        //4. Jika Menggunalam parseInt untuk Operasi Matematika
        // Misalkan kita ingin menjumlahkan elemen pertema dan kedua dari ListString megmabil List (auto-unboxing)
        int angka1 = Integer.parseInt(ListString.get(0));// Integer otomatis jadi int
        int angka2 = Integer.parseInt(ListString.get(1));
        int angka3 = Integer.parseInt(ListString.get(2));
        int total = angka1 + angka2 + angka3;

        //5. Menampilkan Hasil
        System.out.println("--- Hasil Konversi ke ArrayList ---");
        System.out.println(" Hasil konversi: " + ListInteger);

        System.out.println("\n--- Hasil Operasi Matematika ---");
        System.out.println("Hasil " + angka1 + " + " + angka2 + " + " + angka3 + " = " + total);
    }
}
