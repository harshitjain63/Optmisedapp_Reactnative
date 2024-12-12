package com.nativelocalstorage;
import com.nativelocalstorage.NativeLocalStorageSpec;
import android.content.Context;
import android.content.SharedPreferences;

import androidx.annotation.NonNull;

import com.facebook.react.bridge.ReactApplicationContext;

public class NativeLocalStorageModule extends NativeLocalStorageSpec {

    private static final String NAME = "NativeLocalStorage";

    public NativeLocalStorageModule(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @NonNull
    @Override
    public String getName() {
        return NAME;
    }


    public static String getModuleName(){return NAME;}

    @Override
    public void setItem(String value, String key) {
        SharedPreferences sharedPref = getReactApplicationContext().getSharedPreferences("my_prefs", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString(key, value);
        editor.apply();
    }

    @Override
    public String getItem(String key) {
        SharedPreferences sharedPref = getReactApplicationContext().getSharedPreferences("my_prefs", Context.MODE_PRIVATE);
        String username = sharedPref.getString(key, null);
        return username;
    }

    @Override
    public void removeItem(String key) {
        SharedPreferences sharedPref = getReactApplicationContext().getSharedPreferences("my_prefs", Context.MODE_PRIVATE);
        sharedPref.edit().remove(key).apply();
    }

    @Override
    public void clear() {

    }
}