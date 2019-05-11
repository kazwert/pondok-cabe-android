package com.ponca.pakin.pondokcabe.view;

import com.ponca.pakin.pondokcabe.R;
import java.util.ArrayList;

public class Quote {

    private int quoteId;

    private String quote;

    private String page;

    public Quote(final int quoteId, final String quote, final String page) {
        this.quoteId = quoteId;
        this.quote = quote;
        this.page = page;
    }

    public int getQuoteId() {
        return quoteId;
    }

    public void setQuoteId(final int quoteId) {
        this.quoteId = quoteId;
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(final String quote) {
        this.quote = quote;
    }

    public String getPage() {
        return page;
    }

    public void setPage(final String page) {
        this.page = page;
    }

    public static ArrayList<Quote> getQuotes() {
        ArrayList<Quote> mQuotes = new ArrayList<>();
        mQuotes.add(new Quote(1,
                "Hati yang tidak pada tempatnya, sekalipun melihat takkan tampak, meski mendengar takkan terdengar dan meski makan takkan merasakan.",
                "Ajaran Besar BAB VII Pasal 2-3"));
        mQuotes.add(new Quote(2,
                "Inilah sebabnya dikatakan, bahwa untuk membina diri itu berpangkal pada melurus hati.",
                "Ajaran Besar BAB VII Pasal 3-3"));
        mQuotes.add(new Quote(3,
                "Nabi bersabda, 'Belajar dan selalu dilatih, tidakkah itu menyenangkan ?'",
                "Sabda Suci Jilid I Pasal 1"));
        mQuotes.add(new Quote(4,
                "Kawan-kawan datang dari tempat jauh, tidakkah itu membahagiakan ?",
                "Sabda Suci Jilid I Pasal 1"));
        mQuotes.add(new Quote(5,
                "Nabi bersabda, 'Seorang yang pandai memutar kata-kata dan bermanis muka, sesungguhnya jarang ber-Peri Cinta Kasih'",
                "Sabda Suci Jilid I Pasal 3"));

        return mQuotes;
    }


    public static ArrayList<Integer> getQuoteBackground() {
        ArrayList<Integer> backgrounds = new ArrayList<>();
        backgrounds.add(R.drawable.bg_gradient_blue);
        backgrounds.add(R.drawable.bg_gradient_green);
        backgrounds.add(R.drawable.bg_gradient_orange);
        backgrounds.add(R.drawable.bg_gradient_purple);

        return backgrounds;
    }
}
