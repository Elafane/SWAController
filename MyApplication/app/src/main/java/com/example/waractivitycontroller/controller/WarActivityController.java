package com.example.waractivitycontroller.controller;

import android.app.Application;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Handler;
import android.os.StrictMode;
import android.preference.PreferenceManager;

import com.example.waractivitycontroller.BuildConfig;

/**
 * @author Oliver
 */

public class WarActivityController extends Application {

    //static global values
    public static WarActivityController sApplicationContext;
    public static SharedPreferences sSharedPreferences;


    @Override
    public void onCreate() {
        if (BuildConfig.DEBUG) {
            enableStrictMode();
        }
        sApplicationContext = this;
        sSharedPreferences = PreferenceManager.getDefaultSharedPreferences(sApplicationContext);

        new InitialWork(sApplicationContext);
    }

    //<editor-fold defaultstate="collapsed" desc="StrictMode">
    private void enableStrictMode() {
        if (Build.VERSION.SDK_INT >= 9) {
            // strict mode is available from API 9
            strictModeConfigurations();
        }

        if (Build.VERSION.SDK_INT >= 16) {
            // from API 16 on the strict mode must be enabled like this when used in Application class
            new Handler().postAtFrontOfQueue(new Runnable() {
                @Override
                public void run() {
                    strictModeConfigurations();
                }
            });
        }
    }

    private void strictModeConfigurations() {
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
                .detectAll()
                .penaltyLog()
                .build()
        );
        StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder()
                .detectAll()
                .penaltyLog()
                .build()
        );
    }
    //</editor-fold>
}
