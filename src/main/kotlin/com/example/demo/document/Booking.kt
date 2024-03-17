package com.example.demo.document

import jakarta.persistence.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "booking")
data class Booking(
    @Id val id: String?,
    val userId: String,
    val flightId: String,
    val status: BookingStatus // Enum representing booking status
)

enum class BookingStatus {
    BOOKED, CANCELED, PENDING
}