import java.util.Set;


public class Contato {
	
	private String nome;
	
	private Set telefones;
	
	public Contato(String nome, Set telefone) {
		this.nome = nome;
		this.telefones = telefone;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Set getTelefone() {
		return telefones;
	}

	public void setTelefone(Set telefone) {
		this.telefones = telefone;
	}

	@Override
	public String toString() {
		return "Contato [nome=" + nome + ", telefones=" + telefones + "]";
	}
	

}
