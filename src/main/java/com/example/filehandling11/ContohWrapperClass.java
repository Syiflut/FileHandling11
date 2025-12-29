package com.example.filehandling11;

public class ContohWrapperClass {
    public static void main(String[] args) {
        //1. BOXING-primitif ke objek(manual)
        int nilaiPrimitif = 100;
        Integer nilaiObjek = Integer.valueOf(nilaiPrimitif);
        System.out.println("Nilai objek: " +nilaiObjek);

        //2. AUTOBOXING - Otomatis oleh java
        Integer otomatis = 200;// java otomatis boxing

        // 3. UNBOXING - Objek ke Primitif (Manual)
        int kembaliPrimitif = nilaiObjek.intValue();

        //4. AUTO-UNBOXING - otomatis
        int otomatisUnbox = otomatis; // java otomatis unboxing

        // 5. Parsing String ke number
        String angkaString = "12345";
        int angkaInt = Integer.parseInt(angkaString);
        System.out.println("String '12345' jadi int: " +angkaInt);

        //6. Number ke String
        Integer nilai=999;
        String nilaiString = nilai.toString();
        System.out.println("Int 999 jadi Stirng: " + nilaiString);

        // Method Utility
        System.out.println("Nilai Maksimal int: " + Integer.MAX_VALUE);
        System.out.println("Nilai minimal Int: " + Integer.MIN_VALUE);

        //8. Perbandingan
        Integer a = 100;
        Integer b = 100;
        System.out.println("Apakah sama? " +a.equals(b));

        //9. Konversi basis angka
        String binary = Integer.toBinaryString(10);
        System.out.println("10 Dalam Biner : " +binary);
    }
}
