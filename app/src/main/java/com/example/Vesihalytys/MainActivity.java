package com.example.Vesihalytys;
/**
 * Main application page.
 * @author Mustafa,
 * @version 0.1
 *Vesihälytys reminds users to drink water
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
        /**
         *@yksilassi Button is used to add a regular glass of water which is 240 ml.
         *
         */
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
            /**
             *@updateInfo interface method is used to update the interface of the application.
             * add_progressbar adds the amount of water in progress bar.
             * textView shows the amount of water in number ml.
             */
            private void updateInfo() {
                add_progressbar.setProgress(amount);
                textView.setText(amount+"ML");
            }
        });

        /**
         *@addWater Button is used to add water manually using a link from MainActivity to AddWaterActivity.
         */
        addWater = findViewById(R.id.add_water);
        addWater.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddWaterActivity();

            }
        });


        /**
         *@setting Button is used to set settings to the application using linking  MainActivity to SettingActivity.
         */
        settin = findViewById(R.id.setting);
        settin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SettingsActivity();
            }
        });

        /**
         *@Hisotry Button is set settings to the application using using a link from MainActivity to SettingActivity.
         */
        history = findViewById(R.id.history);
        history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                History();
            }
        });
    }

    /**
     *intent for AddWaterActivty page
     */
    public void AddWaterActivity(){
        Intent intent = new Intent(this, AddWaterActivity.class);
        startActivity(intent);
    }


    public void SettingsActivity(){
        Intent intent = new Intent(this, SettingsActivity.class);
        startActivity(intent);
    }
    /**
     *intent for History page
     */
    private void History() {
        Intent intent = new Intent(this, History.class);
        startActivity(intent);
    }




}