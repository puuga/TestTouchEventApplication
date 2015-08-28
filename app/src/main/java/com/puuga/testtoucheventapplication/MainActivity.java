package com.puuga.testtoucheventapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnLine1;
    Button btnLine2;
    Button btnLine3;
    LineTouchView lineTouchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initInstances();
    }

    private void initInstances() {
        btnLine1 = (Button) findViewById(R.id.btnLine1);
        btnLine2 = (Button) findViewById(R.id.btnLine2);
        btnLine3 = (Button) findViewById(R.id.btnLine3);

        lineTouchView = (LineTouchView) findViewById(R.id.vLineTouchView);
    }

    public void activeLine(View view) {
        switch (view.getId()) {
            case R.id.btnLine1:
                lineTouchView.line1.active();
                lineTouchView.line2.inactive();
                lineTouchView.line3.inactive();
                break;
            case R.id.btnLine2:
                lineTouchView.line1.inactive();
                lineTouchView.line2.active();
                lineTouchView.line3.inactive();
                break;
            case R.id.btnLine3:
                lineTouchView.line1.inactive();
                lineTouchView.line2.inactive();
                lineTouchView.line3.active();
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
