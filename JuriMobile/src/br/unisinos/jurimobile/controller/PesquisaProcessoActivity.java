package br.unisinos.jurimobile.controller;

import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import br.unisinos.jurimobile.R;
import br.unisinos.jurimobile.view.adapter.TabPesquisaProcessoAdapter;

public class PesquisaProcessoActivity extends FragmentActivity  {

	private static final String TITLE_PAGE = "Pesquisa";
	
	@SuppressWarnings("deprecation")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// Get the view from activity_main.xml
		setContentView(R.layout.pesquisa_processo_activity);
		
		// Locate the viewpager in activity_main.xml
		ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
		PagerTabStrip pagerTabStrip = (PagerTabStrip) findViewById(R.id.tab_filtro_pesquisa);
		pagerTabStrip.setDrawFullUnderline(false);
		pagerTabStrip.setTabIndicatorColor(getResources().getColor(R.color.primary));
 
		Toolbar toolbar = (Toolbar) findViewById(R.id.processo_toolbar);
		toolbar.setTitle(TITLE_PAGE);
	    if (toolbar != null) {
	    	Drawable backArrowDrawble = getResources().getDrawable(android.support.v7.appcompat.R.drawable.abc_ic_ab_back_mtrl_am_alpha);
	    	backArrowDrawble.setColorFilter(getResources().getColor(R.color.white), PorterDuff.Mode.SRC_ATOP);
	    	
			toolbar.setNavigationIcon(backArrowDrawble);
	        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
	            @Override
	            public void onClick(View v) {
	                onBackPressed();
	            }
	        });
	    }
		
		// Set the ViewPagerAdapter into ViewPager
		viewPager.setAdapter(new TabPesquisaProcessoAdapter(getSupportFragmentManager()));
	}

}
