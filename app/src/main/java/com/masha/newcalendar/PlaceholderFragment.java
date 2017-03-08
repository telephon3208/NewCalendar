package com.masha.newcalendar;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A placeholder fragment containing a simple view.
 */
public class PlaceholderFragment extends Fragment {
    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    private static final String ARG_SECTION_NUMBER = "section_number";
    Calendar rightNow;

    public PlaceholderFragment() {
    }

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static PlaceholderFragment newInstance(int SectionNumber, Calendar calendar) {
        //в аргументе передавать объект календарь
        //здесь должен быть код, который формирует календарь

        PlaceholderFragment fragment = new PlaceholderFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, SectionNumber);
        args.putString("Календарь", calendar.get(Calendar.DAY_OF_MONTH) + "." +
            calendar.get(Calendar.MONTH) + "." + calendar.get(Calendar.YEAR));
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(calendar.get(Calendar.DAY_OF_MONTH));
        list.add(calendar.get(Calendar.MONTH));
        list.add(calendar.get(Calendar.YEAR));
        args.putIntegerArrayList("list", list);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ArrayList<Integer> list = getArguments().getIntegerArrayList("list");
        rightNow = Calendar.getInstance();
        rightNow.set(Calendar.DAY_OF_MONTH, list.get(0));
        rightNow.set(Calendar.MONTH, list.get(1));
        rightNow.set(Calendar.YEAR, list.get(2));

        if (getArguments().getInt(ARG_SECTION_NUMBER) == MainActivity.BIG_COUNT/2 + 1) {
            //   createCalendar(rightNow);
        } else {
            int days = getArguments().getInt(ARG_SECTION_NUMBER) - (MainActivity.BIG_COUNT/2 + 1);
            rightNow.add(Calendar.DAY_OF_MONTH, days);
            //  createCalendar(rightNow);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_tabs, container, false);
        TextView textView = (TextView) rootView.findViewById(R.id.section_label);
        textView.setText(getString(R.string.section_format, getArguments().getInt(ARG_SECTION_NUMBER)));
        TextView textView2 = (TextView) rootView.findViewById(R.id.section_label2);



        textView2.setText(rightNow.get(Calendar.DAY_OF_MONTH) + "." +
                rightNow.get(Calendar.MONTH) + "." + rightNow.get(Calendar.YEAR));

      //  textView2.setText(getArguments().getString("Календарь"));
        return rootView;
    }

}