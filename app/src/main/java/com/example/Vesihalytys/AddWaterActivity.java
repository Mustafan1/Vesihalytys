package com.example.Vesihalytys;
/***
 * AddWaterActivity
 * The user can add water manually.
 */

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class AddWaterActivity extends AppCompatActivity {
    private int addDrink = 0;
    private ProgressBar progressAmount;
    private Button Addto;
    private Button plussa;
    private Button miinus;
    private TextView amount;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_water);
        amount = (TextView) findViewById(R.id.arvo_2);
        Addto = (Button) findViewById(R.id.add);
        plussa = (Button) findViewById(R.id.plus);
        miinus = (Button) findViewById(R.id.minus);
        progressAmount = (ProgressBar)findViewById(R.id.progressBar2);




        plussa.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                progressAmount.setMax(1200);
                if (addDrink <=1180){
                    addDrink +=20;
                    updateWater();
                }
            }
        });
        miinus.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (addDrink >=20){
                    addDrink -=20;
                    updateWater();
                }
            }
        });

        Addto.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent  intent = new Intent(AddWaterActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    public void updateWater(){
        progressAmount.setProgress(addDrink);
        amount.setText(addDrink+"ML");
    }
}