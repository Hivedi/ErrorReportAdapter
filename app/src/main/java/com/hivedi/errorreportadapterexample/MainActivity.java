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
	    });

        ERA.logException(new RuntimeException("aaa"), "test1", "test2");
    }
}
