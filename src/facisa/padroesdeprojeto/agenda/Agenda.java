package facisa.padroesdeprojeto.agenda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import facisa.padroesdeprojeto.agenda.exceptions.AgendaException;

/**
 * Data: 24/07/2013
 * 
 * @author Adriano Melo
 * @author Fábio Do Carmo
 * @author Vamberto Lima
 */
public class Agenda {

	//a lista dos contatos
	private ArrayList<Contato> contatos;

	//limite máximo que a agenda suporte
	private int limiteMaximoContatos = 999;

	/**
	 * Construtor
	 */
	public Agenda() {
		this.contatos = new ArrayList<Contato>();
	}

	/**
	 * Verifica se a agenda não tem nenhum contato
	 * @return boolean true se a agenda tem pelo menos um contato
	 */
	public boolean isVazia() {
		return this.getContatos().size() == 0;
	}

	/**
	 * Verifica se a agenda está complementamente cheia
	 * @return boolean true se a agenda está cheia
	 */
	public boolean isFull() {
		return this.getContatos().size() == this.limiteMaximoContatos;
	}

	/**
	 * Adiciona um contato na agenda
	 * @param contato um Contato
	 */
	public void adicionarContato(Contato contato) {
		if (!this.existe(contato) && !this.isFull())
			this.getContatos().add(contato);
		else
			throw new AgendaException(
					"Contato já existe na agenda ou agenda está cheia.");
	}

	/**
	 * Remove um contato da agenda
	 * @param contato um Contato
	 */
	public void removerContato(Contato contato) {
		if (this.existe(contato))
			this.getContatos().remove(contato);
		else
			throw new AgendaException("Contato não existe na agenda.");
	}

	/**
	 * Retorna a lista de todos os contatos
	 * @return List todos os contatos
	 */
	public ArrayList<Contato> getContatos() {
		return this.contatos;
	}

	/**
	 * Retorna o Contato pelo nome
	 * @param nome
	 * @return
	 */
	public Contato getContato(String nome) {
		// procura pelo nome na agenda
		Iterator it = getContatos().iterator();
		while (it.hasNext()) {
			Contato contatoTemporario = (Contato) it.next();
			if (contatoTemporario.getNome().equalsIgnoreCase(nome)) {
				return contatoTemporario;
			}
		}
		return null;
	}

	/**
	 * Verifica se o contato já existe na agenda
	 * @param contato
	 * @return
	 */
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

	/**
	 * Remove todos os contatos da agenda 
	 */
	public void clear() {
		this.contatos.clear();
	}

	/**
	 * Retorna a lista que contatos favoritos
	 * @return
	 */
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

	/**
	 * Retorna os contatos ordenados alfabeticamente
	 * @return a lista de Contatos
	 */
	public List<Contato> getContatosPorOrdemAlfabetica() {
		List contatosOrdenados = (List) getContatos().clone();
		Collections.sort(contatosOrdenados);
		return contatosOrdenados;
	}

}
