package com.example.android.habittracker;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.facebook.stetho.Stetho;

public class MainActivity extends AppCompatActivity {

    HabitTrackerHelperClass db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Stetho.InitializerBuilder initializerBuilder = Stetho.newInitializerBuilder(this);
        initializerBuilder.enableWebKitInspector(Stetho.defaultInspectorModulesProvider(this));
        initializerBuilder.enableDumpapp(Stetho.defaultDumperPluginsProvider(this));
        Stetho.Initializer initializer = initializerBuilder.build();
        Stetho.initialize(initializer);
        db = new HabitTrackerHelperClass(this);
        db.write("01/07/2016", 4, "Wings of fire", "COD5");
        db.write("30/06/2016", 2, "OWASP Security", "FIFA17");
        db.write("29/06/2016", 2, "WEB DEVELOPMENT", "FIFA17");
        Cursor cursor = db.read(2);
        db.update("01/07/2016", 6, "Android Cookbook");
        db.delete();
        db.close();
    }
}
