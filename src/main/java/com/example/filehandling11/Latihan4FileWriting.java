package com.example.filehandling11;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Latihan4FileWriting {
    public static void main(String[] args) {
        //Tentukan pesan aktivitas yang ingin dicatat
        String pesanAktivitas = "User melakukan Login ke sistem";

        //Menggunakan Try-with-Resource agar file otomatis tertutup
        //Parameter 'true' pada FileWriter mengaktifkan Append Mode
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Log.txt" , true))) {

            //1. Mendapatkan waktu saat ini dengan fromat rapi
            LocalDateTime waktuSekarang = LocalDateTime.now();
            DateTimeFormatter formatWaktu = DateTimeFormatter.ofPattern("yyyy-mm-dd HH:mm:ss");
            String waktuFormatted = waktuSekarang.format(formatWaktu);

            //2. Gabungkan waktu dan pesan sesuai format: [waktu] Pesan
            String barisLog = "[" + waktuFormatted + "] " + pesanAktivitas;

            //3. Tulis ke file dan tambahan baris baru
            writer.write(barisLog);
            writer.newLine();

            System.out.println("Aktivitas berhasi dicatat ke log.txt! ");
        } catch (IOException e) {
            System.out.println("Terjadi kesalahan saat menulis log: " + e.getMessage());
        }
    }
}
