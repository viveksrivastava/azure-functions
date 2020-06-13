package io.github.vivek.quotes;

import java.util.Random;

public class QuoteGenerator {
    public Quote aRandomQuote() {
        Random rand = new Random();
        return QuotesListBuilder.quotes.get(rand.nextInt(QuotesListBuilder.quotes.size()));
    }

}