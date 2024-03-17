package com.example.demo.service

import com.example.demo.dao.UserDAO
import com.example.demo.grpc.GetUserRequest
import com.example.demo.grpc.UpdateUserRequest
import com.example.demo.grpc.User
import com.example.demo.grpc.UserServiceGrpcKt
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class UserService(@Autowired private val userDAO: UserDAO) : UserServiceGrpcKt.UserServiceCoroutineImplBase() {
    override suspend fun getUser(request: GetUserRequest): User {
        /**
         * val user = userDao.getUserById(request.userId) ?: throw StatusException(Status.NOT_FOUND.withDescription("user not found"))
         *
         */

        // Mock response (replace with actual db call as shown above)
        val user = User.newBuilder()
            .setUserId(request.userId)
            .setName("John Doe") // Replace with actual data retrieval logic
            .setEmail("john@example.com")
            .build()
        return user
    }

    override suspend fun updateUser(request: UpdateUserRequest): User {
        /**
         * validate request
         *
         * var user = userDAO.updateUser(com.example.demo.document.User(UUID.randomUUID().toString(), request.name, request.email))
         *
         */

        // Mock response (replace with actual db call as shown above)
        val updatedUser = User.newBuilder()
            .setUserId(request.userId)
            .setName(request.name)
            .setEmail(request.email)
            .build()
        return updatedUser
    }
}