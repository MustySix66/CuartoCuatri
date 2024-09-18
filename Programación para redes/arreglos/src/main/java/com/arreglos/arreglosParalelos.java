package com.arreglos;

import java.util.Scanner;

public class arreglosParalelos {
    private Scanner teclado;
    private String[] nombres;
    private int[] edades;

    private void cargar(){
        teclado = new Scanner(System.in);
        nombres = new String[5];
        edades = new int[5];

        for (int i = 0; i < nombres.length; i++) {
            System.out.println("Ingresa el nombre: ");
            nombres[i]=teclado.next();
            System.out.println("Ingresa la edad: ");
            edades[i]=teclado.nextInt();
        }
    }

    private void mostrar(){
        for (int i = 0; i < nombres.length; i++) {
            System.out.println("nombre: "+ nombres[i] + " edad: " + edades[i]);
        }
    }

    private void mayores(){
        for (int i = 0; i < nombres.length; i++) {
            if (edades[i]>=18) {
                System.out.println(nombres[i] + " es mayor de edad.");
            }
        }
    }

    private void personaMayor(){
        int mayor = 0;
        int indice = 0;
        for (int i = 0; i < nombres.length; i++) {
            if (edades[i]>mayor) {
                mayor = edades[i];
                indice = i;
            }
        }
        System.out.println("el mayor es "+nombres[indice]);
    }

    private void personaMenor(){
        int menor = 0;
        int indice = 0;
        for (int i = 0; i < nombres.length; i++) {
            if (edades[i]<menor) {
                menor = edades[i];
                indice = i;
            }
        }
        System.out.println("el menor es "+nombres[indice]);
    }

    private void ordenar(){
        for (int i = 0; i < nombres.length-1; i++) {
            for (int j = 0; j < nombres.length-1-i; j++) {
                if (edades[j] > edades[j+1]) {
                    int aux = edades[j];
                    String auxNombre = nombres[j];
                    edades[j] = edades[j+1];
                    nombres[j] = nombres[j+1];
                    edades[j+1] = aux;
                    nombres[j+1] = auxNombre;
                }
            }
        }
    }

    public static void main(String[] args) {
        arreglosParalelos aParalelos = new arreglosParalelos();
        aParalelos.cargar();
        aParalelos.mostrar();
        aParalelos.mayores();
        aParalelos.personaMayor();
        aParalelos.personaMenor();
        aParalelos.ordenar();
        aParalelos.mostrar();
    }
}
