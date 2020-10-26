package ListAdapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tournament.R;
import com.squareup.picasso.Picasso;

import java.util.List;

import Tournament.Tournament;

public class TournamentListViewAdapter extends RecyclerView.Adapter<TournamentListViewAdapter.ViewHolder> {
    private Context context;
    private List<Tournament> Tournamentlist;
  //  private LayoutInflater layoutInflater;


    public TournamentListViewAdapter(Context context, List<Tournament> Tournaments)
    {

        this.context=context;
        this.Tournamentlist=Tournaments;
    }
    public TournamentListViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       // View view= layoutInflater.inflate(R.layout.list_row_for_user_dashboard,parent,false);
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_row_for_user_dashboard, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TournamentListViewAdapter.ViewHolder holder, int position) {


        Tournament tournament = Tournamentlist.get(position);


        Picasso.get()
                .load(tournament.getImagelist())
                .into(holder.imageView);
        holder.date.setText(tournament.getDate());
        holder.prize.setText(tournament.getPrice());
        holder.listname.setText(tournament.getTournamentname());
    }

    @Override
    public int getItemCount() {
        return Tournamentlist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public ImageView imageView;
        public TextView date;
        public TextView listname;
        public TextView prize;
        public  Button viewdetail;


        public ViewHolder(View view) {
            super(view);



           imageView = (ImageView) view.findViewById(R.id.Tournamentimage);
            date = (TextView) view.findViewById(R.id.tournamentlistdate);
            prize = (TextView) view.findViewById(R.id.tournamentlistprize);

            viewdetail = (Button) view.findViewById(R.id.listviewdetailbutton);


          viewdetail.setOnClickListener(this);


            viewdetail.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //go to next screen/ DetailsActivity
//                    int position = getAdapterPosition();
//
//                    Grocery grocery = groceryItems.get(position);
//                    Intent intent = new Intent(context, DetailsActivity.class);
//                    intent.putExtra("name", grocery.getName());
//                    intent.putExtra("quantity", grocery.getQuantity());
//                    intent.putExtra("id", grocery.getId());
//                    intent.putExtra("date", grocery.getDateItemAdded());
//                    context.startActivity(intent);


                }
            });
        }

        @Override
        public void onClick(View v) {

        }
    }
}
