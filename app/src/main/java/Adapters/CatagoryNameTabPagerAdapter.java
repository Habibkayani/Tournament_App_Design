package Adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import Fragments.CataNew;
import Fragments.cataAll;

public class CatagoryNameTabPagerAdapter extends FragmentPagerAdapter {
    private int tabsNumber;

    public CatagoryNameTabPagerAdapter(@NonNull FragmentManager fm, int behavior, int tabs) {
        super(fm, behavior);
        this.tabsNumber = tabs;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new cataAll();
            case 1:
                return new CataNew();

            default: return null;
        }
    }

    @Override
    public int getCount() {
        return tabsNumber;
    }
}
