package Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.tournament.R;

import Act.Catagory_Name;

public class Tournament_Catagories_Fragment extends Fragment {
    LinearLayout linearLayout1;
    LinearLayout linearLayout2;
    LinearLayout linearLayout3;
    LinearLayout linearLayout4;
    LinearLayout linearLayout5;
    LinearLayout linearLayout6;
    LinearLayout linearLayout7;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tournament__catagories_, container, false);



    }
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        linearLayout1=view.findViewById(R.id.linearlayout1);
        linearLayout2=view.findViewById(R.id.linearlayout2);
        linearLayout3=view.findViewById(R.id.linearlayout3);
        linearLayout4=view.findViewById(R.id.linearlayout4);
        linearLayout5=view.findViewById(R.id.linearlayout5);
        linearLayout6=view.findViewById(R.id.linearlayout6);
        linearLayout7=view.findViewById(R.id.linearlayout7);
        setonclicklistener();

    }

    private void setonclicklistener() {


        linearLayout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getContext(), Catagory_Name.class);
                startActivity(i);
            }
        });
        linearLayout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getContext(), Catagory_Name.class);
                startActivity(i);
            }
        });
        linearLayout3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getContext(), Catagory_Name.class);
                startActivity(i);
            }
        });
        linearLayout4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getContext(), Catagory_Name.class);
                startActivity(i);
            }
        });
        linearLayout5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getContext(), Catagory_Name.class);
                startActivity(i);
            }
        });
        linearLayout6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getContext(), Catagory_Name.class);
                startActivity(i);
            }
        });
        linearLayout7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getContext(), Catagory_Name.class);
                startActivity(i);
            }
        });
    }

}