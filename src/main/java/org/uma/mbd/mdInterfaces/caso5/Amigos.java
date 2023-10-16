package org.uma.mbd.mdInterfaces.caso5;
// CON INTERFACES, LISTAS Y FUNCIONAL
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Amigos {
	private List<Persona> personas;
	
	public Amigos(List<Persona> personas) {
		this.personas = personas;
	}
	
	public List<Persona> getPersonas() {
		return personas;
	}

}
