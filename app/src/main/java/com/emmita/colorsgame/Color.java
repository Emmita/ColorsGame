package com.emmita.colorsgame;

public class Color {

    private int mColorName;
    private boolean mAnswerTrue;
    private int mTextColor;
    private int mButtonTrueColor;
    private int mButtonFalseColor;

    public Color(int colorName, int textColor, boolean answerTrue, int buttonTrueColor, int buttonFalseColor){
        mColorName = colorName;
        mTextColor = textColor;
        mAnswerTrue = answerTrue;
        mButtonTrueColor = buttonTrueColor;
        mButtonFalseColor = buttonFalseColor;
    }

    public int getColorName(){
        return mColorName;
    }

    public void setColorName(int colorName){
        mColorName = colorName;
    }

    public boolean isAnswerTrue(){
        return mAnswerTrue;
    }

    public void setAnswerTrue(boolean answerTrue){
        mAnswerTrue = answerTrue;
    }

    public int getTextColor(){
        return mTextColor;
    }

    public void setTextColor(int textColor){
        mTextColor = textColor;
    }

    public int getButtonTrueColor(){
        return mButtonTrueColor;
    }

    public void setButtonTrueColor(int buttonTrueColor){
        mButtonTrueColor = buttonTrueColor;
    }

    public int getButtonFalseColor(){
        return mButtonFalseColor;
    }

    public void setButtonFalseColor(int buttonFalseColor){
        mButtonFalseColor = buttonFalseColor;
    }

}
