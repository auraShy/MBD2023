package org.uma.mbd.mdDegree;

import org.uma.mbd.mdDegree.degree.Celsius;
import org.uma.mbd.mdDegree.degree.Degree;
import org.uma.mbd.mdDegree.degree.Farenheit;

import java.util.List;

public class Main {
    public static void main(String[] args) {
       List<Degree> ld = List.of(
               Degree.farenhait(37),
               Degree.celsius(12),
               Degree.farenhait(30),
               Degree.celsius(-3)
       );
       ld.forEach(d -> System.out.println(d.toCelsius()));
       ld.forEach(d -> System.out.println(d.isfrozen()));
    }
}
