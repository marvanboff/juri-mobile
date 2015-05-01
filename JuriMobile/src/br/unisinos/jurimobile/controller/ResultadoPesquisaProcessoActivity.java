package br.unisinos.jurimobile.controller;

import java.util.Arrays;
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
import br.unisinos.jurimobile.model.entity.mock.ProcessoMock;

public class ResultadoPesquisaProcessoActivity extends ActionBarActivity {

	private Toolbar toolBar;

	private List<ProcessoMock> processos;
	
	public static final String PARAMETRO_LIST_RESULT = "LIST_RESULTS";
	
	@Override
	protected void onCreate(Bundle bundle) {
		super.onCreate(bundle);
		
		loadListProcessos();
		
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
		
	}

	private void loadListProcessos() {
		ProcessoMock[] arrayProcessos = (ProcessoMock[]) this.getIntent().getExtras().getSerializable(PARAMETRO_LIST_RESULT);
		if(arrayProcessos != null){
			processos = Arrays.asList(arrayProcessos);
		}
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

	public List<ProcessoMock> getProcessos() {
		return processos;
	}

	public void setProcessos(List<ProcessoMock> processos) {
		this.processos = processos;
	}

}
