package com.example.filehandling11;

//Definisi Enum level dengan field poinMinimum
enum Level{
    BEGINNER( 0),
    INTERMEDIATE( 100),
    EXPERT( 500);

    //Field untuk menyimpan poin minimum
    private final int poinMinimum;

    //Constructor (Harus private untuk Enum)
    Level(int poinMinimum) {
        this.poinMinimum = poinMinimum;
    }

    //Getter untuk mengabil nilai poinMinimum
    public int getPoinMinimum() {
        return  poinMinimum;
    }
}

public class Latihan2Enum {
    public static void main(String[] args) {
        //Menampilkan semua level beserta poin Minimumnya
        System.out.println("Daftar Level dan Poin Minimum: ");

        for (Level lv : Level.values()) {
            System.out.println("- " + lv.name() + ": " + lv.getPoinMinimum() + " poin");
        }

        //Contoh penggunaan Spesifik
        Level userLevel = Level.INTERMEDIATE;
        System.out.println("\nLevel Anda saat ini: " + userLevel);
        System.out.println("Syarat point: " + userLevel.getPoinMinimum());
    }
}
