package com.masha.newcalendar;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Calendar;

/**
 * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {

    Calendar rightNow;
    int ListSize = MainActivity.BIG_COUNT;
    Context context;
    int newPosition;
    int oldPosition;

    public SectionsPagerAdapter(FragmentManager fm, Calendar calendar, Context context) {
        super(fm);
        rightNow = calendar;
        this.context = context;
        newPosition = 0;
        oldPosition = 0;
    }

    @Override
    public Fragment getItem(int position) {
        // getItem is called to instantiate the fragment for the given page.
        // Return a PlaceholderFragment (defined as a static inner class below).
        oldPosition = position;
        newPosition = position + 1;
        return PlaceholderFragment.newInstance(newPosition, rightNow);
     //   return PlaceholderFragment.newInstance(position + 1);
    }


    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        //здесь формируется layout

        //не знаюю как это работает, но % позволяет сделать бесконечной прокрутку
        int virtualPosition = position % ListSize;
        return super.instantiateItem(container, virtualPosition);
      //  return super.instantiateItem(container, position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        //не знаюю как это работает, но % позволяет сделать бесконечной прокрутку
        int virtualPosition = position % ListSize;
        super.destroyItem(container, virtualPosition, object);
      //  super.destroyItem(container, position, object);
    }

    @Override
    public int getCount() {
        // Show 3 total pages.
        return MainActivity.BIG_COUNT;
     //   return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "SECTION 1";
            case 1:
                return "SECTION 2";
            case 2:
                return "SECTION 3";
        }
        return null;
    }


}

