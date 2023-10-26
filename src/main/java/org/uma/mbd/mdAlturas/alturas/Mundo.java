package org.uma.mbd.mdAlturas.alturas;

import org.uma.mbd.mdBusV1L.buses.Bus;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class Mundo {
    private List<Pais> paises;

    public Mundo(){
        paises = new ArrayList<>();
    }

    public List<Pais> getPaises() {
        return paises;
    }

    public void leePaises(String file) throws IOException {
        Path fichero = Path.of(file);
        for (String line : Files.readAllLines(fichero)){
            try(Scanner sc = new Scanner(line);){
                sc.useDelimiter(",");
                String nombre = sc.next();
                String continente = sc.next();
                double altura = sc.useLocale(Locale.US).nextDouble();
                paises.addLast(new Pais(nombre,continente,altura));
            }catch (InputMismatchException e) {
                System.err.println("Error en dato numérico en " + line);
            }catch (NumberFormatException e) {
                System.err.println("Error, faltan datos en " + line);
            }
        }
    }

   /* private void leeScan(String line){
        try(Scanner sc = new Scanner(line);){
            sc.useDelimiter(",");
            String nombre = sc.next();
            String continente = sc.next();
            double altura = sc.useLocale(Locale.US).nextDouble();
            paises.addLast(new Pais(nombre,continente,altura));
        }catch (InputMismatchException e) {
            System.err.println("Error en dato numérico en " + line);
        }catch (NumberFormatException e) {
            System.err.println("Error, faltan datos en " + line);
        }
    }*/

    public List<Pais> selecciona(Seleccion sel){
        System.out.println(sel);
        return paises.stream()
                .filter(pais -> sel.test(pais))
                .toList();
    }

}
