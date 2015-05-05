package br.unisinos.jurimobile.view.fragment;

import java.util.ArrayList;
import java.util.Collections;
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
import br.unisinos.jurimobile.controller.ProcessoMainActivity;
import br.unisinos.jurimobile.model.entity2.Processo;
import br.unisinos.jurimobile.model.entity2.ProcessoParticipante;

public class DetalhesProcessoTabFragment extends Fragment {

	private Processo processo;
	
	private TextView numero;
	private TextView assunto;
	private TextView situacao;
	private TextView comarca;
	private TextView orgaoJulgador;
	
	private ListView listParticipantes;
	
	public DetalhesProcessoTabFragment(){
		
	}
	
	public DetalhesProcessoTabFragment(Processo processo) {
		this.processo = processo;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View contentTabView = inflater.inflate(R.layout.detalhes_processo_fragment_tab, container, false);
		
		int primary = getResources().getColor(R.color.primary);
//		EditText inputNumeroProcesso = (EditText) rootView.findViewById(R.id.inputNumeroProcesso);
//		inputNumeroProcesso.getBackground().setColorFilter(primary, PorterDuff.Mode.SRC_IN);
		
		if(processo == null){
			processo = ((ProcessoMainActivity)getActivity()).getProcesso();
		}
		carregarProcesso(contentTabView);
		
		return contentTabView;
	}
	
	public void carregarProcesso(View contentTabView){
		
		numero = (TextView) contentTabView.findViewById(R.id.numeroProcesso);
		orgaoJulgador = (TextView) contentTabView.findViewById(R.id.orgaoJulgador);
		assunto = (TextView) contentTabView.findViewById(R.id.assunto);
		situacao = (TextView) contentTabView.findViewById(R.id.situacaoProcesso);
		comarca = (TextView) contentTabView.findViewById(R.id.comarca);
		
		numero.setText(processo.getNumero());
		orgaoJulgador.setText(processo.getOrgaoJulgador());
		assunto.setText(processo.getAssunto());
		situacao.setText(processo.getSituacao());
		comarca.setText(processo.getComarca());
		
		loadListParticipantes(contentTabView, processo);
		
	}
	
	private void loadListParticipantes(View contentTabView, Processo processo) {
		String[] de = { "nomeParticipante", "tipoParticipacao" };
		int[] para = { R.id.nomeParticipante, R.id.tipoParticipacao };

		SimpleAdapter adapter = new SimpleAdapter(contentTabView.getContext(), convertToMapParticipantes(processo.getParticipantes()), R.layout.participantes, de, para);
		listParticipantes = (ListView) contentTabView.findViewById(R.id.lista_participantes);
		listParticipantes.setAdapter(adapter);
	}
	
	public static List<Map<String, Object>> convertToMapParticipantes(List<ProcessoParticipante> participantes){
		List<Map<String, Object>> mapParticipantes = new ArrayList<Map<String, Object>>();
		
		Collections.sort(participantes);
		
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
