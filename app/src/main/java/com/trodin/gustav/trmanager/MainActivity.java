package com.trodin.gustav.trmanager;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends Activity {

    List<TroubleReport> troubleReports = new ArrayList<TroubleReport>();
    public static final int ADD_TR_RESULT_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == ADD_TR_RESULT_CODE) {
            Bundle bundle = data.getExtras();
            TroubleReport troubleReport = bundle.getParcelable("TroubleReport");
            Log.v("MainActivity", troubleReport.toString());
            troubleReports.add(troubleReport);
        }
        Log.v("MainActivity", "Number of Trouble reports: " + troubleReports.size());
    }

    public void onAddTrButtonClick(View view) {
        Intent addTroubleReportIntent = new Intent(this, AddTroubleReport.class);
        startActivityForResult(addTroubleReportIntent, ADD_TR_RESULT_CODE);
    }

    public void onAddWeekButtonClick(View view) {
    }
}
