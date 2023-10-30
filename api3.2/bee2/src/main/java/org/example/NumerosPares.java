package org.example;

import java.util.Scanner;

public class NumerosPares {
    private Integer X = 0;

    public void lerPares() {
        Scanner leitor = new Scanner(System.in);
        X = leitor.nextInt();

        for (int i = X; i <= X + 11; i++) {
            mostrarPares(i);
        }
    }
    public void mostrarPares(Integer numero){
        if (numero % 2 == 0) {
            System.out.println(numero);
        }
    }
}
