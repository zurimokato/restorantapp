package unimagdalena.project.com.otrapracticamas.activities;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import unimagdalena.project.com.otrapracticamas.R;
import unimagdalena.project.com.otrapracticamas.pojos.Menu;

public class MainActivity3 extends AppCompatActivity {

    private Button agregar;
    private Bundle resive;
    private TextView nombrePlato;
    private TextView precioPlato;
    private ImageView imagePlato;
    private ImageButton imageButton;
    private TextView textCabe;
    private TextView descripPlato;
    private Button netx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        nombrePlato=(TextView) findViewById(R.id.nombrePlato);
        precioPlato=(TextView) findViewById(R.id.precioPlato);
        imagePlato=(ImageView)findViewById(R.id.imagenPlato);
        textCabe=(TextView)findViewById(R.id.cabeza);
        netx=(Button)findViewById(R.id.bAgregar);
        descripPlato=(TextView)findViewById(R.id.textDescripcionPlato) ;

        agregar= (Button) findViewById(R.id.bAgregar);
        agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getBaseContext(),"Para agregar el pedido",Toast.LENGTH_SHORT).show();
            }
        });


        resive=getIntent().getExtras();

        Menu menu = (Menu) resive.get("plato");

        if(menu ==null){
            Toast.makeText(getBaseContext(),"Error al paso del objeto",Toast.LENGTH_SHORT).show();
        }else{
            nombrePlato.setText(menu.getNombre());
            precioPlato.setText("$"+Integer.toString(menu.getPrecio()));
            Picasso.get().load(menu.getImagen()).into(imagePlato);
            textCabe.setText(menu.getNombre());

            descripPlato.setText(menu.getDescripcion());

            netx.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent pasar = new Intent(getApplicationContext(),MainActivity4.class);
                    pasar.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(pasar);


                }
            });
        }




    }
}
