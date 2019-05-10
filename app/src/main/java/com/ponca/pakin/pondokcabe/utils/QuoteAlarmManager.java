package com.ponca.pakin.pondokcabe.utils;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import com.ponca.pakin.pondokcabe.receiver.QuoteReceiver;
import java.util.Calendar;

public class QuoteAlarmManager {

    private static final int QUOTE_RECEIVER_REQUEST_CODE = 1299312;

    private AlarmManager mAlarmManager;

    private Context mContext;

    private PendingIntent mPendingIntent;

    public QuoteAlarmManager(final Context context) {
        mContext = context;
    }

    public void initQuoteAlarmManager() {
        //init pending intent for showing quote dialog broadcast receiver
        Intent intent = new Intent(mContext, QuoteReceiver.class);
        mPendingIntent = PendingIntent.getBroadcast(
                this.mContext, QUOTE_RECEIVER_REQUEST_CODE, intent, 0);
        // init calendar
        Calendar dailyTimeCalendar = Calendar.getInstance();
        dailyTimeCalendar.setTimeInMillis(System.currentTimeMillis());
        // set calendar to 7am
        dailyTimeCalendar.set(Calendar.HOUR_OF_DAY, 7);
        //init alarm Manager
        mAlarmManager = (AlarmManager) mContext.getSystemService(mContext.ALARM_SERVICE);
        // setInexactRepeating will repeating alarm manager with approximate time (it will not exact same time as calendar)
        // for performance and battery consumption reason
        mAlarmManager.setInexactRepeating(
                AlarmManager.RTC_WAKEUP,
                dailyTimeCalendar.getTimeInMillis(),
                AlarmManager.INTERVAL_DAY,
                mPendingIntent);

    }

    public void cancelQuoteAlarmManager() {
        if (mAlarmManager != null) {
            mAlarmManager.cancel(mPendingIntent);
        }
    }
}
