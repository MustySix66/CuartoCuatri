package com.arreglos;

import java.util.Scanner;

public class matriz {
    private Scanner teclado;
    private int[][] matriz;

    private void cargar(){
        teclado=new Scanner(System.in);
        matriz = new int[2][3];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.println("Ingresa un valor ");
                matriz[i][j]=teclado.nextInt();
            }
        }
    }

    private void imprimir(){
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(matriz[i][j]+ " ");
            }
            System.out.println();
        }
    }
    
    public static void main(String[] args) {
        matriz mz = new matriz();
        mz.cargar();
        mz.imprimir();
    }
}
