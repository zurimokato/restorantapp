package unimagdalena.project.com.otrapracticamas.adapters;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import unimagdalena.project.com.otrapracticamas.R;
import unimagdalena.project.com.otrapracticamas.pojos.Restaurante;

public class RestaurantesAdapters extends BaseAdapter {
    private List<Restaurante>restaurantes;
    private Context context;
    private LayoutInflater inflater;

    public RestaurantesAdapters(Context context, List<Restaurante> restaurantes) {
        this.context = context;
        this.restaurantes = restaurantes;
    }

    @Override
    public int getCount() {
        return restaurantes.size();
    }

    @Override
    public Object getItem(int i) {
        return restaurantes.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View vista =inflater.inflate(R.layout.restaurantes,viewGroup,false);
        Restaurante res=(Restaurante)getItem(i);
        TextView texNombre= (TextView) vista.findViewById(R.id.textViewNombreR);
        TextView texDireccion= (TextView) vista.findViewById(R.id.textViewDireccionR);
        TextView textPrecio= (TextView) vista.findViewById(R.id.textViewCostoenvioR);
        RatingBar ratinCalific= (RatingBar) vista.findViewById(R.id.ratingCalifR);
        ImageView imageRes= (ImageView) vista.findViewById(R.id.imagenRestaurante);
        texNombre.setText(res.getNombre());
        texDireccion.setText(res.getDireccion());
        textPrecio.setText(Integer.toString(res.getPrecioEnvio()));
        ratinCalific.setRating(res.getCalificacion());
        Picasso.get().load(res.getImagen()).into(imageRes);

        return vista;
    }
}
