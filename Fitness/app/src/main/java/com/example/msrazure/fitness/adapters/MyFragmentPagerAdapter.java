package com.example.msrazure.fitness.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by MSRAzure on 01.12.2015.
 */
public class MyFragmentPagerAdapter extends FragmentPagerAdapter {
    List<Fragment> listFragments;

    public MyFragmentPagerAdapter(FragmentManager fm,
                                  List<Fragment> listFragments) {
        super(fm);
        this.listFragments = listFragments;
    }

    @Override
    public Fragment getItem(int position) {
        return listFragments.get(position);
    }

    @Override
    public int getCount() {
        return listFragments.size();
    }
}


