package unimagdalena.project.com.otrapracticamas.adapters;

import android.content.Context;
import android.content.Intent;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import unimagdalena.project.com.otrapracticamas.activities.MainActivity3;
import unimagdalena.project.com.otrapracticamas.R;
import unimagdalena.project.com.otrapracticamas.pojos.Menu;

/**
 * Created by Ingenieros on 26/06/2016.
 */
public class MenuRecyclerAdapter extends RecyclerView.Adapter<MenuRecyclerAdapter.MenuViewHolder> {

    private Context context;
    private List<Menu>menus;
    private LayoutInflater inflater;

    public MenuRecyclerAdapter(Context context, List<Menu> menus) {
        this.context = context;
        this.menus = menus;
        inflater=LayoutInflater.from(context);
    }

    @Override
    public MenuViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View root=inflater.inflate(R.layout.menu_card_view,parent,false);
        MenuViewHolder holder=new MenuViewHolder(root,context,menus);
        return holder;
    }

    @Override
    public void onBindViewHolder(MenuViewHolder holder, int position) {

        Menu men=menus.get(position);
        holder.nombre.setText(men.getNombre());
        Picasso.get().load(men.getImagen()).into(holder.imagen);
        holder.precio.setText(Integer.toString(men.getPrecio()));


    }

    @Override
    public int getItemCount() {
        return menus.size();
    }

    public static class MenuViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private TextView nombre;
        private ImageView imagen;
        private TextView precio;
        private Context context;
        private List<Menu>menus;

        public MenuViewHolder(View itemView,Context context,List<Menu>menus) {
            super(itemView);
            itemView.setOnClickListener(this);
            this.context=context;
            this.menus=menus;
            nombre= (TextView) itemView.findViewById(R.id.textNombrePCard);
            imagen= (ImageView) itemView.findViewById(R.id.imagePlatoCard);
            precio= (TextView) itemView.findViewById(R.id.textPrecioPlatoCard);

        }

        @Override
        public void onClick(View view) {

            int i=getAdapterPosition();
            Menu menu=menus.get(i);
            Intent pasar=new Intent(context, MainActivity3.class);
            pasar.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            pasar.putExtra("plato",menu);
            context.startActivity(pasar);

        }
    }
}
