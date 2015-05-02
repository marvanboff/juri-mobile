package br.unisinos.jurimobile.facade;

import java.util.Collection;

import android.content.Context;
import br.unisinos.jurimobile.mode.dao.ProcessoDAO;
import br.unisinos.jurimobile.mode.dao.ProcessoMockDAO;
import br.unisinos.jurimobile.model.entity.mock.ProcessoMock;

public class JuriMobileFacadeImpl implements JuriMobileFacade {

	@Override
	public Collection<ProcessoMock> pesquisarProcessos(Context context, String nome, String numeroProcesso) {
		return new ProcessoMockDAO(context).pesquisarProcessos(nome, numeroProcesso);
	}

	@Override
	public boolean favoritarProcesso(Context context, Long idProcessoMock) {
		return new ProcessoDAO(context).favoritarProcesso(idProcessoMock);
	}

	@Override
	public boolean desfavoritarProcesso(Context context, Long idProcesso) {
		return new ProcessoDAO(context).desfavoritarProcesso(idProcesso);
	}
	
}
