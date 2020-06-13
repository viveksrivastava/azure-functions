package io.github.vivek

import com.microsoft.azure.functions.*
import java.util.HashMap

/**
 * The mock for HttpResponseMessage, can be used in unit tests to verify if the
 * returned response by HTTP trigger function is correct or not.
 */
class HttpResponseMessageMock(private val httpStatus: HttpStatusType, private val headers: Map<String, String>, private val body: Any) : HttpResponseMessage {
    private val httpStatusCode: Int

    init {
        this.httpStatusCode = httpStatus.value()
    }

    @Override
    override fun getStatus(): HttpStatusType {
        return this.httpStatus
    }

    @Override
    override fun getStatusCode(): Int {
        return httpStatusCode
    }

    @Override
    override fun getHeader(key: String): String {
        return this.headers.getValue(key)
    }

    @Override
    override fun getBody(): Any {
        return this.body
    }

    class HttpResponseMessageBuilderMock : HttpResponseMessage.Builder {
        override fun body(body: Any?): HttpResponseMessage.Builder {
            this.body = body
            return this
        }

        private var body: Any? = null
        private var httpStatusCode: Int = 0
        private val headers = hashMapOf<String,String>()
        private var httpStatus: HttpStatusType? = null

        fun status(status: HttpStatus): HttpResponseMessage.Builder {
            this.httpStatusCode = status.value()
            this.httpStatus = status
            return this
        }

        @Override
        override fun status(httpStatusType: HttpStatusType): HttpResponseMessage.Builder {
            this.httpStatusCode = httpStatusType.value()
            this.httpStatus = httpStatusType
            return this
        }

        @Override
        override fun header(key: String, value: String): HttpResponseMessage.Builder {
            this.headers.put(key, value)
            return this
        }

        @Override
        override fun build(): HttpResponseMessage {
            return HttpResponseMessageMock(this.httpStatus!!, this.headers, this.body!!)
        }
    }
}
