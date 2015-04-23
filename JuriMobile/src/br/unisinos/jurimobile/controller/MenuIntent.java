package br.unisinos.jurimobile.controller;

import android.content.Context;
import android.content.Intent;
import android.view.MenuItem;
import br.unisinos.jurimobile.R;

public class MenuIntent {

	public Intent resolve(Context context, MenuItem item) {
		Intent intentResolved = null;
		switch (item.getItemId()) {
		case R.id.meus_processos_item_menu:
			intentResolved = new Intent(context, ProcessoListActivity.class);
			break;
		case R.id.pesquisa_processo_item_menu:
			intentResolved = new Intent(context, PesquisaProcessoActivity.class);
			break;
		case R.id.configuracoes_item_menu:
			intentResolved = new Intent(context, ProcessoListActivity.class);
			break;
		}

		return intentResolved;
	}

}
