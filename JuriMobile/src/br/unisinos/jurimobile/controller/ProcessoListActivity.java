package br.unisinos.jurimobile.controller;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import br.unisinos.jurimobile.R;
import br.unisinos.jurimobile.R.id;
import br.unisinos.jurimobile.R.layout;
import br.unisinos.jurimobile.model.entity.Grupo;
import br.unisinos.jurimobile.model.entity.GrupoProcesso;
import br.unisinos.jurimobile.model.entity.Processo;
import br.unisinos.jurimobile.model.entity.ProcessoParticipante;
import br.unisinos.jurimobile.view.adapter.ProcessoListAdapter;

public class ProcessoListActivity extends Activity {

	private RecyclerView recyclerView;
	private RecyclerView.Adapter<ProcessoListAdapter.RecyclerViewHolder> adapter;
	private RecyclerView.LayoutManager layoutManager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.lista_processo);
		recyclerView = (RecyclerView) findViewById(R.id.lista_processo_recycler_view);
		
		// use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerView.setHasFixedSize(true);
        
        // use a linear layout manager
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        // specify an adapter (see also next example)
        adapter = new ProcessoListAdapter(getMockProcessos());
        recyclerView.setAdapter(adapter);
//        recyclerView.setItemAnimator(new DefaOultItemAnimator());
	}
	
	public List<Processo> getMockProcessos(){
		List<Processo> processos = new ArrayList<>();
		
		//Ex: 9123782-66.2014.8.21.0033
		processos.add(new Processo(1l, "9123782-66.2014.8.10.0023", "Acidente de Transito", "Comarca de São Leopoldo", "Aguardando Audiência"));
		processos.add(new Processo(2l, "9135782-22.2015.1.11.0055", "Acidente de Transito", "Comarca de Canoas", "Turmas Recursais"));
		processos.add(new Processo(3l, "9165824-55.2014.12.21.0233", "Acidente de Transito", "Comarca de Patenon", "Concluso"));
		processos.add(new Processo(4l, "9165822-78.2014.6.1.8033", "Acidente de Transito", "Comarca de Novo Hamburgo", "Turmas Recursais"));
		processos.add(new Processo(5l, "9165822-78.2014.6.1.8033", "Cobrança Aluguel", "Comarca de Novo Hamburgo", "Baixado"));
		
		processos.get(0).addParticipante((new ProcessoParticipante(1l, "João Carlos")));
		processos.get(0).addParticipante((new ProcessoParticipante(2l, "Maria Silva")));
		processos.get(0).addParticipante((new ProcessoParticipante(12l, "Cleber dos Reis")));
		processos.get(1).addParticipante((new ProcessoParticipante(3l, "Rafael Prereira")));
		processos.get(1).addParticipante((new ProcessoParticipante(4l, "José Emanuel")));
		processos.get(2).addParticipante((new ProcessoParticipante(5l, "Ricardo Fonseca")));
		processos.get(2).addParticipante((new ProcessoParticipante(6l, "José Antunes")));
		processos.get(3).addParticipante((new ProcessoParticipante(7l, "Carlos Reis da Silva")));
		processos.get(3).addParticipante((new ProcessoParticipante(8l, "Fabiano Pereira Campos")));
		processos.get(3).addParticipante((new ProcessoParticipante(11l, "Emerson Silveira Flach")));
		processos.get(3).addParticipante((new ProcessoParticipante(9l, "Joana Peixoto de Castro")));
		processos.get(4).addParticipante((new ProcessoParticipante(10l, "Fernando Henrique Pereira")));
		processos.get(4).addParticipante((new ProcessoParticipante(11l, "Jonas de Brito")));
		processos.get(4).addParticipante((new ProcessoParticipante(8l, "Fabiano Pereira Campos")));
		
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
	
}
