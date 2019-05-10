package com.ponca.pakin.pondokcabe.utils;

import android.app.Activity;
import android.app.AlertDialog;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.ponca.pakin.pondokcabe.R;

public class DialogUtils {

    public static void showQuoteDialog(@NonNull final Activity context,
            @NonNull String quote,
            @NonNull String page,
            @NonNull final MyDialogActionListener closeListener) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        View view = context.getLayoutInflater().inflate(R.layout.alert_quotes, null);

        TextView tvQuote = view.findViewById(R.id.tv_quote);
        TextView tvPage = view.findViewById(R.id.tv_page);
        ImageView btnClose = view.findViewById(R.id.img_close);
        builder.setView(view);
        builder.setCancelable(false);
        final AlertDialog dialog = builder.create();
        tvPage.setText(quote);
        tvQuote.setText(page);
        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                if (closeListener != null) {
                    closeListener.action();
                }
            }
        });
        dialog.show();
    }

    public interface MyDialogActionListener {

        void action();
    }
}
