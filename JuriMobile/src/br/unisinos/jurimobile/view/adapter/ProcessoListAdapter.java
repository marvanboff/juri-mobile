package br.unisinos.jurimobile.view.adapter;

import java.util.List;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import br.unisinos.jurimobile.R;
import br.unisinos.jurimobile.model.entity.Processo;

public class ProcessoListAdapter extends RecyclerView.Adapter<ProcessoListAdapter.RecyclerViewHolder> {
	
	private List<Processo> processos;
	
    public static class RecyclerViewHolder extends RecyclerView.ViewHolder {

    	private TextView numeroProcesso;
        private TextView participantes;
        
        public RecyclerViewHolder(View v) {
            super(v);
            numeroProcesso = (TextView) v.findViewById(R.id.numeroProcesso);
            participantes = (TextView) v.findViewById(R.id.participantes);
        }

		public TextView getNumeroProcesso() {
			return numeroProcesso;
		}

		public TextView getParticipantes() {
			return participantes;
		}

    }
	
    public ProcessoListAdapter(List<Processo> processos) {
    	super();
    	setProcessos(processos);
	}
    
	@Override
	public int getItemCount() {
		return processos.size();
	}

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        Processo processo = processos.get(position);
		holder.getNumeroProcesso().setText(processo.getNumero());
        holder.getParticipantes().setText(processo.getNomesParticipantes());

    }

	@Override
	  public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_processo_item, parent, false);
		return new RecyclerViewHolder(view);
	}

	public List<Processo> getProcessos() {
		return processos;
	}

	public void setProcessos(List<Processo> processos) {
		this.processos = processos;
	}
	
}
