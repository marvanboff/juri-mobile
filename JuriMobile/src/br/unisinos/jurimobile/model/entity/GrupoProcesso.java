package br.unisinos.jurimobile.model.entity;

@Deprecated
public class GrupoProcesso {

	private Long id;
	private Processo processo;
	private Grupo grupo;

	public GrupoProcesso() {
		super();
	}

	public GrupoProcesso(Long id, Processo processo, Grupo grupo) {
		super();
		this.id = id;
		this.processo = processo;
		this.grupo = grupo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Processo getProcesso() {
		return processo;
	}

	public void setProcesso(Processo processo) {
		this.processo = processo;
	}

	public Grupo getGrupo() {
		return grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}

}
