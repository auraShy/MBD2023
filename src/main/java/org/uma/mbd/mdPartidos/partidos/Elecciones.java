package org.uma.mbd.mdPartidos.partidos;

import java.io.FileNotFoundException;
import java.io.IOException;

import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class Elecciones {
    private List<Partido> partidos;


    static private Partido stringToPartido(String dato){
        try(Scanner sc = new Scanner(dato)){
            sc.useDelimiter(",+");
            String nombrePartido = sc.next();
            int nVotos = sc.nextInt();
            return new Partido(nombrePartido,nVotos);
        } catch(InputMismatchException e) {
            throw new EleccionesException("El número de votos no es un numero en: " + dato);
        } catch(NoSuchElementException e) {
            throw new EleccionesException("Faltan datos en: " + dato);
        }
    }

    public void leeDatos(String [] datos){
        partidos = new ArrayList<>();
        List<Partido> datosPart = Arrays.stream(datos)
                .map(Elecciones::stringToPartido)
                .toList();
        partidos.addAll(datosPart);
    }

    public void leeDatos(String nombreFichero) throws IOException {
        partidos = new ArrayList<>();
        Path fichero = Path.of(nombreFichero);
        for(String linea : Files.readAllLines(fichero)){
            partidos.add(stringToPartido(linea));
        }
    }

    public Map<Partido,Integer> generaResultados (CriterioSeleccion cs, int numEsc){
        return cs.ejecuta(partidos,numEsc);
    }

    public void presentaResultados(String nombreFichero, Map<Partido,Integer> map) throws FileNotFoundException{
        try(PrintWriter pw = new PrintWriter(nombreFichero)){
            presentaResultados(pw,map);
        }

    }

    public void presentaResultados(PrintWriter pw, Map<Partido,Integer> map){
        for (Partido partido : partidos){
            pw.printf("%s : %d, ", partido.getNombre(),partido.getVotos());
            if(!map.containsKey(partido))
                pw.println("Sin representacion");
            else
                pw.println(map.get(partido));
        }
    }
}
