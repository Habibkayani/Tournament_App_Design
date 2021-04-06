package Act;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.tournament.R;

;

public class Tournament_Detials extends AppCompatActivity {

    private Dialog dialog,dialog1;
    private Button participants;
     private TextView notnow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tournament__detials);
        /////  for bac button on toolbar///////
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar22);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        /////////////////////////////////////////
        participants=findViewById(R.id.paticipantbtn);
        notnow=findViewById(R.id.notnow);




        dialog=new Dialog(this);
       // dialog1=new Dialog(this);
        participants();


    }

    private void participants() {
        participants.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dialog.setContentView(R.layout.tournament_detail_dialog);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                ImageView userdialodimage = dialog.findViewById(R.id.userdialogimage);
                Button indiviual = dialog.findViewById(R.id.TournamentDetailDialogindivualbtn);
                Button team = dialog.findViewById(R.id.TournamentDetailDialogteambtn);

                indiviual.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        dialog.setContentView(R.layout.indiviual_successfull_dialog);
                        Button home = dialog.findViewById(R.id.organizergotohomebtn);
                        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                        home.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                dialog.dismiss();
                                Intent i = new Intent(getApplicationContext(), UserDashboard.class);
                                startActivity(i);
                            }
                        });
                    }

                });
                //dialog1.show();
                dialog.show();
               team.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        dialog.dismiss();
                        Intent i = new Intent(getApplicationContext(), MyTeams.class);
                        startActivity(i);
                    }
                });






            }
        });
        notnow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), UserDashboard.class);
                startActivity(i);
            }
        });
    }



    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if(item.getItemId() == android.R.id.home)
        {finish();

        }
        return super.onOptionsItemSelected(item);
    }
}