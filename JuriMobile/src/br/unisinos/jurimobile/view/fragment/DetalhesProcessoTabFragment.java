package br.unisinos.jurimobile.view.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import br.unisinos.jurimobile.R;
import br.unisinos.jurimobile.controller.ProcessoActivity;
import br.unisinos.jurimobile.controller.ProcessoMainActivity;
import br.unisinos.jurimobile.model.entity.Processo;

public class DetalhesProcessoTabFragment extends Fragment {

	private Long idProcesso;

	private TextView numeroProcesso;
	private TextView estadoProcesso;
	private ListView listParticipantes;
	
	public DetalhesProcessoTabFragment(Long idProcesso) {
		this.idProcesso = idProcesso;
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
		
		Processo processo = ProcessoActivity.getProcesso(idProcesso);
		numeroProcesso = (TextView) contentTabView.findViewById(R.id.numeroProcesso_tab);
		estadoProcesso = (TextView) contentTabView.findViewById(R.id.estadoProcesso_tab);
		numeroProcesso.setText(processo.getNumero());
		estadoProcesso.setText(processo.getEstadoProcesso());
		
		loadListParticipantes(contentTabView, processo);
		
	}
	
	private void loadListParticipantes(View contentTabView, Processo processo) {
		String[] de = { "nomeParticipante", "tipoParticipacao" };
		int[] para = { R.id.nomeParticipante, R.id.tipoParticipacao };

		SimpleAdapter adapter = new SimpleAdapter(contentTabView.getContext(), ProcessoActivity.convertToMapParticipantes(processo.getParticipantes()), R.layout.participantes, de, para);
		listParticipantes = (ListView) contentTabView.findViewById(R.id.lista_participantes_tab);
		listParticipantes.setAdapter(adapter);
	}
	
}
