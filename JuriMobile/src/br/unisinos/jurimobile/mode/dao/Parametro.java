package br.unisinos.jurimobile.mode.dao;


public class Parametro {

	private String sql;
	private String value;
	
	public Parametro(String sql, String value) {
		super();
		this.sql = sql;
		this.value = value;
	}
	public String getSql() {
		return sql;
	}
	public void setSql(String sql) {
		this.sql = sql;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
}
