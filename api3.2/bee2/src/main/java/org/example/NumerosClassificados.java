package org.example;
import java.util.Scanner;

public class NumerosClassificados {
    private int numerosPares = 0;
    private int numerosImpares = 0;
    private int numerosPositivos = 0;
    private int numerosNegativos = 0;

    public void classificarNumeros() {
        Scanner leitor = new Scanner(System.in);

        for (int i = 1; i <= 5; i++) {
            double numero = leitor.nextDouble();
            classificarNumero(numero);
        }

        leitor.close();

        mostrarResultados();
    }

    private void classificarNumero(double numero) {
        if (numero % 2 == 0) {
            numerosPares++;
        } else {
            numerosImpares++;
        }

        if (numero > 0) {
            numerosPositivos++;
        } else if (numero < 0) {
            numerosNegativos++;
        }
    }

    private void mostrarResultados() {
        System.out.println(numerosPares + " valor(es) par(es)");
        System.out.println(numerosImpares + " valor(es) impar(es)");
        System.out.println(numerosPositivos + " valor(es) positivo(s)");
        System.out.println(numerosNegativos + " valor(es) negativo(s)");
    }
}
