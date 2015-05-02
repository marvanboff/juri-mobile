package br.unisinos.jurimobile.mode.dao;

import java.util.ArrayList;
import java.util.List;

import br.unisinos.jurimobile.model.entity.mock.ProcessoParticipanteAdvogadoMock;
import br.unisinos.jurimobile.model.entity.mock.ProcessoParticipanteMock;
import android.content.Context;
import android.database.Cursor;

public class AdvogadosMockDAO extends JuriMobileDAO {

	private static final String QUERY_SEL_ADVOGADOS = "select participante_advogado._id, participante_advogado.id_participante, participante_advogado.id_advogado, advogado._id, " +
													  "advogado.nome, advogado.numero_oab from participante_advogado_mock participante_advogado " +
													  "inner join advogado_mock advogado on (participante_advogado._id = advogado._id) where participante_advogado.id_participante = ? ";
	
	public AdvogadosMockDAO(Context context) {
		super(context);
	}

	public List<ProcessoParticipanteAdvogadoMock> pesquisarParticipantes(Long idParticipante){
		
		Cursor cursor = getDataBase().rawQuery(QUERY_SEL_ADVOGADOS, new String[]{ idParticipante.toString() });
		
		List<ProcessoParticipanteAdvogadoMock> participantesAdvogados = new ArrayList<ProcessoParticipanteAdvogadoMock>();
		while (cursor.moveToNext()) {
			participantesAdvogados.add(parseToParticipantesAdvogados(cursor));
		}
		cursor.close();
		return participantesAdvogados;
		
	}

	private ProcessoParticipanteAdvogadoMock parseToParticipantesAdvogados(Cursor cursor) {
		
		
		
		return null;
	}
	
	
}
