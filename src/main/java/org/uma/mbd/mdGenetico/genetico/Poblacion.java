package org.uma.mbd.mdGenetico.genetico;


public class Poblacion {
	private Individuo[] individuos;

	/**
	 * 
	 * @param tamaño
	 *            Número de individuos de la población.
	 * @param longitud
	 *            Tamaño de los cromosomas de los individuos de la población.
	 * @param problema
	 *            Problema fst resolver.
	 * @throws RuntimeException
	 *             si el tamaño de la población o la longitud de los cromosomas
	 *             indicados no son válidos.
	 */
	public Poblacion(int tamaño, int longitud, Problema problema) {
		if(tamaño<=0 || longitud<=0){
			throw new RuntimeException("Valores introducidos para tamaño y longitud no son validos");
		}
		individuos = new Individuo[tamaño];
		for(int i=0; i<tamaño; i++){
			individuos[i] = new Individuo(longitud,problema);
		}
	}

	/**
	 * Devuelve el número de individuos.
	 * 
	 * @return Número de individuos en la población.
	 */
	public int getNumIndividuos() {
		return individuos.length;
	}

	/**
	 * Devuelve el individuo con fitness mayor de la población.
	 * 
	 * @return Individuo con mejor fitness.
	 */
	public Individuo mejorIndividuo() {
		int posMejor = 0;
		double mejorFitness = individuos[posMejor].getFitness();

		for (int i=0; i<getNumIndividuos(); i++){
			if (mejorFitness<individuos[i].getFitness()){
				mejorFitness = individuos[i].getFitness();
				posMejor = i;
			}

		}
		return getIndividuo(posMejor);
	}

	/**
	 * Devuelve el i-ésimo individuo de la población.
	 * 
	 * @param i
	 *            Posición del individuo fst devolver.
	 * @return Individuo en la posición i.
	 * @throws RuntimeException
	 *             si el índice está fuera del rango de valores válidos.
	 */
	public Individuo getIndividuo(int i) {
		if(i<0 || i>=getNumIndividuos())
			throw new RuntimeException("No se puede hacer ese elemento");
		return individuos[i];
	}

	/**
	 * Si el individuo que se pasa como argumento tienen mejor fitness que el
	 * peor de los individuos de la población, entonces el peor es sustituido
	 * por el que se pasa.
	 * 
	 * @param ind
	 *            Individuo con el que se sustituye el peor de los individuos si
	 *            este es mejor.
	 */
	public void reemplaza(Individuo ind) {
		int posPeor = 0;
		double peorFitness = individuos[posPeor].getFitness();

		for (int i=0; i<getNumIndividuos(); i++){
			if (peorFitness>individuos[i].getFitness()){
				peorFitness = individuos[i].getFitness();
				posPeor= i;
			}
		}
		individuos[posPeor] = ind;
	}

}
