package br.unisinos.jurimobile.mode.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import br.unisinos.jurimobile.model.entity.TipoParticipante;
import br.unisinos.jurimobile.model.entity.mock.ProcessoMock;
import br.unisinos.jurimobile.model.entity.mock.ProcessoMovimentoMock;
import br.unisinos.jurimobile.model.entity.mock.ProcessoParticipanteAdvogadoMock;
import br.unisinos.jurimobile.model.entity.mock.ProcessoParticipanteMock;
import br.unisinos.jurimobile.model.entity.mock.TransformMockToEntity;
import br.unisinos.jurimobile.model.entity2.Advogado;
import br.unisinos.jurimobile.model.entity2.Processo;
import br.unisinos.jurimobile.model.entity2.ProcessoMovimento;
import br.unisinos.jurimobile.model.entity2.ProcessoParticipante;
import br.unisinos.jurimobile.model.entity2.ProcessoParticipanteAdvogado;
import br.unisinos.jurimobile.utils.DateUtils;

public class ProcessoDAO extends JuriMobileDAO {

	private String SQL_PROCESSO_PARTICIPANTES_INFORMACOES_BASICAS = "select processo._id, processo.numero, participante._id, participante.nome, participante.tipo_participante from processo as processo "
			+ "inner join processo_participante as participante on (processo._id = participante.id_processo)";

	private static final String QUERY_SEL_PROCESSO = "select _id, assunto, comarca, data_distribuicao, numero, orgao_julgador, situacao, data_ult_atualizacao from processo where _id = ? ";
	
	private String SQL_COUNT_PROCESSO = "select count(1) from processo";

	private enum ProcessoColumns {

		_id, assunto, comarca, data_distribuicao, numero, orgao_julgador, situacao, data_ult_atualizacao;

		public static String getTableName() {
			return "processo";
		}
	}

	public ProcessoDAO(Context context) {
		super(context);
	}

	public List<Processo> pesquisarProcessos() {

		Cursor cursor = getDataBase().rawQuery(SQL_PROCESSO_PARTICIPANTES_INFORMACOES_BASICAS, null);

		Map<Long, Processo> mapProcessos = new HashMap<Long, Processo>();
		while (cursor.moveToNext()) {
			Long idProcesso = cursor.getLong(0);

			Processo processo = null;
			if (mapProcessos.containsKey(idProcesso)) {
				processo = mapProcessos.get(idProcesso);
			} else {
				processo = new Processo(idProcesso, cursor.getString(1));
				mapProcessos.put(idProcesso, processo);
			}
			parseToParticipante(cursor, processo);
			
		}

		cursor.close();
		return new ArrayList<Processo>(mapProcessos.values());
	}

	public boolean isExist(String numeroProcesso) {

		String sql = SQL_COUNT_PROCESSO + " where " + ProcessoColumns.numero.name() + " = ?";
		Cursor cursor = getDataBase().rawQuery(sql, new String[] { numeroProcesso });

		cursor.moveToNext();
		boolean isExist = cursor.getInt(0) > 0;
		cursor.close();
		return isExist;
	}

	private void parseToParticipante(Cursor cursor, Processo processo) {
		processo.addParticipante(new ProcessoParticipante(cursor.getLong(2), cursor.getString(3), TipoParticipante.valueOf(cursor.getString(4))));
	}

	public Processo insert(Processo processo) {

		ContentValues values = new ContentValues();
		values.put(ProcessoColumns.assunto.name(), processo.getAssunto());
		values.put(ProcessoColumns.comarca.name(), processo.getComarca());
		values.put(ProcessoColumns.data_distribuicao.name(), DateUtils.formatDate(processo.getDataDistribuicao()));
		values.put(ProcessoColumns.numero.name(), processo.getNumero());
		values.put(ProcessoColumns.orgao_julgador.name(), processo.getOrgaoJulgador());
		values.put(ProcessoColumns.situacao.name(), processo.getSituacao());
		values.put(ProcessoColumns.data_ult_atualizacao.name(), DateUtils.formatDate(new Date()));

		Long idProcesso = getDataBaseWrite().insert(ProcessoColumns.getTableName(), null, values);
		processo.setId(idProcesso);
		return processo;
	}

	public void delete(Long idProcesso) {
		getDataBaseWrite().delete(ProcessoColumns.getTableName(), ProcessoColumns._id.name() + " = ? ", new String[] { idProcesso.toString() });
	}
	
	public Processo recuperarProcesso(Long idProcesso){
		ProcessoParticipanteDAO participanteDAO = new ProcessoParticipanteDAO(getContext());
		ProcessoMovimentoDAO processoMovimentoDAO = new ProcessoMovimentoDAO(getContext());
		
		Cursor cursor = getDataBase().rawQuery(QUERY_SEL_PROCESSO, new String[]{ idProcesso.toString() });
		
		cursor.moveToNext();
		Processo processo = parseToProcesso(cursor);
		processo.setParticipantes(participanteDAO.recuperaParticipantesCompleto(idProcesso));
		processo.setMovimentacoes(processoMovimentoDAO.recuperaMovimentacoes(processo));
		
		cursor.close();
		return processo;
		
	}

	public Processo parseToProcesso(Cursor cursor){
		Processo processo = new Processo();
		
		processo.setId(cursor.getLong(0));
		processo.setAssunto(cursor.getString(1));
		processo.setComarca(cursor.getString(2));
		processo.setDataDistribuicao(DateUtils.parseDate(cursor.getString(3)));
		processo.setNumero(cursor.getString(4));
		processo.setOrgaoJulgador(cursor.getString(5));
		processo.setSituacao(cursor.getString(6));
		processo.setDataUltAtualizacao(DateUtils.parseDate(cursor.getString(7)));
		
		return processo;
	}
	
	public boolean favoritarProcesso(Long idProcessoMock) {
		ProcessoMockDAO processoMockDAO = new ProcessoMockDAO(getContext());
		ProcessoParticipanteDAO processoParticipanteDAO = new ProcessoParticipanteDAO(getContext());
		AdvogadoDAO advogadoDAO = new AdvogadoDAO(getContext());
		ProcessoMovimentoDAO movimentoDAO = new ProcessoMovimentoDAO(getContext());
		
		ProcessoMock processoMock = processoMockDAO.pesquisarProcesso(idProcessoMock);

		Processo processo = TransformMockToEntity.transformTo(processoMock);

		try {

			insert(processo);

			for (ProcessoParticipanteMock participanteMock : processoMock.getParticipantes()) {
				ProcessoParticipante participante = TransformMockToEntity.transformTo(participanteMock);

				participante.setProcesso(processo);
				processoParticipanteDAO.insert(participante);
				
				
				for (ProcessoParticipanteAdvogadoMock participanteAdvogadoMock : participanteMock.getAdvogados()) {
					Advogado advogado = TransformMockToEntity.transformTo(participanteAdvogadoMock.getAdvogado());
					advogadoDAO.insert(advogado);

					ProcessoParticipanteAdvogado participanteAdvogado = new ProcessoParticipanteAdvogado(participante, advogado);
					advogadoDAO.insert(participanteAdvogado);
					
					participante.addAdvogado(participanteAdvogado);
				}
				
				processo.addParticipante(participante);
			}
			
			for (ProcessoMovimentoMock movimentoMock : processoMock.getMovimentacoes()) {
				ProcessoMovimento movimento = TransformMockToEntity.transformTo(movimentoMock);
				movimento.setProcesso(processo);
				
				movimentoDAO.insert(movimento);
				
				processo.addMovimento(movimento);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} 

		return true;
	}

	public boolean desfavoritarProcesso(Long idProcesso) {
		ProcessoParticipanteDAO participanteDAO = new ProcessoParticipanteDAO(getContext());
		AdvogadoDAO advogadoDAO = new AdvogadoDAO(getContext());
		ProcessoMovimentoDAO movimentoDAO = new ProcessoMovimentoDAO(getContext());
		
		List<ProcessoParticipante> participantes = participanteDAO.recuperaParticipantesCompleto(idProcesso);
		List<ProcessoMovimento> movimentacoes = movimentoDAO.recuperaMovimentacoes(new Processo(idProcesso));

		try {
			for (ProcessoParticipante participante : participantes) {
				for (ProcessoParticipanteAdvogado participanteAdvogado : participante.getAdvogados()) {
					advogadoDAO.delete(participanteAdvogado.getAdvogado());
					advogadoDAO.delete(participanteAdvogado);
				}
				participanteDAO.delete(participante);
			}
			for (ProcessoMovimento movimento : movimentacoes) {
				movimentoDAO.delete(movimento);
			}
			delete(idProcesso);
		} catch (Exception e) {
			return false;
		} 

		return true;
	}

}
