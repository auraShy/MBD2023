package org.uma.mbd.mdJarras;

import org.uma.mbd.mdJarras.jarras.Mesa;

public class MainMesa {
    public static void main(String[] args) {
        Mesa mesa = new Mesa(7,5);

        System.out.println("Conseguir 1L en una jarra (8 pasos): ");
        mesa.llenaB();
        mesa.vuelcaBSobreA();
        mesa.llenaB();
        mesa.vuelcaBSobreA();
        mesa.vaciaA();
        mesa.vuelcaBSobreA();
        mesa.llenaB();
        mesa.vuelcaBSobreA();


        System.out.println(mesa);
    }
}
