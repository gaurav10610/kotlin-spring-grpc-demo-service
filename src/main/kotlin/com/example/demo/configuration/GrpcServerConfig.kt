package com.example.demo.configuration

import com.example.demo.service.CalculatorService
import com.example.demo.service.HelloService
import io.grpc.ServerBuilder
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import javax.annotation.PostConstruct


@Component
class GrpcServerConfig(@Autowired val helloService: HelloService, @Autowired val calculatorService: CalculatorService) {

    companion object {
        private val log = LoggerFactory.getLogger(GrpcServerConfig::class.java)
    }

    @PostConstruct
    fun onServerStarted() {
        log.info("gRPC Server starting...")
        val server = ServerBuilder
            .forPort(15001)
            .addService(helloService)
            .addService(calculatorService)
            .build()

        Runtime.getRuntime().addShutdownHook(Thread {
            server.shutdown()
            server.awaitTermination()
        })

        server.start()
        log.info("gRPC Server started")
        server.awaitTermination()
    }
}