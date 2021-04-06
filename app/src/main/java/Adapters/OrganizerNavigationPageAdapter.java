package Adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import Fragments.Organizer_All;
import Fragments.Organizer_New;
import Fragments.Organizer_Past;

public class OrganizerNavigationPageAdapter extends FragmentPagerAdapter {
    private int tabsNumber;

    public OrganizerNavigationPageAdapter(@NonNull FragmentManager fm, int behavior, int tabs) {
        super(fm, behavior);
        this.tabsNumber = tabs;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new Organizer_All();
            case 1:
                return new Organizer_New();
            case 2:
                return new Organizer_Past();

            default: return null;
        }
    }

    @Override
    public int getCount() {
        return tabsNumber;
    }
}
