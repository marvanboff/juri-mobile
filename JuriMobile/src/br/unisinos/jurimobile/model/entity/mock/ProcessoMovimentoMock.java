package br.unisinos.jurimobile.model.entity.mock;

import java.util.Date;

import br.unisinos.jurimobile.model.entity.cnj.MovimentosCNJ;

public class ProcessoMovimentoMock {

	private Long id;

	private Date dataMovimentacao;

	private String descricao;

	private ProcessoMock processo;

	private MovimentosCNJ movimentoCNJ;

	@Override
	public String toString() {
		return dataMovimentacao + " - " + descricao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public Date getDataMovimentacao() {
		return dataMovimentacao;
	}

	public void setDataMovimentacao(Date dataMovimentacao) {
		this.dataMovimentacao = dataMovimentacao;
	}

	public ProcessoMock getProcesso() {
		return processo;
	}

	public void setProcesso(ProcessoMock processo) {
		this.processo = processo;
	}

	public MovimentosCNJ getMovimentoCNJ() {
		return movimentoCNJ;
	}

	public void setMovimentoCNJ(MovimentosCNJ movimentoCNJ) {
		this.movimentoCNJ = movimentoCNJ;
	}

}
