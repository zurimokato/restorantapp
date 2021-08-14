package unimagdalena.project.com.otrapracticamas.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import unimagdalena.project.com.otrapracticamas.R;
import unimagdalena.project.com.otrapracticamas.pojos.Menu;

/**
 * Created by Ingenieros on 17/06/2016.
 */
public class MenuAdapter extends BaseAdapter {
    private LayoutInflater inflater;
    private Context context;
    private List<Menu>menus;


    public MenuAdapter(Context context, List<Menu> menus) {
        this.context = context;
        this.menus = menus;
    }

    @Override
    public int getCount() {
        return menus.size();
    }

    @Override
    public Object getItem(int i) {
        return menus.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View vista=inflater.inflate(R.layout.menu,viewGroup,false);
        Menu menuI= (Menu) getItem(i);
        TextView platoNom,platoPre,platoDes;
        ImageView imagePlato;
        platoNom= (TextView) vista.findViewById(R.id.textNombreP);
        imagePlato= (ImageView) vista.findViewById(R.id.imagePlato);
        platoPre= (TextView) vista.findViewById(R.id.textPrecioPlato);
        platoDes=(TextView)vista.findViewById(R.id.textDescripcionPlato);

        platoNom.setText(menuI.getNombre());
        Picasso.get().load(menuI.getImagen()).into(imagePlato);
        platoPre.setText(Integer.toString(menuI.getPrecio()));
        platoDes.setText(menuI.getDescripcion());
        return vista;
    }
}
