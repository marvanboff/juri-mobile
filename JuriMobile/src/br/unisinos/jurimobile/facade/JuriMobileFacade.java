package br.unisinos.jurimobile.facade;

import java.util.Collection;
import java.util.List;

import br.unisinos.jurimobile.model.entity.mock.ProcessoMock;
import br.unisinos.jurimobile.model.entity2.Processo;
import android.content.Context;

public interface JuriMobileFacade {

	Collection<ProcessoMock> pesquisarProcessos(Context context, String nome, String numeroProcesso);
	
	boolean favoritarProcesso(Context context, Long idProcessoMock);
	
	boolean desfavoritarProcesso(Context context, Long idProcesso);
	
	List<Processo> listarProcessosUsuario(Context context);
}
