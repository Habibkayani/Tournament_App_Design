package Act;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatRadioButton;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentPagerAdapter;

import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.TextAppearanceSpan;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toolbar;

import com.example.tournament.R;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

import static com.example.tournament.R.color.red_color_almost;
import static com.example.tournament.R.color.white;

public class UserDashboard extends AppCompatActivity implements   NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawerLayout;
    ActionBarDrawerToggle toggle;
    NavigationView navigationView;
    MenuItem item;
    private Button b1,b2;
    View view;
    TabLayout mTabLayout;
    TabItem firstItem,secondItem,thirdItem;
    NaviagtionandTabPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_dashboard);
        androidx.appcompat.widget.Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        b1=findViewById(R.id.userdashrbuser);
        b2=findViewById(R.id.userdashrborganizer);
     //   checkbox(view);

        navigationView=findViewById(R.id.nav_view);
       // mTabLayout = findViewById(R.id.tablayout1);



        //////checkbox////



        ///////////////
/////////////label color///////////

        Menu menu = navigationView.getMenu();

        MenuItem tools= menu.findItem(R.id.title1);
        SpannableString s = new SpannableString(tools.getTitle());
        s.setSpan(new TextAppearanceSpan(this, R.style.TextAppearance44), 0, s.length(), 0);
        tools.setTitle(s);
       //////////////////////
        navigationView.setNavigationItemSelectedListener(this);

       item=findViewById(R.id.nav_logout);

        drawerLayout=findViewById(R.id.drawer_layout);
        navigationView.setNavigationItemSelectedListener(this);

        toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.setDrawerIndicatorEnabled(true);
        toggle.syncState();





    }

//  //  private void checkbox(View view) {
//
//
//        boolean isSelected = ((AppCompatRadioButton) view).isChecked();
//        switch ((view.getId())) {
//            case R.id.userdashrbuser:
//                if (isSelected) {
//                Intent i=new Intent(getApplicationContext(),Tournament_Catagories_Fragment.class);
//                startActivity(i);
//                }
//                break;
//            case R.id.userdashrborganizer:
//                if (isSelected) {
//                    Intent i=new Intent(getApplicationContext(),User_dashboard_fragment.class);
//                    startActivity(i);
//                }
//                break;
//
//        }
//    }


    public void onRadioButtonClicked(View view) {

            boolean isSelected = ((AppCompatRadioButton) view).isChecked();
            switch ((view.getId())) {
                case R.id.userdashrbuser:
                    if (isSelected) {
                        b1.setTextColor(getApplication().getResources().getColor(white));
                        b2.setTextColor(getApplication().getResources().getColor(red_color_almost));
                    }
                    break;
                case R.id.userdashrborganizer:
                    if (isSelected) {
                        b2.setTextColor(getApplication().getResources().getColor(white));
                        b1.setTextColor(getApplication().getResources().getColor(red_color_almost));
                    }
                    break;

            }
        }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.main_menu1,menu);
        return true;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return false;

//        drawerLayout.closeDrawer(GravityCompat.START);
////        if(item.getItemId() == R.id.menuTab){
////            Intent i=new Intent(MainActivity.this,Home.class);
////            startActivity(i);
////        }
    }


/////////////////////////Toolbar//////////////////////////////

//        toggle = new ActionBarDrawerToggle(this,
//                drawerLayout,
//                toolbar,
//                R.string.navigation_drawer_open,
//                R.string.navigation_drawer_close  );
//        drawerLayout.addDrawerListener(toggle);
//        toggle.setDrawerIndicatorEnabled(true);
//        toggle.syncState();






}