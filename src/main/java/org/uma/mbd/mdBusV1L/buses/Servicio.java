package org.uma.mbd.mdBusV1L.buses;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
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

    public List<Bus> filtra(Criterio criterio){
        return buses.stream()
                .filter(bus -> criterio.esSeleccionable(bus))
                .toList();
    }

    public void guarda(String file, Criterio criterio) throws FileNotFoundException {
        try(PrintWriter pw = new PrintWriter(file)){
            guarda(pw,criterio);
        }
    }

    public void guarda(PrintWriter pw, Criterio c){
        List<Bus> busesFilt= filtra(c);
        for (Bus line : busesFilt){
            pw.println(line.toString());
        }
    }
}
