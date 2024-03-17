package com.example.demo

import com.amazonaws.auth.DefaultAWSCredentialsProviderChain
import com.amazonaws.services.sqs.AmazonSQS
import com.amazonaws.services.sqs.AmazonSQSClientBuilder
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
class KotlinSpringGrpcApplication

fun main(args: Array<String>) {
	runApplication<KotlinSpringGrpcApplication>(*args)
}

@Bean
fun createSQSClient(): AmazonSQS {
	return AmazonSQSClientBuilder.standard()
		.withCredentials(DefaultAWSCredentialsProviderChain.getInstance())
		.withRegion("my_aws_region")
		.build()
}
