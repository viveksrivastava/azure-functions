package io.github.vivek

import com.microsoft.azure.functions.ExecutionContext
import com.microsoft.azure.functions.HttpMethod
import com.microsoft.azure.functions.HttpRequestMessage
import com.microsoft.azure.functions.HttpResponseMessage
import com.microsoft.azure.functions.HttpStatus
import com.microsoft.azure.functions.annotation.AuthorizationLevel
import com.microsoft.azure.functions.annotation.FunctionName
import com.microsoft.azure.functions.annotation.HttpTrigger
import io.github.vivek.quotes.aRandomQuote

/**
 * Azure Functions with HTTP Trigger.
 */
class Function {

    @FunctionName("quotes")
    fun run(
            @HttpTrigger(name = "req", methods = [HttpMethod.GET, HttpMethod.POST], authLevel = AuthorizationLevel.ANONYMOUS)
            request: HttpRequestMessage<Any>,
            context: ExecutionContext): HttpResponseMessage {
        context.logger.info("Java HTTP trigger processed a request.")
       return  request.createResponseBuilder(HttpStatus.OK).body(aRandomQuote().let {  "${it.quote} :: ${it.author}" } ).build()
    }
}
