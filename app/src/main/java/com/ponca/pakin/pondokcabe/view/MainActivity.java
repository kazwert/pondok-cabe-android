package com.ponca.pakin.pondokcabe.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.ponca.pakin.pondokcabe.R;
import com.ponca.pakin.pondokcabe.utils.QuoteAlarmManager;
import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private QuoteAlarmManager quoteAlarmManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initQuoteAlarmManager();

        initQuoteInMain();
    }

    private void initQuoteInMain() {
        ArrayList<Quote> mQuotes = Quote.getQuotes();
        ArrayList<Integer> backgrounds = Quote.getQuoteBackground();
        Random randomGenerator = new Random();
        //nextInt will decrease mQuotes.size by 1 so yo dont need to add minus 1 as range
        int randomQuote = randomGenerator.nextInt(mQuotes.size());
        int randomBackground = randomGenerator.nextInt(backgrounds.size());
        Quote quote = mQuotes.get(randomQuote);
        int background = backgrounds.get(randomBackground);

        RelativeLayout container = findViewById(R.id.container_quote);
        TextView tvQuote = findViewById(R.id.tv_quote);
        TextView tvPage = findViewById(R.id.tv_page);
        ImageView btnClose = findViewById(R.id.img_close);
        tvPage.setText(quote.getPage());
        tvQuote.setText(quote.getQuote());
        btnClose.setVisibility(View.GONE);
        container.setBackgroundResource(background);

        container.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(final View v) {
                QuoteActivity.start(getApplicationContext(), 0);
            }
        });
    }

    private void initQuoteAlarmManager() {
        quoteAlarmManager = new QuoteAlarmManager(this);
        quoteAlarmManager.initQuoteAlarmManager();
    }
}
