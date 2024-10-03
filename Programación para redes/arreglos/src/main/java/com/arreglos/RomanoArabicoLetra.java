package com.arreglos;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class RomanoArabicoLetra {
    private static final Map<Character, Integer> romanoANumArabicoMap = new HashMap<>();
    private static final String[] unidades = {"", "uno", "dos", "tres", "cuatro", "cinco", "seis", "siete", "ocho", "nueve"};
    private static final String[] decenas = {"", "diez", "veinte", "treinta", "cuarenta", "cincuenta", "sesenta", "setenta", "ochenta", "noventa"};
    private static final String[] teens = {"diez", "once", "doce", "trece", "catorce", "quince", "dieciséis", "diecisiete", "dieciocho", "diecinueve"};
    private static final String[] centenas = {"", "cien", "doscientos", "trescientos", "cuatrocientos", "quinientos", "seiscientos", "setecientos", "ochocientos", "novecientos"};

    static {
        romanoANumArabicoMap.put('I', 1);
        romanoANumArabicoMap.put('V', 5);
        romanoANumArabicoMap.put('X', 10);
        romanoANumArabicoMap.put('L', 50);
        romanoANumArabicoMap.put('C', 100);
        romanoANumArabicoMap.put('D', 500);
        romanoANumArabicoMap.put('M', 1000);
    }

    public static int romanoAArabico(String roman) {
        int res = 0;
        for (int i = 0; i < roman.length(); i++) {
            int esteNum = romanoANumArabicoMap.get(roman.charAt(i));
            int ElOtroNum = (i + 1 < roman.length()) ? romanoANumArabicoMap.get(roman.charAt(i + 1)) : 0;
            if (esteNum < ElOtroNum) {
                res -= esteNum;
            } else {
                res += esteNum;
            }
        }
        return res;
    }

    public static String numberoAPalabra(int num) {
        if (num < 10) {
            return unidades[num];
        } else if (num < 20) {
            return teens[num - 10];
        } else if (num < 100) {
            return decenas[num / 10] + ((num % 10 != 0) ? " y " + unidades[num % 10] : "");
        } else if (num < 1000) {
            return centenas[num / 100] + ((num % 100 != 0) ? " " + numberoAPalabra(num % 100) : "");
        } else if (num < 4000) { 
            int miles = num / 1000;
            return (miles == 1 ? "mil" : unidades[miles] + " mil") + ((num % 1000 != 0) ? " " + numberoAPalabra(num % 1000) : "");
        } else {
            return "fuera de rango";
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Escribe el numerito en romano");
        String romano = scanner.nextLine().toUpperCase();
        int arabico = romanoAArabico(romano);
        String palabra = numberoAPalabra(arabico);

        System.out.println("Número romano: " + romano);
        System.out.println("Número arábigo: " + arabico);
        System.out.println("En palabras: " + palabra);
        scanner.close();
    }
}