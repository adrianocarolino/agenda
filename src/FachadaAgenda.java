import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

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
		if (agenda.existe(contato))
			contato.setFavorite(true);
		else
			throw new AgendaException("Contato não existe na agenda.");
	}

	public void removeContatoDosFavoritos(Contato contato) {
		if (agenda.existe(contato) && contato.isFavorite())
			contato.setFavorite(false);
		else
			throw new AgendaException(
					"Contato não existe na agenda ou nos favoritos.");
	}

	public HashSet<Contato> getContatosFavoritos() {
		return agenda.getFavoritos();
	}

	public ArrayList<Contato> getFamiliares() {
		return getContatosDeGrupo(Grupo.FAMILIA);
	}

	public ArrayList<Contato> getAmigos() {
		return getContatosDeGrupo(Grupo.AMIGOS);
	}

	public ArrayList<Contato> getColegasDeTrabalho() {
		return getContatosDeGrupo(Grupo.TRABALHO);
	}

	private ArrayList<Contato> getContatosDeGrupo(int idGrupo) {
		Iterator it = agenda.getContatos().iterator();
		ArrayList<Contato> contatosDoGrupo = new ArrayList<Contato>();
		while (it.hasNext()) {
			Contato c = (Contato) it.next();
			if (c.getGrupo() == idGrupo)
				contatosDoGrupo.add(c);
		}
		return contatosDoGrupo;
	}

	public ArrayList<Contato> getContatosSemGrupo() {
		return getContatosDeGrupo(Grupo.SEM_GRUPO);
	}

	public List<Contato> getContatosPorOrdemAlfabetica() {
		return agenda.getContatosPorOrdemAlfabetica();
	}

}
