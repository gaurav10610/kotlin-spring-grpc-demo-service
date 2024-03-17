package com.example.demo.dao

import com.example.demo.document.Flight
import com.example.demo.repository.FlightRepository
import org.springframework.stereotype.Component
import java.util.Date

@Component
class FlightDAO(private val flightRepository: FlightRepository) {

    fun searchFlights(origin: String, destination: String, date: Date): List<Flight> {
        // Implement search logic here
        return flightRepository.findByOriginAndDestinationAndDepartureTime(origin, destination, date)
    }
}