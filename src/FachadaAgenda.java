import java.util.ArrayList;

/**
 * 
 * @author Adriano Melo
 *
 */ 

public class FachadaAgenda {
	
	private Agenda agenda;
	
	public FachadaAgenda() {
		agenda = new Agenda();
	}

	public void adicionarContato(Contato contato) {
		agenda.adicionarContato(contato);		
	}
	
	public void removerContato(Contato contato) {
		agenda.removerContato(contato);
	}

	public ArrayList<Contato> getContatos() {
		return agenda.getContatos();
	}
	
	public boolean isFull() {
		return agenda.isFull();
	}
	
	public boolean editarContato(Contato contatoAntigo, Contato novoContato) {
		return agenda.editarContato(contatoAntigo, novoContato);
	}
}
