package br.unisinos.jurimobile.view.fragment;

import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import br.unisinos.jurimobile.R;
import br.unisinos.jurimobile.controller.ResultadoPesquisaProcessoActivity;
import br.unisinos.jurimobile.model.entity.mock.ProcessoMock;
import br.unisinos.jurimobile.view.adapter.DividerItemDecoration;
import br.unisinos.jurimobile.view.adapter.ResultadoPesquisaProcessoAdapter;
import br.unisinos.jurimobile.view.adapter.ResultadoPesquisaProcessoAdapter.ClickSelectListener;

public class RecyclerViewResultadoPesquisaProcessosFragment extends Fragment  {

	protected Context context;
	protected Activity activity;
	
	private RecyclerView recyclerView;
	private RecyclerView.Adapter<RecyclerView.ViewHolder> resultadoPesquisaAdapter;
	private RecyclerView.LayoutManager layoutManager;
	

	public RecyclerViewResultadoPesquisaProcessosFragment() {
		super();
	}

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		this.activity = activity;
		this.context = activity.getApplicationContext();
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		activity = null;
		context = null;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		recyclerView = (RecyclerView) inflater.inflate(R.layout.fragment_recycler_resultado_pesquisa_processos, container, false);
		
		loadView();

		return recyclerView;
	}

	private void loadView() {
		
		layoutManager = new LinearLayoutManager(context);
		recyclerView.setLayoutManager(layoutManager);
		recyclerView.setHasFixedSize(true);
		recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL_LIST));
		
		ResultadoPesquisaProcessoActivity resultadoPesquisaActivity = (ResultadoPesquisaProcessoActivity)getActivity();
		resultadoPesquisaAdapter = new ResultadoPesquisaProcessoAdapter(resultadoPesquisaActivity.getProcessos());
		((ResultadoPesquisaProcessoAdapter) resultadoPesquisaAdapter).setClickSelectListener((ClickSelectListener) activity);
		
		recyclerView.setAdapter(resultadoPesquisaAdapter);
		
	}

	public void realoadRecycler(List<ProcessoMock> processos){
		resultadoPesquisaAdapter = new ResultadoPesquisaProcessoAdapter(processos);
//		((ProcessoListAdapter) processoListAdapter).setClickListener((ClickListener) activity);
		
		recyclerView.setAdapter(resultadoPesquisaAdapter);
		
	}

	
}
