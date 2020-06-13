package io.github.vivek.quotes;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuoteBuilderTest {
    @Test
    public void testBuildQuotes() throws Exception {
        assertNotNull(QuotesListBuilder.quotes);
        assertTrue(QuotesListBuilder.quotes.size() != 0);
    }

}