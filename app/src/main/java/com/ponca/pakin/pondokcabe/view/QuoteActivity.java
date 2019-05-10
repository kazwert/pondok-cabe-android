package com.ponca.pakin.pondokcabe.view;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.ponca.pakin.pondokcabe.R;
import com.ponca.pakin.pondokcabe.utils.DialogUtils;
import com.ponca.pakin.pondokcabe.utils.DialogUtils.MyDialogActionListener;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quote);

        dayCounter = getIntent().getIntExtra(KEY_DAY_COUNTER, 0);

        DialogUtils.showQuoteDialog(this, getString(R.string.sample_page), getString(R.string.sample_quote), new MyDialogActionListener() {
            @Override
            public void action() {
                finish();
            }
        });

    }
}
