package br.unisinos.jurimobile.view.adapter;
 
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import br.unisinos.jurimobile.view.fragment.PesquisaPorNomeFragment;
import br.unisinos.jurimobile.view.fragment.PesquisaPorNumeroProcessoFragment;
 
public class TabPesquisaProcessoAdapter extends FragmentPagerAdapter {
 
	final int PAGE_COUNT = 2;
	// Tab Titles
	private String tabtitles[] = new String[] { "Nome", "Nº Processo" };
 
	public TabPesquisaProcessoAdapter(FragmentManager fm) {
		super(fm);
	}
 
	@Override
	public int getCount() {
		return PAGE_COUNT;
	}
 
	@Override
	public Fragment getItem(int position) {
		switch (position) {
 
		case 0:
			return new PesquisaPorNomeFragment();
		case 1:
			return new PesquisaPorNumeroProcessoFragment();
		}
		return null;
	}
 
	@Override
	public CharSequence getPageTitle(int position) {
		return tabtitles[position];
	}
}