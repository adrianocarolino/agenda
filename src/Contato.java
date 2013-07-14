import java.util.Set;

/**
 * 
 * @author Adriano Melo
 *
 */ 
public class Contato {
	
	private String nome;
	
	private Set<String> telefones;
	
	private boolean favorito;
	
	public Contato(String nome, Set<String> telefone) {
		this.nome = nome;
		this.telefones = telefone;
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

	public boolean isFavorito() {
		return favorito;
	}

	public void setFavorito(boolean favorito) {
		this.favorito = favorito;
	}
	
	
}
