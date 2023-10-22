package org.uma.mbd.mdGenetico;

import org.uma.mbd.mdGenetico.genetico.Cromosoma;

public class Main {
    public static void main(String[] args) {
        Cromosoma c1 = new Cromosoma(5,true);
        Cromosoma c2 = new Cromosoma(c1);

        System.out.println("Hashcode datos c1: " + c1.hashCode());
        System.out.println("Hashcode datos c2: " + c2.hashCode());

    }



}
