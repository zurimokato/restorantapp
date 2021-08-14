package unimagdalena.project.com.otrapracticamas.adapters;

import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by Ingenieros on 02/07/2016.
 */
public class TabViewPagerAdapter2 extends FragmentPagerAdapter {

    private ArrayList<Fragment>fragments=new ArrayList<>();
    private ArrayList<String>titulos=new ArrayList<>();
    private Context context;

    public TabViewPagerAdapter2(FragmentManager fm) {
        super(fm);
        this.fragments = fragments;
        this.titulos = titulos;
        this.context = context;
    }

    public void addFragments(Fragment fragment, String titulo){
        fragments.add(fragment);
        titulos.add(titulo);
    }

    public void addFragments(Fragment fragment){
        fragments.add(fragment);
    }


    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titulos.get(position);
    }
}
