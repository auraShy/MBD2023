package org.uma.mbd.mdBusV1L.buses;

import org.uma.mbd.mdTestL.tests.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class Servicio {
    private String ciudad;
    private List<Bus> buses;

    public Servicio(String ciudad){
        buses = new ArrayList<>();
        this.ciudad = ciudad;
    }

    public String getCiudad() {
        return ciudad;
    }

    public List<Bus> getBuses() {
        return buses;
    }

    public void leeBuses(String file) throws IOException{
        Path fichero = Path.of(file);
        for (String linea : Files.readAllLines(fichero)){
                try(Scanner sc = new Scanner(linea);){
                    sc.useDelimiter("[,]+");
                    int codBus = sc.nextInt();
                    String matricula = sc.next();
                    int codLinea = sc.nextInt();
                    buses.addLast(new Bus(codBus, matricula));
                }catch (InputMismatchException e) {
                    System.err.println("Faltan datos en " + linea);
                } catch (NoSuchElementException e) {
                    System.err.println("Numero erroneo en " + linea);
                }

            }
    }

}
