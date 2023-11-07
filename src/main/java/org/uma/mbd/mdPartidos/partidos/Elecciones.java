package org.uma.mbd.mdPartidos.partidos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Elecciones {
    private List<Partido> partidos;


    static private Partido stringToPartido(String dato){
        try(Scanner sc = new Scanner(dato);){
            sc.useDelimiter(",");
            String nombrePartido = sc.next();
            int nVotos = sc.nextInt();
            return new Partido(nombrePartido,nVotos);
        } // faltan excepciones
    }

    public void leeDatos(String [] datos){
        partidos = new ArrayList<>();
        //partidos.stream().
    }
}
