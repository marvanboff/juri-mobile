package br.unisinos.jurimobile.mode.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import android.content.Context;
import android.database.Cursor;
import br.unisinos.jurimobile.model.entity.TipoParticipante;
import br.unisinos.jurimobile.model.entity.mock.ProcessoMock;
import br.unisinos.jurimobile.model.entity.mock.ProcessoParticipanteMock;

public class ProcessoMockDAO extends JuriMobileDAO {
	
	private String SQL_PROCESSO_PARTICIPANTES_INFORMACOES_BASICAS = "select processo._id, processo.numero, participante._id, participante.nome, participante.tipo_participante from processo_mock as processo " +
			"inner join processo_participante_mock as participante on (processo._id = participante.id_processo)";
	
	public ProcessoMockDAO(Context context) {
		super(context);
	}

	public Collection<ProcessoMock> pesquisarProcessos(String nome, String numeroProcesso) {
		
		StringBuilder sql = new StringBuilder(SQL_PROCESSO_PARTICIPANTES_INFORMACOES_BASICAS);
		List<Parametro> parametros = montaClausulaWhere(nome, numeroProcesso);
		
		//TODO COMENTADO PARA TESTE
//		addWhereExpression(sql, parametros);
//		List<String> arguments = extractArguments(parametros);
		
//		Cursor cursor = getDataBase().rawQuery(sql.toString(), arguments.toArray(new String[arguments.size()]));
		Cursor cursor = getDataBase().rawQuery(sql.toString(), null);
		
		Map<Long, ProcessoMock> mapProcessos = new HashMap<Long, ProcessoMock>();
		while (cursor.moveToNext()) {
			extrairProcesso(cursor, mapProcessos);
		}
		
		cursor.close();
		return mapProcessos.values();
	}

	private List<String> extractArguments(List<Parametro> parametros) {
		List<String> arguments = new ArrayList<String>();
		for (Parametro parametro : parametros) {
			arguments.add(parametro.getValue());
		}
		return arguments;
	}

	private void addWhereExpression(StringBuilder sql, List<Parametro> parametros) {
		int countParameters = 0;
		for (Parametro parametro : parametros) {
			if(countParameters < 1){
				sql.append(" where ");
			}else{
				sql.append(" and ");
			}
			sql.append(parametro.getSql());
		}
	}


	private List<Parametro> montaClausulaWhere(String nome, String numeroProcesso) {
		
		List<Parametro> parametros = new ArrayList<Parametro>();
		
		if(StringUtils.isNotBlank(nome)){
			String[] splitNome = nome.split(" ");
			
			for (String nameFragment : splitNome) {
				parametros.add(new Parametro(" participante.nome like ? ", "%"+nameFragment+"%"));
			}
			
		}else if(StringUtils.isNotBlank(numeroProcesso)){
			parametros.add(new Parametro(" processo.numero like ? ", "%"+numeroProcesso+"%"));
		}
		return parametros;
	}


	private void extrairProcesso(Cursor cursor, Map<Long, ProcessoMock> mapProcessos) {
		Long idProcesso = cursor.getLong(0);
		
		ProcessoMock processoMock = null;
		if(mapProcessos.containsKey(idProcesso)){
			processoMock = mapProcessos.get(idProcesso);
		}else{
			processoMock = new ProcessoMock(idProcesso, cursor.getString(1));
			mapProcessos.put(idProcesso, processoMock);
		}
		
		extrairParticipante(cursor, processoMock);
	}


	private void extrairParticipante(Cursor cursor, ProcessoMock processoMock) {
		processoMock.addParticipante(new ProcessoParticipanteMock(cursor.getLong(2), cursor.getString(3), TipoParticipante.valueOf(cursor.getString(4))));
	}
	
	
}
