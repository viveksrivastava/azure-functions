package io.github.vivek.quotes

import org.json.JSONArray
import org.json.JSONObject

object QuotesListBuilder {
    var quotes = mutableListOf<Quote>()

    init {
        buildQuotes()
    }

    private fun buildQuotes()  =
                JSONArray(quotesJson).forEach { quote -> addQuote(quote as JSONObject) }

    private fun addQuote(jsonQuote: JSONObject) {
        quotes.add(Quote(jsonQuote.get("quote") as String, jsonQuote.get("author") as String))
    }

}