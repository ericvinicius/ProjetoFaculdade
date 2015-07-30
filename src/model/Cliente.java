package model;

public class Cliente {
	private String nome;

	public String getNome() {
		if (nome == null) {
			return "Maluco Beleza";
		}
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
