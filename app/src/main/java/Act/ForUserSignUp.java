package Act;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatRadioButton;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tournament.R;

import static com.example.tournament.R.color.red_color_almost;
import static com.example.tournament.R.color.white;

public class ForUserSignUp extends AppCompatActivity {
    AppCompatRadioButton rbuser,rborganizer;
    private TextView already,createaccount;
    Dialog dialog,dialog2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_for_user_sign_up);
        rbuser=findViewById(R.id.rbuser);
        rborganizer=findViewById(R.id.rborganizer);


//        b1=findViewById(R.id.Userselectionbtn);
//        b2=findViewById(R.id.Orgnizerselectionbtn);
//        already=findViewById(R.id.textView29);
 createaccount=findViewById(R.id.usercreateaccount);
     dialog=new Dialog(this);
      dialog2=new Dialog(this);
       // buttonclick();
        CreatLogin();

    }

    private void CreatLogin() {
        createaccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(rbuser.isChecked()){
                    dialog2.dismiss();
                    dialog.setContentView(R.layout.usercreat_successfull_dialog);
                    dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                    ImageView userdialodimage = dialog.findViewById(R.id.userdialogimage);
                    Button userdialodbtn = dialog.findViewById(R.id.userdialogbtn);

                    userdialodbtn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            dialog.dismiss();
                            Intent i = new Intent(getApplicationContext(), LoginAct.class);
                            startActivity(i);
                        }
                    });
                    dialog.show();

                }

                if(rborganizer.isChecked()){
                       dialog.dismiss();
                    dialog2.setContentView(R.layout.organizercreat_successfull_dialog);
                    dialog2.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                    ImageView organizerdialodimage = dialog2.findViewById(R.id.organizerdialogimage);
                    Button organizerdialodbtn = dialog2.findViewById(R.id.organizerdialogbtn);

                   organizerdialodbtn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            dialog2.dismiss();
                            Intent i = new Intent(getApplicationContext(), LoginAct.class);
                            startActivity(i);
                        }
                    });
                    dialog2.show();


                }

            }
        });
    }

    public void onRadioButtonClicked(View view){

        boolean isSelected =((AppCompatRadioButton)view).isChecked();
        switch ((view.getId())){
            case R.id.rbuser:
                if(isSelected)
                {rbuser.setTextColor(getApplication().getResources().getColor(white));
                    rborganizer.setTextColor(getApplication().getResources().getColor(red_color_almost));
                }
                break;
            case R.id.rborganizer:
                if(isSelected)
                {
                    rborganizer.setTextColor(getApplication().getResources().getColor(white));
                    rbuser.setTextColor(getApplication().getResources().getColor(red_color_almost));
                }
                break;

        }

    }
//  private void buttonclick() {
//
//        b2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (b2.isClickable()) {
//                    //b2.setBackgroundColor(b2.getContext().getResources().getDrawable(R.drawable.custom_button));
//                    b2.setBackgroundResource(R.drawable.custom_button);
//                    b2.setTextColor(getApplication().getResources().getColor(white));
//                    //b1.setBackgroundColor(b1.getContext().getResources().getColor(white));
//                    b1.setBackgroundResource(R.drawable.custom2);
//                    b1.setTextColor(getApplication().getResources().getColor(red_color_almost));
//
//                }
//            }
//        });
//        b1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (b1.isClickable()) {
//                    b2.setBackgroundResource(R.drawable.custom2);
//                    b2.setTextColor(getApplication().getResources().getColor(red_color_almost));
//                    b1.setBackgroundResource(R.drawable.custom_button);
//                    b1.setTextColor(getApplication().getResources().getColor(white));
//                }
//            }
//        });
//        already.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent i = new Intent(getApplicationContext(), LoginAct.class);
//                startActivity(i);
//            }
//        });

//
//
//    }//
}