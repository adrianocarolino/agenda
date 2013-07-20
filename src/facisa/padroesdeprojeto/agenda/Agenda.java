package facisa.padroesdeprojeto.agenda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import facisa.padroesdeprojeto.agenda.exceptions.AgendaException;

/**
 * @author Adriano Melo
 * @author Fabio do Carmo
 * @author Vamberto Lima
 */
public class Agenda {

	private ArrayList<Contato> contatos;

	private int limiteMaximoContatos = 999;

	public Agenda() {
		this.contatos = new ArrayList<Contato>();
	}

	public boolean isVazia() {
		return this.getContatos().size() == 0;
	}

	public boolean isFull() {
		return this.getContatos().size() == this.limiteMaximoContatos;
	}

	public void adicionarContato(Contato contato) {
		if (!this.existe(contato) && !this.isFull())
			this.getContatos().add(contato);
		else
			throw new AgendaException(
					"Contato já existe na agenda ou agenda está cheia.");
	}

	public void removerContato(Contato contato) {
		if (this.existe(contato))
			this.getContatos().remove(contato);
		else
			throw new AgendaException("Contato não existe na agenda.");
	}

	public ArrayList<Contato> getContatos() {
		return this.contatos;
	}

	public Contato getContato(String nome) {
		// procura pelo nome na agenda toda
		Iterator it = getContatos().iterator();

		while (it.hasNext()) {
			Contato contatoTemporario = (Contato) it.next();
			if (contatoTemporario.getNome().equalsIgnoreCase(nome)) {
				return contatoTemporario;
			}
		}
		return null;
	}

	public boolean existe(Contato contato) {
		// se o nome já existe, então o contato já existe na agenda. Não precisa
		// comparar os telefones, pois
		// pode ocorrer o caso de ter dois contatos com o mesmo número de
		// telefone e nomes diferentes
		Iterator it = getContatos().iterator();

		while (it.hasNext()) {
			Contato contatoTemporario = (Contato) it.next();
			if (contatoTemporario.getNome().equalsIgnoreCase(contato.getNome())) {
				return true;
			}
		}
		return false;
	}

	public boolean editarContato(Contato antigoContato, Contato novoContato) {
		if (existe(antigoContato)) {
			// substitui o antigo pelo novo
			this.removerContato(antigoContato);
			this.adicionarContato(novoContato);
			return true;
		} else
			throw new AgendaException("Contato não existe na agenda.");
	}

	public void clear() {
		this.contatos.clear();
	}

	public HashSet<Contato> getFavoritos() {
		Iterator it = getContatos().iterator();
		HashSet<Contato> favoritos = new HashSet<Contato>();
		while (it.hasNext()) {
			Contato c = (Contato) it.next();
			if (c.isFavorite())
				favoritos.add(c);
		}
		return favoritos;
	}

	public List<Contato> getContatosPorOrdemAlfabetica() {
		List contatosOrdenados = (List) getContatos().clone();
		Collections.sort(contatosOrdenados);
		return contatosOrdenados;
	}

}
