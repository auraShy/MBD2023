package org.uma.mbd.mdAmigoInvisible.amigos;

import java.io.IOException;
import java.io.PrintWriter;

public class ClubManager {
    private String fEntrada;
    private String delimitadores;
    private String fSalida;
    private Boolean consola;
    private Club club;

    public ClubManager(Club club){
        this.club = club;
    }

    public ClubManager setEntrada (String fEntrada, String delim){
        this.fEntrada = fEntrada;
        this.delimitadores = delim;
        return this;
    }

    public ClubManager setSalida (String salida){
        this.fSalida = salida;
        return this;
    }

    public ClubManager setConsola (boolean consola){
        this.consola = consola;
        return this;
    }

    private void verify(){
       if (fEntrada == null)
           throw new AmigoException("No existe archivo de entrada");
       if (fSalida == null && consola)
           throw new AmigoException("No existe salida, ni a fichero, ni a consola");
    }

    public void build() throws IOException {
        verify();
        club.lee(fEntrada,delimitadores);
        club.hacerAmigos();
        club.presentaAmigos(fSalida);
        club.presentaAmigos(new PrintWriter(System.out, true));
    }
}
