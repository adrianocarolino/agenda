import java.util.Set;


public class Contato {
	
	private String nome;
	
	private Set telefone;
	
	public Contato(String nome, Set telefone) {
		this.nome = nome;
		this.telefone = telefone;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Set getTelefone() {
		return telefone;
	}

	public void setTelefone(Set telefone) {
		this.telefone = telefone;
	}
	
	
}
