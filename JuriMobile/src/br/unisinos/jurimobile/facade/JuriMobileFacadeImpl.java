package br.unisinos.jurimobile.facade;

import java.util.Collection;
import java.util.List;

import android.content.Context;
import br.unisinos.jurimobile.mode.dao.ProcessoDAO;
import br.unisinos.jurimobile.mode.dao.ProcessoMockDAO;
import br.unisinos.jurimobile.mode.dao.ProcessoMovimentoDAO;
import br.unisinos.jurimobile.mode.dao.ProcessoMovimentoMockDAO;
import br.unisinos.jurimobile.model.entity.mock.ProcessoMock;
import br.unisinos.jurimobile.model.entity.mock.ProcessoMovimentoMock;
import br.unisinos.jurimobile.model.entity2.Processo;
import br.unisinos.jurimobile.model.entity2.ProcessoMovimento;

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
	
	public List<Processo> listarProcessosUsuario(Context context){
		return new ProcessoDAO(context).pesquisarProcessos();
	}

	@Override
	public boolean isExistProcesso(Context context, String numeroProcesso) {
		return new ProcessoDAO(context).isExist(numeroProcesso);
	}

	@Override
	public Processo recuperarProcesso(Context context, Long idProcesso) {
		return new ProcessoDAO(context).recuperarProcesso(idProcesso);
	}

	@Override
	public List<ProcessoMovimentoMock> recuperaMovimentacoesMock(Context context, Long idProcessoMock) {
		return new ProcessoMovimentoMockDAO(context).recuperaMovimentacoes(idProcessoMock);
	}

	@Override
	public List<ProcessoMovimento> recuperaMovimentacoes(Context context, Processo processo) {
		return new ProcessoMovimentoDAO(context).recuperaMovimentacoes(processo);
	}
	
	
	
}
