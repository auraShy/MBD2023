package org.uma.mbd.mdPartidos.partidos;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class DHont extends DHontSimple implements CriterioSeleccion{
    private double mp;

    public DHont(double mp){
        super();
        if (mp<0 || mp>=15)
            throw new EleccionesException("El minimo porcentaje admisible debe estar entre 0-15%");
        this.mp = mp;
    }

    /*private  Map<Partido,Integer> filtraPartidos(List<Partido> partidos, int numEsc){
        int votosTotales = partidos.stream()
                .mapToInt(Partido::getVotos)
                .sum();
            List<Partido> partidosValidos = partidos.stream()
                .filter(partido -> ((double)partido.getVotos()/(double)votosTotales)*100 > mp)
                .toList();
        return super.ejecuta(partidosValidos,numEsc);
    }*/

    public Map<Partido, Integer> ejecuta(List<Partido> partidos, int numEsc) {
        int votosTotales = partidos.stream()
                .mapToInt(Partido::getVotos)
                .sum();
        List<Partido> partidosFiltrados = partidos.stream()
                .filter(p -> ((double)p.getVotos()/votosTotales)*100 > mp)
                .toList();
        return super.ejecuta(partidosFiltrados, numEsc);
    }
}
