package br.unisinos.jurimobile.model.entity2;

import java.util.Date;
import java.util.List;

public class Processo implements Auditavel{

	private Long id;

	private String numero;
	
	private String assunto;
	
	private String situacao;
	
	private String comarca;
	
	private String orgaoJulgador;
	
	private Date dataDistribuicao;
	
	private Usuario usuario;
	
	private List<ProcessoParticipante> participantes;
	
	private List<GrupoProcesso> grupos;
	
	private List<ProcessoMovimento> movimentacoes;
	
	private Date dataUltAtualizacao;
	
	public Processo(Long idProcesso) {
		this.setId(idProcesso);
	}

	public Processo() {
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getAssunto() {
		return assunto;
	}

	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public String getComarca() {
		return comarca;
	}

	public void setComarca(String comarca) {
		this.comarca = comarca;
	}

	public String getOrgaoJulgador() {
		return orgaoJulgador;
	}

	public void setOrgaoJulgador(String orgaoJulgador) {
		this.orgaoJulgador = orgaoJulgador;
	}

	public Date getDataDistribuicao() {
		return dataDistribuicao;
	}

	public void setDataDistribuicao(Date dataDistribuicao) {
		this.dataDistribuicao = dataDistribuicao;
	}

	public List<ProcessoParticipante> getParticipantes() {
		return participantes;
	}

	public void setParticipantes(List<ProcessoParticipante> participantes) {
		this.participantes = participantes;
	}

	public List<GrupoProcesso> getGrupos() {
		return grupos;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Date getDataUltAtualizacao() {
		return dataUltAtualizacao;
	}

	public void setDataUltAtualizacao(Date dataUltAtualizacao) {
		this.dataUltAtualizacao = dataUltAtualizacao;
	}

	public void setGrupos(List<GrupoProcesso> grupos) {
		this.grupos = grupos;
	}

	public List<ProcessoMovimento> getMovimentacoes() {
		return movimentacoes;
	}

	public void setMovimentacoes(List<ProcessoMovimento> movimentacoes) {
		this.movimentacoes = movimentacoes;
	}

}
