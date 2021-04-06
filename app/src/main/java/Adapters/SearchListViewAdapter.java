package Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tournament.R;

import java.util.List;

import Data.Tournament;

public class SearchListViewAdapter extends RecyclerView.Adapter<SearchListViewAdapter.ViewHolder> {
    private Context context;
    private List<Tournament> Tournamentlist;
  //  private LayoutInflater layoutInflater;


    public SearchListViewAdapter(Context context, List<Tournament> Tournaments)
    {

        this.context=context;
        this.Tournamentlist=Tournaments;
    }
    public SearchListViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       // View view= layoutInflater.inflate(R.layout.list_row_for_user_dashboard,parent,false);
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.search_list_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SearchListViewAdapter.ViewHolder holder, int position) {


        Tournament tournament = Tournamentlist.get(position);


      //  Picasso.get()
             //   .load(tournament.getImagelist())
                //.into(holder.imageView);
        holder.date.setText(tournament.getDate());
        holder.title.setText(tournament.getTitle());
        holder.prize.setText(String.valueOf(tournament.getPrice()));
        //holder.listname.setText(tournament.getname());
        holder.imageView.setImageResource(R.drawable.createteam);
    }

    @Override
    public int getItemCount() {
        return Tournamentlist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public ImageView imageView;
        public TextView date;

        public TextView prize;
        public TextView title;



        public ViewHolder(View view) {
            super(view);



           imageView = (ImageView) view.findViewById(R.id.searchimage);
            date = (TextView) view.findViewById(R.id.searchratingrating);
            prize = (TextView) view.findViewById(R.id.searchmember);
           title= (TextView) view.findViewById(R.id.searchtitle);





        }

        @Override
        public void onClick(View v) {

        }
    }
}
