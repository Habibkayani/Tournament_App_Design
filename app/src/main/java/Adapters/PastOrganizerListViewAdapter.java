package Adapters;

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

import java.util.List;

import Act.Organizer_Tournament_Detail;
import Data.Tournament;

public class PastOrganizerListViewAdapter extends RecyclerView.Adapter<PastOrganizerListViewAdapter.ViewHolder> {
    private Context context;
    private List<Tournament> Tournamentlist;
  //  private LayoutInflater layoutInflater;


    public PastOrganizerListViewAdapter(Context context, List<Tournament> Tournaments)
    {

        this.context=context;
        this.Tournamentlist=Tournaments;
    }
    public PastOrganizerListViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       // View view= layoutInflater.inflate(R.layout.list_row_for_user_dashboard,parent,false);
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_row_for_user_dashboard, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PastOrganizerListViewAdapter.ViewHolder holder, int position) {


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
        public TextView listname;
        public TextView prize;
        public TextView title;
        public  Button viewdetail;


        public ViewHolder(View view) {
            super(view);



           imageView = (ImageView) view.findViewById(R.id.Tournamentimage);
            date = (TextView) view.findViewById(R.id.tournamentlistdate);
            prize = (TextView) view.findViewById(R.id.tournamentlistprize);
           title= (TextView) view.findViewById(R.id.tournamentlistname);
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
                    Intent intent = new Intent(context, Organizer_Tournament_Detail.class);
//                    intent.putExtra("name", grocery.getName());
//                    intent.putExtra("quantity", grocery.getQuantity());
//                    intent.putExtra("id", grocery.getId());
//                    intent.putExtra("date", grocery.getDateItemAdded());
                    context.startActivity(intent);

                }
            });
        }

        @Override
        public void onClick(View v) {

        }
    }
}
