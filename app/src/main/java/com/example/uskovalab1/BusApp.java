package com.example.uskovalab1;

import android.app.Application;
import com.squareup.otto.Bus;

public class BusApp extends Application {
    private static Bus bus;

    public static Bus getBus() {
        if (bus == null) {
            bus = new Bus();
        }
        return bus;
    }
}