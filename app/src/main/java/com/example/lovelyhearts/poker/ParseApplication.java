package com.example.lovelyhearts.poker;

/**
 * Created by ryan on 4/25/15.
 */

        import android.app.Application;

        import com.parse.Parse;
        import com.parse.ParseObject;
        import com.parse.ParseACL;
        import com.parse.ParseCrashReporting;
        import com.parse.ParseUser;



public class ParseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        // Initialize Crash Reporting.
        ParseCrashReporting.enable(this);

        // Enable Local Datastore.
        Parse.enableLocalDatastore(this);

        // register subclasses
        ParseObject.registerSubclass(Location.class);
        ParseObject.registerSubclass(Player.class);
        ParseObject.registerSubclass(Seat.class);
        ParseObject.registerSubclass(Table.class);
        ParseObject.registerSubclass(Tournament.class);

        // Add your initialization code here
        Parse.initialize(this, "CMGQQp6k1D8jVqr39taB6iEVwLSV39VNJq6SmEJe", "uSZcKaAIdtdQ8xxbiTMmRZTDiXiwT5FnSiOT6bLt");


        ParseUser.enableAutomaticUser();
        ParseACL defaultACL = new ParseACL();
        // Optionally enable public read access.
        // defaultACL.setPublicReadAccess(true);
        ParseACL.setDefaultACL(defaultACL, true);
    }
}
