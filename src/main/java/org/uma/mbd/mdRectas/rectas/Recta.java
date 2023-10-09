package org.uma.mbd.mdRectas.rectas;

public class Recta {
    private Vector direccion;
    private Punto pto;

    public Recta(Punto pto1,Punto pto2){
        direccion = new Vector(pto1,pto2);
        //dudas con la forma de sacar el punto de la recta
        pto.setX(direccion.getCompenenteX());
        pto.setY(direccion.getComponenteY());
    }

    public boolean paralelaA(Recta rect){
        if(this.direccion.paraleloA(rect.direccion)){
            return true;
        }
        else{
            return false;
        }
    }

    public Recta(Vector v, Punto p){
        direccion = v;
        pto = p;
    }
}
