package unimagdalena.project.com.otrapracticamas.fragments;


import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import unimagdalena.project.com.otrapracticamas.R;
import unimagdalena.project.com.otrapracticamas.adapters.MenuAdapter;
import unimagdalena.project.com.otrapracticamas.adapters.MenuRecyclerAdapter;
import unimagdalena.project.com.otrapracticamas.pojos.Restaurante;


public class PlatosFragment extends Fragment {
    private ListView menu;
    private RecyclerView menuRecycler;
    private MenuAdapter menuA;
    private MenuRecyclerAdapter menuAdpater;

    public PlatosFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View vista=inflater.inflate(R.layout.fragment_platos,container,false);
        Bundle resive=this.getArguments();
        Restaurante resItem=resive.getParcelable("listaM");
        if(resItem!=null){
            menuRecycler= (RecyclerView) vista.findViewById(R.id.recyMenu);
            menuAdpater=new MenuRecyclerAdapter(getActivity(),resItem.getMenu());
            menuRecycler.setLayoutManager(new LinearLayoutManager(getActivity()));
            menuRecycler.setAdapter(menuAdpater);
           /* menuA=new MenuAdapter(getActivity(),resItem.getMenu());
            menu= (ListView) vista.findViewById(R.id.listMenu);
            menu.setAdapter(menuA);
            menu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    Menu menuitem= (Menu) menuA.getItem(i);
                    Intent pasarPlato=new Intent(getActivity(), MainActivity3.class);
                    pasarPlato.putExtra("plato",menuitem);
                    pasarPlato.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(pasarPlato);
                }
            });*/
        }else{
            Toast.makeText(getActivity(),"Tampoco se pasa nada",Toast.LENGTH_SHORT).show();

        }

        return vista;
    }

}
