package br.unisinos.jurimobile.controller;

import java.util.Collection;

import org.apache.commons.lang3.StringUtils;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.Toolbar.OnMenuItemClickListener;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import br.unisinos.jurimobile.R;
import br.unisinos.jurimobile.facade.JuriMobileFacade;
import br.unisinos.jurimobile.facade.JuriMobileFacadeImpl;
import br.unisinos.jurimobile.model.dto.ProcessoMockListDTO;
import br.unisinos.jurimobile.model.entity.mock.ProcessoMock;
import br.unisinos.jurimobile.view.SlidingTabLayout;
import br.unisinos.jurimobile.view.SlidingTabLayout.TabColorizer;
import br.unisinos.jurimobile.view.adapter.TabPesquisaProcessoAdapter;

public class PesquisaProcessoActivity extends FragmentActivity {

	private ViewPager mViewPager;
	private SlidingTabLayout mSlidingTabLayout;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// Get the view from activity_main.xml
		setContentView(R.layout.pesquisa_processo_activity);
		
		
	    mViewPager = (ViewPager) findViewById(R.id.pager);
        mViewPager.setAdapter(new TabPesquisaProcessoAdapter(getSupportFragmentManager()));
        mSlidingTabLayout = (SlidingTabLayout) findViewById(R.id.sliding_tabs);
        
        mSlidingTabLayout.setCustomTabView(R.layout.processo_tabs, R.id.tabModel); 
        mSlidingTabLayout.setBackgroundColor(getResources().getColor(R.color.primary));
        mSlidingTabLayout.setCustomTabColorizer(new PesquisarProcessoTabColorizer());
        mSlidingTabLayout.setDistributeEvenly(true);
        
        mSlidingTabLayout.setViewPager(mViewPager);
        
		Toolbar toolbar = (Toolbar) findViewById(R.id.processo_toolbar);

		addToolbar(toolbar);
		
		Drawable backArrowDrawble = alterarCorBotaoVoltar();
		
		toolbar.setTitle(R.string.pesquisar_processo_por);
		if (toolbar != null) {

			toolbar.setNavigationIcon(backArrowDrawble);
			
			toolbar.setNavigationOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					onBackPressed();
				}
			});
		}

	}

	private Drawable alterarCorBotaoVoltar() {
		Drawable backArrowDrawble = getResources().getDrawable(R.drawable.abc_ic_ab_back_mtrl_am_alpha);
		backArrowDrawble.setColorFilter(getResources().getColor(R.color.white), PorterDuff.Mode.SRC_ATOP);
		return backArrowDrawble;
	}

	private void addToolbar(Toolbar toolbar) {
		toolbar.setOnMenuItemClickListener(new OnMenuItemClickListener() {

			@Override
			public boolean onMenuItemClick(MenuItem itemMenu) {
				startActivity(new MenuIntent().resolve(getApplicationContext(), itemMenu));
				return true;
			}
		});

		toolbar.inflateMenu(R.menu.navigation_menu);
		toolbar.getMenu().removeItem(R.id.pesquisa_processo_item_menu);
	}

	public class PesquisarProcessoTabColorizer implements TabColorizer {
	
		@Override
		public int getIndicatorColor(int position) {
			return getResources().getColor(R.color.indicadorColor);
		}
		
	}

	public void pesquisarPorNome(View view){
		JuriMobileFacade facade = new JuriMobileFacadeImpl(); 
		
		String nome = getInputName(view).getText().toString();
		
		if(StringUtils.isBlank(nome)){
			Toast.makeText(this, "Favor informar um nome para a pesquisa", Toast.LENGTH_LONG).show();
		}else{
			exibiResultadoPesquisa(facade.pesquisarProcessos(view.getContext(), nome, null));
		}
	}
	
	public void pesquisarPorNumero(View view) {
		JuriMobileFacade facade = new JuriMobileFacadeImpl();
		
		String numeroProcesso = getInputNumeroProcesso(view).getText().toString();
		
		if (StringUtils.isBlank(numeroProcesso)) {
			Toast.makeText(this, "Favor informar um número de processo para a pesquisa", Toast.LENGTH_LONG).show();
		} else {
			exibiResultadoPesquisa(facade.pesquisarProcessos(view.getContext(), null, numeroProcesso));
		}
	}
	
	private EditText getInputNumeroProcesso(View view) {
		return (EditText) findViewById(R.id.inputNumeroProcesso);
	}
	
	private EditText getInputName(View view) {
		return (EditText) findViewById(R.id.inputNome);
	}
	
	public void exibiResultadoPesquisa(Collection<ProcessoMock> processos) {
		Intent intent = new Intent(this, ResultadoPesquisaProcessoActivity.class);
//		ProcessoMockListDTO processoMockListDTO = new ProcessoMockListDTO();
//		processoMockListDTO.addAll(processos);
		intent.putExtra(ResultadoPesquisaProcessoActivity.PARAMETRO_LIST_RESULT, processos.toArray(new ProcessoMock[processos.size()]));
		startActivity(intent);
	}
	
	
}
