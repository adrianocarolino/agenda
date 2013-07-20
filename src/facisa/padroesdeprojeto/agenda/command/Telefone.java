package facisa.padroesdeprojeto.agenda.command;

import java.util.ArrayList;
import java.util.List;

public class Telefone {
	
	private List<Comando> historicoDeAcoes = new ArrayList<Comando>();
	
	public void armazenarEExecutar(Comando cmd) {
		historicoDeAcoes.add(cmd);
		cmd.execute();
	}
}
