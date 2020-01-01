package com.mpssdi.test.ui;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import com.mpssdi.test.R;


public class MainActivity extends AppCompatActivity {

    private final static String TAG = "MainActivity";
     WatchAdapter watchAdapter;
     ListView listView;
    MainActivityViewmodel mainActivityViewmodel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainActivityViewmodel = ViewModelProviders.of(this,
                new MainActivityFactory(this.getApplication())).
                get(MainActivityViewmodel.class);
        init();



    }

    public void init() {
        mainActivityViewmodel.insertWatch();
        listView = (ListView) findViewById(R.id.listView);
        if (mainActivityViewmodel.getMachineWatchInfo() != null) {
            watchAdapter = new WatchAdapter(MainActivity.this,
                    mainActivityViewmodel.getMachineWatchInfo());
            listView.setAdapter(watchAdapter);
        }
    }


}
