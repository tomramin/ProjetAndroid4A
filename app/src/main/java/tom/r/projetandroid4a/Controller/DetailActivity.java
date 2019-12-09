package tom.r.projetandroid4a.Controller;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import tom.r.projetandroid4a.Fragment.FragmentAdapter;
import tom.r.projetandroid4a.Fragment.FragmentDofus;
import tom.r.projetandroid4a.Fragment.FragmentDofusRetro;
import tom.r.projetandroid4a.Fragment.FragmentWakfu;
import tom.r.projetandroid4a.R;

public class DetailActivity extends AppCompatActivity {

    private TabLayout tableLayout;
    private ViewPager viewPager;
    private FragmentAdapter fragmentAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.perso_detail);

        tableLayout = (TabLayout) findViewById(R.id.tablayout_id);
        viewPager = (ViewPager) findViewById(R.id.viewpager_id);
        fragmentAdapter = new FragmentAdapter(getSupportFragmentManager());

        tableLayout.setTabTextColors(getResources().getColor(R.color.blanc),getResources().getColor(R.color.doré));

        fragmentAdapter.AddFragments(new FragmentDofus(), "Dofus");
        fragmentAdapter.AddFragments(new FragmentWakfu(), "Wakfu");
        fragmentAdapter.AddFragments(new FragmentDofusRetro(), "Dofus Retro");

        viewPager.setAdapter(fragmentAdapter);
        tableLayout.setupWithViewPager(viewPager);

        /*tablayout.getTabAt(0).setIcon(R.drawable.ic_group);
        tablayout.getTabAt(1).setIcon(R.drawable.ic_equipment);
        tablayout.getTabAt(2).setIcon(R.drawable.ic_arme);*/

    }
}
