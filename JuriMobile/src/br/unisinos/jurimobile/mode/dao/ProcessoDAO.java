package br.unisinos.jurimobile.mode.dao;

import java.util.Collection;

import android.content.Context;
import android.database.Cursor;
import br.unisinos.jurimobile.model.entity.mock.ProcessoMock;

public class ProcessoDAO extends JuriMobileDAO{

	public ProcessoDAO(Context context) {
		super(context);
	}

	private String TABLE_DOMAIN = "processo"; 
	
	private String SQL_PROCESSO_PARTICIPANTES_INFORMACOES_BASICAS = "select processo._id, processo.numero, participante._id, participante.nome, participante.tipo_participante from processo as processo " +
																	"inner join processo_participante as participante on (processo._id = participante.id_processo)";
	
	public Collection<ProcessoMock> pesquisarProcessos() {
		
		Cursor cursor = getDataBase().rawQuery(SQL_PROCESSO_PARTICIPANTES_INFORMACOES_BASICAS, null);
		
		
		return null;
	}
		
}
