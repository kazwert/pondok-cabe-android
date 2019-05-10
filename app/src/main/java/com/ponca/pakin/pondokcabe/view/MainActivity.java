package com.ponca.pakin.pondokcabe.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.ponca.pakin.pondokcabe.R;
import com.ponca.pakin.pondokcabe.utils.QuoteAlarmManager;

public class MainActivity extends AppCompatActivity {

    private QuoteAlarmManager quoteAlarmManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initQuoteAlarmManager();
    }

    private void initQuoteAlarmManager() {
        quoteAlarmManager = new QuoteAlarmManager(this);
        quoteAlarmManager.initQuoteAlarmManager();
    }
}
