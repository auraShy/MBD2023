package org.uma.mbd.mdAlturasV2.alturas;

public record Pais(String nombre, String continente, double altura) implements Comparable<Pais> {

    public int compareTo(Pais o) {
        int resultado = Double.compare(altura,o.altura);
        if (resultado == 0)
            resultado = nombre.compareTo(o.nombre);
        return resultado;
    }
}
