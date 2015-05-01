package br.unisinos.jurimobile.model.dto;

import java.io.Serializable;
import java.util.Collection;

import br.unisinos.jurimobile.model.entity.mock.ProcessoMock;

public class ProcessoMockListDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private ProcessoMock[] processos;
	
	public void addAll(Collection<ProcessoMock> processos2){
		processos = processos2.toArray(new ProcessoMock[processos2.size()]);
	}

	public ProcessoMock[] getProcessos() {
		return processos;
	}

	public void setProcessos(ProcessoMock[] processos) {
		this.processos = processos;
	}
	
}
