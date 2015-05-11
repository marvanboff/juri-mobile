package br.unisinos.jurimobile.view.fragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import br.unisinos.jurimobile.R;
import br.unisinos.jurimobile.controller.ProcessoMainActivity;
import br.unisinos.jurimobile.model.entity2.Processo;
import br.unisinos.jurimobile.model.entity2.ProcessoMovimento;

public class MovimentacoesProcessoTabFragment extends Fragment {
	
	private Processo processo;

	public MovimentacoesProcessoTabFragment() {
	}

	
	public MovimentacoesProcessoTabFragment(Processo processo) {
		this.processo = processo;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View contentTabView = inflater.inflate(R.layout.movimentacoes_processo_fragment_tab, container, false);
		
		int primary = getResources().getColor(R.color.primary);
//		EditText inputNome = (EditText) rootView.findViewById(R.id.inputNome);
//		inputNome.getBackground().setColorFilter(primary, PorterDuff.Mode.SRC_IN);
		
		if(processo == null){
			processo = ((ProcessoMainActivity)getActivity()).getProcesso();
		}
		carregarMovimentacoes(contentTabView, processo.getMovimentacoes());
		
		return contentTabView;
	}

	private void carregarMovimentacoes(View contentTabView, List<ProcessoMovimento> mockMovimentacao) {
		// TODO Auto-generated method stub
		
			String[] de = { "descricaoMovimento" };
			int[] para = { R.id.descricaoMovimento};
			
			SimpleAdapter adapter = new SimpleAdapter(contentTabView.getContext(), convertToMapMovimentos(mockMovimentacao), R.layout.movimentos, de, para);
			ListView listView = (ListView) contentTabView.findViewById(R.id.movimentacoes);
			
			listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){

				@Override
				public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
					createAlertDialog(position);
				}
				
			});
			
			listView.setAdapter(adapter);
		
	}
	
	private void createAlertDialog(int position) {
		ProcessoMovimento processoMovimento = processo.getMovimentacoes().get(position);
		String textoAjuda = processoMovimento.getTextoAjuda();
		String descricaoCNJ = processoMovimento.getDescricaoCNJ();
		
		if(textoAjuda != null){
			AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
			builder.setTitle(descricaoCNJ);
			builder.setMessage(textoAjuda);
			
			builder.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
	               @Override
	               public void onClick(DialogInterface dialog, int id) {
	            	   dialog.cancel();
	               }
			});
			
			builder.show();
		}
	}
	
	public static List<Map<String, Object>> convertToMapMovimentos(List<ProcessoMovimento> movimentos){
		List<Map<String, Object>> mapMovimentos = new ArrayList<Map<String, Object>>();
		
		for (ProcessoMovimento movimento : movimentos) {
			addMap(movimento, mapMovimentos);
		}
		
		return mapMovimentos;
	}
	
	private static void addMap(ProcessoMovimento processoMovimento, List<Map<String, Object>> participantes) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("descricaoMovimento", processoMovimento.toString());
		participantes.add(map);
	}
	
}
