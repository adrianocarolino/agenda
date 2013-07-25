package facisa.padroesdeprojeto.agenda.command;

/**
 * Data: 24/07/2013
 * 
 * @author Adriano Melo
 * @author Fábio Do Carmo
 * @author Vamberto Lima
 */
import java.util.ArrayList;
import java.util.List;

public class Telefone {
	
	private List<Comando> historicoDeAcoes = new ArrayList<Comando>();
	
	/**
	 * Guarda o histórico dos comandos e os executa
	 * @param cmd
	 */
	public void armazenarEExecutar(Comando cmd) {
		historicoDeAcoes.add(cmd);
		cmd.execute();
	}
}
