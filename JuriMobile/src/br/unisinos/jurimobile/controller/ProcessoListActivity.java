package br.unisinos.jurimobile.controller;

import java.util.ArrayList;
import java.util.List;

import android.app.ActionBar;
import android.app.Activity;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import br.unisinos.jurimobile.R;
import br.unisinos.jurimobile.model.entity.Grupo;
import br.unisinos.jurimobile.model.entity.GrupoProcesso;
import br.unisinos.jurimobile.model.entity.Processo;
import br.unisinos.jurimobile.model.entity.ProcessoParticipante;
import br.unisinos.jurimobile.view.adapter.ProcessoListAdapter;

public class ProcessoListActivity extends Activity {

	private RecyclerView recyclerView;
	private RecyclerView.Adapter<ProcessoListAdapter.RecyclerViewHolder> adapter;
	private RecyclerView.LayoutManager layoutManager;

	private DrawerLayout drawerLayout;
	private String[] options;
	private ListView drawerList;

	private ActionBarDrawerToggle drawerToggle;
    private ActionBarHelper mActionBar;

	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.lista_processo);
		recyclerView = (RecyclerView) findViewById(R.id.lista_processo_recycler_view);

		recyclerView.setHasFixedSize(true);

		layoutManager = new LinearLayoutManager(this);
		recyclerView.setLayoutManager(layoutManager);

		adapter = new ProcessoListAdapter(getMockProcessos());
		recyclerView.setAdapter(adapter);

		
		options = getResources().getStringArray(R.array.drawer_options);

		drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
		drawerList = (ListView) findViewById(R.id.processos_drawer);
		drawerList.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,options));
		
		
	   mActionBar = createActionBarHelper();
       mActionBar.init();
        
       drawerToggle = new ActionBarDrawerToggle(
                this,               
                drawerLayout,       
                R.drawable.ic_drawer,
                R.string.drawer_open,  
                R.string.drawer_close   
                ) {
			public void onDrawerClosed(View view) {
				super.onDrawerClosed(view);
//				getSupportActionBar().setTitle("onDrawerClosed");
//				supportInvalidateOptionsMenu();
			}

			public void onDrawerOpened(View drawerView) {
				super.onDrawerOpened(drawerView);
//				getSupportActionBar().setTitle("onDrawerOpened");
//				supportInvalidateOptionsMenu();
			}
        };
        
        drawerLayout.setDrawerListener(drawerToggle);
		
	}
	
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

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        drawerToggle.onConfigurationChanged(newConfig);
    }
	
	public List<Processo> getMockProcessos() {
		List<Processo> processos = new ArrayList<>();

		// Ex: 9123782-66.2014.8.21.0033
		processos.add(new Processo(1l, "9123782-66.2014.8.10.0023",
				"Acidente de Transito", "Comarca de São Leopoldo",
				"Aguardando Audiência"));
		processos
				.add(new Processo(2l, "9135782-22.2015.1.11.0055",
						"Acidente de Transito", "Comarca de Canoas",
						"Turmas Recursais"));
		processos.add(new Processo(3l, "9165824-55.2014.12.21.0233",
				"Acidente de Transito", "Comarca de Patenon", "Concluso"));
		processos.add(new Processo(4l, "9165822-78.2014.6.1.8033",
				"Acidente de Transito", "Comarca de Novo Hamburgo",
				"Turmas Recursais"));
		processos.add(new Processo(5l, "9165822-78.2014.6.1.8033",
				"Cobrança Aluguel", "Comarca de Novo Hamburgo", "Baixado"));

		processos.get(0).addParticipante(
				(new ProcessoParticipante(1l, "João Carlos")));
		processos.get(0).addParticipante(
				(new ProcessoParticipante(2l, "Maria Silva")));
		processos.get(0).addParticipante(
				(new ProcessoParticipante(12l, "Cleber dos Reis")));
		processos.get(1).addParticipante(
				(new ProcessoParticipante(3l, "Rafael Prereira")));
		processos.get(1).addParticipante(
				(new ProcessoParticipante(4l, "José Emanuel")));
		processos.get(2).addParticipante(
				(new ProcessoParticipante(5l, "Ricardo Fonseca")));
		processos.get(2).addParticipante(
				(new ProcessoParticipante(6l, "José Antunes")));
		processos.get(3).addParticipante(
				(new ProcessoParticipante(7l, "Carlos Reis da Silva")));
		processos.get(3).addParticipante(
				(new ProcessoParticipante(8l, "Fabiano Pereira Campos")));
		processos.get(3).addParticipante(
				(new ProcessoParticipante(11l, "Emerson Silveira Flach")));
		processos.get(3).addParticipante(
				(new ProcessoParticipante(9l, "Joana Peixoto de Castro")));
		processos.get(4).addParticipante(
				(new ProcessoParticipante(10l, "Fernando Henrique Pereira")));
		processos.get(4).addParticipante(
				(new ProcessoParticipante(11l, "Jonas de Brito")));
		processos.get(4).addParticipante(
				(new ProcessoParticipante(8l, "Fabiano Pereira Campos")));

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
	
	/** ACTION BAR */
	
	/**
     * Create a compatible helper that will manipulate the action bar if available.
     */
    private ActionBarHelper createActionBarHelper() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.ICE_CREAM_SANDWICH) {
            return new ActionBarHelperICS();
        } else {
            return new ActionBarHelper();
        }
    }

    /**
     * Stub action bar helper; this does nothing.
     */
    private class ActionBarHelper {
        public void init() {}
        public void onDrawerClosed() {}
        public void onDrawerOpened() {}
        public void setTitle(CharSequence title) {}
    }

    /**
     * Action bar helper for use on ICS and newer devices.
     */
    private class ActionBarHelperICS extends ActionBarHelper {
        private final ActionBar mActionBar;
        private CharSequence mDrawerTitle;
        private CharSequence mTitle;

        ActionBarHelperICS() {
            mActionBar = getActionBar();
        }

        @Override
        public void init() {
            mActionBar.setDisplayHomeAsUpEnabled(true);
            mActionBar.setHomeButtonEnabled(true);
            mTitle = mDrawerTitle = getTitle();
        }

        /**
         * When the drawer is closed we restore the action bar state reflecting
         * the specific contents in view.
         */
        @Override
        public void onDrawerClosed() {
            super.onDrawerClosed();
            mActionBar.setTitle(mTitle);
        }

        /**
         * When the drawer is open we set the action bar to a generic title.
         * The action bar should only contain data relevant at the top level of
         * the nav hierarchy represented by the drawer, as the rest of your content
         * will be dimmed down and non-interactive.
         */
        @Override
        public void onDrawerOpened() {
            super.onDrawerOpened();
            mActionBar.setTitle(mDrawerTitle);
        }

        @Override
        public void setTitle(CharSequence title) {
            mTitle = title;
        }
    }
	
	
}
