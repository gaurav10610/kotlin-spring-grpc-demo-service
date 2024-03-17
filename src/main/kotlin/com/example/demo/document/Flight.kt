package com.example.demo.document

import jakarta.persistence.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.util.Date

@Document(collection = "flight")
data class Flight(
    @Id val id: String?,
    val airline: String,
    val origin: String,
    val destination: String,
    val departureTime: Date,
    val arrivalTime: Date,
    val price: Double
)