package com.arreglos;

public class Main {
    public static void main(String[] args) {
        SumaNumeros();
        Promedio();
        MaxMin();
        Inversion();
        Palindromo();
        prueba();
        NumPares();
        SumNumPares();
    }

    //TODO: Practicas del maestro
    private static void prueba(){
        int [] numeros= new int[4];
        numeros[1] = 15;
        System.out.println(numeros[0]);
        boolean [] boleanos= {true, false, true, false};
        boleanos[2]=true;
        for (int i = 0; i < numeros.length; i++) {
            System.out.println("en el valor de "+ (i+1)+" está: "+ numeros[i]);
        }
    }

    private static void NumPares(){
        int [] pares = new int[51];
        int index = 0;
        for (int i = 0; i < 101; i++) {
            if (i%2 == 0) {
                pares[index] = i;
                index++;
            }
        }
        for (int i = 0; i < pares.length; i++) {
            System.out.println(pares[i]);
        }
    }

    private static void SumNumPares(){
        int [] pares = new int[51];
        int index = 0;
        int suma =0;
        for (int i = 0; i < 101; i++) {
            if (i%2 == 0) {
                pares[index] = i;
                index++;
            }
        }
        for (int i = 0; i < pares.length; i++) {
            suma = suma + pares[i];
        }
        System.out.println(suma);
    }

    //TODO: Tarea (de aqui pa abajo)
    private static void SumaNumeros(){
        System.out.println("/n Suma de Numeros");
        int[] numeros = {1, 2, 3, 4, 5};
        int suma = 0;
        for (int i = 0; i < numeros.length; i++) {
            suma += numeros[i];
        }
        System.out.println("La suma del arreglo es: " + suma);
    }

    private static void Promedio(){
        System.out.println("/n Promedios");
        int[] numeros = {10, 8, 10, 8, 9};
        int suma = 0;

        for (int i = 0; i < numeros.length; i++) {
            suma += numeros[i];
        }

        int division = suma / numeros.length;

        System.out.println("El promedio del arreglo es: " + division);
    }

    private static void MaxMin(){
        System.out.println("/n Maximos y minimos");
        int[] numeros = {3, 5, 7, 2, 8, -1, 4, 10, 12}; // Ejemplo de arreglo
        int max = numeros[0];
        int min = numeros[0];

        for (int i = 1; i < numeros.length; i++) {
            if (numeros[i] > max) {
                max = numeros[i];
            }
            if (numeros[i] < min) {
                min = numeros[i];
            }
        }

        System.out.println("El valor máximo del arreglo es: " + max);
        System.out.println("El valor mínimo del arreglo es: " + min);
    }

    private static void Inversion(){
        System.out.println("/n Inversion");
        int[] original = {1,2,3,4,5,7,9,11,13,15}; 
        int[] invertido = new int[original.length];

        for (int i = 0; i < original.length; i++) {
            invertido[i] = original[original.length - 1 - i];
        }

        // Imprimir el arreglo invertido
        for (int i = 0; i < invertido.length; i++) {
            System.out.print(invertido[i] + " ");
        }
    }

    private static void Palindromo(){
        System.out.println("/n Palindromo");
        char[] arreglo = {'a', 'n', 'i', 't', 'a', 'l', 'a', 'v', 'a', 'l', 'a', 't', 'i', 'n', 'a'};
        boolean esPalindromo = true;

        for (int i = 0; i < arreglo.length / 2; i++) {
            if (arreglo[i] != arreglo[arreglo.length - 1 - i]) {
                esPalindromo = false;
                break;
            }
        }

        if (esPalindromo) {
            System.out.println("El arreglo es un palíndromo.");
        } else {
            System.out.println("El arreglo no es un palíndromo.");
        }
    }
}


// a rico