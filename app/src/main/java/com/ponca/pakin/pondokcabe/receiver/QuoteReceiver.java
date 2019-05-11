package com.ponca.pakin.pondokcabe.receiver;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.widget.Toast;
import com.ponca.pakin.pondokcabe.R;
import com.ponca.pakin.pondokcabe.view.QuoteActivity;

public class QuoteReceiver extends BroadcastReceiver {

    Context mContext;

    @Override
    public void onReceive(Context context, Intent intent) {
        this.mContext = context;
        showQuoteDialog();
    }

    private void showQuoteDialog() {
        QuoteActivity.start(mContext, 0);
    }
}
