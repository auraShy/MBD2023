package org.uma.mbd.mdTren.tren;

import java.util.ArrayList;
import java.util.List;

public class Tren {
    private List<Vagon> vagones;

    public Tren(int numVagones, int capVagones){
        vagones = new ArrayList<>();
        for (int i=0; i<numVagones; i++){
            vagones.add(new Vagon(capVagones));
        }
    }



    @Override
    public String toString(){
        return "Tren[" + vagones.toString() + "]";
    }
}
