package com.example.ieproject.scubaversity_v10;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class TabFragment extends Fragment {

    public static TabLayout tabLayout;
    public static ViewPager viewPager;
    public static int int_items = 3 ;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        //Inflate tab_layout and setup views.
        View x =  inflater.inflate(R.layout.tab_layout,null);
        tabLayout = (TabLayout) x.findViewById(R.id.tabs);
        //viewPager is used for screen slide animations.
        viewPager = (ViewPager) x.findViewById(R.id.viewpager);


         //Sets up an adapter for the viewPager.
        viewPager.setAdapter(new MyAdapter(getChildFragmentManager()));


        //Needs to be cast as runnable otherwise setUpWithViewPager doesn't work correctly.
        tabLayout.post(new Runnable() {
            @Override
            public void run() {
                tabLayout.setupWithViewPager(viewPager);
            }
        });

        return x;
    }


    //Inner class that returns the correct fragments when the tab position is selected
    class MyAdapter extends FragmentPagerAdapter{

        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        //Returns the fragment of the tab according to the position.
        @Override
        public Fragment getItem(int position)
        {
            switch (position){
                case 0 : return new PrimaryFragment();
                case 1 : return new SocialFragment();
                case 2 : return new TripsFragment();
            }
            return null;
        }

        //Counter method to keep track of what tab position is selected
        @Override
        public int getCount() {
            return int_items;
        }


        //Returns the title of the tab according to the position.
        @Override
        public CharSequence getPageTitle(int position) {

            switch (position){
                case 0 :
                    return "Primary";
                case 1 :
                    return "Social";
                case 2 :
                    return "Trips";
            }
            return null;
        }
    }

}
