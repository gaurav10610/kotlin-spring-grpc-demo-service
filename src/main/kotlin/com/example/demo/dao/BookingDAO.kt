package com.example.demo.dao

import com.example.demo.document.Booking
import com.example.demo.document.BookingStatus
import com.example.demo.repository.BookingRepository
import org.springframework.stereotype.Component
import java.util.UUID

@Component
class BookingDAO(private val bookingRepository: BookingRepository) {

    fun getBookingsByUserId(userId: String): List<Booking> {
        return bookingRepository.findByUserId(userId)
    }

    fun getBookingByFlightId(flightId: String): Booking? {
        return bookingRepository.findByFlightId(flightId)
    }

    fun createBooking(userId: String, flightId: String): Booking {
        /**
         * id generation can be more robust
         */
        val booking = Booking(id = UUID.randomUUID().toString(), userId = userId, flightId = flightId, status = BookingStatus.PENDING)
        return bookingRepository.save(booking)
    }

    fun updateBookingStatus(bookingId: String, newStatus: BookingStatus): Booking? {
        val booking = bookingRepository.findById(bookingId)
        if (booking.isPresent) {
            val updatedBooking = booking.get().copy(status = newStatus)
            return bookingRepository.save(updatedBooking)
        }
        return null
    }
}