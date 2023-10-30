package org.uma.mbd.mdAlturasV2.alturas;

public class EnContinente implements Seleccion {
    private String texto;

    public EnContinente(String txt){
        texto = txt;
    }

    @Override
    public boolean test(Pais pais) {
        return pais.continente().toLowerCase().contains(texto.toLowerCase());
    }

    @Override
    public String toString(){
        return "Paises que contienen la palabra " + texto + " en su continente: ";
    }
}
