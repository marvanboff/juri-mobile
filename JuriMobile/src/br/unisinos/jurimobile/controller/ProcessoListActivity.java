package br.unisinos.jurimobile.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.Toolbar.OnMenuItemClickListener;
import android.view.MenuItem;
import android.view.View;
import br.unisinos.jurimobile.R;
import br.unisinos.jurimobile.model.entity.Grupo;
import br.unisinos.jurimobile.model.entity.Processo;
import br.unisinos.jurimobile.model.entity.ProcessoParticipante;
import br.unisinos.jurimobile.model.entity.TipoParticipante;
import br.unisinos.jurimobile.view.adapter.ProcessoListAdapter.ClickListener;
import br.unisinos.jurimobile.view.fragment.FragmentCallBack;
import br.unisinos.jurimobile.view.fragment.NavigationDrawerFragment;
import br.unisinos.jurimobile.view.fragment.RecyclerViewMeusProcessosFragment;

public class ProcessoListActivity extends ActionBarActivity implements ClickListener, FragmentCallBack {

	private Toolbar toolBar;
	private NavigationDrawerFragment navigationDrawerFragment;
	private RecyclerViewMeusProcessosFragment recyclerViewFragment;

	@Override
	protected void onCreate(Bundle bundle) {
		super.onCreate(bundle);
		setContentView(R.layout.lista_processo);
		
		toolBar = (Toolbar) findViewById(R.id.lista_processo_toolbar);
		toolBar.setTitle(R.string.meusProcessos);
//		setSupportActionBar(toolBar);
//		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		
		
		addMenuToolbar(toolBar);
		loadViewComponents();
		loadInfoDrawerMenu();
		
		// Recyclerview
//		recyclerView = (RecyclerView) findViewById(R.id.lista_processo_recycler_view);
//		recyclerView.setHasFixedSize(true);
		
//		View linearLayout = findViewById(R.id.lista_processo_content);
		
//		layoutManager = new LinearLayoutManager(this);
//		recyclerView.setLayoutManager(layoutManager);
//
//		processoListAdapter = new ProcessoListAdapter(getMockProcessos());
//		((ProcessoListAdapter) processoListAdapter).setClickListener(this);
//
//		recyclerView.setAdapter(processoListAdapter);

		/*navigationDrawerFragment = new NavigationDrawerFragment();
		navigationDrawerFragment.setArguments(bundle);

		FragmentManager manager = getSupportFragmentManager();
		FragmentTransaction transaction = manager.beginTransaction();
		transaction.replace(R.id.grupos_processo_navigation_drawer, navigationDrawerFragment);
		transaction.addToBackStack(null);
		transaction.commit();*/
		
		
	}
	
	private void addMenuToolbar(Toolbar toolBar) {
		toolBar.setOnMenuItemClickListener(new OnMenuItemClickListener() {

			@Override
			public boolean onMenuItemClick(MenuItem itemMenu) {
				startActivity(new MenuIntent().resolve(getApplicationContext(), itemMenu));
				return true;
			}
		});

		toolBar.inflateMenu(R.menu.navigation_menu);
		toolBar.getMenu().removeItem(R.id.meus_processos_item_menu);
	}


	private void loadViewComponents() {
		recyclerViewFragment = (RecyclerViewMeusProcessosFragment) getSupportFragmentManager().findFragmentById(R.id.lista_processo_recycler_view);
		navigationDrawerFragment = (NavigationDrawerFragment) getSupportFragmentManager().findFragmentById(R.id.grupos_processo_navigation_drawer);
		
		navigationDrawerFragment.registerCallBack(this);
//		toolBar = (Toolbar) findViewById(R.id.screen_default_toolbar);
	}
	
	//TODO mudar implementação para fragments https://developer.android.com/guide/components/fragments.html
	@Override
	public void onSelectedItem(int position) {
		Grupo grupo = getGruposMock().get(position);
		if(grupo.getProcessos() == null){
			grupo.setProcessos(getMockProcessos());
		}
		recyclerViewFragment.realoadRecycler(grupo.getProcessos());
		
	}

	private void loadInfoDrawerMenu() {
		navigationDrawerFragment.setUp(R.id.content_frame_drawer, (DrawerLayout) findViewById(R.id.processos_drawer_layout), toolBar);
	}

	@Override
	public void onClick(View view, Long itemId) {
		Intent intent = new Intent(this, ProcessoActivity.class);
		intent.putExtra(ProcessoActivity.NAME_PARAMETER_ID_PROCESSO, itemId);
		startActivity(intent);
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

		/*
		 * Grupo g1 = new Grupo(1l, "Reparação de Danos"); Grupo g2 = new
		 * Grupo(2l, "Dr. Francisco"); Grupo g3 = new Grupo(3l, "Recorrer");
		 * Grupo g4 = new Grupo(4l, "Recurso Pendente"); Grupo g5 = new
		 * Grupo(5l, "Em Prazo");
		 * 
		 * GrupoProcesso gp1 = new GrupoProcesso(1l, processos.get(0), g1);
		 * GrupoProcesso gp2 = new GrupoProcesso(2l, processos.get(0), g2);
		 * processos.get(0).addGrupo(gp1); processos.get(0).addGrupo(gp2);
		 * 
		 * GrupoProcesso gp3 = new GrupoProcesso(3l, processos.get(1), g3);
		 * GrupoProcesso gp4 = new GrupoProcesso(4l, processos.get(1), g4);
		 * processos.get(1).addGrupo(gp3); processos.get(1).addGrupo(gp4);
		 * 
		 * GrupoProcesso gp5 = new GrupoProcesso(5l, processos.get(2), g2);
		 * GrupoProcesso gp6 = new GrupoProcesso(6l, processos.get(2), g5);
		 * processos.get(2).addGrupo(gp5); processos.get(2).addGrupo(gp6);
		 * 
		 * GrupoProcesso gp7 = new GrupoProcesso(7l, processos.get(3), g4);
		 * GrupoProcesso gp8 = new GrupoProcesso(8l, processos.get(4), g2);
		 * processos.get(3).addGrupo(gp7); processos.get(4).addGrupo(gp8);
		 */

		return processos;
	}

	public static List<Grupo> getGruposMock() {
		Grupo todos = new Grupo(null, "Todos");
		Grupo g1 = new Grupo(1l, "Reparação de Danos");
		Grupo g2 = new Grupo(2l, "Dr. Francisco");
		Grupo g3 = new Grupo(3l, "Recorrer");
		Grupo g4 = new Grupo(4l, "Recurso Pendente");
		Grupo g5 = new Grupo(5l, "Em Prazo");
		
		List<Grupo> grupos = new ArrayList<Grupo>();

		List<Processo> processos = getMockProcessos();
		
		g1.addProcesso(processos.get(0));

		g2.addProcesso(processos.get(0));
		g2.addProcesso(processos.get(2));
		g2.addProcesso(processos.get(4));

		g3.addProcesso(processos.get(1));

		g4.addProcesso(processos.get(1));
		g4.addProcesso(processos.get(3));

		g5.addProcesso(processos.get(2));

		grupos.add(todos);
		grupos.add(g1);
		grupos.add(g2);
		grupos.add(g3);
		grupos.add(g4);
		grupos.add(g5);

		return grupos;
	}

	public static List<Map<String, Object>> getMockGrupos() {
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

	private static void addMap(Grupo g1, List<Map<String, Object>> grupos) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("labelName", g1.getNome());
		grupos.add(map);
	}

}
