package br.unisinos.jurimobile.mode.dao;

import android.content.ContentValues;
import android.content.Context;
import br.unisinos.jurimobile.model.entity2.Advogado;
import br.unisinos.jurimobile.model.entity2.ProcessoParticipanteAdvogado;

public class AdvogadoDAO extends JuriMobileDAO {

	private enum ProcessoParticipanteAdvogadoColumns {

		_id, id_participante, id_advogado, data_ult_atualizacao;

		public static String getTableName() {
			return "processo_participante_advogado";
		}
	}

	private enum AdvogadoColumns {

		_id, nome, numero_oab, data_ult_atualizacao;

		public static String getTableName() {
			return "advogado";
		}
	}

	public AdvogadoDAO(Context context) {
		super(context);
	}

	public Advogado insert(Advogado advogado) {

		ContentValues values = new ContentValues();
		values.put(AdvogadoColumns.nome.name(), advogado.getNome());
		values.put(AdvogadoColumns.numero_oab.name(), advogado.getNumeroOAB());

		Long idAdvogado = getDataBaseWrite().insert(AdvogadoColumns.getTableName(), null, values);
		advogado.setId(idAdvogado);
		return advogado;
	}

	public ProcessoParticipanteAdvogado insert(ProcessoParticipanteAdvogado participanteAdvogado) {

		ContentValues values = new ContentValues();
		values.put(ProcessoParticipanteAdvogadoColumns.id_participante.name(), participanteAdvogado.getParticipante().getId());
		values.put(ProcessoParticipanteAdvogadoColumns.id_advogado.name(), participanteAdvogado.getAdvogado().getId());

		Long idParticipanteAdvogado = getDataBaseWrite().insert(ProcessoParticipanteAdvogadoColumns.getTableName(), null, values);
		participanteAdvogado.setId(idParticipanteAdvogado);
		return participanteAdvogado;
	}
	
	public void delete(Advogado advogado){
		getDataBaseWrite().delete(AdvogadoColumns.getTableName(), AdvogadoColumns._id.name() + " = ? ", new String[] {advogado.getId().toString()});
	}
	
	public void delete(ProcessoParticipanteAdvogado participanteAdvogado){
		getDataBaseWrite().delete(ProcessoParticipanteAdvogadoColumns.getTableName(), ProcessoParticipanteAdvogadoColumns._id.name() + " = ? ", new String[] {participanteAdvogado.getId().toString()});
	}
	
}
