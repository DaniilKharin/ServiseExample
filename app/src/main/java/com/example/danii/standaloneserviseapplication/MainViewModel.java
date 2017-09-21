package com.example.danii.standaloneserviseapplication;

import android.app.AlarmManager;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ToggleButton;

import java.lang.ref.WeakReference;

/**
 * Created by danii on 21.09.2017.
 */

public class MainViewModel {

    WeakReference<MainActivity> mainActivityWeakReference;

    public MainViewModel(MainActivity mainActivity) {
        mainActivityWeakReference = new WeakReference<>(mainActivity);
    }

    public void onStartStopButtonClick(View view) {
        if (!(view instanceof ToggleButton)) return;
        if (!((ToggleButton) view).isChecked())
            startServise();
        else
            stopServise();
    }

    private void startServise() {
        if (mainActivityWeakReference.get() != null)
            mainActivityWeakReference.get().startService(new Intent(mainActivityWeakReference.get().getApplicationContext(), GeoService.class));
    }

    private void stopServise() {
    }
}
