package unimagdalena.project.com.otrapracticamas.adapters;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by Ingenieros on 16/06/2016.
 */
public class TabViewAdapeter extends FragmentPagerAdapter {

    private ArrayList<Fragment>fragmentos=new ArrayList<>();
    private ArrayList<String>tabTitulo=new ArrayList<>();

    public void addFragmen(Fragment fragment,String titulo ){
        fragmentos.add(fragment);
        tabTitulo.add(titulo);
    }

    public void addFragmen(Fragment fragment){
        fragmentos.add(fragment);
    }

    public TabViewAdapeter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentos.get(position);
    }

    @Override
    public int getCount() {
        return fragmentos.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitulo.get(position);
    }
}
