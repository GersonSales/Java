package com.nokia.cap.festafimdeano.util;

import android.content.ContentProvider;
import android.content.Context;
import android.content.SharedPreferences;

import com.nokia.cap.festafimdeano.constants.FimDeAnoConstants;

/**
 * Created by gersonsales on 15/12/17.
 */

public class SecurityPreferences {

    private final SharedPreferences mSharedPreferences;


    public SecurityPreferences(Context context) {
        mSharedPreferences = context.getSharedPreferences("FimDeAno", Context.MODE_PRIVATE);
    }


    public void storeString(String key, String value) {
        mSharedPreferences.edit().putString(key, value).apply();
    }


    public String getStoredString(String key) {
        return mSharedPreferences.getString(key, FimDeAnoConstants.NO_VALUE);
    }
}
