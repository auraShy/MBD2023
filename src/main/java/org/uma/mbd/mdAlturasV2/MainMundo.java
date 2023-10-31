package org.uma.mbd.mdAlturasV2;

import org.uma.mbd.mdAlturasV2.alturas.MenoresQue;
import org.uma.mbd.mdAlturasV2.alturas.EnContinente;
import org.uma.mbd.mdAlturasV2.alturas.Mundo;
import org.uma.mbd.mdAlturasV2.alturas.Pais;

import java.io.IOException;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class MainMundo {
    public static void main(String args[]) throws IOException {
        Mundo paises = new Mundo();
        paises.leePaises("recursos/mdAlturas/alturas.txt");

        //APARTADO A
        Comparator<Pais> ordenAltura = Comparator.comparingDouble(Pais::altura);
        Set<Pais> paisesOrdenAlt = new TreeSet<>(ordenAltura);
        //paisesOrdenAlt.addAll(paises.getPaises());
        //paisesOrdenAlt.forEach(System.out::println);

        //APARTADO B
        Comparator<Pais> ordenAlfabetico = Comparator.comparing(Pais::nombre);
        Set<Pais> paisesOrdenAlf = new TreeSet<>(ordenAlfabetico);
        //paisesOrdenAlf.addAll(paises.getPaises());
        //paisesOrdenAlf.forEach(System.out::println);

        //APARTADO C
        Comparator<Pais> ordenContinente = Comparator.comparing(Pais::continente);
        Comparator<Pais> ordenContAlf = ordenContinente.thenComparing(ordenAlfabetico);
        Set<Pais> paisesContAlf = new TreeSet<>(ordenContAlf);
        //paisesContAlf.addAll(paises.getPaises());
        //paisesContAlf.forEach(System.out::println);

        //APARTADO D
        Comparator<Pais> ordenContAlfRever = ordenContinente.thenComparing(ordenAlfabetico.reversed());
        Set<Pais> paisesContAlfRever = new TreeSet<>(ordenContAlfRever);
        //paisesContAlfRever.addAll(paises.getPaises());
        //paisesContAlfRev.forEach(System.out::println);

        //APARTADO E
        Comparator<Pais> ordenContNat = ordenContinente.thenComparing(Comparator.naturalOrder());
        Set<Pais> paisesContNat = new TreeSet<>(ordenContNat);
        //paisesContNat.addAll(paises.getPaises());
        //paisesContNat.forEach(System.out::println);

        for (Pais pais : paises.selecciona(new MenoresQue(1.70))) {
            paisesOrdenAlt.add(pais);
            paisesOrdenAlf.add(pais);
            paisesContAlf.add(pais);
            paisesContAlfRever.add(pais);
            paisesContNat.add(pais);
        }
        System.out.println("***********ORDEN POR ALTURA DE MENOR A MAYOR***********");
        paisesOrdenAlt.forEach(System.out::println);
        System.out.println("***********ORDEN ALFABETICO DE LOS PAISES***********");
        paisesOrdenAlf.forEach(System.out::println);
        System.out.println("***********ORDEN POR CONTINENTE Y A IGUALDAD, ALFABETICAMENTE***********");
        paisesContAlf.forEach(System.out::println);
        System.out.println("***********ORDEN POR CONTINENTE Y A IGUALDAD, ALFABETICAMENTE INVERSO***********");
        paisesContAlfRever.forEach(System.out::println);
        System.out.println("***********ORDEN POR CONTINENTE Y A IGUALDAD, ORDEN NATURAL***********");
        paisesContNat.forEach(System.out::println);





    }
}
