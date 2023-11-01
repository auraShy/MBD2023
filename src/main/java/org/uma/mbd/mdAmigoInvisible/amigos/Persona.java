package org.uma.mbd.mdAmigoInvisible.amigos;

import java.util.Objects;

public class Persona implements Comparable<Persona>{
    private String nombre;
    private Persona amigo;

    public Persona(String nombre){
        this.nombre = nombre;
    }

    public void setAmigo(Persona amigo){
        this.amigo = amigo;
    }

    public String getNombre() {
        return nombre;
    }

    public Persona getAmigo() {
        return amigo;
    }

    @Override
    public boolean equals(Object o) {
        return (o instanceof Persona p)
                && (nombre.equalsIgnoreCase(p.nombre));
    }

    @Override
    public int hashCode(){
        return Objects.hash(nombre.toLowerCase());
    }

    @Override
    public String toString(){
        if (amigo == null)
            return nombre + " --> sin amigo";
        return nombre + " --> " + amigo.nombre;
    }


    public int compareTo(Persona p) {
        int resultado = this.nombre.compareToIgnoreCase(p.nombre);
        return resultado;
    }
}
