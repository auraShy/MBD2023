package org.uma.mbd.mdBusV1L.buses;

public class EnMatricula implements Criterio{

    private String dato;

    public EnMatricula(String dato){
        this.dato = dato;
    }

    @Override
    public boolean esSeleccionable(Bus bus) {
        return (bus.getMatricula().contains(dato));
    }

    @Override
    public String toString(){
        return "Autobuse cuya matricula contiene " + dato;
    }
}
