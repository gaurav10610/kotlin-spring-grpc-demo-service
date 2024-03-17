package com.example.demo.service

import com.example.demo.dao.BookingDAO
import com.example.demo.dao.FlightDAO
import com.example.demo.dao.UserDAO
import com.example.demo.grpc.*
import com.example.demo.queue.SQSService
import org.springframework.beans.factory.annotation.Autowired

class FlightService(
    @Autowired
    private val sqsService: SQSService,
    @Autowired
    private val flightDAO: FlightDAO,
    @Autowired
    private val bookingDao: BookingDAO,
    @Autowired
    private val userDao: UserDAO
) : FlightServiceGrpcKt.FlightServiceCoroutineImplBase() {

    override suspend fun searchFlights(request: SearchRequest): SearchResponse {
        /**
         *
         *         val formatter = SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH)
         *         val dateInString = "7-Jun-2013"
         *         val date = formatter.parse(request.date)
         *         val flights: List<Flight>  = flightDAO.searchFlights(request.origin, request.destination, date)
         *
         */

        // Mock data (replace with actual data retrieval from database here - shown above)
        val flights = listOf(
            Flight.newBuilder()
                .setId("1")
                .setAirline("Airline A")
                .setOrigin("Origin A")
                .setDestination("Destination A")
                .setDepartureTime("2024-03-18T10:00:00")
                .setArrivalTime("2024-03-18T12:00:00")
                .setPrice(200.0)
                .build(),
            Flight.newBuilder()
                .setId("2")
                .setAirline("Airline B")
                .setOrigin("Origin B")
                .setDestination("Destination B")
                .setDepartureTime("2024-03-18T12:00:00")
                .setArrivalTime("2024-03-18T14:00:00")
                .setPrice(250.0)
                .build()
        )

        return SearchResponse.newBuilder().addAllFlights(flights).build()
    }

    override suspend fun bookFlight(request: BookingRequest): BookingResponse {
        /**
         *
         *  val user = userDao.getUserById(request.userId) ?: throw StatusException(Status.NOT_FOUND.withDescription("user not found"))
         *
         *  val booking = bookingDao.createBooking(request.userId, request.flightId)
         *
         */

        // Mock booking logic here (replace with actual data booking in database here - shown above)
        val bookingSuccessful = true // Assume booking is successful
        val message = if (bookingSuccessful) "Booking successful" else "Booking failed"

        val bookingId = "123" // assuming a booking ID is generated

        if (bookingSuccessful) {
            sqsService.publishSuccessMessage(bookingId)
        } else {
            val errorMessage = "Insufficient funds"
            sqsService.publishFailureMessage(bookingId, errorMessage)
        }

        return BookingResponse.newBuilder().setSuccess(bookingSuccessful).setBookingId(bookingId).setMessage(message)
            .build()
    }
}