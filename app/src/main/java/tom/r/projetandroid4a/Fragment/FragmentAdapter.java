package tom.r.projetandroid4a.Fragment;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class FragmentAdapter extends FragmentPagerAdapter {
    private final List<Fragment> listeFragments = new ArrayList<>();
    private final List<String> listeTitre = new ArrayList<>();

    public FragmentAdapter(FragmentManager fragmentManager){
        super(fragmentManager);
    }

    @Override
    public Fragment getItem(int position) {
        return listeFragments.get(position);
    }

    @Override
    public int getCount() {
        return listeTitre.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return listeTitre.get(position);
    }

    public void AddFragments (Fragment fragment, String title){
        listeFragments.add(fragment);
        listeTitre.add(title);
    }
}
