package io.github.vivek.quotes;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class QuotesListBuilder {
    public static List<Quote> quotes = new ArrayList<>();
    static {
        buildQuotes();
    }

    private static void buildQuotes() {
        try {
            String fileString = new String(
                    Files.readAllBytes(
                            Paths.get(QuotesListBuilder.class.getClassLoader().getResource("quotes.json").toURI())),
                    StandardCharsets.UTF_8);
            System.out.println(fileString);
            JSONArray quotesArray = new JSONArray(fileString);
            quotesArray.forEach(quote -> addQuote((JSONObject) quote));
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
    }

    private static void addQuote(JSONObject jsonQuote) {
        quotes.add(new Quote((String) jsonQuote.get("quote"), (String) jsonQuote.get("author")));
    }

}