package Act;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.tournament.R;

public class Organizer_Create_New_Tournament extends AppCompatActivity {
    androidx.appcompat.widget.Toolbar toolbar;
    Spinner spinner;
    Dialog dialog;
    Button create_team;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_organizer__create__new__tournament);

        dialog=new Dialog(this);
        settoolbar();
        spinner();
        message();
    }

    private void settoolbar() {
        toolbar = findViewById(R.id.toolbarcreate);
        setSupportActionBar(toolbar);
        create_team=findViewById(R.id.organizercreatetournamnet);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    private void message() {
        create_team.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.setContentView(R.layout.organizer_tournament_create_dialog);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                Button indiviual = dialog.findViewById(R.id.gotobtn);
                TextView team = dialog.findViewById(R.id.anothertournament);

                indiviual.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {


                        dialog.dismiss();
                        Intent i = new Intent(getApplicationContext(), OrganizerDashBoard.class);
                        startActivity(i);


                    }

                });
                dialog.show();
                team.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        dialog.dismiss();
                    }
                });

            }
        });

            }


    private void spinner() {
         spinner=findViewById(R.id.spinner);
        ArrayAdapter<String> adapter=new ArrayAdapter<>(Organizer_Create_New_Tournament.this,R.layout.custom_spinner,getResources().getStringArray(R.array.LIST));
        adapter.setDropDownViewResource(R.layout.custom_spinner_dropdown);
        spinner.setAdapter(adapter);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if(item.getItemId() == android.R.id.home)
        {finish();

        }
        return super.onOptionsItemSelected(item);
    }
}