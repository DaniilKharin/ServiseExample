package com.example.danii.standaloneserviseapplication;

import android.app.AlarmManager;
import android.app.IntentService;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.widget.Toast;

/**
 * Created by danii on 21.09.2017.
 */

public class GeoService extends IntentService {

    public GeoService() {
        super("geoService");
    }

    private final int COLLECT_INTERVAL = 4000; //900000; //15 минут в милисекундах
    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     * @param name Used to name the worker thread, important only for debugging.
     */
    public GeoService(String name) {
        super(name);
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        Intent startGeoSrviseIntent = new Intent(getApplicationContext(),GeoService.class);
        Handler mHandler = new Handler(getMainLooper());
        mHandler.post(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(getApplicationContext(),"i am alive",Toast.LENGTH_SHORT).show();
            }
        });

        PendingIntent startGeoSrvisePendingIntent = PendingIntent.getService(getApplicationContext(), 1, startGeoSrviseIntent, PendingIntent.FLAG_ONE_SHOT);
        AlarmManager am = (AlarmManager) getSystemService(ALARM_SERVICE);
        am.setExact(AlarmManager.RTC_WAKEUP,System.currentTimeMillis() + COLLECT_INTERVAL,startGeoSrvisePendingIntent);
        stopSelf();
    }
}
