package Act;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class NaviagtionandTabPagerAdapter extends FragmentPagerAdapter {
    private int tabsNumber;

    public NaviagtionandTabPagerAdapter(@NonNull FragmentManager fm, int behavior, int tabs) {
        super(fm, behavior);
        this.tabsNumber = tabs;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new TournamentList_Fragment();
            case 1:
                return new Tournament_Catagories_Fragment();

            default: return null;
        }
    }

    @Override
    public int getCount() {
        return tabsNumber;
    }
}
