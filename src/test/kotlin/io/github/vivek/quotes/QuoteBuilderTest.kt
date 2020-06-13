package io.github.vivek.quotes

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class QuoteBuilderTest {
    @Test
    @Throws(Exception::class)
    fun testBuildQuotes() {
        assertNotNull(QuotesListBuilder.quotes)
        assertTrue(QuotesListBuilder.quotes.isNotEmpty())
    }
}