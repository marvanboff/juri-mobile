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
import br.unisinos.jurimobile.controller.ProcessoListActivity;
import br.unisinos.jurimobile.model.entity.Processo;
import br.unisinos.jurimobile.view.adapter.ProcessoListAdapter;
import br.unisinos.jurimobile.view.adapter.ProcessoListAdapter.ClickListener;

public class RecyclerViewMeusProcessosFragment extends Fragment {

	protected Context context;
	protected Activity activity;
	
	private RecyclerView recyclerView;
	private RecyclerView.Adapter<RecyclerView.ViewHolder> processoListAdapter;
	private RecyclerView.LayoutManager layoutManager;
	

	public RecyclerViewMeusProcessosFragment() {
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
		recyclerView = (RecyclerView) inflater.inflate(R.layout.fragment_recycler_processos, container, false);

		loadView();

		return recyclerView;
	}

	private void loadView() {
		
		layoutManager = new LinearLayoutManager(context);
		recyclerView.setLayoutManager(layoutManager);
		recyclerView.setHasFixedSize(true);
		
		processoListAdapter = new ProcessoListAdapter(ProcessoListActivity.getMockProcessos());
		((ProcessoListAdapter) processoListAdapter).setClickListener((ClickListener) activity);
		
		recyclerView.setAdapter(processoListAdapter);
		
	}

	public void realoadRecycler(List<Processo> processos){
		processoListAdapter = new ProcessoListAdapter(processos);
		((ProcessoListAdapter) processoListAdapter).setClickListener((ClickListener) activity);
		
		recyclerView.setAdapter(processoListAdapter);
		
	}
	
}
