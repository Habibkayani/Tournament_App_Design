package Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

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

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import Adapters.ExistingTeamRecylerViewAdapter;
import Data.ExistingTeams;


public class MyteamExistingteamfragment extends Fragment {
    List<ExistingTeams> teams;
    RecyclerView recyclerView;
    private RequestQueue queue;
    LinearLayoutManager manager;
    ProgressBar progressBar;

    private final String JSON_URL = "https://gist.githubusercontent.com/aws1994/f583d54e5af8e56173492d3f60dd5ebf/raw/c7796ba51d5a0d37fc756cf0fd14e54434c547bc/anime.json";
    private JsonArrayRequest request;
    public ExistingTeamRecylerViewAdapter adapter;



    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //  getexsistingteams();

        // RecyclerView recyclerView = view.findViewById(R.id.exsitingteamRecylerview);
        recyclerView = view.findViewById(R.id.teamrecylercview);
        //progressBar=view.findViewById(R.id.progressBar);
        manager=new LinearLayoutManager(getContext());
        teams = new ArrayList<>();

        jsonrequest();


    }

    private void jsonrequest() {

        request = new JsonArrayRequest(JSON_URL, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                JSONObject jsonObject = null;

                for (int i = 0; i < response.length(); i++) {


                    try {
                        jsonObject = response.getJSONObject(i);
                        ExistingTeams anime = new ExistingTeams();
                        anime.setTitle(jsonObject.getString("name"));
                        //anime.setDescription(jsonObject.getString("description"));
                        anime.setRating(jsonObject.getString("Rating"));
                        //anime.(jsonObject.getString("categorie"));
                        anime.setMember(jsonObject.getInt("episode"));
                        //anime.setStudio(jsonObject.getString("studio"));
                        // anime.setImage(jsonObject.getString(String.valueOf(R.drawable.listrowwww)));

                        teams.add(anime);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }


                }


                adapter = new ExistingTeamRecylerViewAdapter(getActivity(),teams);
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







    //  getData(page,limit);


//    private void getData(int page, int limit) {
//
//        //intialze retrofit
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl("https://gist.githubusercontent.com/aws1994/f583d54e5af8e56173492d3f60dd5ebf/raw/c7796ba51d5a0d37fc756cf0fd14e54434c547bc/anime.json")
//                .addConverterFactory(ScalarsConverterFactory.create())
//                .build();
//        //create main interface
//        MainInterface mainInterface =retrofit.create(MainInterface.class);
//        ///iIntialice call
//        Call<String> call=mainInterface.STRING_CALL(page,limit);
//        call.enqueue(new Callback<String>() {
//            @Override
//            public void onResponse(Call<String> call, retrofit2.Response<String> response) {
//                if (response.isSuccessful() && response.body() !=null){
//               //When Response is Sucessfull and not empty
//                    //hide progress bar
//                  progressBar.setVisibility(View.GONE);
//
//                    try {
//                        //intialize jason array
//
//                        JSONArray jsonArray= new JSONArray(response.body());
//
//                        ParseResult(jsonArray);
//                    } catch (JSONException e) {
//                        e.printStackTrace();
//                    }
//
//                }
//            }
//
//            @Override
//            public void onFailure(Call<String> call, Throwable t) {
//
//            }
//        });
//        GitHubService service = retrofit.create(GitHubService.class);
////          progressBar.setVisibility(getView().VISIBLE);
////          new Handler().postDelayed(new Runnable() {
////              @Override
////              public void run() {
////                  for(int i=0;i<5;i++)
////                  {
////
////                      teams.add(Math.floor(Math.random()*100)+"");
////                  }
////              }
////          })
//    }
//
//    private void ParseResult(JSONArray jsonArray) {
//
//        //use for loop
//        for(int i=0;i<jsonArray.length();i++){
//
//
//            try {
//                JSONObject object =jsonArray.getJSONObject(i);
//                ExistingTeams t=new ExistingTeams();
//                t.setTitle(object.getString("name"));
//                t.setRating(object.getString("Rating"));
//                t.setMember(object.getInt("episode"));
//                teams.add(t);
//
//            } catch (JSONException e) {
//                e.printStackTrace();
//            }
//            //intializeadapter
//
//
//        }
//    }


//    private void extractSongs() {
//
//        RequestQueue queue = Volley.newRequestQueue(getContext());
//        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, JSON_URL, null, new Response.Listener<JSONArray>() {
//            @Override
//            public void onResponse(JSONArray response) {
//                for (int i = 0; i < response.length(); i++) {
//                    try {
//                        JSONObject songObject = response.getJSONObject(i);
//
//                        ExistingTeams song = new ExistingTeams();
//                        song.setTitle(songObject.getString("song"));
//                        song.setRating(songObject.getString("artists"));
//                        song.setImage(songObject.getString("cover_image"));
//                        song.setMember(songObject.getString("url"));
//                        teams.add(song);
//
//                    } catch (JSONException e) {
//                        e.printStackTrace();
//                    }
//                }
//
//                recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
//                adapter = new ExistingTeamRecylerViewAdapter(getContext(),teams);
//                recyclerView.setAdapter(adapter);
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                Log.d("tag", "onErrorResponse: " + error.getMessage());
//            }
//        });
//
//        queue.add(jsonArrayRequest);
//
//    }



//    private void extractteam() {
//
//        RequestQueue queue= Volley.newRequestQueue(getContext());
//        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Request.Method.GET,get_jason(), null,
//                new Response.Listener<JSONArray>() {
//
//
//
//                    @Override
//                    public void onResponse(JSONArray response) {
//
//
//                        for (int i = 0; i < response.length(); i++) {
//
//
//                            try {
//                                JSONObject Song = response.getJSONObject(i);
//                                ExistingTeams team1 = new ExistingTeams();
//                                // dataa.setId(movieObj.getString("userId"));
//                                team1.setTitle(Song.getString("title"));
//                               // team1.setMember(Integer.parseInt(Song.getString("members")));
//                                //team1.setRating(Integer.parseInt(Song.getString("rating")));
//                                team1.setMember(Song.getString("members"));
//                                team1.setRating(Song.getString("rating"));
//                                team1.setImage(Song.getString("img-url"));
//
//
//                                teams.add(team1);
//
//                            } catch (JSONException e) {
//                                e.printStackTrace();
//                            }
//
//
//                        }
//                        //recyclerView123.setHasFixedSize(true);
//                       adapter= new ExistingTeamRecylerViewAdapter(getContext(),teams);
//                        recyclerView.setAdapter(adapter);
//                        adapter.notifyDataSetChanged();
//
//
//
//                    }
//
//
//                }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                Toast.makeText(getContext(),"Error message"+error,Toast.LENGTH_LONG).toString();
//            }
//        });
//        queue.add(jsonArrayRequest);
//    }

//    private void getlist() {
//        // dataList1.clear();
//        queue = Volley.newRequestQueue(getContext());
//        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(
//                Request.Method.GET,
//                URL,
//                null, new Response.Listener<JSONArray>() {
//
//
//            @Override
//            public void onResponse(JSONArray response) {
//
//
//                for (int i = 0; i<response.length(); i++) {
//
//
//                    try {
//                        JSONObject  movieObj = response.getJSONObject(i);
//                        team1= new ExistingTeams();
//                        // dataa.setId(movieObj.getString("userId"));
//                        team1.setMember(movieObj.getString("userId"));
//                       team1.setRating(movieObj.getString("id"));
//                        team1.setTitle(movieObj.getString("title"));
//
//
//
//                    } catch (JSONException e) {
//                        e.printStackTrace();
//                    }
//                    teams.add(team1);
//
//
//                }
//
//                /**
//                 * Very important!! Otherwise, we wont see anything being displayed.
//                 */
//                // dataRecyclerViewAdapter.notifyDataSetChanged();//Important!!
//
//                recyclerView.setHasFixedSize(true);
//                recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
//
//                adapter = new ExistingTeamRecylerViewAdapter(getContext(),teams);
//                recyclerView.setAdapter(adapter);
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//
//            }
//        });
//
//        queue.add(jsonArrayRequest);
//
//
//    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_my_team__existing_team_, container, false);


    }


    private String get_jason() {

        String jason = null;

        try {
            InputStream is = getContext().getAssets().open("temp.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            jason = new String(buffer, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }

        return jason;


    }
}