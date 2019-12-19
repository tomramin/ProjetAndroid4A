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

/**
 * @author Tom
 */
// deuxième activité contenant les 3 fragments
public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        TabLayout tableLayout;
        ViewPager viewPager;
        FragmentAdapter fragmentAdapter;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.perso_detail);

        tableLayout = findViewById(R.id.tablayout_id);
        viewPager = findViewById(R.id.viewpager_id);
        fragmentAdapter = new FragmentAdapter(getSupportFragmentManager());

        // couleur du nom du fragment non sélectionné puis sélectionné
        tableLayout.setTabTextColors(getResources().getColor(R.color.blanc),getResources().getColor(R.color.doré));

        // ajout des trois fragments
        fragmentAdapter.AddFragments(new FragmentWakfu(), "Wakfu");
        fragmentAdapter.AddFragments(new FragmentDofus(), "Dofus");
        fragmentAdapter.AddFragments(new FragmentDofusRetro(), "Dofus Retro");

        viewPager.setAdapter(fragmentAdapter);
        tableLayout.setupWithViewPager(viewPager);
    }
}
