package br.unisinos.jurimobile.model.entity2;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Processo implements Auditavel {

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

	public Processo(Long idProcesso, String numeroProcesso) {
		this.id = idProcesso;
		this.numero = numeroProcesso;
	}

	public String getNomesParticipantes() {
		StringBuilder nomes = new StringBuilder();
		if (participantes != null) {
			for (ProcessoParticipante participante : participantes) {
				if (nomes.length() > 0) {
					nomes.append(", ");
				}
				nomes.append(participante.getNome());
			}
		}
		return nomes.toString();
	}

	public boolean addParticipante(ProcessoParticipante participante) {
		if (participantes == null) {
			participantes = new ArrayList<ProcessoParticipante>();
		}
		return participantes.add(participante);
	}
	
	public boolean addMovimento(ProcessoMovimento movimento) {
		if(movimentacoes == null){
			movimentacoes = new ArrayList<ProcessoMovimento>();
		}
		return movimentacoes.add(movimento);
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
