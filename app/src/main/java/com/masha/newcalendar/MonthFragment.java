package com.masha.newcalendar;

import java.util.ArrayList;
import java.util.Calendar;

import android.content.Context;
import android.media.midi.MidiManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A placeholder fragment containing a simple view.
 */
public class MonthFragment extends Fragment {
    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    private static final String ARG_SECTION_NUMBER = "section_number";


    public MonthFragment() {
    }

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static MonthFragment newInstance(int SectionNumber) {
        //в аргументе передавать объект календарь
        //здесь должен быть код, который формирует календарь

        MonthFragment fragment = new MonthFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, SectionNumber);
       /* ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(calendar.get(Calendar.DAY_OF_MONTH));
        list.add(calendar.get(Calendar.MONTH));
        list.add(calendar.get(Calendar.YEAR));
        args.putIntegerArrayList("list", list);*/
        fragment.setArguments(args);
        fragment.setRetainInstance(true);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

       /* ArrayList<Integer> list = getArguments().getIntegerArrayList("list");
        rightNow = Calendar.getInstance();
        rightNow.set(Calendar.DAY_OF_MONTH, list.get(0));
        rightNow.set(Calendar.MONTH, list.get(1));
        rightNow.set(Calendar.YEAR, list.get(2));*/



        if (getArguments().getInt(ARG_SECTION_NUMBER) != MainActivity.BIG_COUNT/2 + 1) {
            int difference = getArguments().getInt(ARG_SECTION_NUMBER) - (MainActivity.BIG_COUNT/2 + 1);
            MainActivity.displayMonth.add(Calendar.MONTH, difference);
        }
        Log.d("MyLogs", "onCreate в MonthFragment");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

//        MainActivity.monthCreater.execute(MainActivity.displayMonth);

       View rootView = inflater.inflate(R.layout.fragment_month, container, false);

        TextView textView2 = (TextView) rootView.findViewById(R.id.monthView);
        textView2.setText(MainActivity.displayMonth.get(Calendar.DAY_OF_MONTH) + "." +
                MainActivity.displayMonth.get(Calendar.MONTH) + "." + MainActivity.displayMonth.get(Calendar.YEAR));

        Log.d("MyLogs", "onCreateView в MonthFragment");
/*        if (MainActivity.monthCreator.getStatus().equals(AsyncTask.Status.FINISHED)) {
            try {
                return MainActivity.monthCreator.get();
            } catch (Exception ex) {
                Log.d("MyLogs", "ошибка monthCreator.get()");
            }
        }*/
        return rootView;


      //  return rootView;
    }

}