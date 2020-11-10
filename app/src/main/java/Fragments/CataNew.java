package Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
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
import Data.Tournament;

public class CataNew extends Fragment {

    private RecyclerView recyclerView;
    private AllOrganizerListViewAdapter recyclerViewAdapter;
    private List<Tournament> tournamentList;
    private RequestQueue queue;
    LinearLayoutManager manager;
    private final String JSON_URL = "https://gist.githubusercontent.com/aws1994/f583d54e5af8e56173492d3f60dd5ebf/raw/c7796ba51d5a0d37fc756cf0fd14e54434c547bc/anime.json";
    private JsonArrayRequest request;
    public AllOrganizerListViewAdapter adapter;
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //  getexsistingteams();

        // RecyclerView recyclerView = view.findViewById(R.id.exsitingteamRecylerview);
        recyclerView = view.findViewById(R.id.lrecyler6);
        //progressBar=view.findViewById(R.id.progressBar);
        manager = new LinearLayoutManager(getContext());
        tournamentList = new ArrayList<>();

        jsonrequest();


    }
    private void jsonrequest() {  request = new JsonArrayRequest(JSON_URL, new Response.Listener<JSONArray>() {
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


            adapter = new AllOrganizerListViewAdapter(getContext(),tournamentList);
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
            recyclerView.setAdapter(adapter);

        }

    }, new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {

        }
    });


        queue = Volley.newRequestQueue(getContext());
        queue.add(request);

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cata_new, container, false);
    }
}