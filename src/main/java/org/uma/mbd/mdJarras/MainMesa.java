package org.uma.mbd.mdJarras;

import org.uma.mbd.mdJarras.jarras.Mesa;

public class MainMesa {
    public static void main(String[] args) {

        //Se crea un objeto mesa con una jarra de 7L y otra de 6L
        Mesa mesa = new Mesa(7,5);

        //Operaciones necesarias para que en una de las jarras quede 1 litro
        System.out.println("\033[34m **** Conseguir 1L en una jarra **** \u001B[0m");
        System.out.println("Estado inicial de las jarras:  " + mesa);
        mesa.llenaB();
        System.out.println("PASO 1:                        " + mesa);
        mesa.vuelcaBSobreA();
        System.out.println("PASO 2:                        " + mesa);
        mesa.llenaB();
        System.out.println("PASO 3:                        " + mesa);
        mesa.vuelcaBSobreA();
        System.out.println("PASO 4:                        " + mesa);
        mesa.vaciaA();
        System.out.println("PASO 5:                        " + mesa);
        mesa.vuelcaBSobreA();
        System.out.println("PASO 6:                        " + mesa);
        mesa.llenaB();
        System.out.println("PASO 7:                        " + mesa);
        mesa.vuelcaBSobreA();
        System.out.println("PASO FINAL:                    " + "\033[32m" + mesa + "\u001B[0m");

    }
}
