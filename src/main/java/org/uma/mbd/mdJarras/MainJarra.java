package org.uma.mbd.mdJarras;
import org.uma.mbd.mdJarras.jarras.Jarra;

public class MainJarra {
    public static void main(String[] args) {
        Jarra j1 = new Jarra(7);
        Jarra j2 = new Jarra(5);

        j1.vacia();
        j2.vacia();

        System.out.println("Conseguir 1L en una jarra (8 pasos): ");
        j2.llena();
        j1.llenaDesde(j2);
        j2.llena();
        j1.llenaDesde(j2);
        j1.vacia();
        j1.llenaDesde(j2);
        j2.llena();
        j1.llenaDesde(j2);

        System.out.println("j1->" + j1);
        System.out.println("j2->" + j2);


    }
}
