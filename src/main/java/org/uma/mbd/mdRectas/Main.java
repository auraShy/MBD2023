package org.uma.mbd.mdRectas;

import org.uma.mbd.mdRectas.rectas.Punto;
import org.uma.mbd.mdRectas.rectas.Vector;

public class Main {
    public static void main(String[] args) {
        Vector v1 = new Vector(5,6);
        System.out.println(v1);
        Vector v2 = new Vector(new Punto(2,3));
        System.out.println(v2);
        Vector v3 = new Vector(new Punto(1,2),new Punto(3,3));
        System.out.println(v3);

        System.out.println(v3.paraleloA(new Vector(9,9)));
        System.out.println(v1.extremoDesde(new Punto(1,1)));
        System.out.println(v3.ortogonal());
    }
}
