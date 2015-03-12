package br.unisinos.jurimobile.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.SimpleAdapter;
import br.unisinos.jurimobile.R;
import br.unisinos.jurimobile.model.entity.ProcessoMovimento;

public class MovimentoActivity extends ListActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
//		setContentView(R.layout.movimentos);
		
//		setListAdapter(new ArrayAdapter<ProcessoMovimento>(this, android.R.layout.simple_list_item_1, ProcessoMovimento.getMockMovimentacao(false)));
		
		loadListMovimentacao(ProcessoMovimento.getMockMovimentacao(false));
	}
	
	
	private void loadListMovimentacao(List<ProcessoMovimento> mockMovimentacao) {
		String[] de = {  "descricaoMovimento" };
		int[] para = {  R.id.descricaoMovimento};

		SimpleAdapter adapter = new SimpleAdapter(this, convertToMapMovimentos(mockMovimentacao), R.layout.movimentos, de, para);
		getListView().setAdapter(adapter);
	}
	
	private List<Map<String, Object>> convertToMapMovimentos(List<ProcessoMovimento> movimentos){
		List<Map<String, Object>> mapMovimentos = new ArrayList<Map<String, Object>>();
		
		for (ProcessoMovimento movimento : movimentos) {
			addMap(movimento, mapMovimentos);
		}
		
		return mapMovimentos;
	}
	
	private void addMap(ProcessoMovimento processoMovimento, List<Map<String, Object>> participantes) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("descricaoMovimento", processoMovimento.toString());
		participantes.add(map);
	}
	
}
