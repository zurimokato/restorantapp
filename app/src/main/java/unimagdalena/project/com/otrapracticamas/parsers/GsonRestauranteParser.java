package unimagdalena.project.com.otrapracticamas.parsers;



import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import unimagdalena.project.com.otrapracticamas.pojos.Restaurante;

/**
 * Created by Ingenieros on 17/06/2016.
 */
public class GsonRestauranteParser  {
    public List<Restaurante>leerFlujoJson(InputStream in)throws IOException{
        Gson gson=new Gson();
        JsonReader reader=new JsonReader(new InputStreamReader(in, "UTF-8"));
        List<Restaurante>restaurantes=new ArrayList<>();
        Restaurante restaurante=null;
        reader.beginArray();
        while(reader.hasNext()){
            restaurante=gson.fromJson(reader,Restaurante.class);
            restaurantes.add(restaurante);
        }
        reader.endArray();
        reader.close();
        return restaurantes;
    }
}
