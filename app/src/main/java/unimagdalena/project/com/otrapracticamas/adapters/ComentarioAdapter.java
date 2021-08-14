package unimagdalena.project.com.otrapracticamas.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import unimagdalena.project.com.otrapracticamas.R;
import unimagdalena.project.com.otrapracticamas.pojos.Comentario;

/**
 * Created by Ingenieros on 17/06/2016.
 */
public class ComentarioAdapter extends BaseAdapter {

    private LayoutInflater inflater;
    private Context context;
    private List<Comentario> comentarios;

    public ComentarioAdapter(Context context, List<Comentario> comentarios) {
        this.context = context;
        this.comentarios = comentarios;
    }

    @Override
    public int getCount() {
        return comentarios.size();
    }

    @Override
    public Object getItem(int i) {
        return comentarios.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater infla=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v=infla.inflate(R.layout.comentario,viewGroup,false);
        Comentario comen= (Comentario) getItem(i);
        TextView texNombre= (TextView) v.findViewById(R.id.textUsuario);
        TextView texComen= (TextView) v.findViewById(R.id.textComentario);
        texNombre.setText(comen.getNombre());
        texComen.setText(comen.getComentario());
        return v;
    }


}
