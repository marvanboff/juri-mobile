package br.unisinos.jurimobile.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.app.ListFragment;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import br.unisinos.jurimobile.R;
import br.unisinos.jurimobile.model.entity.Grupo;
import br.unisinos.jurimobile.model.entity.GrupoProcesso;
import br.unisinos.jurimobile.model.entity.Processo;
import br.unisinos.jurimobile.model.entity.ProcessoParticipante;
import br.unisinos.jurimobile.model.entity.TipoParticipante;
import br.unisinos.jurimobile.view.adapter.ProcessoListAdapter;
import br.unisinos.jurimobile.view.adapter.ProcessoListAdapter.ClickListener;

public class ProcessoListActivity extends Activity implements ClickListener{

	private RecyclerView recyclerView;
	private RecyclerView.Adapter<RecyclerView.ViewHolder> processoListAdapter;
	private RecyclerView.LayoutManager layoutManager;

	private DrawerLayout drawerLayout;
	private String[] options;
	private ListView drawerList;

	private ActionBarDrawerToggle drawerToggle;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.lista_processo);
		
		//Recyclerview
		recyclerView = (RecyclerView) findViewById(R.id.lista_processo_recycler_view);
		recyclerView.setHasFixedSize(true);

		layoutManager = new LinearLayoutManager(this);
		recyclerView.setLayoutManager(layoutManager);

		processoListAdapter = new ProcessoListAdapter(getMockProcessos());
		((ProcessoListAdapter)processoListAdapter).setClickListener(this);
		
		recyclerView.setAdapter(processoListAdapter);
		
		//Drawer
//		options = getResources().getStringArray(R.array.drawer_options);
		drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
		drawerList = (ListView) findViewById(R.id.processos_drawer);
		

		String[] de = { "labelName" };
		int[] para = { R.id.labelName };

		SimpleAdapter adapter = new SimpleAdapter(this, getMockGrupos(), R.layout.processos_drawer_item, de, para);
		drawerList.setAdapter(adapter);
//		drawerList.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,options));
		drawerList.setOnItemClickListener(new ProcessoDrawerItemClickListener());

		//Drawer Action Bar Icon
		ActionBar actionBar = getActionBar();
		actionBar.setDisplayHomeAsUpEnabled(true);
		actionBar.setHomeButtonEnabled(true);
		actionBar.setTitle(getTitle());
		
		
		drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.drawable.ic_drawer, R.string.drawer_open, R.string.drawer_close) {
			public void onDrawerClosed(View view) {
				super.onDrawerClosed(view);
				  getActionBar().setTitle(getTitle());
	              invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
			}

			public void onDrawerOpened(View drawerView) {
				super.onDrawerOpened(drawerView);
				getActionBar().setTitle(getTitle());
                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()

			}
		};

		drawerLayout.setDrawerListener(drawerToggle);

		getActionBar().setDisplayHomeAsUpEnabled(true);
		getActionBar().setHomeButtonEnabled(true);
	}
	
	@Override
	public void onClick(View view, Long itemId) {
		Intent intent = new Intent(this, ProcessoActivity.class);
		intent.putExtra(ProcessoActivity.NAME_PARAMETER_ID_PROCESSO, itemId);
		startActivity(intent);
	}
	
	/**
	 * Mantém sincronização entre Navigation Drawer e a ActionBar
	 */
	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		super.onPostCreate(savedInstanceState);

		// Sync the toggle state after onRestoreInstanceState has occurred.
		drawerToggle.syncState();
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		/*
		 * The action bar home/up action should open or close the drawer.
		 * mDrawerToggle will take care of this.
		 */
		if (drawerToggle.onOptionsItemSelected(item)) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	/**
	 * Mantém sincronização entre Navigation Drawer e a ActionBar
	 */
	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);
		drawerToggle.onConfigurationChanged(newConfig);
	}
	
	private class ProcessoDrawerItemClickListener implements android.widget.AdapterView.OnItemClickListener {

		String title = "Teste";
		
		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
			
			Fragment fragment = new ListFragment();
			
			getFragmentManager().beginTransaction().replace(R.id.content_frame, fragment).commit();
			
			setTitle(title);
			((ProcessoListAdapter)processoListAdapter).setProcessos(getMockProcessos(getMockProcessos()));
			drawerList.setItemChecked(position, true);
			drawerLayout.closeDrawer(drawerList);
		}
		
	}
	
	public List<Processo> getMockProcessos(List<Processo> processos) {
		List<Processo> reducedList = new ArrayList<Processo>(processos);
		reducedList.remove(1);
		reducedList.remove(2);
		return reducedList;
	}
	
	public static List<Processo> getMockProcessos() {
		List<Processo> processos = new ArrayList<>();

		// Ex: 9123782-66.2014.8.21.0033
		processos.add(new Processo(1l, "9123782-66.2014.8.10.0023", "Acidente de Transito", "Juizado Especial Cívil", "São Leopoldo", "Aguardando Audiência"));
		processos.add(new Processo(2l, "9135782-22.2015.1.11.0055", "Acidente de Transito", "2ª Vara Cível", "Canoas", "Turmas Recursais"));
		processos.add(new Processo(3l, "9165824-55.2014.12.21.0233", "Acidente de Transito", "10º Juizado Especial Cível", "Porto Alegre", "Concluso"));
		processos.add(new Processo(4l, "9165822-78.2014.6.1.8033", "Acidente de Transito", "Vara JEC", "Novo Hamburgo", "Turmas Recursais"));
		processos.add(new Processo(5l, "9165822-78.2014.6.1.8033", "Cobrança Aluguel", "2ª Vara Cível", "Novo Hamburgo", "Baixado"));

		processos.get(0).addParticipante((new ProcessoParticipante(1l, "João Carlos", "Autor", TipoParticipante.A)));
		processos.get(0).addParticipante((new ProcessoParticipante(2l, "Maria Silva", "Autor", TipoParticipante.A)));
		processos.get(0).addParticipante((new ProcessoParticipante(12l, "Cleber dos Reis", "Réu", TipoParticipante.P)));
		processos.get(1).addParticipante((new ProcessoParticipante(3l, "Rafael Prereira", "Autor", TipoParticipante.A)));
		processos.get(1).addParticipante((new ProcessoParticipante(4l, "José Emanuel", "Réu", TipoParticipante.P)));
		processos.get(2).addParticipante((new ProcessoParticipante(5l, "Ricardo Fonseca", "Autor", TipoParticipante.A)));
		processos.get(2).addParticipante((new ProcessoParticipante(6l, "José Antunes", "Réu", TipoParticipante.P)));
		processos.get(3).addParticipante((new ProcessoParticipante(7l, "Carlos Reis da Silva", "Autor", TipoParticipante.A)));
		processos.get(3).addParticipante((new ProcessoParticipante(8l, "Fabiano Pereira Campos", "Testemunha", TipoParticipante.O)));
		processos.get(3).addParticipante((new ProcessoParticipante(11l, "Emerson Silveira Flach", "Réu", TipoParticipante.P)));
		processos.get(3).addParticipante((new ProcessoParticipante(9l, "Joana Peixoto de Castro", "Réu", TipoParticipante.P)));
		processos.get(4).addParticipante((new ProcessoParticipante(10l, "Fernando Henrique Pereira", "Autor", TipoParticipante.A)));
		processos.get(4).addParticipante((new ProcessoParticipante(11l, "Jonas de Brito", "Réu", TipoParticipante.P)));
		processos.get(4).addParticipante((new ProcessoParticipante(8l, "Fabiano Pereira Campos", "Testemunha", TipoParticipante.O)));

		Grupo g1 = new Grupo(1l, "Reparação de Danos");
		Grupo g2 = new Grupo(2l, "Dr. Francisco");
		Grupo g3 = new Grupo(3l, "Recorrer");
		Grupo g4 = new Grupo(4l, "Recurso Pendente");
		Grupo g5 = new Grupo(5l, "Em Prazo");

		GrupoProcesso gp1 = new GrupoProcesso(1l, processos.get(0), g1);
		GrupoProcesso gp2 = new GrupoProcesso(2l, processos.get(0), g2);
		processos.get(0).addGrupo(gp1);
		processos.get(0).addGrupo(gp2);

		GrupoProcesso gp3 = new GrupoProcesso(3l, processos.get(1), g3);
		GrupoProcesso gp4 = new GrupoProcesso(4l, processos.get(1), g4);
		processos.get(1).addGrupo(gp3);
		processos.get(1).addGrupo(gp4);

		GrupoProcesso gp5 = new GrupoProcesso(5l, processos.get(2), g2);
		GrupoProcesso gp6 = new GrupoProcesso(6l, processos.get(2), g5);
		processos.get(2).addGrupo(gp5);
		processos.get(2).addGrupo(gp6);

		GrupoProcesso gp7 = new GrupoProcesso(7l, processos.get(3), g4);
		GrupoProcesso gp8 = new GrupoProcesso(8l, processos.get(4), g2);
		processos.get(3).addGrupo(gp7);
		processos.get(4).addGrupo(gp8);

		return processos;
	}
	
	private List<Map<String, Object>> getMockGrupos(){
		Grupo g1 = new Grupo(1l, "Reparação de Danos");
		Grupo g2 = new Grupo(2l, "Dr. Francisco");
		Grupo g3 = new Grupo(3l, "Recorrer");
		Grupo g4 = new Grupo(4l, "Recurso Pendente");
		Grupo g5 = new Grupo(5l, "Em Prazo");
		
		List<Map<String, Object>> grupos = new ArrayList<Map<String, Object>>();
		addMap(g1, grupos);
		addMap(g2, grupos);
		addMap(g3, grupos);
		addMap(g4, grupos);
		addMap(g5, grupos);
		
		return grupos;
	}

	private void addMap(Grupo g1, List<Map<String, Object>> grupos) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("labelName", g1.getNome());
		grupos.add(map);
	}

}
