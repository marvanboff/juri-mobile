package br.unisinos.jurimobile.view.adapter;
 
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import br.unisinos.jurimobile.model.entity2.Processo;
import br.unisinos.jurimobile.view.fragment.DetalhesProcessoTabFragment;
import br.unisinos.jurimobile.view.fragment.MovimentacoesProcessoTabFragment;
 
public class TabProcessoAdapter extends FragmentPagerAdapter {
 
	final int PAGE_COUNT = 2;
	// Tab Titles
	private String tabtitles[] = new String[] { "Geral", "Movimentações" };
 
	private Processo processo;
	
	public TabProcessoAdapter(FragmentManager fm, Processo processo) {
		super(fm);
		this.processo = processo;
	}
 
	@Override
	public int getCount() {
		return PAGE_COUNT;
	}
 
	@Override
	public Fragment getItem(int position) {
		switch (position) {
 
		case 0:
			return new DetalhesProcessoTabFragment(processo);
		case 1:
			return new MovimentacoesProcessoTabFragment(processo);
		}
		return null;
	}
 
	@Override
	public CharSequence getPageTitle(int position) {
		return tabtitles[position];
	}
}