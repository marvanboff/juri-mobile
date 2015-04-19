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
import br.unisinos.jurimobile.view.SlidingTabLayout;
import br.unisinos.jurimobile.view.SlidingTabLayout.TabColorizer;
import br.unisinos.jurimobile.view.adapter.TabPesquisaProcessoAdapter;

public class PesquisaProcessoActivity2 extends FragmentActivity {

	private static final String TITLE_PAGE = "Pesquisa";
	private ViewPager mViewPager;
	private SlidingTabLayout mSlidingTabLayout;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// Get the view from activity_main.xml
		setContentView(R.layout.pesquisa_processo_activity2);
		
		
	    mViewPager = (ViewPager) findViewById(R.id.pager);
        mViewPager.setAdapter(new TabPesquisaProcessoAdapter(getSupportFragmentManager()));
        mSlidingTabLayout = (SlidingTabLayout) findViewById(R.id.sliding_tabs);
        mSlidingTabLayout.setViewPager(mViewPager);
//        mSlidingTabLayout.setBackgroundColor(getResources().getColor(R.color.primary));
//        mSlidingTabLayout.setCustomTabColorizer(new PesquisarProcessoTabColorizer());
        
		// Locate the viewpager in activity_main.xml
//		ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
//		PagerTabStrip pagerTabStrip = (PagerTabStrip) findViewById(R.id.tab_filtro_pesquisa);
//		pagerTabStrip.setDrawFullUnderline(false);
//		pagerTabStrip.setTabIndicatorColor(getResources().getColor(R.color.primary));

		Toolbar toolbar = (Toolbar) findViewById(R.id.processo_toolbar);

		addToolbar(toolbar);

		Drawable backArrowDrawble = alterarCorBotaoVoltar();
		Drawable menuDrawble = alterarCorBotaoMenu();
		
		toolbar.setTitle(TITLE_PAGE);
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

	private Drawable alterarCorBotaoMenu() {
		Drawable menuDrawble = getResources().getDrawable(R.drawable.abc_ic_menu_moreoverflow_mtrl_alpha);
		menuDrawble.setColorFilter(getResources().getColor(R.color.white), PorterDuff.Mode.SRC_ATOP);
		return menuDrawble;
	}

	private Drawable alterarCorBotaoVoltar() {
		Drawable backArrowDrawble = getResources().getDrawable(R.drawable.abc_ic_ab_back_mtrl_am_alpha);
		backArrowDrawble.setColorFilter(getResources().getColor(R.color.white), PorterDuff.Mode.SRC_ATOP);
		return backArrowDrawble;
	}

	private void addToolbar(Toolbar toolbar) {
		toolbar.setOnMenuItemClickListener(new OnMenuItemClickListener() {

			@Override
			public boolean onMenuItemClick(MenuItem arg0) {
				Intent intent = new Intent(getApplicationContext(), ProcessoListActivity.class);
				startActivity(intent);
				return true;
			}
		});

		toolbar.inflateMenu(R.menu.navigation_menu);
	}

	public class PesquisarProcessoTabColorizer implements TabColorizer {
	
		@Override
		public int getIndicatorColor(int position) {
			return getResources().getColor(R.color.textColorPrimary);
		}
		
		@Override
		public int getDividerColor(int position) {
			return R.color.textColorPrimary;
		}
		
	}
	
}
