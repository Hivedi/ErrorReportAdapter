package com.hivedi.errorreportadapterexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.hivedi.era.ERA;
import com.hivedi.era.ReportInterface;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ERA.addAdapter(new ReportInterface() {
            @Override
            public void logException(Throwable e) {
                Log.e("a", "tag", e);
            }
        });

        ERA.logException(new Exception("aaa"));
    }
}
