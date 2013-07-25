package facisa.padroesdeprojeto.agenda;

import java.util.HashSet;

/**
 * Data: 24/07/2013
 * 
 * @author Adriano Melo
 * @author Fábio Do Carmo
 * @author Vamberto Lima
 */
public class Grupo {

	public static final int SEM_GRUPO = -1;

	public static final int FAMILIA = 0;

	public static final int AMIGOS = 1;

	public static final int TRABALHO = 2;

	private static HashSet grupos;

	/**
	 * Construtor
	 */
	public Grupo() {
		grupos = new HashSet();
		grupos.add(SEM_GRUPO);
		grupos.add(FAMILIA);
		grupos.add(AMIGOS);
		grupos.add(TRABALHO);
	}

	/**
	 * Verifica se o grupo é valido
	 * @param idGrupo
	 * @return
	 */
	public boolean isValidGroup(int idGrupo) {
		return grupos.contains(idGrupo);
	}
}
