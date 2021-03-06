package com.example.Vesihalytys;
/***
 * Main application page.
 *
 *
 *
 */

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private int amount = 0;
    private ProgressBar add_progressbar;
    private Button addWater;
    private Button yksilassi;
    private Button settin;
    private Button history;
    private TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.arvo);
        add_progressbar = (ProgressBar)findViewById(R.id.progress_bar);

        yksilassi = findViewById(R.id.one_glass);
        yksilassi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                add_progressbar.setMax(2700);
                if (amount <=2700){
                    amount +=240;
                    updateInfo();
                }
            }
            private void updateInfo() {
                add_progressbar.setProgress(amount);
                textView.setText(amount+"ML");
            }
        });


        addWater = findViewById(R.id.add_water);
        addWater.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddWaterActivity();

            }
        });

        settin = findViewById(R.id.setting);
        settin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SettingsActivity();
            }
        });

        history = findViewById(R.id.history);
        history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                History();
            }
        });
    }


    public void AddWaterActivity(){
        Intent intent = new Intent(this, AddWaterActivity.class);
        startActivity(intent);
    }

    public void SettingsActivity(){
        Intent intent = new Intent(this, SettingsActivity.class);
        startActivity(intent);
    }

    private void History() {
        Intent intent = new Intent(this, History.class);
        startActivity(intent);
    }







}