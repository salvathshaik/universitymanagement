package com.example.mypc.universitymanagement3;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class broadcastpc extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "power connected!!", Toast.LENGTH_SHORT).show();
    }
}
