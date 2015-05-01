package br.unisinos.jurimobile.view.fragment;

import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import br.unisinos.jurimobile.R;

public class PesquisaPorNumeroProcessoFragment extends Fragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.pesquisa_numero_processo_fragment_tab, container, false);

		int primary = getResources().getColor(R.color.primary);
		EditText inputNumeroProcesso = (EditText) view.findViewById(R.id.inputNumeroProcesso);
		inputNumeroProcesso.getBackground().setColorFilter(primary, PorterDuff.Mode.SRC_IN);

		return view;
	}

}
