package com.example.mamunjahir.clocktest.main;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import com.example.mamunjahir.clocktest.utils.NumberProblems;

public class Receiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        NumberProblems numberProblems=new NumberProblems();
        Log.d("OnReceive","I am from Receiver");
        Toast.makeText(context,"Hello from Receiver"+numberProblems.getType_of_Math(),Toast.LENGTH_SHORT).show();
    }
}
