package com.example.filehandling11;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Latihan3FileReading {
    public static void main(String[] args) {
        String namaTertinggi = "";
        int nilaiTertinggi = -1; //Mulai dari angka kecil

        //Menggunakan Try-With-Resources agar file otomatis tertutup
        try (BufferedReader reader = new BufferedReader(new FileReader("nilai.txt"))) {
            String baris;

            while ((baris = reader.readLine()) != null) {
                //1. Pisahkan data berdasarkan koma
                String[] data = baris.split(",");
                String nama = data[0];

                //2. Konversi String nilai ke int menggunakan Wrapper Class
                int nilai = Integer.parseInt(data[1].trim());

                //3. Logika mencari yang tertinggi
                if (nilai > nilaiTertinggi) {
                    nilaiTertinggi = nilai;
                    namaTertinggi = nama;
                }

            }
            if (!namaTertinggi.isEmpty()) {
                System.out.println("Mahasiswa dengan nilai tertinggi:");
                System.out.println("Nama : " + namaTertinggi);
                System.out.println("Nilai : " + nilaiTertinggi);
            }
            }catch (IOException e) {
                System.out.println("Error: File tidak ditemukan atau tidak bisa dibaca");
            }catch (NumberFormatException e) {
                System.out.println("Error: Format nilai dalam file tidak valid.");
            }
        }
    }
