package br.unisinos.jurimobile.model;

public class Processo {

	private Long id;
	private String numero;
	private String assunto;
	private String juizado;

	public Processo() {
		super();
	}

	public Processo(Long id, String numero, String assunto, String juizado) {
		super();
		this.id = id;
		this.numero = numero;
		this.assunto = assunto;
		this.juizado = juizado;
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

}
