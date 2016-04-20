package com.example.a.t13_br;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.SmsMessage;
import android.widget.Toast;

/**
 * Created by a on 2016-04-20.
 */
public class MyBR extends BroadcastReceiver{

    @Override
    public void onReceive(Context context, Intent intent) {
        String str = "";
        SmsMessage[] msgs = null;

        Object[] pdus = (Object[]) intent.getExtras().get("pdus");
        msgs = new SmsMessage[pdus.length];

        for(int i=0; i<msgs.length; i++){
            msgs[i] = SmsMessage.createFromPdu((byte[])pdus[i]);

            str += "SMS From : " + msgs[i].getOriginatingAddress();
            str += " : " + msgs[i].getMessageBody() + "\n";
        }

        Toast.makeText(context, str, Toast.LENGTH_SHORT).show();
    }
}
