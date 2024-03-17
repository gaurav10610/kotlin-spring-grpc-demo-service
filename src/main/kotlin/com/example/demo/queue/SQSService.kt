package com.example.demo.queue

import com.amazonaws.services.sqs.AmazonSQS
import com.amazonaws.services.sqs.model.SendMessageRequest
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class SQSService(@Autowired private val sqs: AmazonSQS) {

    /**
     * both of these can be exported application config
     */
    private val successQueueUrl = "my-success-queue-url"
    private val failureQueueUrl = "my-failure-queue-url"

    fun publishSuccessMessage(bookingId: String) {
        val message = "Booking $bookingId was successful"
        publishMessage(successQueueUrl, message)
    }

    fun publishFailureMessage(bookingId: String, errorMessage: String) {
        val message = "Booking $bookingId failed: $errorMessage"
        publishMessage(failureQueueUrl, message)
    }

    private fun publishMessage(queueUrl: String, message: String) {
        val request = SendMessageRequest()
            .withQueueUrl(queueUrl)
            .withMessageBody(message)
        sqs.sendMessage(request)
    }
}
