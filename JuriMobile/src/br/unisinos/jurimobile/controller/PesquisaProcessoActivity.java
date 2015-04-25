package br.unisinos.jurimobile.controller;

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
        
//        mSlidingTabLayout.setCustomTabView(R.layout.pesquisa_processo_tabs, Arrays.asList(R.id.tabNome, R.id.tabNumeroProcesso));
        mSlidingTabLayout.setCustomTabView(R.layout.processo_tabs, R.id.tabModel); 
        mSlidingTabLayout.setBackgroundColor(getResources().getColor(R.color.primary));
        mSlidingTabLayout.setCustomTabColorizer(new PesquisarProcessoTabColorizer());
        mSlidingTabLayout.setDistributeEvenly(true);
        
        mSlidingTabLayout.setViewPager(mViewPager);
        
//        mSlidingTabLayout.setDividerColors(getResources().getColor(R.color.primaryDark));
//        mSlidingTabLayout.setSelectedIndicatorColors(getResources().getColor(R.color.primaryDark));
        
        
		// Locate the viewpager in activity_main.xml
//		ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
//		PagerTabStrip pagerTabStrip = (PagerTabStrip) findViewById(R.id.tab_filtro_pesquisa);
//		pagerTabStrip.setDrawFullUnderline(false);
//		pagerTabStrip.setTabIndicatorColor(getResources().getColor(R.color.primary));

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

		// Set the ViewPagerAdapter into ViewPager
//		viewPager.setAdapter(new TabPesquisaProcessoAdapter(getSupportFragmentManager()));
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
	
}
