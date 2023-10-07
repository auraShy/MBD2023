package org.uma.mbd.mdNPI;

import org.uma.mbd.mdNPI.npi.Npi;

public class MainNPI {
    public static void main(String[] args) {
        Npi cpi = new Npi();

        System.out.println("\033[34m **** SIMULADOR DE CALCULADORA CON NOTACION POLACA INVERSA **** \u001B[0m");
        // Resolver la expresión: 3 * (6 - 2) + (2 + 7) / 5 -> en NPI: 3 6 2 - * 5 2 7 + / +
        System.out.println("\033[33m Resolucion de 3 6 2 - * 5 2 7 + / + \u001B[0m");
        cpi.entra(3);
        System.out.println(cpi);
        cpi.entra(6);
        System.out.println(cpi);
        cpi.entra(2);
        System.out.println(cpi);
        cpi.resta();
        System.out.println(cpi);
        cpi.multiplica();
        System.out.println(cpi);
        cpi.entra(5);
        System.out.println(cpi);
        cpi.entra(2);
        System.out.println(cpi);
        cpi.entra(7);
        System.out.println(cpi);
        cpi.suma();
        System.out.println(cpi);
        cpi.divide();
        System.out.println(cpi);
        cpi.suma();
        System.out.println(cpi);
        System.out.println("\033[32m Resultado = " + cpi.getResultado() + "\u001B[0m");
    }
}
