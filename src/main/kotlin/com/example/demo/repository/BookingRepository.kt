package com.example.demo.repository

import com.example.demo.document.Booking
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface BookingRepository : MongoRepository<Booking, String> {
    fun findByUserId(userId: String): List<Booking>
    fun findByFlightId(flightId: String): Booking?
}