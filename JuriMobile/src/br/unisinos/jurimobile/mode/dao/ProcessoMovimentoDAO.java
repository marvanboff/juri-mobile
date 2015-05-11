package br.unisinos.jurimobile.mode.dao;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import br.unisinos.jurimobile.model.entity2.Processo;
import br.unisinos.jurimobile.model.entity2.ProcessoMovimento;
import br.unisinos.jurimobile.utils.DateUtils;

public class ProcessoMovimentoDAO extends JuriMobileDAO {

	private static final String QUERY_SEL_MOVIMENTACOES = "select _id, data_movimentacao, data_ult_atualizacao, descricao, texto_ajuda, cod_movimento_cnj, id_processo, descricao_cnj from processo_movimento where id_processo = ? order by data_movimentacao";
	
	private enum ProcessoMovimentoColumns{
		
		_id, data_movimentacao, data_ult_atualizacao, descricao, texto_ajuda, cod_movimento_cnj, id_processo, descricao_cnj;
		
		public static String getTableName() {
			return "processo_movimento";
		}
	}
	
	public ProcessoMovimentoDAO(Context context) {
		super(context);
	}
	
	public List<ProcessoMovimento> recuperaMovimentacoes(Processo processo) {

		Cursor cursor = getDataBase().rawQuery(QUERY_SEL_MOVIMENTACOES, new String[]{processo.getId().toString()});

		List<ProcessoMovimento> movimentos = new ArrayList<ProcessoMovimento>();
		while (cursor.moveToNext()) {

			ProcessoMovimento movimento = new ProcessoMovimento();
			movimento.setId(cursor.getLong(0));
			movimento.setDataMovimentacao(DateUtils.parseDate(cursor.getString(1)));
			movimento.setDataUltAtualizacao(DateUtils.parseDate(cursor.getString(2)));
			movimento.setDescricao(cursor.getString(3));
			movimento.setTextoAjuda(cursor.getString(4));
			movimento.setCodigoMovimentoCNJ(cursor.getLong(5));
			movimento.setDescricaoCNJ(cursor.getString(7));
			movimento.setProcesso(processo);
			
			movimentos.add(movimento);
		}

		cursor.close();
		return movimentos;
	}
	
	public ProcessoMovimento insert(ProcessoMovimento movimento) {

		ContentValues values = new ContentValues();
		values.put(ProcessoMovimentoColumns.data_movimentacao.name(), DateUtils.formatDate(movimento.getDataMovimentacao()));
		values.put(ProcessoMovimentoColumns.data_ult_atualizacao.name(), DateUtils.formatDate(movimento.getDataUltAtualizacao()));
		values.put(ProcessoMovimentoColumns.descricao.name(), movimento.getDescricao());
		values.put(ProcessoMovimentoColumns.texto_ajuda.name(), movimento.getTextoAjuda());
		values.put(ProcessoMovimentoColumns.cod_movimento_cnj.name(), movimento.getCodigoMovimentoCNJ());
		values.put(ProcessoMovimentoColumns.descricao_cnj.name(), movimento.getDescricaoCNJ());
		values.put(ProcessoMovimentoColumns.id_processo.name(), movimento.getProcesso().getId());

		Long idProcessoMovimento = getDataBaseWrite().insert(ProcessoMovimentoColumns.getTableName(), null, values);
		movimento.setId(idProcessoMovimento);
		return movimento;
	}

	public void delete(ProcessoMovimento movimento) {
		getDataBaseWrite().delete(ProcessoMovimentoColumns.getTableName(), ProcessoMovimentoColumns._id.name() + " = ? ", new String[] { movimento.getId().toString() });
	}
	
	
}
