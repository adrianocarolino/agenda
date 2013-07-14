import java.util.ArrayList;
import java.util.HashSet;

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
	
	public Contato getContato(String nome) {
		return agenda.getContato(nome);
	}
	
	public boolean editarContato(Contato contatoAntigo, Contato novoContato) {
		return agenda.editarContato(contatoAntigo, novoContato);
	}
	
	public int getCount() {
		return agenda.getContatos().size();
	}
	
	public void clear() {
		agenda.clear();
	}
	
	public void adicionarContatoAosFavoritos(Contato contato) {
		agenda.getFavoritos().add(contato);
	}
	
	public void removeContatoDosFavoritos(Contato contato) {
		agenda.getFavoritos().remove(contato);
	}
	
	public HashSet<Contato> getContatosFavoritos() {
		return agenda.getFavoritos();
	}
}
