package org.uma.mbd.mdRectas.rectas;

public class Vector {
    private Punto extremo = new Punto();

    public Vector(double x_ext, double y_ext){
        extremo.setX(x_ext);
        extremo.setY(y_ext);
    }

    public Vector(Punto ext){
        extremo = ext;
    }

    public Vector(Punto org, Punto ext){
            extremo.setX(ext.getX() - org.getX());
            extremo.setY(ext.getY() - org.getY());
    }

    public Punto extremoDesde(Punto org){
        double trasladoX =  org.getX()+this.getCompenenteX();
        double trasladoY = org.getY()+this.getComponenteY();
        Punto ptoExtremo = new Punto(trasladoX,trasladoY);
        return ptoExtremo;
    }
    public double getCompenenteX(){return extremo.getX();}

    public double getComponenteY(){return extremo.getY();}

    public double modulo(){
        return Math.sqrt(Math.pow(this.getCompenenteX(),2)+Math.pow(this.getComponenteY(),2));
    }

    public Vector ortogonal(){
        Vector v = new Vector(this.getComponenteY()*-1,this.getCompenenteX());
        return v;
    }

    public boolean paraleloA(Vector v){
        if(this.getCompenenteX()*v.getComponenteY() == this.getComponenteY()* v.getCompenenteX()){
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public String toString(){
        return "V(" + extremo.getX() + "," + extremo.getY() + ")";
    }
}
