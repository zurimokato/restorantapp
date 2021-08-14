package unimagdalena.project.com.otrapracticamas.activities;

import android.os.Bundle;
import com.google.android.material.tabs.TabLayout;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import unimagdalena.project.com.otrapracticamas.R;
import unimagdalena.project.com.otrapracticamas.adapters.TabViewAdapeter;
import unimagdalena.project.com.otrapracticamas.fragments.MapFragment;
import unimagdalena.project.com.otrapracticamas.fragments.RestauranteFragment;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TabLayout tabLayout;
        ViewPager pager;
        TabViewAdapeter adapeter;
        int tabIcon[]={R.drawable.ic_local_dining_white,
                R.drawable.ic_map_white};

        tabLayout= (TabLayout) findViewById(R.id.tablayout);
        pager= (ViewPager) findViewById(R.id.viewPager);
        adapeter=new TabViewAdapeter(getSupportFragmentManager());
        //adapeter.addFragmen(new RestauranteFragment(),"Restaurante");
        //adapeter.addFragmen(new MapFragment(),"Maps");

        adapeter.addFragmen(new RestauranteFragment(),"");
        adapeter.addFragmen(new MapFragment(),"");
        pager.setAdapter(adapeter);
        tabLayout.setupWithViewPager(pager);
        tabLayout.getTabAt(0).setIcon(tabIcon[0]);
        tabLayout.getTabAt(1).setIcon(tabIcon[1]);

    }
}
