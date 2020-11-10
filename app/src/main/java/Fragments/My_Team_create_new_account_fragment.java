package Fragments;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.tournament.R;

import Act.MyTeams;
import Act.Search_User;
import Act.UserDashboard;

public class My_Team_create_new_account_fragment extends Fragment {
Dialog dialog;

Button createteam;
Button addteam;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_my__team_create_new_account_fragment, container, false);



    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        createteam=view.findViewById(R.id.createteambtn);
        addteam=view.findViewById(R.id.addteam);
        dialog=new Dialog(getActivity());
        clicklistenere();
        anotherlistener();



    }

    private void anotherlistener() {
        addteam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getContext(), Search_User.class);
                startActivity(i);
            }
        });
    }

    private void clicklistenere() {


        createteam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.setContentView(R.layout.user_create_team_dialog);
                Button home = dialog.findViewById(R.id.userdialogparticioatebtn);
                TextView notnow = dialog.findViewById(R.id.userdialogtextnotnow);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

                home.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.setContentView(R.layout.indiviual_successfull_dialog);
                        Button home2 = dialog.findViewById(R.id.organizergotohomebtn);
                        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                        home2.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                dialog.dismiss();
                                Intent i = new Intent(getContext(), UserDashboard.class);
                                startActivity(i);
                            }
                        });

                    }

                });

                dialog.show();
                notnow.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                        Intent i = new Intent(getContext(), MyTeams.class);
                        startActivity(i);
                    }
                });

            }

        });



    }
}