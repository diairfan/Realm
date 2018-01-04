package com.fanesgmail.irfan.coba;

import android.app.Application;

import io.realm.Realm;

/**
 * Created by Van Noval on 12/7/2017.
 */

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(this);
    }
}
