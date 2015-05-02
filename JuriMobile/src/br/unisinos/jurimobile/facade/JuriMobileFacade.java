package br.unisinos.jurimobile.facade;

import java.util.Collection;

import br.unisinos.jurimobile.model.entity.mock.ProcessoMock;
import android.content.Context;

public interface JuriMobileFacade {

	Collection<ProcessoMock> pesquisarProcessos(Context context, String nome, String numeroProcesso);
	
	boolean favoritarProcesso(Context context, Long idProcessoMock);
	
	boolean desfavoritarProcesso(Context context, Long idProcesso);
}
