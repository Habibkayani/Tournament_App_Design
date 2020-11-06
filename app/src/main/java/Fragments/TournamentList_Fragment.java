package Act;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tournament.R;

import java.util.ArrayList;
import java.util.List;

import ListAdapters.TournamentListViewAdapter;
import Tournament.Tournament;

public class TournamentList_Fragment extends Fragment {
    private RecyclerView recyclerView;
    private TournamentListViewAdapter recyclerViewAdapter;
    private List<Tournament> tournamentList, listItems;
    //private List<Grocery> listItems;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tournament_list_, container, false);
//        recyclerView = view.findViewById(R.id.lrecyler);
//        recyclerView.setHasFixedSize(true);
//        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
//        initdata();
//
//
//        recyclerViewAdapter = new TournamentListViewAdapter(getContext(), tournamentList);
//        recyclerView.setAdapter(recyclerViewAdapter);
//        recyclerViewAdapter.notifyDataSetChanged();
//        // Inflate the layout for this fragment
//
//
//
//
//});
//
//    private List<Tournament> initdata() {
//        tournamentList = new ArrayList<>();
//
//        for (Tournament c : tournamentList) {
//            Tournament tournament = new Tournament();
//            tournament.setTournamentname(c.getTournamentname());
//            tournament.setPrice(c.getPrice());
//            tournament.setImagelist(c.getImagelist());
//            tournament.setDate(c.getDate());
//            tournamentList.add(tournament);
//
//
//        }
//      return tournamentList;
//    }

        return view;
    }
}
