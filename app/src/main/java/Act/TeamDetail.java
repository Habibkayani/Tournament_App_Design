package Act;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.tournament.R;

public class TeamDetail extends AppCompatActivity {

    private Dialog dialog;
    Button participants,teamdetail;
    TextView left;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_detail);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar223);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
participants=findViewById(R.id.teamdeatilparticipantbtn);
        teamdetail=findViewById(R.id.teamdeatiladdbtn);
        left=findViewById(R.id.leftthisteam);
        dialog=new Dialog(this);
        participants();
        listeners();


    }

    private void listeners() {

        teamdetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),Search_User.class);
                startActivity(i);
            }
        });
    }

    private void participants() {

        participants.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.setContentView(R.layout.indiviual_successfull_dialog);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                Button partintour = dialog.findViewById(R.id.organizergotohomebtn);
                partintour.setOnClickListener(new View.OnClickListener() {
                    @Override
                            public void onClick(View v) {
                                dialog.dismiss();
                                Intent i = new Intent(getApplicationContext(), UserDashboard.class);
                                startActivity(i);


                    }

                });
                //dialog1.show();
                dialog.show();
            }
        });
        left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), MyTeams.class);
                startActivity(i);
            }
        });
    }

    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if(item.getItemId() == android.R.id.home)
        {finish();
        }
        return super.onOptionsItemSelected(item);
    }
}