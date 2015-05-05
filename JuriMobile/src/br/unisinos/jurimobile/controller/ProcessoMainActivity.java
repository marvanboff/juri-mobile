package br.unisinos.jurimobile.controller;

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
import br.unisinos.jurimobile.R;
import br.unisinos.jurimobile.facade.JuriMobileFacadeImpl;
import br.unisinos.jurimobile.model.entity2.Processo;
import br.unisinos.jurimobile.view.SlidingTabLayout;
import br.unisinos.jurimobile.view.SlidingTabLayout.TabColorizer;
import br.unisinos.jurimobile.view.adapter.TabProcessoAdapter;

public class ProcessoMainActivity extends FragmentActivity {

	public final static String NAME_PARAMETER_ID_PROCESSO = "processo_id";
	
	private ViewPager mViewPager;
	private SlidingTabLayout mSlidingTabLayout;
	private Processo processo;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// Get the view from activity_main.xml
		setContentView(R.layout.processo_main_activity);
		
		Long idProcesso = this.getIntent().getExtras().getLong(NAME_PARAMETER_ID_PROCESSO);
		processo = recuperarProcesso(idProcesso);
		
	    mViewPager = (ViewPager) findViewById(R.id.pager);
        mViewPager.setAdapter(new TabProcessoAdapter(getSupportFragmentManager(), processo));
        mSlidingTabLayout = (SlidingTabLayout) findViewById(R.id.sliding_tabs);
        
        mSlidingTabLayout.setCustomTabView(R.layout.processo_tabs, R.id.tabModel); 
        mSlidingTabLayout.setBackgroundColor(getResources().getColor(R.color.primary));
        mSlidingTabLayout.setCustomTabColorizer(new PesquisarProcessoTabColorizer());
        mSlidingTabLayout.setDistributeEvenly(true);
        
        mSlidingTabLayout.setViewPager(mViewPager);
        
		Toolbar toolbar = (Toolbar) findViewById(R.id.processo_toolbar);

		addToolbar(toolbar);
		
		Drawable backArrowDrawble = alterarCorBotaoVoltar();
		
		toolbar.setTitle(R.string.processo);
		if (toolbar != null) {

			toolbar.setNavigationIcon(backArrowDrawble);
			
			toolbar.setNavigationOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					startActivity(new Intent(getApplicationContext(), ProcessoListActivity.class));
				}
			});
		}
	}
	
	private Processo recuperarProcesso(Long idProcesso) {
		return new JuriMobileFacadeImpl().recuperarProcesso(this, idProcesso);
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
	}

	public class PesquisarProcessoTabColorizer implements TabColorizer {
	
		@Override
		public int getIndicatorColor(int position) {
			return getResources().getColor(R.color.indicadorColor);
		}
		
	}

	public Processo getProcesso() {
		return processo;
	}
	
}
