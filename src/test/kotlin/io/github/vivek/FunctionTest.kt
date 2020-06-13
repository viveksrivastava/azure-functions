package io.github.vivek

import com.microsoft.azure.functions.ExecutionContext
import com.microsoft.azure.functions.HttpRequestMessage
import com.microsoft.azure.functions.HttpStatus
import com.nhaarman.mockitokotlin2.mock
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.mockito.Mockito.*
import java.util.logging.Logger


/**
 * Unit test for Function class.
 */
class FunctionTest {
    /**
     * Unit test for QuotesJava method.
     */
    @Test
    @Throws(Exception::class)
    fun testHttpTriggerJava() {
        // Setup
        @SuppressWarnings("unchecked")
        val req : HttpRequestMessage<Any> = mock()

        doReturn("Hello").`when`(req).body

        doAnswer { invocation ->
            val status = invocation.arguments[0] as HttpStatus
            HttpResponseMessageMock.HttpResponseMessageBuilderMock().status(status)
        }.`when`(req).createResponseBuilder(any(HttpStatus::class.java))

        val context = mock(ExecutionContext::class.java)
        doReturn(Logger.getGlobal()).`when`(context).logger

        // Invoke
        val ret = Function().run(req, context)

        // Verify
        assertEquals(ret.status, HttpStatus.OK)
    }
}
