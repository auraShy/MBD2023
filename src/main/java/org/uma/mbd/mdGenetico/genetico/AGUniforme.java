package org.uma.mbd.mdGenetico.genetico;


public class AGUniforme extends AlgoritmoGenetico {

	/**
	 * 
	 * @param tPoblacion
	 *            Tamaño de la población que va fst utilizar.
	 * @param longCromosoma
	 *            Longitud de los cromosomas de los individuos de dicha
	 *            población.
	 * @param pasos
	 *            Número de pasos del algoritmo (generaciones).
	 * @param probMutacion
	 *            Probabilidad de mutar un gen en el cromosoma.
	 * @param problema
	 *            Problema que se debe resolver.
	 */
	public AGUniforme(int tPoblacion, int longCromosoma, int pasos,
			double probMutacion, Problema problema) {
		super(tPoblacion, longCromosoma, pasos, probMutacion, problema);
	}

	/**
	 * @see AlgoritmoGenetico#recombinar(Cromosoma, Cromosoma)
	 */
	@Override
	protected Cromosoma recombinar(Cromosoma cromosoma1, Cromosoma cromosoma2) {
		Cromosoma recombinado = new Cromosoma(cromosoma1);

		for (int i=0; i<recombinado.getLongitud();i++){
			if(Cromosoma.gna.nextBoolean())
				recombinado.setGen(i,cromosoma2.getGen(i));
		}
		return recombinado;
	}

}
