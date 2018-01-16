package com.example.mamunjahir.clocktest.main;

import android.app.ActionBar;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;
import android.support.v7.widget.Toolbar;

import com.example.mamunjahir.clocktest.R;
import com.example.mamunjahir.clocktest.utils.NumberProblems;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    TimePicker timePicker;
    Button button;
    TextView tv;
    int time_picker_hour;
    int min;
    AlarmManager alarmManager;
    Spinner spinner;
    NumberProblems numberProblems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Initializing all
        timePicker = findViewById(R.id.simpleTimePicker);
        button = findViewById(R.id.button);
        tv = findViewById(R.id.textView);
        alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        spinner = (Spinner) findViewById(R.id.spinner2);
        numberProblems = new NumberProblems();
        Toolbar toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_close_black_24dp);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.country_arrays, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
    }


    public void Show(View view) {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
            time_picker_hour = timePicker.getHour();
            min = timePicker.getMinute();
            tv.setText("Alarm set for " + time_picker_hour + " : " + min);
            Intent intent = new Intent(MainActivity.this, Receiver.class);
            PendingIntent pendingIntent = PendingIntent.getBroadcast(MainActivity.this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
            alarmManager.set(AlarmManager.RTC_WAKEUP, 5000, pendingIntent);
        }
    }
// This is for spinner
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        Toast.makeText(MainActivity.this, "Selected " + getResources().getStringArray(R.array.country_arrays)[i], Toast.LENGTH_SHORT).show();
        numberProblems.setType_of_Math(getResources().getStringArray(R.array.country_arrays)[i]);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
// This is for ActionBar

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }
    // Action bar ends
}
