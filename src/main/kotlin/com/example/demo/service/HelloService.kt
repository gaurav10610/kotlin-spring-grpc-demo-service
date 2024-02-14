package com.example.demo.service

import com.example.demo.grpc.HelloReply
import com.example.demo.grpc.HelloRequest
import com.example.demo.grpc.HelloServiceGrpcKt
import org.springframework.stereotype.Service
import javax.annotation.PostConstruct

@Service
class HelloService: HelloServiceGrpcKt.HelloServiceCoroutineImplBase() {
    override suspend fun hello(request: HelloRequest): HelloReply {
        return HelloReply.newBuilder()
            .setMessage("Hello, ${request.name}")
            .build()
    }

    @PostConstruct
    fun afterContruct() {
        println("this is hello service post construct")
    }
}