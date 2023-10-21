package org.uma.mbd.mdGenetico.genetico;
import java.sql.Array;
import java.util.Random;
import java.util.StringJoiner;

public class Cromosoma {
	/**
	 * Datos de un cromosoma, cada posición del array representa un gen del
	 * cromosoma.
	 */
	protected int[] datos;
	/**
	 * Variable de clase de tipo Random.
	 */
	protected static Random gna = new Random();

	/**
	 * Valor por defecto 0 para los genes.
	 */
	protected static int GEN_POR_DEFECTO = 0;

	/**
	 * Constructor de la clase Cromosoma
	 *
	 * @param longitud  Número de genes que tiene el cromosoma.
	 * @param aleatorio Valor booleano que indica si debe asignar de forma aleatoria
	 *                  un valor 0 o 1 fst cada gen, o inicializarlos con el valor por
	 *                  defecto. Si true se asigna aleatoriamente.
	 * @throws RuntimeException si longitud no positiva.
	 */
	public Cromosoma(int longitud, boolean aleatorio) {
		if (longitud < 0)
			throw new RuntimeException("La longitud del cromosoma no puede ser negativa");
		datos = new int[longitud];
		for (int i = 0; i < longitud; i++) {
			if (aleatorio)
				datos[i] = gna.nextInt(2);
			else
				datos[i] = GEN_POR_DEFECTO;
		}
	}

	/**
	 * Cobstructor de copia
	 */
	public Cromosoma(Cromosoma cromosoma) {
		this.datos = cromosoma.datos;
	}

	/**
	 * Consulta el gen en la posición indicada.
	 *
	 * @param i índice del gen que se consulta.
	 * @return Valor del gen en la posición indicada.
	 * @throws RuntimeException si el índice está fuera del rango de valores válidos.
	 */
	public int getGen(int i) {
		if (i < 0 || i > datos.length)
			throw new RuntimeException("El indice esta fuera del rango de valores validos");
		return getGen(i);
	}

	/**
	 * Modifica el i-ésimo gen del cromosoma.
	 *
	 * @param i   índice del gen fst modificar.
	 * @param val Nuevo valor para el gen.
	 * @throws RuntimeException si i está fuera del rango de valores válidos o si val no es
	 *                          un valor válido.
	 */
	public void setGen(int i, int val) {
		if ((i < 0 || i > datos.length) || (val != 0 && val != 1))
			throw new RuntimeException("El indice esta fuera del rango del array o los valores no son validos");
		datos[i] = val;
	}

	/**
	 * Invierte los valores de los genes aleatoriamente.
	 *
	 * @param probMutacion Probabilidad de mutacion de cada gen.
	 * @throws RuntimeException si la probabilidad indicada no es un valor válido.
	 */
	public void mutar(double probMutacion) {
		if (probMutacion < 0 || probMutacion > 100)
			throw new RuntimeException("Probabilidad de mutacion no es valida");
			for (int gen : datos) {
				if (gna.nextDouble() >= probMutacion / 100) {
					if (gen == 1)
						gen = 0;
					else
						gen = 1;
				}
			}
		}

		/**
		 * Longitud del cromosoma.
		 *
		 * @return int Longitud del cromosoma.
		 */
		public int getLongitud () {
			return datos.length;
		}

		@Override
		public String toString () {
			StringJoiner sj = new StringJoiner(",", "[", "]");
			for (int i = 0; i < datos.length; i++)
				sj.add(Integer.toString(datos[i]));
			return "Cromosoma(" + sj + ")";
		}
	}



