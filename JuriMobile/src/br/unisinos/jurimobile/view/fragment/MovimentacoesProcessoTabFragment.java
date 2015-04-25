package br.unisinos.jurimobile.view.fragment;

import java.util.List;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import br.unisinos.jurimobile.R;
import br.unisinos.jurimobile.controller.ProcessoActivity;
import br.unisinos.jurimobile.model.entity.ProcessoMovimento;

public class MovimentacoesProcessoTabFragment extends Fragment {
	
	private Long idProcesso;

	public MovimentacoesProcessoTabFragment(Long idProcesso) {
		this.idProcesso = idProcesso;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View contentTabView = inflater.inflate(R.layout.movimentacoes_processo_fragment_tab, container, false);
		
		int primary = getResources().getColor(R.color.primary);
//		EditText inputNome = (EditText) rootView.findViewById(R.id.inputNome);
//		inputNome.getBackground().setColorFilter(primary, PorterDuff.Mode.SRC_IN);
		
		carregarMovimentacoes(contentTabView, ProcessoMovimento.getMockMovimentacao(false));
		
		return contentTabView;
	}

	private void carregarMovimentacoes(View contentTabView, List<ProcessoMovimento> mockMovimentacao) {
		// TODO Auto-generated method stub
		
			String[] de = { "descricaoMovimento" };
			int[] para = { R.id.descricaoMovimento};
			
			SimpleAdapter adapter = new SimpleAdapter(contentTabView.getContext(), ProcessoActivity.convertToMapMovimentos(mockMovimentacao), R.layout.movimentos, de, para);
			ListView listView = (ListView) contentTabView.findViewById(R.id.movimentacoes);
			listView.setAdapter(adapter);
		
	}

}
