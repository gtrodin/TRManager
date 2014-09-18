package com.trodin.gustav.trmanager;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;


public class AddTroubleReport extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_trouble_report);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.add_trouble_report, menu);
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

    public void onDoneTrButtonClick(View view) {
        EditText trIdText = (EditText) findViewById(R.id.add_tr_id_text);
        if(trIdText.getText().toString() == "") {
            trIdText.setError("Please enter a TR ID!");
        } else {
            String trId = String.valueOf(trIdText.getText());
            Intent returnTroubleReportIntent = new Intent();
            returnTroubleReportIntent.putExtra("TroubleReport", new TroubleReport(trId));
            setResult(MainActivity.ADD_TR_RESULT_CODE, returnTroubleReportIntent);
            finish();
        }
    }
}
