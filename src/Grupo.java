import java.util.HashSet;


public class Grupo {
	
	public static final int SEM_GRUPO = -1;
	
	public static final int FAMILIA = 0;
	
	public static final int AMIGOS = 1;
	
	public static final int TRABALHO = 2;
	
	private static HashSet grupos;
	
	public Grupo() {
		grupos = new HashSet();
		grupos.add(SEM_GRUPO);
		grupos.add(FAMILIA);
		grupos.add(AMIGOS);
		grupos.add(TRABALHO);
	}

	public boolean isValidGroup(int idGrupo) {
		return grupos.contains(idGrupo);
	}
}
