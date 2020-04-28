package tello.control;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.google.android.material.tabs.TabLayout;

public class PagerAdapter extends FragmentPagerAdapter{

    public PagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch(position){
            case 0:
                return new fragment_state();

            case 1:
                return new fragment_control();

            case 2:
                return new fragment_video();

            default: return null;
        }
    }

    @Override
    public int getCount() {
        return 3;
    }
}
