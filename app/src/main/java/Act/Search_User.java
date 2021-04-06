package Act;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.tournament.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import Adapters.AllOrganizerListViewAdapter;
import Adapters.SearchListViewAdapter;
import Data.Tournament;

public class Search_User extends AppCompatActivity {
    private RecyclerView recyclerView;
    Button addtoteam, Searchfromlist;
    EditText searchedit;
    private AllOrganizerListViewAdapter recyclerViewAdapter;
    private List<Tournament> tournamentList;
    private List<Tournament> filterlist = new ArrayList<>();
    private RequestQueue queue;
    LinearLayoutManager manager;
    private final String JSON_URL = "https://gist.githubusercontent.com/aws1994/f583d54e5af8e56173492d3f60dd5ebf/raw/c7796ba51d5a0d37fc756cf0fd14e54434c547bc/anime.json";
    private JsonArrayRequest request;
    public SearchListViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search__user);
        recyclerView = findViewById(R.id.lrecyler8);
        addtoteam = findViewById(R.id.addtoteam);
        searchedit = findViewById(R.id.searchedittext);
        Searchfromlist = findViewById(R.id.searchinlistbtn);
        Toolbar toolbar = (Toolbar) findViewById(R.id.Searchtoolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        //progressBar=view.findViewById(R.id.progressBar);
        manager = new LinearLayoutManager(this);
        tournamentList = new ArrayList<>();

        jsonrequest();
        listeners();
    }

    private void listeners() {
        addtoteam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), MyTeams.class);
                startActivity(i);
            }
        });

        searchedit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                 filterlist.clear();
                if (s.toString().isEmpty()) {


                    recyclerView.setAdapter(new SearchListViewAdapter(getApplicationContext(), tournamentList));
                    adapter.notifyDataSetChanged();

                } else {
                    Filter(s.toString());
                }

            }
        });

    }

    private void Filter(String text) {
        for (Tournament tournament : tournamentList) {

            if (Integer.toString(tournament.getPrice()).equals(text)) {

        filterlist.add(tournament);
            }

        }
recyclerView.setAdapter(new SearchListViewAdapter(getApplicationContext(),filterlist));
        adapter.notifyDataSetChanged();
    }

    private void jsonrequest() {
        request = new JsonArrayRequest(JSON_URL, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                JSONObject jsonObject = null;

                for (int i = 0; i < response.length(); i++) {


                    try {
                        jsonObject = response.getJSONObject(i);
                        Tournament anime = new Tournament();
                        anime.setTitle(jsonObject.getString("name"));
                        //anime.setDescription(jsonObject.getString("description"));
                        anime.setDate(jsonObject.getString("Rating"));
                        //anime.(jsonObject.getString("categorie"));
                        anime.setPrice(jsonObject.getInt("episode"));
                        //anime.setStudio(jsonObject.getString("studio"));
                        // anime.setImage(jsonObject.getString(String.valueOf(R.drawable.listrowwww)));

                        tournamentList.add(anime);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }


                }


                adapter = new SearchListViewAdapter(getApplicationContext(), tournamentList);
                recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                recyclerView.setAdapter(adapter);

            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });


        queue = Volley.newRequestQueue(getApplicationContext());
        queue.add(request);

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (item.getItemId() == android.R.id.home) {
            finish();

        }
        return super.onOptionsItemSelected(item);
    }

}