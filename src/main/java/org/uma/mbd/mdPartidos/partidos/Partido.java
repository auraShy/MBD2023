package org.uma.mbd.mdPartidos.partidos;

import org.uma.mbd.mdBusV1L.buses.Bus;

import java.util.Objects;

public class Partido {
    private String nombre;
    private int votos;

    public Partido(String nombre, int votos){
        this.nombre = nombre;
        this.votos = votos;
    }

    public int getVotos() {
        return votos;
    }

    public String getNombre(){
        return nombre;
    }

    @Override
    public boolean equals(Object o) {
        return (o instanceof Partido p)
                && (p.nombre.equalsIgnoreCase(nombre));
    }

    @Override
    public int hashCode(){
        return Objects.hash(nombre.toLowerCase());
    }

    @Override
    public String toString(){
        return nombre + " : " + votos;
    }
}
