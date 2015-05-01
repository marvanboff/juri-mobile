package br.unisinos.jurimobile.facade;

import java.util.Collection;

import android.content.Context;
import br.unisinos.jurimobile.mode.dao.ProcessoMockDAO;
import br.unisinos.jurimobile.model.entity.mock.ProcessoMock;

public class JuriMobileFacadeImpl implements JuriMobileFacade {

	@Override
	public Collection<ProcessoMock> pesquisarProcessos(Context context, String nome, String numeroProcesso) {
		return new ProcessoMockDAO(context).pesquisarProcessos(nome, numeroProcesso);
	}

}
