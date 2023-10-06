package org.uma.mbd.mdPuntos.puntos;

public class Segmento {
    private Punto origen, extremo;
    public Segmento(double x1, double y1, double x2, double y2) {
        origen = new Punto(x1, y1);
        extremo = new Punto(x2, y2);
    }

    // COPIA PROFUNDA
    public Segmento(Segmento seg){
        origen = new Punto(seg.origen.abscisa(), seg.origen.ordenada());
        extremo = new Punto(seg.origen.abscisa(), seg.origen.ordenada());
    }
    public double longitud() {
        return origen.distancia(extremo);
    }

    @Override
    public String toString(){
        return "P(" + origen + "," + extremo + ")";
    }
}
