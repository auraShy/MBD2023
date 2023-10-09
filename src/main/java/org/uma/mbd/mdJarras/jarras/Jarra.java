package org.uma.mbd.mdJarras.jarras;

public class Jarra {
    private final int capacidad; // "final" Para que no cambie de valor una vez creado un objeto
    private int contenido;

    public Jarra(int capInicial){
        // Al ser solo una sentencia en el if no es necesario usar corchetes
        if (capInicial<=0)
            throw new IllegalArgumentException("No se puede crear una jarra con capacidad " + capInicial);

        capacidad = capInicial;
        contenido = 0;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public int getContenido() {
        return contenido;
    }

    public void llena(){
        contenido = capacidad;
    }

    public void vacia(){
        contenido = 0;
    }

    public void llenaDesde(Jarra j){
        if(this == j)
            throw new IllegalArgumentException("No se puede volcar una jarra sobre si misma");
        int cabe = capacidad - contenido;
        if(cabe >= j.contenido){
            contenido += j.contenido;
            j.vacia();
        }else{
            this.llena(); // a mi mismo
            j.contenido -= cabe;
        }
    }

    @Override
    public String toString(){
        return "J(" + capacidad + "," + contenido + ")";
    }
}
