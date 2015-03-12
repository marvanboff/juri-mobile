package br.unisinos.jurimobile.view.adapter;

import java.util.List;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import br.unisinos.jurimobile.R;
import br.unisinos.jurimobile.model.entity.Processo;

public class ProcessoListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

	private static final int EMPTY_VIEW = 10;
	private List<Processo> processos;
	private ClickListener clickListener;
	
	public static class RecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

		private TextView numeroProcesso;
		private TextView participantes;
		private ClickListener clickListener;
		
		
		public RecyclerViewHolder(View view) {
			super(view);
			numeroProcesso = (TextView) view.findViewById(R.id.numeroProcesso);
			participantes = (TextView) view.findViewById(R.id.participantes);
			
			view.setOnClickListener(this);
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
		Processo processo = processos.get(position);
		RecyclerViewHolder recycleHolder = (RecyclerViewHolder) holder;
		recycleHolder.getNumeroProcesso().setText(processo.getNumero());
		recycleHolder.getParticipantes().setText(processo.getNomesParticipantes());
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

		view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_processo_item, parent, false);
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
