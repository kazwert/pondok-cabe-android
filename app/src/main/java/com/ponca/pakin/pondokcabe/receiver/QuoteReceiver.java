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
        showQuoteNotification();
        showQuoteDialog();
    }

    private void showQuoteDialog() {
        QuoteActivity.start(mContext, 0);
    }

    private void showQuoteNotification() {
        Log.d("PPC", "Quote Receiver");
        NotificationManager notificationManager = (NotificationManager) mContext
                .getSystemService(Context.NOTIFICATION_SERVICE);

        //If on Oreo then notification required a notification channel.
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel("default", "Default", NotificationManager.IMPORTANCE_DEFAULT);
            notificationManager.createNotificationChannel(channel);
        }

        NotificationCompat.Builder notification = new NotificationCompat.Builder(mContext, "default")
                .setContentTitle("PPC")
                .setContentText("Message PPC")
                .setSmallIcon(R.mipmap.ic_launcher);

        notificationManager.notify(1, notification.build());
    }
}
