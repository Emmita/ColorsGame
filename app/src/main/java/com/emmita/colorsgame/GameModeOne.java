package com.emmita.colorsgame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Random;

import at.markushi.ui.CircleButton;

public class GameModeOne extends AppCompatActivity {

    private TextView mColorTextView;
    private CircleButton mTrueButton;
    private CircleButton mFalseButton;

    private Color[] mColors = new Color[]{

            new Color(R.string.negro, R.color.azul, true, R.color.azul, R.color.negro),
            new Color(R.string.negro, R.color.azul, false, R.color.negro, R.color.azul),
            new Color(R.string.amarillo, R.color.negro, true, R.color.negro, R.color.amarillo),
            new Color(R.string.amarillo, R.color.negro, false, R.color.amarillo, R.color.negro),
            new Color(R.string.azul, R.color.amarillo, true, R.color.amarillo, R.color.azul),
            new Color(R.string.azul, R.color.amarillo, false, R.color.azul, R.color.amarillo),
            new Color(R.string.naranja, R.color.verde, true, R.color.verde, R.color.naranja),
            new Color(R.string.naranja, R.color.verde, false, R.color.naranja, R.color.verde),
            new Color(R.string.rojo, R.color.naranja, true, R.color.naranja, R.color.rojo),
            new Color(R.string.rojo, R.color.naranja, false, R.color.rojo, R.color.naranja),
            new Color(R.string.verde, R.color.rojo, true, R.color.rojo, R.color.verde),
            new Color(R.string.verde, R.color.rojo, false, R.color.verde, R.color.rojo)

    };

    private int mCurrentIndex = new Random().nextInt(mColors.length);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_mode_one);

        mColorTextView = (TextView) findViewById(R.id.colorName);
        mTrueButton = (CircleButton) findViewById(R.id.true_button);
        mFalseButton = (CircleButton) findViewById(R.id.false_button);

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

    private void updateColor(){

        int colorName = mColors[mCurrentIndex].getColorName();
        int color = mColors[mCurrentIndex].getTextColor();
        int buttonTrueColor = mColors[mCurrentIndex].getButtonTrueColor();
        int buttonFalseButton = mColors[mCurrentIndex].getButtonFalseColor();

        mColorTextView.setText(colorName);
        mColorTextView.setTextColor(getResources().getColor(color));
        mTrueButton.setColor(getResources().getColor(buttonTrueColor));
        mFalseButton.setColor(getResources().getColor(buttonFalseButton));

    }

    private void checkAnswer(boolean userPressedTrue){

        boolean answer = mColors[mCurrentIndex].isAnswerTrue();

        if (userPressedTrue == answer){
            Toast.makeText(this, "Correcto", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this, "Incorrecto", Toast.LENGTH_SHORT).show();
        }

    }


}
