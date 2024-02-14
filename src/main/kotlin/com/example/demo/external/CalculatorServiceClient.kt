package com.example.demo.external

import com.example.demo.grpc.CalculatorServiceGrpc
import com.example.demo.grpc.CalculatorServiceGrpc.CalculatorServiceBlockingStub
import com.example.demo.grpc.OperationRequest
import io.grpc.Channel

/**
 *
 * wherever we need to use the client channel can be created via below approach
 *
 * ManagedChannel channel = ManagedChannelBuilder.forTarget("localhost:15001").userPlainText().build();
 */
class CalculatorServiceClient(channel: Channel) {
    var calculatorServiceBlockingStub: CalculatorServiceBlockingStub;

    init {
        calculatorServiceBlockingStub = CalculatorServiceGrpc.newBlockingStub(channel)
    }

    fun performAddition(x: Double, y: Double): Double {
        val request: OperationRequest = OperationRequest.newBuilder().setX(x).setY(y).build();
        return calculatorServiceBlockingStub.addition(request).result;
    }

    fun performSubtraction(x: Double, y: Double): Double {
        val request: OperationRequest = OperationRequest.newBuilder().setX(x).setY(y).build();
        return calculatorServiceBlockingStub.subtraction(request).result;
    }

    fun performMultiplication(x: Double, y: Double): Double {
        val request: OperationRequest = OperationRequest.newBuilder().setX(x).setY(y).build();
        return calculatorServiceBlockingStub.multiplication(request).result;
    }

    fun performDivision(x: Double, y: Double): Double {
        val request: OperationRequest = OperationRequest.newBuilder().setX(x).setY(y).build();
        return calculatorServiceBlockingStub.division(request).result;
    }
}