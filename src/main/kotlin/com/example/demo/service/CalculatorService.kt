package com.example.demo.service

import com.example.demo.grpc.*
import com.example.demo.grpc.Number
import io.grpc.Status
import io.grpc.StatusException
import kotlinx.coroutines.flow.*
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
        if(request.y == 0.0) {
            throw StatusException(Status.INVALID_ARGUMENT.withDescription("Cannot divide by zero"))
        }
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

    override fun calculateSquares(requests: Flow<SquareRequest>): Flow<SquareResponse> {
        return flow {
            // could use transform, but it's currently experimental
            requests.collect { it ->
                emit(SquareResponse.newBuilder().setValue(Math.pow(it.value.toDouble(), 2.0)).build())
            }
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