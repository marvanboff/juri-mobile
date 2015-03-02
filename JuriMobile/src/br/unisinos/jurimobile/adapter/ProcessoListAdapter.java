package br.unisinos.jurimobile.adapter;

import java.util.List;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import br.unisinos.jurimobile.R;
import br.unisinos.jurimobile.model.Processo;

public class ProcessoListAdapter extends RecyclerView.Adapter<ProcessoListAdapter.RecyclerViewHolder> {
	
	private List<Processo> processos;
	
	// Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class RecyclerViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        private TextView numeroProcesso;
        
        public RecyclerViewHolder(View v) {
            super(v);
            numeroProcesso = (TextView) v.findViewById(R.id.numeroProcesso);
        }

		public TextView getNumeroProcesso() {
			return numeroProcesso;
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

	// Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.getNumeroProcesso().setText(processos.get(position).getNumero());

    }

	@Override
	  public ProcessoListAdapter.RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		 // create a new view
		View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_processo_item, parent, false);
        // set the view's size, margins, paddings and layout parameters
		return new RecyclerViewHolder(view);
	}

	public List<Processo> getProcessos() {
		return processos;
	}

	public void setProcessos(List<Processo> processos) {
		this.processos = processos;
	}
	
}
