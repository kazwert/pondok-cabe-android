package com.ponca.pakin.pondokcabe.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.ponca.pakin.pondokcabe.view.QuoteAlarmManager;

public class BootReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals("android.intent.BOOT_COMPLETED")){
            //Set Alarm Here
            QuoteAlarmManager quoteAlarmManager = new QuoteAlarmManager(context);
            quoteAlarmManager.initQuoteAlarmManager();
        }
    }
}
