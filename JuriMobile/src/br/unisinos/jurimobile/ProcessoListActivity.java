package br.unisinos.jurimobile;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import br.unisinos.jurimobile.adapter.ProcessoListAdapter;
import br.unisinos.jurimobile.model.Processo;

public class ProcessoListActivity extends Activity {

	private RecyclerView mRecyclerView;
	private RecyclerView.Adapter mAdapter;
	private RecyclerView.LayoutManager mLayoutManager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.lista_processo);
		mRecyclerView = (RecyclerView) findViewById(R.id.lista_processo_recycler_view);
		
		// use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);
        
        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter (see also next example)
        mAdapter = new ProcessoListAdapter(getMockProcessos());
        mRecyclerView.setAdapter(mAdapter);
	}
	
	public List<Processo> getMockProcessos(){
		List<Processo> processos = new ArrayList<>();
		
		//Ex: 9123782-66.2014.8.21.0033
		processos.add(new Processo(1l, "9123782-66.2014.8.10.0023", "Acidente de Transito", "Comarca de São Leopoldo"));
		processos.add(new Processo(2l, "9135782-22.2015.1.11.0055", "Acidente de Transito", "Comarca de Canoas"));
		processos.add(new Processo(3l, "9165824-55.2014.12.21.0233", "Acidente de Transito", "Comarca de Patenon"));
		processos.add(new Processo(4l, "9165822-78.2014.6.1.8033", "Acidente de Transito", "Comarca de Novo Hamburgo"));
		
		return processos;
	}
	
}
