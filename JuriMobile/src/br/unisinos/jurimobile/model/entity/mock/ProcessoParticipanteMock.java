package br.unisinos.jurimobile.model.entity.mock;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.unisinos.jurimobile.model.entity.TipoParticipante;

public class ProcessoParticipanteMock implements Serializable, Comparable<ProcessoParticipanteMock> {
	
	private static final long serialVersionUID = 1L;
	
	public static final String _ID = "_id";
	public static final String NOME = "nome";
	public static final String TIPO_PARTICIPANTE = "tipo_participante"; 
	
	private Long id;

	private String nome;

	private String tipoParticipacao;

	private TipoParticipante tipoParticipante;

	private Long idProcesso;
	
	private List<ProcessoParticipanteAdvogadoMock> advogados;

	public ProcessoParticipanteMock() {
	}
	
	public ProcessoParticipanteMock(Long id, String nome, TipoParticipante tipoParticipante) {
		super();
		this.id = id;
		this.nome = nome;
		this.tipoParticipante = tipoParticipante;
	}



	public ProcessoParticipanteMock(Long id, String nome, String tipoParticipacao, TipoParticipante tipoParticipante) {
		super();
		this.id = id;
		this.nome = nome;
		this.tipoParticipacao = tipoParticipacao;
		this.tipoParticipante = tipoParticipante;
	}
	
	public boolean addAdvogado(ProcessoParticipanteAdvogadoMock advogadoMock){
		if(advogados == null){
			advogados = new ArrayList<ProcessoParticipanteAdvogadoMock>();
		}
		if(advogadoMock != null){
			return advogados.add(advogadoMock);
		}
		return false;
	}
	
	@Override
	public int compareTo(ProcessoParticipanteMock participante) {
		if(this.getTipoParticipante().ordinal() == participante.getTipoParticipante().ordinal()){
			return getId().compareTo(participante.getId()); 
		}
		return Integer.valueOf(this.getTipoParticipante().ordinal()).compareTo(participante.getTipoParticipante().ordinal());
	}
	
	public List<ProcessoParticipanteAdvogadoMock> getAdvogados() {
		return advogados;
	}

	public void setAdvogados(List<ProcessoParticipanteAdvogadoMock> advogados) {
		this.advogados = advogados;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTipoParticipacao() {
		return tipoParticipacao;
	}

	public void setTipoParticipacao(String tipoParticipacao) {
		this.tipoParticipacao = tipoParticipacao;
	}

	public TipoParticipante getTipoParticipante() {
		return tipoParticipante;
	}

	public void setTipoParticipante(TipoParticipante tipoParticipante) {
		this.tipoParticipante = tipoParticipante;
	}


	public Long getIdProcesso() {
		return idProcesso;
	}


	public void setIdProcesso(Long idProcesso) {
		this.idProcesso = idProcesso;
	}
	
}
