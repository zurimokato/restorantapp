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
import unimagdalena.project.com.otrapracticamas.adapters.ComentarioAdapter;
import unimagdalena.project.com.otrapracticamas.adapters.ComentarioRecyclerAdpater;
import unimagdalena.project.com.otrapracticamas.pojos.Restaurante;

public class ComentarioFragment extends Fragment {
    private ListView comentarios;
    private ComentarioAdapter comenAdap;
    private RecyclerView comenRecy;
    private ComentarioRecyclerAdpater recyclerAdpater;

    public ComentarioFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View vis = inflater.inflate(R.layout.fragment_comentario, container, false);
        Bundle resiveC = this.getArguments();
        Restaurante resItem = resiveC.getParcelable("listaC");
        if (resItem != null) {
            comenRecy= (RecyclerView) vis.findViewById(R.id.recyComent);
            recyclerAdpater=new ComentarioRecyclerAdpater(getActivity(),resItem.getComentarios());
            comenRecy.setLayoutManager(new LinearLayoutManager(getActivity()));
            comenRecy.setAdapter(recyclerAdpater);
           /* comentarios = (ListView) vis.findViewById(R.id.listComentario);
            comenAdap = new ComentarioAdapter(getActivity(), resItem.getComentarios());
            comentarios.setAdapter(comenAdap);*/
        }else{
            Toast.makeText(getActivity(),"Tampoco se pasa nada",Toast.LENGTH_SHORT).show();
        }
        return vis;
    }
}