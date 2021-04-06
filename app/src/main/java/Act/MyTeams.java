package Act;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.tournament.R;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

import Adapters.MyTeamTabPagerAdapter;

public class MyTeams extends AppCompatActivity  {
    MenuItem items;
    ViewPager pager;
    View view;
    //NavigationView navigationView;
    TabLayout mTabLayout;
    TabItem ExistingTeam, Createnewaccount;
    MyTeamTabPagerAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_teams);
        androidx.appcompat.widget.Toolbar toolbar = findViewById(R.id.toolbar1);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        pager = findViewById(R.id.request_orders_view_pager1);

        mTabLayout = findViewById(R.id.myteamtabs);
        ExistingTeam = findViewById(R.id.firstItem1);
         Createnewaccount = findViewById(R.id.secondItem2);
      //  Menu menu = navigationView.getMenu();
        //////label color//////////
        //Menu menu = navigationView.getMenu();
//        MenuItem tools = menu.findItem(R.id.title1);
//        SpannableString s = new SpannableString(tools.getTitle());
//        s.setSpan(new TextAppearanceSpan(this, R.style.TextAppearance44), 0, s.length(), 0);
//        tools.setTitle(s);
        ////////////////
      //  navigationView.setNavigationItemSelectedListener(this);

        adapter=new MyTeamTabPagerAdapter(getSupportFragmentManager(),FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT,mTabLayout.getTabCount());

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
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if(item.getItemId() == android.R.id.home)
        {finish();
        }
        return super.onOptionsItemSelected(item);
    }
}