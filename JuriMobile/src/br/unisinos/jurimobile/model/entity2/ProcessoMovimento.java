package br.unisinos.jurimobile.model.entity2;

import java.util.Date;

public class ProcessoMovimento implements Auditavel {

	private Long id;
	
	private Date dataMovimentacao;
	
	private String descricao;

	private Processo processo;
	
	private Date dataUltAtualizacao;
	
	private Long codigoMovimentoCNJ;
	
	private String glossario;
	
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

	public Processo getProcesso() {
		return processo;
	}

	public void setProcesso(Processo processo) {
		this.processo = processo;
	}

	public Date getDataUltAtualizacao() {
		return dataUltAtualizacao;
	}

	public void setDataUltAtualizacao(Date dataUltAtualizacao) {
		this.dataUltAtualizacao = dataUltAtualizacao;
	}

	public Long getCodigoMovimentoCNJ() {
		return codigoMovimentoCNJ;
	}

	public void setCodigoMovimentoCNJ(Long codigoMovimentoCNJ) {
		this.codigoMovimentoCNJ = codigoMovimentoCNJ;
	}

	public String getGlossario() {
		return glossario;
	}

	public void setGlossario(String glossario) {
		this.glossario = glossario;
	}
	
	
}
