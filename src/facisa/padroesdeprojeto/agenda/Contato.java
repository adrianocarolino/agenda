package facisa.padroesdeprojeto.agenda;
import java.util.Set;

import facisa.padroesdeprojeto.agenda.exceptions.AgendaException;

/**
 * 
 * @author Adriano Melo
 *
 */ 
public class Contato implements Comparable<Contato>{
	
	private String nome;
	
	private Set<String> telefones;
	
	private int grupo;
	
	private boolean isFavorite;
	
	public Contato(String nome, Set<String> telefone) {
		this.nome = nome;
		this.telefones = telefone;
		this.grupo = Grupo.SEM_GRUPO;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Set<String> getTelefone() {
		return telefones;
	}

	public void setTelefone(Set<String> telefone) {
		this.telefones = telefone;
	}

	@Override
	public String toString() {
		return "Contato: [nome=" + nome + ", telefones=" + telefones + "]";
	}

	public int getGrupo() {
		return grupo;
	}

	public void setGrupo(int idGrupo) {
		if (new Grupo().isValidGroup(idGrupo))
			this.grupo = idGrupo;
		else throw new AgendaException("Grupo inválido: " + idGrupo);
	}

	public boolean isFavorite() {
		return isFavorite;
	}

	public void setFavorite(boolean isFavorite) {
		this.isFavorite = isFavorite;
	}

	@Override
	public int compareTo(Contato c) {
		return nome.compareTo(c.getNome());
	}
	
	

}
