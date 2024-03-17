package com.example.demo

import com.example.demo.client.CalculaterServiceClient
import com.example.demo.grpc.CalculatorServiceGrpcKt
import com.example.demo.grpc.OperationRequest
import com.example.demo.grpc.OperationResponse
import com.example.demo.service.CalculatorService
import io.grpc.StatusException
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit.jupiter.SpringExtension
import io.grpc.Status
import io.mockk.coEvery
import io.mockk.mockk

//@SpringBootTest
//@AutoConfigureMockMvc
//@ExtendWith(SpringExtension::class)
class CalculatorServiceTest {
    @Autowired
    private lateinit var calculatorService: CalculatorService

    @Autowired
    private lateinit var calculatorServiceClient: CalculaterServiceClient

    private val mockStub = mockk<CalculatorServiceGrpcKt.CalculatorServiceCoroutineStub>()

    @BeforeEach
    fun setUp() {
        coEvery { mockStub.division(any(), any()) } returns OperationResponse.newBuilder().build()
    }

    //@Test
    fun `test divide`() {
        val request = OperationRequest.newBuilder()
            .setX(10.0)
            .setY(2.0)
            .build()

        runBlocking {
            val response = calculatorService.division(request)
            assert(response.result == 5.0)
        }
    }

    //@Test
    fun `test divide by zero`() {
        val request = OperationRequest.newBuilder()
            .setX(10.0)
            .setY(0.0) // Division by zero
            .build()

        try {
            runBlocking { calculatorService.division(request) }
        } catch (e: StatusException) {
            assert(e.status.code == Status.INVALID_ARGUMENT.code)
            assert(e.status.description == "Cannot divide by zero")
        }
    }

    //@Test
    fun `test divide client`() {
        runBlocking {
            val response = calculatorServiceClient.performDivision(10.0, 2.0, mockStub)
            assert(response.result == 0.0) // Placeholder assertion
        }
    }
}