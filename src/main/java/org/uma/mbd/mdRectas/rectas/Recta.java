package org.uma.mbd.mdRectas.rectas;

public class Recta {
    private Vector direccion;
    private Punto pto;

    public Recta(Vector v, Punto p){
        direccion = v;
        pto = p;
    }
    public Recta(Punto pto1,Punto pto2){
        direccion = new Vector(pto1,pto2);
        pto = pto1;
    }

    public record Implicita(double a, double b, double c){}

    private Implicita Implicita(){
        double a = this.direccion.getComponenteY();
        double b = this.direccion.getCompenenteX()*-1;
        double c = this.direccion.getCompenenteX()*this.pto.getY() - this.direccion.getComponenteY()*this.pto.getX();
        return new Implicita(a,b,c);
    }

    static private double determinante(double a11, double a12, double a21, double a22){
        return a11*a22 - a12*a21;
    }
    public boolean paralelaA(Recta rect){
        if(this.direccion.paraleloA(rect.direccion))
            return true;

        else
            return false;

    }

    public boolean pasaPor(Punto p){
        Vector v = new Vector(p,this.pto);
        return this.direccion.paraleloA(v);
    }

    public Recta paralelaPor(Punto p){
        return new Recta(this.direccion,p);
    }

    public Recta perpendicularPor(Punto p){
        return new Recta(this.direccion.ortogonal(),p);
    }

    public Punto interseccionCon(Recta r){
        if(this.paralelaA(r)) {
            // Asi se evita que el denominador de 0
            throw new RuntimeException("Rectas paralelas");
        }
            Implicita i1 = this.Implicita();
            Implicita i2 = r.Implicita();

            double numX = determinante(-1*i1.c, i1.b,-1*i2.c,i2.b);
            double denom = determinante(i1.a, i1.b, i2.a, i2.b);
            double numY = determinante(i1.a, -1*i1.c, i2.a, -1*i2.c);


            return new Punto(numX/denom,numY/denom);


    }

    public double distanciaDesde(Punto p){
        Recta r = this.perpendicularPor(p);
        Punto pInterseccion =  this.interseccionCon(r);
        return pInterseccion.distancia(p);
    }

    @Override
    public String toString(){
        return "R(" + direccion + "," + pto + ")";
    }

}
