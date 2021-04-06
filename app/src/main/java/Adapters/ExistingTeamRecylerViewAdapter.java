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

import Act.TeamDetail;
import Data.ExistingTeams;


public class ExistingTeamRecylerViewAdapter extends RecyclerView.Adapter<ExistingTeamRecylerViewAdapter.ViewHolder> {
    private Context context;
    private List<ExistingTeams> Tournamentlist;
    //  private LayoutInflater layoutInflater;


    public ExistingTeamRecylerViewAdapter(Context context, List<ExistingTeams> Tournaments)
    {
        this.context=context;
        this.Tournamentlist=Tournaments;
    }
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // View view= layoutInflater.inflate(R.layout.list_row_for_user_dashboard,parent,false);
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_row_for_existing_team, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {


        ExistingTeams listItem = Tournamentlist.get(position);
        holder.name.setText(listItem.getTitle());
        holder.description.setText(String.valueOf(listItem.getMember()));
        holder.rating.setText(listItem.getRating());

        holder.imageView.setImageResource(R.drawable.createteam);
    }

    @Override
    public int getItemCount() {
        return Tournamentlist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView name;
        public TextView description;
        public TextView rating;
        public ImageView imageView;
       public Button viewdetail;



        public ViewHolder(View view) {
            super(view);


            name = (TextView) itemView.findViewById(R.id.exisitingteamtitle);
            description = (TextView) itemView.findViewById(R.id.exisitingteammembers);
            rating = (TextView) itemView.findViewById(R.id.exsitingteamrating);
            imageView = (ImageView) itemView.findViewById(R.id.exsitingteamimage);
            viewdetail=view.findViewById(R.id.listviewdetailbutton);



            viewdetail.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //go to next screen/ DetailsActivity
                    int position = getAdapterPosition();
//
//                    Grocery grocery = groceryItems.get(position);
                    Intent intent = new Intent(context, TeamDetail.class);
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

