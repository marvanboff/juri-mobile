package br.unisinos.jurimobile.facade;

import java.util.Collection;
import java.util.List;

import br.unisinos.jurimobile.model.entity.mock.ProcessoMock;
import br.unisinos.jurimobile.model.entity.mock.ProcessoMovimentoMock;
import br.unisinos.jurimobile.model.entity2.Processo;
import br.unisinos.jurimobile.model.entity2.ProcessoMovimento;
import android.content.Context;

public interface JuriMobileFacade {

	Collection<ProcessoMock> pesquisarProcessos(Context context, String nome, String numeroProcesso);
	
	List<ProcessoMovimentoMock> recuperaMovimentacoesMock(Context context, Long idProcessoMock);
	
	List<ProcessoMovimento> recuperaMovimentacoes(Context context, Processo processo);
	
	boolean favoritarProcesso(Context context, Long idProcessoMock);
	
	boolean desfavoritarProcesso(Context context, Long idProcesso);
	
	List<Processo> listarProcessosUsuario(Context context);
	
	boolean isExistProcesso(Context context, String numeroProcesso);
	
	Processo recuperarProcesso(Context context, Long idProcesso);
	
	
}
