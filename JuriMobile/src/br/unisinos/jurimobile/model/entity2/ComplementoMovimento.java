package br.unisinos.jurimobile.model.entity2;

import br.unisinos.jurimobile.model.entity.cnj.MovimentosCNJ;

public class ComplementoMovimento {

	private Long id;

	private MovimentosCNJ movimentoCNJ;

	private String glossario;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public MovimentosCNJ getMovimentoCNJ() {
		return movimentoCNJ;
	}

	public void setMovimentoCNJ(MovimentosCNJ movimentoCNJ) {
		this.movimentoCNJ = movimentoCNJ;
	}

	public String getGlossario() {
		return glossario;
	}

	public void setGlossario(String glossario) {
		this.glossario = glossario;
	}

}
