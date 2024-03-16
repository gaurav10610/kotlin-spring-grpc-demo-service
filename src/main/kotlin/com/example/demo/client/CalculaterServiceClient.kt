package com.example.demo.client

import com.example.demo.grpc.CalculatorServiceGrpcKt
import io.grpc.ManagedChannelBuilder
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import org.springframework.stereotype.Component

@Component
class CalculaterServiceClient {

    fun testAverageCalculatorRPC() {
        val channel = ManagedChannelBuilder.forAddress("localhost", 15001)
            .usePlaintext()
            .build()

        val stub = CalculatorServiceGrpcKt.CalculatorServiceCoroutineStub(channel)

        val numbers = listOf(1.0, 2.0, 3.0, 4.0, 5.0)
        runBlocking {
            stub.calculateAverage(numbersFlow(numbers)).collect { response ->
                // Print the average
                println("Average: ${response.value}")
            }
        }
        channel.shutdown()
    }

    private fun numbersFlow(numbers: List<Double>): Flow<com.example.demo.grpc.Number> = flow {
        numbers.forEach { value ->
            emit(com.example.demo.grpc.Number.newBuilder().setValue(value).build())
        }
    }
}