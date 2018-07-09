package com.emmita.colorsgame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button mButtonModeOne;
    private Button mButtonModeTwo;
    private Intent mIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mButtonModeOne = (Button) findViewById(R.id.btn_mode_one);
        mButtonModeTwo = (Button) findViewById(R.id.btn_mode_two);

        mButtonModeOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mIntent = new Intent(MainActivity.this, GameModeOne.class);
                startActivity(mIntent);

            }
        });

        mButtonModeTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mIntent = new Intent(MainActivity.this, GameModeTwo.class);
                startActivity(mIntent);

            }
        });


    }
}
