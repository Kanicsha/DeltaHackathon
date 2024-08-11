package com.example.xnyl;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.d_xnyl.R;

import java.util.Calendar;

public class CalenderViewActivity extends AppCompatActivity {
    int year1, month1, dayOfMonth1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_calender_view);
        CalendarView calendarView=findViewById(R.id.calender);
        TextView date=findViewById(R.id.tv_date);
        Button schedule = findViewById(R.id.schedule);
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                String Date
                        = dayOfMonth + "-"
                        + (month + 1) + "-" + year;
                year1=year;
                Calendar date1=Calendar.getInstance();


                dayOfMonth1=dayOfMonth;
                month1=month+1;

                date.setText(Date);
                view.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Log.i("cal","clicked");
                    }
                });
            }
        });

//        schedule.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                AddCalendarEvent(v);
//            }
//        });

    }
    public void AddCalendarEvent(View view) {
        Calendar calendarEvent = Calendar.getInstance();
     //   calendarEvent.setFirstDayOfWeek(Calendar.MONDAY);
     //   calendarEvent.setWeekDate(year1,month1,dayOfMonth1);
        Intent i = new Intent(Intent.ACTION_EDIT);
        i.setType("vnd.android.cursor.item/event");
        i.putExtra("beginTime", calendarEvent.getTimeInMillis());
        i.putExtra("allDay", true);
        i.putExtra("rule", "FREQ=YEARLY");
        i.putExtra("endTime", calendarEvent.getTimeInMillis() + 60 * 60 * 1000);
        i.putExtra("title", "Calendar Event");
        startActivity(i);
    }
}