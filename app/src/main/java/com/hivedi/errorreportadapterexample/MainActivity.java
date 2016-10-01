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

	    ERA.registerAdapter(new ReportInterface() {
		    @Override
		    public void logException(Throwable e, Object... metaParams) {
			    Log.e("a", "error=" + e + ", param1=" + metaParams[0] + ", param2=" + metaParams[1], e);
		    }

            @Override
            public void log(String s, Object... extraParams) {
                // TODO add log info
            }

            @Override
            public void breadcrumb(String s, Object... extraParams) {
                // TODO add breadcrumb info
            }
        });

        ERA.logException(new RuntimeException("aaa"), "test1", "test2");
        ERA.log("Test 1");
        ERA.breadcrumb("Param 1");
        ERA.breadcrumb("Param 2");
    }
}
