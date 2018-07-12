package com.emmita.colorsgame;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Random;

import at.markushi.ui.CircleButton;

public class GameModeOne extends AppCompatActivity {

    private ProgressBar mProgressBar;
    private TextView mColorTextView;
    private CircleButton mTrueButton;
    private CircleButton mFalseButton;
    private TextView mRecord;
    private TextView mScore;

    private Handler mHandler = new Handler();
    private Preferences mPreferences;
    private String record;
    private int i = 199;

    private Color[] mColors = new Color[]{

            new Color(R.string.negro, R.color.azul, false, R.color.azul, R.color.negro),
            new Color(R.string.negro, R.color.azul, true, R.color.negro, R.color.azul),
            new Color(R.string.amarillo, R.color.negro, false, R.color.negro, R.color.amarillo),
            new Color(R.string.amarillo, R.color.negro, true, R.color.amarillo, R.color.negro),
            new Color(R.string.azul, R.color.amarillo, false, R.color.amarillo, R.color.azul),
            new Color(R.string.azul, R.color.amarillo, true, R.color.azul, R.color.amarillo),
            new Color(R.string.naranja, R.color.verde, false, R.color.verde, R.color.naranja),
            new Color(R.string.naranja, R.color.verde, true, R.color.naranja, R.color.verde),
            new Color(R.string.rojo, R.color.naranja, false, R.color.naranja, R.color.rojo),
            new Color(R.string.rojo, R.color.naranja, true, R.color.rojo, R.color.naranja),
            new Color(R.string.verde, R.color.rojo, false, R.color.rojo, R.color.verde),
            new Color(R.string.verde, R.color.rojo, true, R.color.verde, R.color.rojo)

    };

    private int mCurrentIndex = new Random().nextInt(mColors.length);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_mode_one);

        mPreferences = new Preferences(GameModeOne.this);
        record = mPreferences.getRecord();

        initProgress();

        mColorTextView = (TextView) findViewById(R.id.colorName);
        mTrueButton = (CircleButton) findViewById(R.id.true_button);
        mFalseButton = (CircleButton) findViewById(R.id.false_button);
        mRecord = (TextView) findViewById(R.id.record);
        mScore = (TextView) findViewById(R.id.score);
        mProgressBar = (ProgressBar) findViewById(R.id.progressBar);

        mRecord.setText(record);

        mTrueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                checkAnswer(true);

                mCurrentIndex = new Random().nextInt(mColors.length);
                updateColor();

            }
        });

        mFalseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                checkAnswer(false);

                mCurrentIndex = new Random().nextInt(mColors.length);
                updateColor();

            }
        });

        updateColor();

    }

    private void updateColor() {

        int colorName = mColors[mCurrentIndex].getColorName();
        int color = mColors[mCurrentIndex].getTextColor();
        int buttonTrueColor = mColors[mCurrentIndex].getButtonTrueColor();
        int buttonFalseButton = mColors[mCurrentIndex].getButtonFalseColor();

        mColorTextView.setText(colorName);
        mColorTextView.setTextColor(getResources().getColor(color));
        mTrueButton.setColor(getResources().getColor(buttonTrueColor));
        mFalseButton.setColor(getResources().getColor(buttonFalseButton));

        i = 199;
        initProgress();

    }

    private void checkAnswer(boolean userPressedTrue) {

        int currentRecord = Integer.parseInt(record);

        String score = mScore.getText().toString();
        int currentScore = Integer.parseInt(score);

        boolean answer = mColors[mCurrentIndex].isAnswerTrue();

        if (userPressedTrue == answer) {

            currentScore += 10;

            if (currentScore > currentRecord) {

                mPreferences.setRecord(String.valueOf(currentScore));

            }

            mScore.setText(String.valueOf(currentScore));

            mProgressBar.setProgress(200);
            i = 199;
            initProgress();

        } else {
            Toast.makeText(this, "Incorrecto", Toast.LENGTH_SHORT).show();
        }

    }

    private void initProgress() {

        new Thread(new Runnable() {
            @Override
            public void run() {

                while (i < 200 && i > 0) {
                    i -= 1;

                    mHandler.post(new Runnable() {
                        @Override
                        public void run() {

                            mProgressBar.setProgress(i);

                        }
                    });

                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }

            }
        }).start();

    }


}
