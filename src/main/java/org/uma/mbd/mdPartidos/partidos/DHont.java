package org.uma.mbd.mdPartidos.partidos;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class DHont extends DHontSimple{
    private double mp;

    public DHont(double mp){
        if (mp<=0 || mp>=15)
            throw new EleccionesException("El minimo porcentaje admisible debe estar entre 0-15%");
        this.mp = mp;
    }

    private  Map<Partido,Integer> filtraPartidos(List<Partido> partidos, int numEsc){
        int votosTotales = partidos.stream()
                .mapToInt(Partido::getVotos)
                .sum();
            List<Partido> partidosValidos = partidos.stream()
                .filter(partido -> ((double)partido.getVotos()/(double)votosTotales)*100 > mp)
                .toList();
        return super.ejecuta(partidosValidos,numEsc);
    }
}
