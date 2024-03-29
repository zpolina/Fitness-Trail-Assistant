package com.example.msrazure.fitness;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TabHost;

import com.example.msrazure.fitness.adapters.MyFragmentPagerAdapter;
import com.example.msrazure.fitness.fragments.Fragment1;
import com.example.msrazure.fitness.fragments.Fragment2;
import com.example.msrazure.fitness.fragments.Fragment3;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MSRAzure on 01.12.2015.
 */
public class FragmentExercise extends Fragment implements ViewPager.OnPageChangeListener, TabHost.OnTabChangeListener  {

    ViewPager viewPager;
    TabHost tabHost;
    View v;
    MyFragmentPagerAdapter myFragmentPagerAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.tabs_exercises_layout, container, false);
        initViewPager();
        initTabHost();

        return v;
    }

    private void initTabHost() {

        tabHost = (TabHost)v.findViewById(R.id.tabhost);
        tabHost.setup();
        String[] tabNames = {"The Routine","Move 1: The Runner’s Stretch","Move 2: The Standing Side Stretch","Move 3: The Forward Hang","Move 4: The Low Lunge Arch","Move 5: The Seated Back Twist"};

        for(int i = 0; i<tabNames.length; i++){
            TabHost.TabSpec tabSpec;
            tabSpec = tabHost.newTabSpec(tabNames[i]);
            tabSpec.setIndicator(tabNames[i]);
            tabSpec.setContent(new FakeContent(getActivity()));
            tabHost.addTab(tabSpec);
        }

        tabHost.setOnTabChangedListener(this);
    }

    private void initViewPager() {

        List<Fragment> listFragments = new ArrayList<Fragment>();
        listFragments.add(new Fragment1());
        listFragments.add(new Fragment2());
        listFragments.add(new Fragment3());
        listFragments.add(new Fragment1());
        listFragments.add(new Fragment2());
        listFragments.add(new Fragment3());


        this.myFragmentPagerAdapter = new MyFragmentPagerAdapter(getChildFragmentManager(), listFragments);
        this.viewPager = (ViewPager)v.findViewById(R.id.view_pager);
        this.viewPager.setAdapter(myFragmentPagerAdapter);
        this.viewPager.setOnPageChangeListener(this);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.action_settings){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int selectedItem) {
        tabHost.setCurrentTab(selectedItem);
    }

    @Override
    public void onPageScrollStateChanged(int state) {
    }

    @Override
    public void onTabChanged(String tabId) {
        int selectedItem = tabHost.getCurrentTab();
        viewPager.setCurrentItem(selectedItem);
    }

    public class FakeContent implements TabHost.TabContentFactory {
        Context context;
        public FakeContent(Context mcontext) {
            context = mcontext;
        }
        @Override
        public View createTabContent(String tag) {
            View fakeView = new View(context);
            fakeView.setMinimumHeight(0);
            fakeView.setMinimumWidth(0);
            return fakeView;
        }
    }
}
