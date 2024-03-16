package com.example.demo.interceptors

import io.grpc.Metadata
import io.grpc.ServerCall
import io.grpc.ServerCallHandler
import io.grpc.ServerInterceptor
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

@Component
class GrpcRPCInterceptor : ServerInterceptor {

    override fun <ReqT : Any?, RespT : Any?> interceptCall(
        call: ServerCall<ReqT, RespT>,
        headers: Metadata,
        next: ServerCallHandler<ReqT, RespT>
    ): ServerCall.Listener<ReqT> {
        log.info("Service: ${call.methodDescriptor.serviceName}, Method: ${call.methodDescriptor.bareMethodName}, Headers: $headers")
        return next.startCall(call, headers)
    }

    companion object {
        private val log = LoggerFactory.getLogger(GrpcRPCInterceptor::class.java)
    }
}