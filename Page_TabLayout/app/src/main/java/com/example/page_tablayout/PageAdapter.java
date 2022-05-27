package com.example.page_tablayout;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class PageAdapter extends FragmentPagerAdapter {

    private int tabCount;

    public PageAdapter(FragmentManager fragmentManager, int tabCount) {
        super(fragmentManager);
        this.tabCount = tabCount;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0: {
                FragmentOne fragmentOne = new FragmentOne();
                return fragmentOne;
            }
            case 1: {
                FragmentTwo fragmentTwo = new FragmentTwo();
                return fragmentTwo;
            }
            case 2: {
                FragmentThree fragmentThree = new FragmentThree();
                return fragmentThree;
            }
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return tabCount;
    }
}
