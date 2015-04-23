package br.unisinos.jurimobile.controller;

import java.util.ArrayList;
import java.util.List;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.Toolbar.OnMenuItemClickListener;
import android.view.MenuItem;
import android.view.View;
import br.unisinos.jurimobile.R;
import br.unisinos.jurimobile.model.entity.TipoParticipante;
import br.unisinos.jurimobile.model.entity.mock.ProcessoMock;
import br.unisinos.jurimobile.model.entity.mock.ProcessoParticipanteMock;

public class ResultadoPesquisaProcessoActivity extends ActionBarActivity {

	private Toolbar toolBar;

	@Override
	protected void onCreate(Bundle bundle) {
		super.onCreate(bundle);
		setContentView(R.layout.resultado_pesquisa_processo);
		
		toolBar = (Toolbar) findViewById(R.id.resultado_pesquisa_processo_toolbar);
		
		addMenuToolbar(toolBar);
		
		Drawable backArrowDrawble = alterarCorBotaoVoltar();
		
		toolBar.setTitle(R.string.resultado);
		if (toolBar != null) {

			toolBar.setNavigationIcon(backArrowDrawble);
			
			toolBar.setNavigationOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					startActivity(new Intent(getApplicationContext(), PesquisaProcessoActivity.class));
				}
			});
		}
		
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
	
	private void addMenuToolbar(Toolbar toolbar) {
		toolbar.setOnMenuItemClickListener(new OnMenuItemClickListener() {

			@Override
			public boolean onMenuItemClick(MenuItem itemMenu) {
				startActivity(new MenuIntent().resolve(getApplicationContext(), itemMenu));
				return true;
			}
		});

		toolbar.inflateMenu(R.menu.navigation_menu);
	}

	private Drawable alterarCorBotaoVoltar() {
		Drawable backArrowDrawble = getResources().getDrawable(R.drawable.abc_ic_ab_back_mtrl_am_alpha);
		backArrowDrawble.setColorFilter(getResources().getColor(R.color.white), PorterDuff.Mode.SRC_ATOP);
		return backArrowDrawble;
	}


	public static List<ProcessoMock> getMockProcessos() {
		List<ProcessoMock> processos = new ArrayList<>();

		// Ex: 9123782-66.2014.8.21.0033
		processos.add(new ProcessoMock(1l, "9123782-66.2014.8.10.0023", "Acidente de Transito", "Juizado Especial Cívil", "São Leopoldo", "Aguardando Audiência"));
		processos.add(new ProcessoMock(2l, "9135782-22.2015.1.11.0055", "Acidente de Transito", "2ª Vara Cível", "Canoas", "Turmas Recursais"));
		processos.add(new ProcessoMock(3l, "9165824-55.2014.12.21.0233", "Acidente de Transito", "10º Juizado Especial Cível", "Porto Alegre", "Concluso"));
		processos.add(new ProcessoMock(4l, "9165822-78.2014.6.1.8033", "Acidente de Transito", "Vara JEC", "Novo Hamburgo", "Turmas Recursais"));
		processos.add(new ProcessoMock(5l, "9165822-78.2014.6.1.8033", "Cobrança Aluguel", "2ª Vara Cível", "Novo Hamburgo", "Baixado"));

		processos.get(0).addParticipante((new ProcessoParticipanteMock(1l, "João Carlos", "Autor", TipoParticipante.A)));
		processos.get(0).addParticipante((new ProcessoParticipanteMock(2l, "Maria Silva", "Autor", TipoParticipante.A)));
		processos.get(0).addParticipante((new ProcessoParticipanteMock(12l, "Cleber dos Reis", "Réu", TipoParticipante.P)));
		processos.get(1).addParticipante((new ProcessoParticipanteMock(3l, "Rafael Prereira", "Autor", TipoParticipante.A)));
		processos.get(1).addParticipante((new ProcessoParticipanteMock(4l, "José Emanuel", "Réu", TipoParticipante.P)));
		processos.get(2).addParticipante((new ProcessoParticipanteMock(5l, "Ricardo Fonseca", "Autor", TipoParticipante.A)));
		processos.get(2).addParticipante((new ProcessoParticipanteMock(6l, "José Antunes", "Réu", TipoParticipante.P)));
		processos.get(3).addParticipante((new ProcessoParticipanteMock(7l, "Carlos Reis da Silva", "Autor", TipoParticipante.A)));
		processos.get(3).addParticipante((new ProcessoParticipanteMock(8l, "Fabiano Pereira Campos", "Testemunha", TipoParticipante.O)));
		processos.get(3).addParticipante((new ProcessoParticipanteMock(11l, "Emerson Silveira Flach", "Réu", TipoParticipante.P)));
		processos.get(3).addParticipante((new ProcessoParticipanteMock(9l, "Joana Peixoto de Castro", "Réu", TipoParticipante.P)));
		processos.get(4).addParticipante((new ProcessoParticipanteMock(10l, "Fernando Henrique Pereira", "Autor", TipoParticipante.A)));
		processos.get(4).addParticipante((new ProcessoParticipanteMock(11l, "Jonas de Brito", "Réu", TipoParticipante.P)));
		processos.get(4).addParticipante((new ProcessoParticipanteMock(8l, "Fabiano Pereira Campos", "Testemunha", TipoParticipante.O)));

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

}
