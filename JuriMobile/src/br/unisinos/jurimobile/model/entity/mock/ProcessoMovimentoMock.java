package br.unisinos.jurimobile.model.entity.mock;

import java.util.Date;

import br.unisinos.jurimobile.model.entity.cnj.MovimentosCNJ;

public class ProcessoMovimentoMock {

	private Long id;

	private Date dataMovimentacao;

	private String descricao;

	private Long idProcesso;

	private Long codMovimentoCNJ;
	
	private String textoAjuda;

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

	public Long getIdProcesso() {
		return idProcesso;
	}

	public void setIdProcesso(Long idProcesso) {
		this.idProcesso = idProcesso;
	}

	public Long getCodMovimentoCNJ() {
		return codMovimentoCNJ;
	}

	public void setCodMovimentoCNJ(Long codMovimentoCNJ) {
		this.codMovimentoCNJ = codMovimentoCNJ;
	}

	public String getTextoAjuda() {
		return textoAjuda;
	}

	public void setTextoAjuda(String textoAjuda) {
		this.textoAjuda = textoAjuda;
	}
	

}
