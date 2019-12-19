package tom.r.projetandroid4a.Controller;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.inputmethod.EditorInfo;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import tom.r.projetandroid4a.Model.Personnage;
import tom.r.projetandroid4a.R;
import tom.r.projetandroid4a.View.MyAdapter;


public class MainActivity extends AppCompatActivity {

    private final String JSON_URL = "https://raw.githubusercontent.com/tomramin/API_2/master/dofus.json" ;
    private JsonArrayRequest request ;
    private RequestQueue requestQueue ;
    private List<Personnage> listePersonnages ;
    private RecyclerView recyclerView ;
    private MyAdapter myAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listePersonnages = new ArrayList<>() ;
        recyclerView = findViewById(R.id.recyclerviewid);
        jsonrequest();

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    private void jsonrequest() {

        request = new JsonArrayRequest(JSON_URL, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                JSONObject jsonObject  = null ;

                for (int i = 0 ; i < response.length(); i++ ) {
                    try {
                        jsonObject = response.getJSONObject(i) ;
                        Personnage personnage = new Personnage() ;
                        personnage.setId(jsonObject.getString("id"));
                        personnage.setClasse(jsonObject.getString("classe"));
                        personnage.setName(jsonObject.getString("name"));
                        personnage.setGender(jsonObject.getString("gender"));
                        personnage.setSort1(jsonObject.getString("sort1"));
                        personnage.setSort2(jsonObject.getString("sort2"));
                        personnage.setSort3(jsonObject.getString("sort3"));
                        personnage.setImage_sort1(jsonObject.getString("image_sort1"));
                        personnage.setImage_sort2(jsonObject.getString("image_sort2"));
                        personnage.setImage_sort3(jsonObject.getString("image_sort3"));
                        personnage.setDescription_wakfu(jsonObject.getString("description_wakfu"));
                        personnage.setDescription_dofus(jsonObject.getString("description_dofus"));
                        personnage.setDescription_dofus_retro(jsonObject.getString("description_dofus_retro"));
                        personnage.setIcone(jsonObject.getString("icone"));
                        personnage.setImage(jsonObject.getString("image"));
                        personnage.setImage_wakfu(jsonObject.getString("image_wakfu"));
                        personnage.setImage_dofus(jsonObject.getString("image_dofus"));
                        personnage.setImage_dofus_retro(jsonObject.getString("image_dofus_retro"));
                        personnage.setLien_dofus(jsonObject.getString("lien_dofus"));
                        personnage.setLien_dofus_retro(jsonObject.getString("lien_dofus_retro"));
                        personnage.setLien_wakfu(jsonObject.getString("lien_wakfu"));
                        listePersonnages.add(personnage);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

                setuprecyclerview(listePersonnages);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        requestQueue = Volley.newRequestQueue(MainActivity.this);
        requestQueue.add(request) ;

    }

    private void setuprecyclerview(List<Personnage> lstpersonnage) {

        myAdapter = new MyAdapter(this,lstpersonnage) ;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(myAdapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.personnage_menu, menu);
        MenuItem searchPerso = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) searchPerso.getActionView();
        searchView.setImeOptions(EditorInfo.IME_ACTION_DONE);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                myAdapter.getFilter().filter(s);

                return false;
            }
        });

        return true;
    }
}
