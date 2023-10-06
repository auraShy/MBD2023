package org.uma.mbd.mdNPI;

import org.uma.mbd.mdNPI.npi.Npi;

public class MainNPI {
    public static void main(String[] args) {
        Npi npiA = new Npi();
        Npi npiB = new Npi();

        // Resolver la expresión: 3 * (6 - 2) + 5 -> en NPI: 3 6 2 - * 5 +
        npiA.entra(3);
        npiA.entra(6);
        npiA.entra(2);
        npiA.resta();
        npiA.multiplica();
        npiA.entra(5);
        npiA.suma();
        System.out.println("3 * (6 - 2) + 5 -> en NPI: 3 6 2 - * 5 + = " + npiA.getResultado());

        // Resolver la expresión: 3 * (6 - 2) + (2 + 7) / 5 -> en NPI: 3 6 2 - * 5 2 7 + / +
        npiB.entra(3);
        npiB.entra(6);
        npiB.entra(2);
        npiB.resta();
        npiB.multiplica();
        npiB.entra(5);
        npiB.entra(2);
        npiB.entra(7);
        npiB.suma();
        npiB.divide();
        npiB.suma();
        System.out.println("3 * (6 - 2) + (2 + 7) / 5 -> en NPI: 3 6 2 - * 5 2 7 + / + = " + npiB.getResultado());
    }
}
