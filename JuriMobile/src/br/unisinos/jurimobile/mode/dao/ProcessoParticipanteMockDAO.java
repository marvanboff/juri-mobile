package br.unisinos.jurimobile.mode.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.content.Context;
import android.database.Cursor;
import br.unisinos.jurimobile.model.entity.TipoParticipante;
import br.unisinos.jurimobile.model.entity.mock.AdvogadoMock;
import br.unisinos.jurimobile.model.entity.mock.ProcessoParticipanteAdvogadoMock;
import br.unisinos.jurimobile.model.entity.mock.ProcessoParticipanteMock;

public class ProcessoParticipanteMockDAO extends JuriMobileDAO {

	private static final String QUERY_SEL_PARTICIPANTES = "select _id, nome, tipo_participacao, tipo_participante, id_processo from processo_participante_mock where id_processo = ? ";

	private static final String QUERY_SEL_PARTICIPANTES_ADVOGADOS = "select participante._id, participante.nome, participante.tipo_participacao, participante.tipo_participante, " +
																	"participante.id_processo, participante_advogado._id, participante_advogado.id_participante, " +
																	"participante_advogado.id_advogado, advogado._id, advogado.nome, advogado.numero_oab " + 
																	"from participante_advogado_mock participante_advogado " + 
																	"inner join advogado_mock advogado on (participante_advogado.id_advogado = advogado._id) " +
																	"inner join processo_participante_mock participante on (participante_advogado.id_participante = participante._id) " +
																	"where participante.id_processo =  ? ";
	
	public ProcessoParticipanteMockDAO(Context context) {
		super(context);
	}

	@Deprecated
	public List<ProcessoParticipanteMock> pesquisarParticipantes(Long idProcessoMock){
		
		Cursor cursor = getDataBase().rawQuery(QUERY_SEL_PARTICIPANTES, new String[]{ idProcessoMock.toString() });
		
		List<ProcessoParticipanteMock> participantes = new ArrayList<ProcessoParticipanteMock>();
		while (cursor.moveToNext()) {
			participantes.add(parseToParticipante(cursor));
		}
		cursor.close();
		return participantes;
		
	}
	
	public List<ProcessoParticipanteMock> recuperaParticipantesCompleto(Long idProcessoMock){
		
		Cursor cursor = getDataBase().rawQuery(QUERY_SEL_PARTICIPANTES_ADVOGADOS, new String[]{ idProcessoMock.toString() });
		
		Map<Long, ProcessoParticipanteMock> mapParticipantes = new HashMap<Long, ProcessoParticipanteMock>();
		while (cursor.moveToNext()) {
			Long idParticipante = cursor.getLong(0);
			ProcessoParticipanteMock participante = null;
			
			if(mapParticipantes.containsKey(idParticipante)){
				participante = mapParticipantes.get(idParticipante);
			}else{
				participante = parseToParticipante(cursor);
				mapParticipantes.put(idParticipante, participante);
			}
			
			ProcessoParticipanteAdvogadoMock participanteAdvogado = parseToProcessoParticipanteAdvogado(cursor);
			participante.addAdvogado(participanteAdvogado);
		}
		cursor.close();
		return new ArrayList<ProcessoParticipanteMock>(mapParticipantes.values());
		
	}
	
	
	public ProcessoParticipanteMock parseToParticipante(Cursor cursor){
		
		ProcessoParticipanteMock participante = new ProcessoParticipanteMock();
		
		participante.setId(cursor.getLong(0));
		participante.setNome(cursor.getString(1));
		participante.setTipoParticipacao(cursor.getString(2));
		participante.setTipoParticipante(TipoParticipante.valueOf(cursor.getString(3)));
		participante.setIdProcesso(cursor.getLong(4));
		participante.setAdvogados(new ArrayList<ProcessoParticipanteAdvogadoMock>());
		
		return participante;
	}

	private ProcessoParticipanteAdvogadoMock parseToProcessoParticipanteAdvogado(Cursor cursor) {
		ProcessoParticipanteAdvogadoMock participanteAdvogado = new ProcessoParticipanteAdvogadoMock();
		AdvogadoMock advogado = new AdvogadoMock();
		
		participanteAdvogado.setId(cursor.getLong(5));
		participanteAdvogado.setIdParticipante(cursor.getLong(6));
		participanteAdvogado.setAdvogado(advogado);
		
		advogado.setId(cursor.getLong(7));
		advogado.setNome(cursor.getString(8));
		advogado.setNumeroOAB(cursor.getString(9));
		
		return participanteAdvogado;
	}
	
	
	
}
