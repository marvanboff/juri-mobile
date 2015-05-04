package br.unisinos.jurimobile.view.fragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import br.unisinos.jurimobile.R;
import br.unisinos.jurimobile.model.entity2.Processo;
import br.unisinos.jurimobile.model.entity2.ProcessoParticipante;

public class DetalhesProcessoTabFragment extends Fragment {

	private Processo processo;

	private TextView numeroProcesso;
	private TextView estadoProcesso;
	private ListView listParticipantes;
	
	public DetalhesProcessoTabFragment(Processo processo) {
		this.processo = processo;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View contentTabView = inflater.inflate(R.layout.detalhes_processo_fragment_tab, container, false);
		
		int primary = getResources().getColor(R.color.primary);
//		EditText inputNumeroProcesso = (EditText) rootView.findViewById(R.id.inputNumeroProcesso);
//		inputNumeroProcesso.getBackground().setColorFilter(primary, PorterDuff.Mode.SRC_IN);
		
		carregarProcesso(contentTabView);
		
		return contentTabView;
	}
	
	public void carregarProcesso(View contentTabView){
		
		numeroProcesso = (TextView) contentTabView.findViewById(R.id.numeroProcesso_tab);
		estadoProcesso = (TextView) contentTabView.findViewById(R.id.estadoProcesso_tab);
		numeroProcesso.setText(processo.getNumero());
		estadoProcesso.setText(processo.getSituacao());
		
		loadListParticipantes(contentTabView, processo);
		
	}
	
	private void loadListParticipantes(View contentTabView, Processo processo) {
		String[] de = { "nomeParticipante", "tipoParticipacao" };
		int[] para = { R.id.nomeParticipante, R.id.tipoParticipacao };

		SimpleAdapter adapter = new SimpleAdapter(contentTabView.getContext(), convertToMapParticipantes(processo.getParticipantes()), R.layout.participantes, de, para);
		listParticipantes = (ListView) contentTabView.findViewById(R.id.lista_participantes_tab);
		listParticipantes.setAdapter(adapter);
	}
	
	public static List<Map<String, Object>> convertToMapParticipantes(List<ProcessoParticipante> participantes){
		List<Map<String, Object>> mapParticipantes = new ArrayList<Map<String, Object>>();
		
		for (ProcessoParticipante participante : participantes) {
			addMap(participante, mapParticipantes);
		}
		
		return mapParticipantes;
	}
	
	private static void addMap(ProcessoParticipante participante, List<Map<String, Object>> participantes) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("tipoParticipacao", participante.getTipoParticipacao());
		map.put("nomeParticipante", participante.getNome());
		participantes.add(map);
	}
}
