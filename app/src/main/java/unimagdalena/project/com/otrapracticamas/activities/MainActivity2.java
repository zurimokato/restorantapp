package unimagdalena.project.com.otrapracticamas.activities;

import android.os.Bundle;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import unimagdalena.project.com.otrapracticamas.R;
import unimagdalena.project.com.otrapracticamas.adapters.TabViewPagerAdapter2;
import unimagdalena.project.com.otrapracticamas.fragments.ComentarioFragment;
import unimagdalena.project.com.otrapracticamas.fragments.PlatosFragment;
import unimagdalena.project.com.otrapracticamas.pojos.Restaurante;

public class MainActivity2 extends AppCompatActivity {





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        TabLayout tab;
        ViewPager pager2;
        FloatingActionButton floatingButton;
        TabViewPagerAdapter2 adapter;
        int tabIcon[]={R.drawable.ic_local_pizza_white,
                R.drawable.ic_people_outline_white};
        PlatosFragment platos=new PlatosFragment();
        ComentarioFragment comentario = new ComentarioFragment();
        tab= (TabLayout) findViewById(R.id.tablayout2);
        pager2= (ViewPager) findViewById(R.id.viewPager2);
        adapter=new TabViewPagerAdapter2(getSupportFragmentManager());
        adapter.addFragments(platos,"");
        adapter.addFragments(comentario,"");
        pager2.setAdapter(adapter);
        tab.setupWithViewPager(pager2);
        tab.getTabAt(0).setIcon(tabIcon[0]);
        tab.getTabAt(1).setIcon(tabIcon[1]);

        floatingButton= (FloatingActionButton) findViewById(R.id.flotante);
        floatingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getBaseContext(),"Para ir a la lista del pedido",Toast.LENGTH_SHORT).show();
            }
        });

        Bundle bundle=getIntent().getExtras();
        Restaurante item= (Restaurante) bundle.get("resto");
        Bundle pasarMenu=new Bundle();
        Bundle pasaCom=new Bundle();
        if(item!=null){
            pasarMenu.putParcelable("listaM",item);
            pasaCom.putParcelable("listaC",item);
            platos.setArguments(pasarMenu);
            comentario.setArguments(pasaCom);
        }else{
                Toast.makeText(getBaseContext(),"Error al cargar los archivos",Toast.LENGTH_SHORT ).show();
        }
    }
}
