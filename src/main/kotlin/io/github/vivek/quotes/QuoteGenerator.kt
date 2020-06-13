package io.github.vivek.quotes

import java.util.Random


fun aRandomQuote(): Quote {
    val rand = Random()
    return QuotesListBuilder.quotes[rand.nextInt(QuotesListBuilder.quotes.size)]
}
