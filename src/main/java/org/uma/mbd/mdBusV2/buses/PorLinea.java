package org.uma.mbd.mdBusV2.buses;

import org.uma.mbd.mdBusV2.buses.Bus;
import org.uma.mbd.mdBusV2.buses.Criterio;

public class PorLinea implements Criterio {
    private int codLinea;

    public PorLinea(int codLinea){
        this.codLinea = codLinea;
    }

    @Override
    public boolean esSeleccionable(Bus bus) {
        return (bus.getCodLinea() == codLinea);
    }

    @Override
    public String toString(){
        return "Autobuses de la linea " + codLinea;
    }
}
