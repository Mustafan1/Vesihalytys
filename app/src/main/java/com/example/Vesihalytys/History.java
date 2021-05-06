package com.example.Vesihalytys;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CalendarView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class History extends AppCompatActivity {
    CalendarView calendarView;
    TextView viewDate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        calendarView= (CalendarView) findViewById(R.id.calendarView);
        viewDate = (TextView) findViewById(R.id.date);

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                String date = "Valintasi "+ dayOfMonth +"." + (month+1) +"." +year;
                viewDate.setText(date);
            }
        });

    }
}