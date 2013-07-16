import java.util.Set;

/**
 * 
 * @author Adriano Melo
 *
 */ 
public class Contato {
	
	private String nome;
	
	private Set<String> telefones;
	
	private int grupo;
	
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
	
	

}
