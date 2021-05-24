package com.codekade.payoneerhomework.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.codekade.payoneerhomework.R;

public class MainActivity extends AppCompatActivity {


    Button buttonPayoneer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonPayoneer = findViewById(R.id.payoneer_button);


        buttonPayoneer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //open new activity displaying list of payment methods
                Intent intent = new Intent(MainActivity.this, ListOfPaymentsActivity.class);
                startActivity(intent);

            }
        });

    }
}