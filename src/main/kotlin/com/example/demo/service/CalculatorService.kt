package com.example.demo.service

import com.example.demo.grpc.*
import com.example.demo.grpc.Number
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.toList
import org.springframework.stereotype.Service

@Service
class CalculatorService : CalculatorServiceGrpcKt.CalculatorServiceCoroutineImplBase() {
    override suspend fun addition(request: OperationRequest): OperationResponse {
        return OperationResponse.newBuilder().setResult(request.x + request.y).build();
    }

    override suspend fun subtraction(request: OperationRequest): OperationResponse {
        return OperationResponse.newBuilder().setResult(request.x - request.y).build();
    }

    override suspend fun multiplication(request: OperationRequest): OperationResponse {
        return OperationResponse.newBuilder().setResult(request.x * request.y).build();
    }

    override suspend fun division(request: OperationRequest): OperationResponse {
        return OperationResponse.newBuilder().setResult(request.x / request.y).build();
    }

    override fun generatePrimeNumbers(request: PrimeNumberRequest): Flow<PrimeNumberResponse> {
        return flow {
            for (x in 2..request.number) {
                if (isPrime(x)) {
                    emit(PrimeNumberResponse.newBuilder().setPrime(x).build())
                }
            }
        }
    }

    override fun calculateAverage(requests: Flow<Number>): Flow<Average> {
        return flow {
            // could use transform, but it's currently experimental
            requests.map { it.value }.toList().average()
                .let { average -> emit(Average.newBuilder().setValue(average).build()) }
        }
    }

    private fun isPrime(n: Int): Boolean {
        if (n <= 1) return false
        if (n == 2 || n == 3) return true
        if (n % 2 == 0 || n % 3 == 0) return false
        var i = 5
        while (i * i <= n) {
            if (n % i == 0 || n % (i + 2) == 0) return false
            i += 6
        }
        return true
    }
}