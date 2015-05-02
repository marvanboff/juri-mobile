package br.unisinos.jurimobile.view.adapter;

import java.util.List;

import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import br.unisinos.jurimobile.R;
import br.unisinos.jurimobile.model.entity.mock.ProcessoMock;

public class ResultadoPesquisaProcessoAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

	private static final int EMPTY_VIEW = 10;
	private List<ProcessoMock> processos;
	private ClickSelectListener clickSelectListener;

	public class RecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

		private TextView numeroProcesso;
		private TextView participantes;
		
		private ImageView favorito;
		private Drawable favoritoMarcado;
		private Drawable favoritoDesmarcado;
		private boolean selecionado;
		
		private ClickSelectListener clickSelectListener;

		public RecyclerViewHolder(View view) {
			super(view);
			numeroProcesso = (TextView) view.findViewById(R.id.numeroProcesso);
			participantes = (TextView) view.findViewById(R.id.participantes);

			favorito = (ImageView) view.findViewById(R.id.favorito);
			favorito.setImageDrawable(getDrawableFavoritoDesmarcado(view));
			
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
			selecionado = !selecionado;
			if(selecionado){
				favorito.setImageDrawable(getDrawableFavoritoMarcado(view));
			}else{
				favorito.setImageDrawable(getDrawableFavoritoDesmarcado(view));
			}
			
			clickSelectListener.onClick(view, getItemId(), selecionado);
		}

		public void setClickSelectListener(ClickSelectListener clickSelectListener) {
			this.clickSelectListener = clickSelectListener;
		}

		public ImageView getFavorito() {
			return favorito;
		}
		
	}

	public interface ClickSelectListener {

		void onClick(View view, Long itemId, boolean selected);

	}
	
	public Drawable getDrawableFavoritoMarcado(View view){
		Drawable drawable = view.getResources().getDrawable(R.drawable.abc_btn_rating_star_on_mtrl_alpha);
		drawable.setColorFilter(view.getResources().getColor(R.color.favorite), PorterDuff.Mode.SRC_ATOP);
		return drawable;
	}
	
	public Drawable getDrawableFavoritoDesmarcado(View view){
		Drawable drawable = view.getResources().getDrawable(R.drawable.abc_btn_rating_star_off_mtrl_alpha);
		drawable.setColorFilter(view.getResources().getColor(R.color.favorite), PorterDuff.Mode.SRC_ATOP);
		return drawable;
	}
	
	public ResultadoPesquisaProcessoAdapter(List<ProcessoMock> processos) {
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
		ProcessoMock processo = processos.get(position);
		RecyclerViewHolder recycleHolder = (RecyclerViewHolder) holder;
		recycleHolder.getNumeroProcesso().setText(processo.getNumero());
		recycleHolder.getParticipantes().setText(processo.getNomesParticipantes());
		//abc_btn_rating_star_off_mtrl_alpha.png
//		recycleHolder.getFavorito().setImageDrawable(R.drawable.abc_btn_rating_star_on_mtrl_alpha);
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

	// TODO Talvez estender o onCreateViewHolder para o ProcessoListActivity
	@Override
	public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		View view = null;
		if (viewType == EMPTY_VIEW) {
			view = LayoutInflater.from(parent.getContext()).inflate(R.layout.empty_view, parent, false);
			return new EmptyViewHolder(view);
		}

		view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_recycler_resultado_processos_item, parent, false);
		RecyclerViewHolder recyclerViewHolder = new RecyclerViewHolder(view);
		recyclerViewHolder.setClickSelectListener(getClickSelectListener());
		return recyclerViewHolder;
	}

	public List<ProcessoMock> getProcessos() {
		return processos;
	}

	public void setProcessos(List<ProcessoMock> processos) {
		this.processos = processos;
	}

	public ClickSelectListener getClickSelectListener() {
		return clickSelectListener;
	}

	public void setClickSelectListener(ClickSelectListener clickSelectListener) {
		this.clickSelectListener = clickSelectListener;
	}
}
