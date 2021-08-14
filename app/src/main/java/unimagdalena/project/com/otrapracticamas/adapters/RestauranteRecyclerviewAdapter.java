package unimagdalena.project.com.otrapracticamas.adapters;

import android.content.Context;
import android.content.Intent;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import unimagdalena.project.com.otrapracticamas.activities.MainActivity2;
import unimagdalena.project.com.otrapracticamas.R;
import unimagdalena.project.com.otrapracticamas.pojos.Restaurante;

/**
 * Created by Ingenieros on 21/06/2016.
 */
public class RestauranteRecyclerviewAdapter extends RecyclerView.Adapter<RestauranteRecyclerviewAdapter.ResViewHolder> {

    private Context contex;
    private static List<Restaurante>restaurantes;
    private LayoutInflater inflater;

    public RestauranteRecyclerviewAdapter(Context contex, List<Restaurante> restaurantes) {
        this.contex = contex;
        inflater=LayoutInflater.from(contex);
        this.restaurantes = restaurantes;
    }

    @Override
    public ResViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View root=inflater.inflate(R.layout.cardvista,parent,false);
        ResViewHolder holder=new ResViewHolder(root,contex,restaurantes);
        return holder;
    }

    @Override
    public void onBindViewHolder(ResViewHolder holder, int position) {
        Restaurante res=restaurantes.get(position);
        holder.nombre.setText(res.getNombre());
        holder.direccion.setText(res.getDireccion());
        holder.calificacion.setRating(res.getCalificacion());
        Picasso.get().load(res.getImagen()).into(holder.imagen);

    }

    @Override
    public int getItemCount() {
        return restaurantes.size();
    }

    public static class  ResViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private TextView nombre;
        private TextView direccion;
        private RatingBar calificacion;
        private ImageView imagen;
        private List<Restaurante>restaurantes;
        private Context context;

            public ResViewHolder(View itemView, Context context,List<Restaurante>restaurantes) {
            super(itemView);
            itemView.setOnClickListener(this);
            this.context=context;
            this.restaurantes=restaurantes;
            nombre= (TextView) itemView.findViewById(R.id.textCardNombreR);
            direccion= (TextView) itemView.findViewById(R.id.textCardDireccionR);
            imagen= (ImageView) itemView.findViewById(R.id.cardImageRes);
            calificacion= (RatingBar) itemView.findViewById(R.id.ratingBarCard);
        }


        @Override
        public void onClick(View view) {
            int i=getAdapterPosition();
            Restaurante res=restaurantes.get(i);
            Intent pasar=new Intent(this.context, MainActivity2.class);
            pasar.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            pasar.putExtra("resto",res);
            this.context.startActivity(pasar);

        }
    }
}
