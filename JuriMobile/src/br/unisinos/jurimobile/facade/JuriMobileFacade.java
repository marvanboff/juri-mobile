package br.unisinos.jurimobile.facade;

import java.util.Collection;

import br.unisinos.jurimobile.model.entity.mock.ProcessoMock;
import android.content.Context;

public interface JuriMobileFacade {

	Collection<ProcessoMock> pesquisarProcessos(Context context, String nome, String numeroProcesso);
}
