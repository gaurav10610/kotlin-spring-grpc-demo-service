package com.example.demo.repository

import com.example.demo.document.Flight
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository
import java.util.Date

@Repository
interface FlightRepository : MongoRepository<Flight, String> {
    fun findByOriginAndDestinationAndDepartureTime(origin: String, destination: String, departureTime: Date): List<Flight>
}