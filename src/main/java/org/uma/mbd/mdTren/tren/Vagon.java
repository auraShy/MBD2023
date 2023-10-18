package org.uma.mbd.mdTren.tren;

public class Vagon {
    private int capacidad, carga;

    public Vagon(int cap){
        carga = 0;
        capacidad = cap;
    }

    // DEVUELVE LAS TONELADAS QUE NO SE HAN PODIDO CARGAR EN EL VAGON
    public int carga(int ton){
        //int sobrante = 0;
        int capacidadAct = capacidad - carga;

        if (ton > capacidadAct) {
            carga =  capacidad;
        }

        else{
            carga += ton;
        }
        return ton - capacidadAct;

    }

    // DEVUELVE LAS TONELADAS QUE NO SE HAN PODIDO DESCARGAR DEL VAGON
    public int descarga(int ton){
        int falta = 0;
        if (ton > carga){
            falta = ton - carga;
            carga = 0;
        }
        else
            carga = carga - ton;
        return falta;
    }

    public int getCarga(){
        return carga;
    }

    public int getCapacidad(){
        return capacidad;
    }

    @Override
    public String toString(){
        return "V(" + carga + "/" + capacidad + ")";
    }

}
