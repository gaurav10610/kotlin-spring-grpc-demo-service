package com.example.demo.service

import com.example.demo.configuration.GrpcServerConfig
import com.example.demo.grpc.HelloReply
import com.example.demo.grpc.HelloRequest
import com.example.demo.grpc.HelloServiceGrpcKt
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import javax.annotation.PostConstruct

@Service
class HelloService: HelloServiceGrpcKt.HelloServiceCoroutineImplBase() {
    companion object {
        private val log = LoggerFactory.getLogger(HelloService::class.java)
    }

    override suspend fun hello(request: HelloRequest): HelloReply {
        return HelloReply.newBuilder()
            .setMessage("Hello, ${request.name}")
            .build()
    }

    @PostConstruct
    fun afterContruct() {
        log.info("this is hello service post construct")
    }
}