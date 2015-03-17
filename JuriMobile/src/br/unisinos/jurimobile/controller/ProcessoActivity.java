package br.unisinos.jurimobile.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import br.unisinos.jurimobile.R;
import br.unisinos.jurimobile.model.entity.Processo;
import br.unisinos.jurimobile.model.entity.ProcessoMovimento;
import br.unisinos.jurimobile.model.entity.ProcessoParticipante;

public class ProcessoActivity extends ActionBarActivity{

	public final static String NAME_PARAMETER_ID_PROCESSO = "processo_id";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.processo);
		
		Long idProcesso = this.getIntent().getExtras().getLong(NAME_PARAMETER_ID_PROCESSO);
		Processo processo = getProcesso(idProcesso);
		
		Toolbar toolBar = (Toolbar) findViewById(R.id.processo_toolbar);
		setSupportActionBar(toolBar);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		
		TextView numeroProcesso = (TextView) findViewById(R.id.numeroProcesso);
		TextView estadoProcesso = (TextView) findViewById(R.id.estadoProcesso);
		numeroProcesso.setText(processo.getNumero());
		estadoProcesso.setText(processo.getEstadoProcesso());
		
		loadListParticipantes(processo);
		loadListMovimentacao(ProcessoMovimento.getMockMovimentacao(true));
		
		TextView titleMovimentacoes = (TextView) findViewById(R.id.titleMovimentacoes);
		titleMovimentacoes.setOnClickListener(new OnClickListener(){
			
			@Override
			public void onClick(View v) {
				startActivity(new Intent(getApplicationContext(), MovimentoActivity.class));
			}
			
		});
		
	}
	
	//TODO Colocar em uma interface, ou base activity
	public Intent getAplicationParentActivityIntent() {
		return new Intent(this, ProcessoListActivity.class);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	    switch (item.getItemId()) {
	    // Respond to the action bar's Up/Home button
	    case android.R.id.home:
	        Intent upIntent = NavUtils.getParentActivityIntent(this);
	        if(upIntent == null){
	        	upIntent = getAplicationParentActivityIntent();
	        }
	        if (NavUtils.shouldUpRecreateTask(this, upIntent)) {
	            // This activity is NOT part of this app's task, so create a new task
	            // when navigating up, with a synthesized back stack.
	            TaskStackBuilder.create(this)
	                    // Add all of this activity's parents to the back stack
	                    .addNextIntentWithParentStack(upIntent)
	                    // Navigate up to the closest parent
	                    .startActivities();
	        } else {
	            // This activity is part of this app's task, so simply
	            // navigate up to the logical parent activity.
	            NavUtils.navigateUpTo(this, upIntent);
	        }
	        return true;
	    }
	    return super.onOptionsItemSelected(item);
	}
	
	private void loadListMovimentacao(List<ProcessoMovimento> mockMovimentacao) {
		String[] de = { "descricaoMovimento" };
		int[] para = { R.id.descricaoMovimento};

		SimpleAdapter adapter = new SimpleAdapter(this, convertToMapMovimentos(mockMovimentacao), R.layout.movimentos, de, para);
		ListView listView = (ListView) findViewById(R.id.movimentacoes);
		listView.setAdapter(adapter);
	}

	private void loadListParticipantes(Processo processo) {
		String[] de = { "nomeParticipante", "tipoParticipacao" };
		int[] para = { R.id.nomeParticipante, R.id.tipoParticipacao };

		SimpleAdapter adapter = new SimpleAdapter(this, convertToMapParticipantes(processo.getParticipantes()), R.layout.participantes, de, para);
		ListView listView = (ListView) findViewById(R.id.lista_participantes);
		listView.setAdapter(adapter);
	}

	public Processo getProcesso(Long idProcesso){
		if(idProcesso == null){
			idProcesso = 4l;
		}
		for (Processo processo : ProcessoListActivity.getMockProcessos()) {
			if(processo.getId().equals(idProcesso)){
				return processo;
			}
		}
		return null;
		
	}
	
	private List<Map<String, Object>> convertToMapMovimentos(List<ProcessoMovimento> movimentos){
		List<Map<String, Object>> mapMovimentos = new ArrayList<Map<String, Object>>();
		
		for (ProcessoMovimento movimento : movimentos) {
			addMap(movimento, mapMovimentos);
		}
		
		return mapMovimentos;
	}
	
	private List<Map<String, Object>> convertToMapParticipantes(List<ProcessoParticipante> participantes){
		List<Map<String, Object>> mapParticipantes = new ArrayList<Map<String, Object>>();
		
		for (ProcessoParticipante participante : participantes) {
			addMap(participante, mapParticipantes);
		}
		
		return mapParticipantes;
	}
	
	private void addMap(ProcessoParticipante participante, List<Map<String, Object>> participantes) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("tipoParticipacao", participante.getTipoParticipacao());
		map.put("nomeParticipante", participante.getNome());
		participantes.add(map);
	}
	
	private void addMap(ProcessoMovimento processoMovimento, List<Map<String, Object>> participantes) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("descricaoMovimento", processoMovimento.toString());
		participantes.add(map);
	}
	
}
