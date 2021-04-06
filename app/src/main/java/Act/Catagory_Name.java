package Act;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.tournament.R;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

import Adapters.CatagoryNameTabPagerAdapter;

public class Catagory_Name extends AppCompatActivity {


    NavigationView navigationView;
    MenuItem item;
    ViewPager pager;
    private Button b1, b2;
    View view;
    TabLayout mTabLayout;
    TabItem All, New;
    CatagoryNameTabPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catagory__name);
        androidx.appcompat.widget.Toolbar toolbar = findViewById(R.id.catatoolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        pager = findViewById(R.id.cata_name_view_pager);

        mTabLayout = findViewById(R.id.cata_name_tabs);

        All = findViewById(R.id.firstItem);
        New = findViewById(R.id.secondItem);
        //navigationView = findViewById(R.id.organizerdashboard_view);

        //Menu menu = navigationView.getMenu();

        //MenuItem tools = menu.findItem(R.id.title1);
        //SpannableString s = new SpannableString(tools.getTitle());
        //s.setSpan(new TextAppearanceSpan(this, R.style.TextAppearance44), 0, s.length(), 0);
        //tools.setTitle(s);
        //////////////////////
        //  navigationView.setNavigationItemSelectedListener(this);

        //item = findViewById(R.id.nav_logout);

        //drawerLayout = findViewById(R.id.drawer_layout);
        //navigationView.setNavigationItemSelectedListener(this);

        //toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        //drawerLayout.addDrawerListener(toggle);
        //toggle.setDrawerIndicatorEnabled(true);
        //toggle.syncState();
        adapter = new CatagoryNameTabPagerAdapter(
                getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT, mTabLayout.getTabCount());
        pager.setAdapter(adapter);
        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                pager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        pager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTabLayout));


    }

    private void addFragment() {
        addFragment();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
       MenuInflater inflater = getMenuInflater();
      //  inflater.inflate(R.menu.main_menu1, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if(item.getItemId() == android.R.id.home)
        {finish();

        }
        return super.onOptionsItemSelected(item);
    }



}