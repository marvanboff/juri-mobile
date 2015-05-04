package br.unisinos.jurimobile.view.adapter;

import java.util.List;

import android.support.v7.widget.RecyclerView;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import br.unisinos.jurimobile.R;
import br.unisinos.jurimobile.controller.ProcessoListActivity.ProcessoContextMenu;
import br.unisinos.jurimobile.model.entity2.Processo;

public class ProcessoListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

	private static final int EMPTY_VIEW = 10;
	private List<Processo> processos;
	private ClickListener clickListener;
	
	public static class RecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnCreateContextMenuListener{

		private TextView numeroProcesso;
		private TextView participantes;
		private ClickListener clickListener;
		
		
		public RecyclerViewHolder(View view) {
			super(view);
			numeroProcesso = (TextView) view.findViewById(R.id.numeroProcesso);
			participantes = (TextView) view.findViewById(R.id.participantes);
			
			view.setOnClickListener(this);
			view.setOnCreateContextMenuListener(this);

		}

		public TextView getNumeroProcesso() {
			return numeroProcesso;
		}

		public TextView getParticipantes() {
			return participantes;
		}

		@Override
		public void onClick(View view) {
			clickListener.onClick(view, getItemId());
		}

		public void setClickListener(ClickListener clickListener) {
			this.clickListener = clickListener;
		}

		@Override
		public void onCreateContextMenu(ContextMenu menu, View v, ContextMenuInfo menuInfo) {
//			v.inflate(v.getContext(), R.menu.processo_context_menu, null);
			
			menu.add(ProcessoContextMenu.EXIBIR.getGroupID(), 1, Menu.NONE, R.string.exibir);
			menu.add(ProcessoContextMenu.REMOVER.getGroupID(), Integer.valueOf(String.valueOf(getItemId())), Menu.NONE, R.string.remover);
			
			
		}
		
	}
	
	public interface ClickListener{
		
		void onClick(View view, Long itemId);
		
	}
	
	public ProcessoListAdapter(List<Processo> processos) {
		super();
		setProcessos(processos);
		setHasStableIds(true);
	}

	
	@Override
	public int getItemCount() {
		return processos.size() > 0 ? processos.size() : 1;
	}

	@Override
	public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
		if(!processos.isEmpty()){
			Processo processo = processos.get(position);
			RecyclerViewHolder recycleHolder = (RecyclerViewHolder) holder;
			recycleHolder.getNumeroProcesso().setText(processo.getNumero());
			recycleHolder.getParticipantes().setText(processo.getNomesParticipantes());
		}
	}
	
	@Override
	public int getItemViewType(int position) {
		if (processos.size() == 0) {
			return EMPTY_VIEW;
		}
		return super.getItemViewType(position);
	}
	
	@Override
	public long getItemId(int position) {
		if(processos.isEmpty()){
			return 0;
		}
		return processos.get(position).getId();
	}
	
	//TODO Talvez estender o onCreateViewHolder para o ProcessoListActivity
	@Override
	public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		View view = null;
		if (viewType == EMPTY_VIEW) {
			view = LayoutInflater.from(parent.getContext()).inflate(R.layout.empty_view, parent, false);
			return new EmptyViewHolder(view); 
		}

		view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_recycler_processos_item, parent, false);
		RecyclerViewHolder recyclerViewHolder = new RecyclerViewHolder(view);
		recyclerViewHolder.setClickListener(getClickListener());
		return recyclerViewHolder;
	}
	
	public List<Processo> getProcessos() {
		return processos;
	}

	public void setProcessos(List<Processo> processos) {
		this.processos = processos;
	}


	public void setClickListener(ClickListener clickListener) {
		this.clickListener = clickListener;
	}


	public ClickListener getClickListener() {
		return clickListener;
	}
	
}
