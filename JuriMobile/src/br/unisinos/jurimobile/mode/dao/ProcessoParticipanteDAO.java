package br.unisinos.jurimobile.mode.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import br.unisinos.jurimobile.model.entity.TipoParticipante;
import br.unisinos.jurimobile.model.entity2.Advogado;
import br.unisinos.jurimobile.model.entity2.Processo;
import br.unisinos.jurimobile.model.entity2.ProcessoParticipante;
import br.unisinos.jurimobile.model.entity2.ProcessoParticipanteAdvogado;

public class ProcessoParticipanteDAO extends JuriMobileDAO {
	
	private static final String QUERY_SEL_PARTICIPANTES_ADVOGADOS = "select participante._id, participante.nome, participante.tipo_participacao, participante.tipo_participante, " +
																	"participante.id_processo, participante.data_ult_atualizacao, participante_advogado._id, participante_advogado.id_participante, " +
																	"participante_advogado.id_advogado, participante_advogado.data_ult_atualizacao, advogado._id, advogado.nome, " +
																	"advogado.numero_oab, advogado.data_ult_atualizacao " + 
																	"from processo_participante participante " + 
																	"left outer join processo_participante_advogado participante_advogado on (participante._id = participante_advogado._id) " + 
																	"left outer join advogado advogado on (participante_advogado._id = advogado._id) " +
																	"where participante.id_processo =  ? ";
	
	public ProcessoParticipanteDAO(Context context) {
		super(context);
	}
	
	private enum ProcessoParticipanteColumns{
		
		_id, nome, tipo_participacao, tipo_participante, id_processo, data_ult_atualizacao;
		
		public static String getTableName(){
			return "processo_participante";
		}
	}
	
	public List<ProcessoParticipante> recuperaParticipantesCompleto(Long idProcesso){
		
		Cursor cursor = getDataBase().rawQuery(QUERY_SEL_PARTICIPANTES_ADVOGADOS, new String[]{ idProcesso.toString() });
		
		Map<Long, ProcessoParticipante> mapParticipantes = new HashMap<Long, ProcessoParticipante>();
		while (cursor.moveToNext()) {
			Long idParticipante = cursor.getLong(0);
			ProcessoParticipante participante = null;
			
			if(mapParticipantes.containsKey(idParticipante)){
				participante = mapParticipantes.get(idParticipante);
			}else{
				participante = parseToParticipante(cursor);
				mapParticipantes.put(idParticipante, participante);
			}
			
			participante.setAdvogados(new ArrayList<ProcessoParticipanteAdvogado>());
			ProcessoParticipanteAdvogado participanteAdvogado = parseToProcessoParticipanteAdvogado(participante, cursor);
			participante.addAdvogado(participanteAdvogado);
		}
		cursor.close();
		return new ArrayList<ProcessoParticipante>(mapParticipantes.values());
		
	}
	
	public ProcessoParticipante parseToParticipante(Cursor cursor){
		
		ProcessoParticipante participante = new ProcessoParticipante();
		
		participante.setId(cursor.getLong(0));
		participante.setNome(cursor.getString(1));
		participante.setTipoParticipacao(cursor.getString(2));
		participante.setTipoParticipante(TipoParticipante.valueOf(cursor.getString(3)));
		participante.setProcesso(new Processo(cursor.getLong(4)));
		
		return participante;
	}
	
	private ProcessoParticipanteAdvogado parseToProcessoParticipanteAdvogado(ProcessoParticipante participante, Cursor cursor) {
		
		Long idParticipanteAdvogado = cursor.getLong(5);
		if(idParticipanteAdvogado != null && idParticipanteAdvogado > 0){
			ProcessoParticipanteAdvogado participanteAdvogado = new ProcessoParticipanteAdvogado();
			Advogado advogado = new Advogado();
			
			participanteAdvogado.setId(idParticipanteAdvogado);
			participanteAdvogado.setParticipante(participante);
			participanteAdvogado.setAdvogado(advogado);
			
			advogado.setId(cursor.getLong(7));
			advogado.setNome(cursor.getString(8));
			advogado.setNumeroOAB(cursor.getString(9));
			
			return participanteAdvogado;
			
		}
		return null;
	}
	
	public ProcessoParticipante insert(ProcessoParticipante participante){
		
		ContentValues values = new ContentValues();
		values.put(ProcessoParticipanteColumns.nome.name(), participante.getNome());
		values.put(ProcessoParticipanteColumns.tipo_participacao.name(), participante.getTipoParticipacao());
		values.put(ProcessoParticipanteColumns.tipo_participante.name(), participante.getTipoParticipante().name());
		values.put(ProcessoParticipanteColumns.id_processo.name(), participante.getProcesso().getId());
		
		Long idProcesso = getDataBaseWrite().insert(ProcessoParticipanteColumns.getTableName(), null, values);
		participante.setId(idProcesso);
		return participante;
	}
	
	public void delete(ProcessoParticipante participante){
		getDataBaseWrite().delete(ProcessoParticipanteColumns.getTableName(), ProcessoParticipanteColumns._id.name() + " = ? ", new String[] {participante.getId().toString()});
	}
	
}
