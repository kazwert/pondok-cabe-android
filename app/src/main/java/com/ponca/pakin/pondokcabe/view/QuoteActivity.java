package com.ponca.pakin.pondokcabe.view;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationCompat.BigTextStyle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import com.ponca.pakin.pondokcabe.R;
import com.ponca.pakin.pondokcabe.utils.DialogUtils;
import com.ponca.pakin.pondokcabe.utils.DialogUtils.MyDialogActionListener;
import java.util.ArrayList;
import java.util.Random;

public class QuoteActivity extends AppCompatActivity {

    public static final String KEY_DAY_COUNTER = "day_counter";

    public static void start(Context context, int dayCounter) {
        Intent starter = new Intent(context, QuoteActivity.class);
        starter.putExtra(KEY_DAY_COUNTER, dayCounter);
        starter.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        starter.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(starter);
    }

    private int dayCounter;

    private ArrayList<Quote> mQuotes;

    public ArrayList<Integer> getBackgrounds() {
        return backgrounds;
    }

    private ArrayList<Integer> backgrounds;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quote);

        dayCounter = getIntent().getIntExtra(KEY_DAY_COUNTER, 0);
        initBackground();
        mQuotes = Quote.getQuotes();
        backgrounds = Quote.getQuoteBackground();
        Random randomGenerator = new Random();
        //nextInt will decrease mQuotes.size by 1 so yo dont need to add minus 1 as range
        int randomQuote = randomGenerator.nextInt(mQuotes.size());
        int randomBackground = randomGenerator.nextInt(backgrounds.size());
        Quote quote = mQuotes.get(randomQuote);
        int background = backgrounds.get(randomBackground);
        showQuoteDialog(quote, background);
        showQuoteNotification(quote);

    }

    private void initBackground() {

    }

    private void showQuoteNotification(final Quote quote) {
        Log.d("PPC", "Quote Receiver");
        NotificationManager notificationManager = (NotificationManager) this.getSystemService(Context.NOTIFICATION_SERVICE);

        //If on Oreo then notification required a notification channel.
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel("default", "Default", NotificationManager.IMPORTANCE_DEFAULT);
            notificationManager.createNotificationChannel(channel);
        }

        NotificationCompat.Builder notification = new NotificationCompat.Builder(this, "default")
                .setContentTitle("PPC Ayat Harian")
                .setContentText(quote.getQuote())
                .setStyle(new BigTextStyle().bigText(quote.getQuote()))
                .setSmallIcon(R.mipmap.ic_launcher);

        notificationManager.notify(1, notification.build());
    }

    private void showQuoteDialog(final Quote quote, final int background) {
        DialogUtils.showQuoteDialog(this, quote.getPage(), quote.getQuote(), background, new MyDialogActionListener() {
            @Override
            public void action() {
                finish();
            }
        });
    }
}
