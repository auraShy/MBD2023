package org.uma.mbd.mdBusV1L;

import org.uma.mbd.mdBusV1L.buses.Servicio;

import java.io.IOException;
import java.lang.String;

public class Main {
    public static void main(String[] args) throws IOException {
        Servicio s1 = new Servicio("Malaga");
        System.out.println(s1.getCiudad());
        s1.leeBuses("C:\\Users\\david\\Desktop\\Master\\Modulo1_poo\\JavaApps\\src\\main\\java\\org\\uma\\mbd\\mdBusV1L\\buses.txt");
        System.out.println(s1.getBuses());
    }
}

