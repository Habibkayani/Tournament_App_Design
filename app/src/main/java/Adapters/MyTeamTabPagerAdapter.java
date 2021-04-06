package Adapters;


import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import Fragments.My_Team_create_new_account_fragment;
import Fragments.MyteamExistingteamfragment;


public class MyTeamTabPagerAdapter extends FragmentPagerAdapter {
    private int tabsNumber1;

    public MyTeamTabPagerAdapter(@NonNull FragmentManager fm, int behavior, int tabs1) {
        super(fm, behavior);
        this.tabsNumber1 = tabs1;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new MyteamExistingteamfragment();
            case 1:
                return new My_Team_create_new_account_fragment();

            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return tabsNumber1;
    }
}
