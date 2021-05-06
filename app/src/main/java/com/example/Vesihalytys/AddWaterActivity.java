package com.example.Vesihalytys;
/**
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
    private TextView maara;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_water);
        maara = (TextView) findViewById(R.id.arvo_2);
        Addto = (Button) findViewById(R.id.add);
        plussa = (Button) findViewById(R.id.plus);
        miinus = (Button) findViewById(R.id.minus);
        progressAmount = (ProgressBar)findViewById(R.id.progressBar2);

        Intent intent = getIntent();
        final int val = intent.getIntExtra("value", 0);
        /**
         * @plussa button increase the amount water  (ml)
         */
        plussa.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                progressAmount.setMax(1200);
                if (addDrink <=1180){
                    addDrink +=20;
                    updateWater();
                }
            }
        });

        /**
         * @miinus button decrease the amount of water  (ml)
         */
        miinus.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (addDrink >=20){
                    addDrink -=20;
                    updateWater();
                }
            }
        });
        /**
         * @Addto button is used to send back the amount of added water to MainActivity
         */
        Addto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a = val + addDrink;
                Intent b= new Intent();
                b.putExtra("a", a);
                setResult(RESULT_OK, b);
                finish();

            }
        });


    }

   /* private void addWaterClicked() {
        int number1 = Integer.parseInt(maara.getText().toString());
        int number2 = Integer.parseInt(progressAmount.toString());
        Intent  intent = new Intent(AddWaterActivity.this, MainActivity.class);
        intent.putExtra("value", number1);
        intent.putExtra("progress", number2);
        setResult(RESULT_OK, intent);
        finish();
    }
*/

    /**
     *@updateWater interface method is used to display the amount of water in progress bar and also in textview
     *
     */
    public void updateWater(){
        progressAmount.setProgress(addDrink);
        maara.setText(addDrink+"ML");
    }



}