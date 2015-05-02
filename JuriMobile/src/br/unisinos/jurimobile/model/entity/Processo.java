package br.unisinos.jurimobile.model.entity;

import java.util.ArrayList;
import java.util.List;

@Deprecated
public class Processo {

	private Long id;
	private String numero;
	private String assunto;
	private String juizado;
	private String estadoProcesso;
	private String comarca;
	private List<ProcessoParticipante> participantes;
	private List<GrupoProcesso> grupos;
	private List<ProcessoMovimento> movimentacoes;
	
	public Processo() {
		super();
	}

	public Processo(Long id, String numero, String assunto, String juizado, String comarca, String estadoProcesso) {
		super();
		this.id = id;
		this.numero = numero;
		this.assunto = assunto;
		this.juizado = juizado;
		this.comarca = comarca;
		this.estadoProcesso = estadoProcesso;
	}
	
	public boolean addParticipante(ProcessoParticipante participante){
		if(participantes == null){
			participantes = new ArrayList<ProcessoParticipante>();
		}
		return participantes.add(participante);
	}
	
	public boolean addGrupo(GrupoProcesso grupo){
		if(grupos == null){
			grupos = new ArrayList<GrupoProcesso>();
		}
		return grupos.add(grupo);
	}
	
	public String getNomesParticipantes(){
		StringBuilder nomes = new StringBuilder();
		if(participantes != null){
			for (ProcessoParticipante participante : participantes) {
				if(nomes.length() > 0){
					nomes.append(", ");
				}
				nomes.append(participante.getNome());
			}
		}
		return nomes.toString();
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

	public String getJuizado() {
		return juizado;
	}

	public void setJuizado(String juizado) {
		this.juizado = juizado;
	}

	public List<ProcessoParticipante> getParticipantes() {
		return participantes;
	}

	public void setParticipantes(List<ProcessoParticipante> participantes) {
		this.participantes = participantes;
	}

	public String getEstadoProcesso() {
		return estadoProcesso;
	}

	public void setEstadoProcesso(String estadoProcesso) {
		this.estadoProcesso = estadoProcesso;
	}

	public List<GrupoProcesso> getGrupos() {
		return grupos;
	}

	public void setGrupos(List<GrupoProcesso> grupos) {
		this.grupos = grupos;
	}

	public String getComarca() {
		return comarca;
	}

	public void setComarca(String comarca) {
		this.comarca = comarca;
	}

	public List<ProcessoMovimento> getMovimentacoes() {
		return movimentacoes;
	}

	public void setMovimentacoes(List<ProcessoMovimento> movimentacoes) {
		this.movimentacoes = movimentacoes;
	}
}
