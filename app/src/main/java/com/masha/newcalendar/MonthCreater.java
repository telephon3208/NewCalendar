package com.masha.newcalendar;


import android.content.Context;
import android.os.AsyncTask;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.Calendar;

public class MonthCreater extends AsyncTask<Calendar, Void, View>{

    TextView monthView, timeView, textView;

    TableRow week1, week2, week3, week4, week5, week6;

    Calendar calendar;
    View v;

    Button b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, b12, b13, b14;
    Button b15, b16, b17, b18, b19, b20, b21, b22, b23, b24, b25, b26;
    Button b27, b28, b29, b30, b31, b32, b33, b34, b35;
    Button b36, b37, b38, b39, b40, b41, b42;
    Button[] w1 = {b1, b2, b3, b4, b5, b6, b7};
    Button[] w2 = {b8, b9, b10, b11, b12, b13, b14};
    Button[] w3 = {b15, b16, b17, b18, b19, b20, b21};
    Button[] w4 = {b22, b23, b24, b25, b26, b27, b28};
    Button[] w5 = {b29, b30, b31, b32, b33, b34, b35};
    Button[] w6 = {b36, b37, b38, b39, b40, b41, b42};

    Button today, button1, button2;

    public void MonthCreator() {
        initialAll();
    }

    @Override
    protected void onPreExecute() {

        //тут надо написать метод cleanAll
    }

    @Override
    protected View doInBackground(Calendar... calendars) {
        this.calendar = calendars[0];
        return v;
    }

    @Override
    protected void onPostExecute(View view) {

        int weekDay;                    //текущий день недели
        int maxDay = lastDayOfMonth(calendar); //вычисляем количество дней в месяце

        int dayNumber = calendar.get(Calendar.DAY_OF_MONTH);

        if (calendar.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY) {
            weekDay = calendar.get(Calendar.DAY_OF_WEEK) - 1;
        } else weekDay = 7;

        while (dayNumber != 1) {  //Высчитываем на какой день недели приходится
            weekDay--;            //1е число месяца
            dayNumber--;
            if (weekDay == 0) weekDay = 7;
        }
        //  Log.d(TAG,"день недели первого числа месяца: " + getMinimalDaysInFirstWeek(c));

        int daysIn1W = 7 - weekDay + 1;             //количество дней месяца в 1 неделе(строке)

        //добавляем нужные линии
        if (!(weekDay == 1 && maxDay == 28)) {
            v.findViewById(R.id.line29).setBackgroundResource(R.color.colorPrimaryShade);
            v.findViewById(R.id.line30).setBackgroundResource(R.color.colorPrimaryShade);
            v.findViewById(R.id.line31).setBackgroundResource(R.color.colorPrimaryShade);
            v.findViewById(R.id.line32).setBackgroundResource(R.color.colorPrimaryShade);
            v.findViewById(R.id.line33).setBackgroundResource(R.color.colorPrimaryShade);
            v.findViewById(R.id.line34).setBackgroundResource(R.color.colorPrimaryShade);
            v.findViewById(R.id.line35).setBackgroundResource(R.color.colorPrimaryShade);
        }
        if ((weekDay == 6 && maxDay == 31) || (weekDay == 7 && maxDay >= 30)) {
            v.findViewById(R.id.line36).setBackgroundResource(R.color.colorPrimaryShade);
            v.findViewById(R.id.line37).setBackgroundResource(R.color.colorPrimaryShade);
            v.findViewById(R.id.line38).setBackgroundResource(R.color.colorPrimaryShade);
            v.findViewById(R.id.line39).setBackgroundResource(R.color.colorPrimaryShade);
            v.findViewById(R.id.line40).setBackgroundResource(R.color.colorPrimaryShade);
            v.findViewById(R.id.line41).setBackgroundResource(R.color.colorPrimaryShade);
            v.findViewById(R.id.line42).setBackgroundResource(R.color.colorPrimaryShade);
        }

        for (int i = 0, j = daysIn1W + 1; i < 7; i++, j++) { //переименовываем кнопки чтобы
            //получился календарь
            if (j - 7 > 0) {
                w1[i].setText(String.format("%s", j - 7));
            }
            w2[i].setText(String.format("%s", j));
            w3[i].setText(String.format("%s", j + 7));
            w4[i].setText(String.format("%s", j + 14));
            if (j + 21 <= maxDay) {
                w5[i].setText(String.format("%s", j + 21));
            }
            if (j + 28 <= maxDay) {
                w6[i].setText(String.format("%s", j + 28));
            }
        }

        setMonth(calendar);                                 //устанавливаем название месяца
        monthView.append(" " + String.format("%s", calendar.get(Calendar.YEAR)));  //прибавляем год к месяцу

        //  displayTime();
        //  filter.eventsFilter(c);
        //  displayEvents();

        //  Log.d(TAG,"календарь создан");

    }

    private View initialAll() {
        v = LayoutInflater.from(MainActivity.mainActivityLink).inflate(R.layout.fragment_month, null);
        monthView = (TextView) v.findViewById(R.id.monthView);
        timeView = (TextView) v.findViewById(R.id.timeView);

        week1 = (TableRow) v.findViewById(R.id.week1);
        week2 = (TableRow) v.findViewById(R.id.week2);
        week3 = (TableRow) v.findViewById(R.id.week3);
        week4 = (TableRow) v.findViewById(R.id.week4);
        week5 = (TableRow) v.findViewById(R.id.week5);
        week6 = (TableRow) v.findViewById(R.id.week6);

        b1 = (Button) week1.findViewById(R.id.b1);
        b2 = (Button) week1.findViewById(R.id.b2);
        b3 = (Button) week1.findViewById(R.id.b3);
        b4 = (Button) week1.findViewById(R.id.b4);
        b5 = (Button) week1.findViewById(R.id.b5);
        b6 = (Button) week1.findViewById(R.id.b6);
        b7 = (Button) week1.findViewById(R.id.b7);
        b8 = (Button) week2.findViewById(R.id.b8);
        b9 = (Button) week2.findViewById(R.id.b9);
        b10 = (Button) week2.findViewById(R.id.b10);
        b11 = (Button) week2.findViewById(R.id.b11);
        b12 = (Button) week2.findViewById(R.id.b12);
        b13 = (Button) week2.findViewById(R.id.b13);
        b14 = (Button) week2.findViewById(R.id.b14);
        b15 = (Button) week3.findViewById(R.id.b15);
        b16 = (Button) week3.findViewById(R.id.b16);
        b17 = (Button) week3.findViewById(R.id.b17);
        b18 = (Button) week3.findViewById(R.id.b18);
        b19 = (Button) week3.findViewById(R.id.b19);
        b20 = (Button) week3.findViewById(R.id.b20);
        b21 = (Button) week3.findViewById(R.id.b21);
        b22 = (Button) week4.findViewById(R.id.b22);
        b23 = (Button) week4.findViewById(R.id.b23);
        b24 = (Button) week4.findViewById(R.id.b24);
        b25 = (Button) week4.findViewById(R.id.b25);
        b26 = (Button) week4.findViewById(R.id.b26);
        b27 = (Button) week4.findViewById(R.id.b27);
        b28 = (Button) week4.findViewById(R.id.b28);
        b29 = (Button) week5.findViewById(R.id.b29);
        b30 = (Button) week5.findViewById(R.id.b30);
        b31 = (Button) week5.findViewById(R.id.b31);
        b32 = (Button) week5.findViewById(R.id.b32);
        b33 = (Button) week5.findViewById(R.id.b33);
        b34 = (Button) week5.findViewById(R.id.b34);
        b35 = (Button) week5.findViewById(R.id.b35);
        b36 = (Button) week6.findViewById(R.id.b36);
        b37 = (Button) week6.findViewById(R.id.b37);
        b38 = (Button) week6.findViewById(R.id.b38);
        b39 = (Button) week6.findViewById(R.id.b39);
        b40 = (Button) week6.findViewById(R.id.b40);
        b41 = (Button) week6.findViewById(R.id.b41);
        b42 = (Button) week6.findViewById(R.id.b42);

        w1[0] = (Button) v.findViewById(R.id.b1);
        w1[1] = (Button) v.findViewById(R.id.b2);
        w1[2] = (Button) v.findViewById(R.id.b3);
        w1[3] = (Button) v.findViewById(R.id.b4);
        w1[4] = (Button) v.findViewById(R.id.b5);
        w1[5] = (Button) v.findViewById(R.id.b6);
        w1[6] = (Button) v.findViewById(R.id.b7);
        w2[0] = (Button) v.findViewById(R.id.b8);
        w2[1] = (Button) v.findViewById(R.id.b9);
        w2[2] = (Button) v.findViewById(R.id.b10);
        w2[3] = (Button) v.findViewById(R.id.b11);
        w2[4] = (Button) v.findViewById(R.id.b12);
        w2[5] = (Button) v.findViewById(R.id.b13);
        w2[6] = (Button) v.findViewById(R.id.b14);
        w3[0] = (Button) v.findViewById(R.id.b15);
        w3[1] = (Button) v.findViewById(R.id.b16);
        w3[2] = (Button) v.findViewById(R.id.b17);
        w3[3] = (Button) v.findViewById(R.id.b18);
        w3[4] = (Button) v.findViewById(R.id.b19);
        w3[5] = (Button) v.findViewById(R.id.b20);
        w3[6] = (Button) v.findViewById(R.id.b21);
        w4[0] = (Button) v.findViewById(R.id.b22);
        w4[1] = (Button) v.findViewById(R.id.b23);
        w4[2] = (Button) v.findViewById(R.id.b24);
        w4[3] = (Button) v.findViewById(R.id.b25);
        w4[4] = (Button) v.findViewById(R.id.b26);
        w4[5] = (Button) v.findViewById(R.id.b27);
        w4[6] = (Button) v.findViewById(R.id.b28);
        w5[0] = (Button) v.findViewById(R.id.b29);
        w5[1] = (Button) v.findViewById(R.id.b30);
        w5[2] = (Button) v.findViewById(R.id.b31);
        w5[3] = (Button) v.findViewById(R.id.b32);
        w5[4] = (Button) v.findViewById(R.id.b33);
        w5[5] = (Button) v.findViewById(R.id.b34);
        w5[6] = (Button) v.findViewById(R.id.b35);
        w6[0] = (Button) v.findViewById(R.id.b36);
        w6[1] = (Button) v.findViewById(R.id.b37);
        w6[2] = (Button) v.findViewById(R.id.b38);
        w6[3] = (Button) v.findViewById(R.id.b39);
        w6[4] = (Button) v.findViewById(R.id.b40);
        w6[5] = (Button) v.findViewById(R.id.b41);
        w6[6] = (Button) v.findViewById(R.id.b42);

        button1 = (Button) v.findViewById(R.id.button1);
        button2 = (Button) v.findViewById(R.id.button2);

        return v;
    }

    private void setMonth(Calendar c) {
        switch (c.get(Calendar.MONTH)) {
            case 1:
                monthView.setText("Февраль");
                break;
            case 2:
                monthView.setText("Март");
                break;
            case 3:
                monthView.setText("Апрель");
                break;
            case 4:
                monthView.setText("Май");
                break;
            case 5:
                monthView.setText("Июнь");
                break;
            case 6:
                monthView.setText("Июль");
                break;
            case 7:
                monthView.setText("Август");
                break;
            case 8:
                monthView.setText("Сентябрь");
                break;
            case 9:
                monthView.setText("Октябрь");
                break;
            case 10:
                monthView.setText("Ноябрь");
                break;
            case 11:
                monthView.setText("Декабрь");
                break;
            default:
                monthView.setText("Январь");
        }
    }

    private int lastDayOfMonth(Calendar c) {
        Calendar cal = Calendar.getInstance();
        cal.set(c.get(Calendar.YEAR), c.get(Calendar.MONTH) + 1, 1);
        cal.add(Calendar.DAY_OF_MONTH, -1);
//        textView.setText(Integer.toString(rightNow.get(Calendar.DAY_OF_MONTH)));
        return cal.get(Calendar.DAY_OF_MONTH);
    }


}
