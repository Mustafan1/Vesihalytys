package com.example.Vesihalytys;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * @History Activity
 * This activity shows the history of a user in a Calendar
 *
 */
public class History extends AppCompatActivity {
    CalendarView calendarView;
    TextView viewDate;
    Button button ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        calendarView = (CalendarView) findViewById(R.id.calendarView);
        viewDate = (TextView) findViewById(R.id.date);
        /**
         * @CalendarView is used to display the Calendar in History page
         */
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                String date = dayOfMonth + "." + (month + 1) + "." + year;
                viewDate.setText(date);
            }
        });

        button = findViewById(R.id.v);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewday();
            }
        });
    }

     private void viewday() {
        Intent intent = new Intent(this, ViewDay.class);
        startActivity(intent);
    }


    }


