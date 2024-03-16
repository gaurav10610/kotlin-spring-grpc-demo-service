package com.example.demo.client

import com.example.demo.grpc.CalculatorServiceGrpcKt
import com.example.demo.grpc.SquareRequest
import io.grpc.ManagedChannelBuilder
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import org.springframework.stereotype.Component

@Component
class CalculaterServiceClient {

    fun calculateAverages(numbers: List<Double>) {
        val channel = ManagedChannelBuilder.forAddress("localhost", 15001)
            .usePlaintext()
            .build()

        val stub = CalculatorServiceGrpcKt.CalculatorServiceCoroutineStub(channel)
        runBlocking {
            stub.calculateAverage(flow {
                numbers.forEach { value ->
                    emit(com.example.demo.grpc.Number.newBuilder().setValue(value).build())
                }
            }).collect { response ->
                // Print the average
                println("Average: ${response.value}")
            }
        }
        channel.shutdown()
    }

    fun calculateSquares(numbers: List<Int>) {
        val channel = ManagedChannelBuilder.forAddress("localhost", 15001)
            .usePlaintext()
            .build()

        val stub = CalculatorServiceGrpcKt.CalculatorServiceCoroutineStub(channel)
        runBlocking {
            stub.calculateSquares(
                flow {
                    numbers.forEach { value ->
                        emit(SquareRequest.newBuilder().setValue(value).build())
                    }
                }
            ).collect { response ->
                // Print the average
                println("Square: ${response.value}")
            }
        }
        channel.shutdown()
    }
}