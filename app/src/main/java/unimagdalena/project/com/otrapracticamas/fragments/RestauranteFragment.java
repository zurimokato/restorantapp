package unimagdalena.project.com.otrapracticamas.fragments;


import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import unimagdalena.project.com.otrapracticamas.R;
import unimagdalena.project.com.otrapracticamas.parsers.GsonRestauranteParser;
import unimagdalena.project.com.otrapracticamas.pojos.Restaurante;
import unimagdalena.project.com.otrapracticamas.adapters.RestauranteRecyclerviewAdapter;
import unimagdalena.project.com.otrapracticamas.adapters.RestaurantesAdapters;


public class    RestauranteFragment extends Fragment {

    private ListView listaRes;
    private RestauranteRecyclerviewAdapter rAdapter;
    private RecyclerView recyView;

    public RestauranteFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v =inflater.inflate(R.layout.fragment_restaurante,container,false);

       // listaRes= (ListView) v.findViewById(R.id.lisResView);
        recyView= (RecyclerView) v.findViewById(R.id.recycleRes);
        recyView.setLayoutManager(new LinearLayoutManager(getActivity()));
        try{
            ConnectivityManager manager= (ConnectivityManager) getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo info = manager.getActiveNetworkInfo();
            if (info!=null &&info.isConnected()){
                //JsonTask jTask=new JsonTask(listaRes,getActivity());
                JsonTask jTask=new JsonTask(recyView,getActivity());
                jTask.execute(new URL("https://dl.dropbox.com/s/8ouq6vdziec6exz/midomicilio.json?dl=0"));
            }else {
                Toast.makeText(getActivity(), "Error de conexión", Toast.LENGTH_LONG).show();
            }
        }catch (MalformedURLException e){
            e.printStackTrace();
        }
        return v;
    }

    public class JsonTask extends AsyncTask<URL,Void,List<Restaurante>>{
        HttpURLConnection cont;
        private RestaurantesAdapters adapters;
        private RestauranteRecyclerviewAdapter rAdapter;
        private Context context;
        private ListView list;
        private RecyclerView recyclerView;

        public JsonTask(ListView list,Context context){
            this.list = list;
            this.context = context;
        }

        public JsonTask(RecyclerView recyclerView,Context context){
            this.recyclerView=recyclerView;
            this.context=context;
        }


        @Override
        protected List<Restaurante> doInBackground(URL... urls) {
            ArrayList<Restaurante>restaurantes=null;
            try{
                cont= (HttpURLConnection) urls[0].openConnection();
                cont.setConnectTimeout(15000);
                cont.setReadTimeout(10000);
                int statusCode=cont.getResponseCode();
                if(statusCode!=200){
                    restaurantes=new ArrayList<>();
                    restaurantes.add(new Restaurante("Error","Error",0,0f,"Error",null,null,null));
                }else {
                    InputStream stream=new BufferedInputStream(cont.getInputStream());
                    GsonRestauranteParser gsonRes=new GsonRestauranteParser();
                    restaurantes= (ArrayList<Restaurante>) gsonRes.leerFlujoJson(stream);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                cont.disconnect();
            }
            return restaurantes;
        }

        @Override
        protected void onPostExecute(final List<Restaurante> restaurantes) {
            super.onPostExecute(restaurantes);
            if(restaurantes!=null){
                rAdapter=new RestauranteRecyclerviewAdapter(getActivity(),restaurantes);
                recyclerView.setAdapter(rAdapter);

                /*adapters=new RestaurantesAdapters(getActivity(),restaurantes);
                list.setAdapter(adapters);
                list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        Intent pasar=new Intent(context, MainActivity2.class);
                        Restaurante resItem= (Restaurante) adapters.getItem(i);
                        pasar.putExtra("resto",resItem);
                        pasar.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(pasar);
                    }
                });*/

            }else{
                Toast.makeText(context, "Ocurrio un error de parsing de json", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
