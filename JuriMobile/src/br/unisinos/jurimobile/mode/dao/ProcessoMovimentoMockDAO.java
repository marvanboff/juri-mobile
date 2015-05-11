package br.unisinos.jurimobile.mode.dao;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.database.Cursor;
import br.unisinos.jurimobile.model.entity.mock.ProcessoMovimentoMock;
import br.unisinos.jurimobile.utils.DateUtils;

public class ProcessoMovimentoMockDAO extends JuriMobileDAO {

	private static final String QUERY_SEL_MOVIMENTACOES = "select _id, data_movimentacao, descricao, id_processo, cod_movimento_cnj, texto_ajuda, descricao_cnj from processo_movimento_mock where id_processo = ?";
	
	private enum ProcessoMovimentoMockColumns {

		_id, data_movimentacao, descricao, id_processo, cod_movimento_cnj, texto_ajuda, descricao_cnj;

		public static String getTableName() {
			return "processo_movimento_mock";
		}
	}
	
	public ProcessoMovimentoMockDAO(Context context) {
		super(context);
	}
	
	public List<ProcessoMovimentoMock> recuperaMovimentacoes(Long idProcessoMock) {

		Cursor cursor = getDataBase().rawQuery(QUERY_SEL_MOVIMENTACOES, new String[]{idProcessoMock.toString()});

		List<ProcessoMovimentoMock> movimentos = new ArrayList<ProcessoMovimentoMock>();
		while (cursor.moveToNext()) {

			ProcessoMovimentoMock movimentoMock = new ProcessoMovimentoMock();
			movimentoMock.setId(cursor.getLong(0));
			movimentoMock.setDataMovimentacao(DateUtils.parseDate(cursor.getString(1)));
			movimentoMock.setDescricao(cursor.getString(2));
			movimentoMock.setIdProcesso(cursor.getLong(3));
			movimentoMock.setCodMovimentoCNJ(cursor.getLong(4));
			movimentoMock.setTextoAjuda(cursor.getString(5));
			movimentoMock.setDescricaoCNJ(cursor.getString(6));
			
			movimentos.add(movimentoMock);
		}

		cursor.close();
		return movimentos;
	}

}
