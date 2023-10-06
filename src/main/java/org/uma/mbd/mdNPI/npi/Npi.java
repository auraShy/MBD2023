package org.uma.mbd.mdNPI.npi;

public class Npi {

    private double x,y,z,t;

    public void entra(double valor){
        t=z;
        z=y;
        y=x;
        x=valor;
    }

    public void suma(){
        x= x+y;
        y = z;
        z = t;
    }

    public void resta(){
        x= y-x;
        y = z;
        z = t;
    }

    public void multiplica(){
        x = y*x;
        y = z;
        z = t;
    }

    public void divide(){
        x = x/y;
        y = z;
        z = t;
    }

    public double getResultado(){
        return x;
    }

    @Override
    public String toString(){
        return "NPI(x=" + x + ", y=" + y + ", z=" + z + ", t=" + t + ")";
    }
}
