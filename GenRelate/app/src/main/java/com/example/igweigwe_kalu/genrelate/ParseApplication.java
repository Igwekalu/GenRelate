package com.example.igweigwe_kalu.genrelate;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

import com.parse.Parse;
import com.parse.ParseObject;

/**
 * Created by igweigwe-kalu on 4/24/16.
 */
public class ParseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Parse.enableLocalDatastore(this);
        ParseObject.registerSubclass(Genre.class);
        Parse.initialize(this, "QTGRlLMbhjTx5YpoGMx1KmdpO00CLmtWfj1jpgxL",
                "1dFGhppGtI3g20RJprvIjJbmP4F4KXJ5jLK53cEe");
    }

}
