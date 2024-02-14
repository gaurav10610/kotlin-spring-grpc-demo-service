package com.example.demo.service

import com.example.demo.grpc.CalculatorServiceGrpcKt
import com.example.demo.grpc.OperationRequest
import com.example.demo.grpc.OperationResponse
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
}