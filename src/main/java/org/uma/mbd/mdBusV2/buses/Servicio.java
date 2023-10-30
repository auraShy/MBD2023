package org.uma.mbd.mdBusV2.buses;


import org.uma.mbd.mdBusV2.buses.Bus;
import org.uma.mbd.mdBusV2.buses.Criterio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;

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
                    sc.useDelimiter(",");
                    int codBus = sc.nextInt();
                    String matricula = sc.next();
                    int codLinea = sc.nextInt();
                    Bus busAdded = new Bus(codBus, matricula);
                    busAdded.setCodLinea(codLinea);
                    buses.addLast(busAdded);
                }catch (InputMismatchException e) {
                    System.err.println("Error en dato numérico en " + linea);
                } catch (NoSuchElementException e) {
                    System.err.println("Error, faltan datos en " + linea);
                }

            }
    }

    public Set<Bus> filtra(Criterio criterio, Comparator<Bus> cb){
        return buses.stream()
                .filter(criterio::esSeleccionable)
                .sorted(cb)
                .collect(Collectors.toCollection(TreeSet::new));
    }

    public void guarda(String file, Criterio criterio, Comparator<Bus> cb) throws FileNotFoundException {
        try(PrintWriter pw = new PrintWriter(file)){
            System.out.println(criterio);
            guarda(pw,criterio,cb);
        }
    }

    public void guarda(PrintWriter pw, Criterio c, Comparator <Bus> cb){
        Set<Bus> busesFilt= filtra(c,cb);
        for (Bus line : busesFilt){
            pw.println(line.toString());
        }
    }
}
