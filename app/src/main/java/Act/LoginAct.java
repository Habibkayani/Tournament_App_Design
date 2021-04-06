package Act;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatRadioButton;

import com.example.tournament.R;

import static com.example.tournament.R.color.red_color_almost;
import static com.example.tournament.R.color.white;

public class LoginAct extends AppCompatActivity {


    private Button b1,b2;
   private TextView ll,Login;
   private RadioButton rbuser1,rborganizer2;
   private RadioGroup radiogroup;
    RadioGroup group;

    public LoginAct() {
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        b1=findViewById(R.id.rbuser);
        b2=findViewById(R.id.rborganizer);
   ll=findViewById(R.id.textView);
        Login=findViewById(R.id.LLogin);


      group= (RadioGroup) findViewById(R.id.radioAlgorithms);
        rborganizer2=findViewById(R.id.rborganizer);
        rbuser1=findViewById(R.id.rbuser);
        buttonclick();




    }

    private void buttonclick() {

         Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                boolean isSelected = ((AppCompatRadioButton) v).isClickable();
//                switch ((v.getId())) {
//                    case R.id.rbuser:
//                        if (isSelected) {
//                            Intent i = new Intent(getApplicationContext(), UserDashboard.class);
//                            startActivity(i);
//
//                        }
//                        break;
//                    case R.id.rborganizer:
//                        if (isSelected) {
//
//                            Intent i = new Intent(getApplicationContext(), OrganizerDashBoard.class);
//                            startActivity(i);
//                        }
//                        break;
//
//
//                }
                        int id = group.getCheckedRadioButtonId();
                        switch (id) {
                            case R.id.rbuser:
                                // Your code
                                Intent ir=new Intent(getApplicationContext(), UserDashboard.class);
                                startActivity(ir);
                                break;
                            case R.id.rborganizer:
                                // Your code
                                Intent irr=new Intent(getApplicationContext(), OrganizerDashBoard.class);
                                startActivity(irr);
                                break;

                            default:
                                // Your code
                                break;
                        }
                    }
                });






         ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(), ForUserSignUp.class);
                startActivity(i);
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(b2.isClickable()) {
                    //b2.setBackgroundColor(b2.getContext().getResources().getDrawable(R.drawable.custom_button));
                    b2.setBackgroundResource(R.drawable.custom_button);
                    b2.setTextColor(getApplication().getResources().getColor(white));
                    //b1.setBackgroundColor(b1.getContext().getResources().getColor(white));
                    b1.setBackgroundResource(R.drawable.custom2);
                    b1.setTextColor(getApplication().getResources().getColor(red_color_almost));

                }
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(b1.isClickable()) {
                    b2.setBackgroundResource(R.drawable.custom2);
                    b2.setTextColor(getApplication().getResources().getColor(red_color_almost));
                    b1.setBackgroundResource(R.drawable.custom_button);
                    b1.setTextColor(getApplication().getResources().getColor(white));
                }
            }
        });
    }
    public void onRadioButtonClicked(View view) {

        boolean isSelected = ((AppCompatRadioButton) view).isChecked();
        switch ((view.getId())) {
            case R.id.rbuser:
                if (isSelected) {
                    b1.setTextColor(getApplication().getResources().getColor(white));
                    b2.setTextColor(getApplication().getResources().getColor(red_color_almost));

                }
                break;
            case R.id.rborganizer:
                if (isSelected) {
                    b2.setTextColor(getApplication().getResources().getColor(white));
                    b1.setTextColor(getApplication().getResources().getColor(red_color_almost));
                }
                break;

        }
    }


    }