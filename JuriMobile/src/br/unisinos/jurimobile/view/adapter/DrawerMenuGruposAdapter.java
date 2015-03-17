package br.unisinos.jurimobile.view.adapter;

import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import br.unisinos.jurimobile.R;
import br.unisinos.jurimobile.model.entity.Grupo;

public class DrawerMenuGruposAdapter extends BaseAdapter {

	private Context context;
	private List<Grupo> grupos;

	public DrawerMenuGruposAdapter(Context context, List<Grupo> grupos) {
		super();
		this.context = context;
		this.grupos = grupos;
	}

	@Override
	public int getCount() {
		return grupos.size();
	}

	@Override
	public Object getItem(int position) {
		return grupos.get(position);
	}

	@Override
	public long getItemId(int position) {
		// return grupos.get(position).getId();
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolderGrupo holder;

		if (convertView == null) {
			LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
			convertView = inflater.inflate(R.layout.fragment_drawer_menu_item, null);

			holder = new ViewHolderGrupo();
			holder.setNome((TextView) convertView.findViewById(R.id.fragment_drawerMenu_comp_title));
			convertView.setTag(holder);
		} else {
			holder = (ViewHolderGrupo) convertView.getTag();
		}
		holder.getNome().setText(grupos.get(position).getNome());

		return convertView;
	}

	private static class ViewHolderGrupo {

		private TextView nome;

		public TextView getNome() {
			return nome;
		}

		public void setNome(TextView nome) {
			this.nome = nome;
		}
		
	}

}
