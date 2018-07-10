package com.emmita.colorsgame;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class Preferences {

    private SharedPreferences mSharedPreferences;
    private Editor mEditor;
    private Context mContext;

    private static final String PREF_NAME = "color_prefs";
    private static final String RECORD = "record";

    public Preferences(Context context){
        this.mContext = context;
        mSharedPreferences = mContext.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        mEditor = mSharedPreferences.edit();
    }

    public String getRecord(){

        String record = mSharedPreferences.getString(RECORD, "");
        return record;

    }

    public void setRecord(String record){
        mEditor.putString(RECORD, record);
        mEditor.commit();
    }

}
