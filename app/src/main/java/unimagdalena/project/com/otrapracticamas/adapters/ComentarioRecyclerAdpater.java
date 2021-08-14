package unimagdalena.project.com.otrapracticamas.adapters;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import unimagdalena.project.com.otrapracticamas.R;
import unimagdalena.project.com.otrapracticamas.pojos.Comentario;

/**
 * Created by Ingenieros on 26/06/2016.
 */
public class ComentarioRecyclerAdpater extends RecyclerView.Adapter<ComentarioRecyclerAdpater.ComenViewHolder> {

    private Context context;
    private List<Comentario>comentarios;
    private LayoutInflater inflater;


    public ComentarioRecyclerAdpater(Context context, List<Comentario> comentarios) {
        this.context = context;
        this.comentarios = comentarios;
        inflater=LayoutInflater.from(context);
    }

    @Override
    public ComenViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View root=inflater.inflate(R.layout.comentario,parent,false);
        ComenViewHolder holder=new ComenViewHolder(root);
        return holder;
    }

    @Override
    public void onBindViewHolder(ComenViewHolder holder, int position) {

        Comentario comentario=comentarios.get(position);
        holder.nombre.setText(comentario.getNombre());
        holder.comentario.setText(comentario.getComentario());

    }

    @Override
    public int getItemCount() {
        return comentarios.size();
    }

    public static class ComenViewHolder extends RecyclerView.ViewHolder {

        private TextView nombre;
        private TextView comentario;

        public ComenViewHolder(View itemView) {
            super(itemView);
            nombre= (TextView) itemView.findViewById(R.id.textUsuario);
            comentario= (TextView) itemView.findViewById(R.id.textComentario);
        }
    }
}
