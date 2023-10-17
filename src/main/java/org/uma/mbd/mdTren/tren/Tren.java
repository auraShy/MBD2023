package org.uma.mbd.mdTren.tren;

import java.util.ArrayList;
import java.util.List;

public class Tren {
    private List<Vagon> vagones;
    private int capVagones;

    public Tren(int numVagones, int capVag){
        vagones = new ArrayList<>();
        capVagones = capVag;
        for (int i=0; i<numVagones; i++){
            vagones.add(new Vagon(capVagones));
        }
    }

    public void carga(int ton){
        int i = 0;
        while (ton > 0){
            int cargaRestante = vagones.get(i).carga(ton);
            ton = cargaRestante;
            i++;
            if (i==vagones.size() && ton>0){
                vagones.add(new Vagon(capVagones));
            }
        }
    }

    public void gasta(int ton){
        int i = 0;
        while (ton > 0){
            int descargaRest = vagones.get(i).descarga(ton);
            ton = descargaRest;
            i++;
            if (i==vagones.size() && ton>0){
                throw new IllegalArgumentException("No hay suficientes toneladas de combustible para realizar el trayecto");
            }
        }
    }

    public void optimiza(){
        for (int i = 0; i<vagones.size(); i++){
            if (vagones.get(i).getCarga() == 0)
                vagones.remove(i);
        }
    }


    @Override
    public String toString(){
        return "Tren[" + vagones.toString() + "]";
    }
}
