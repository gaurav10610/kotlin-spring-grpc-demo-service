package com.example.demo.dao

import com.example.demo.document.User
import com.example.demo.repository.UserRepository
import org.springframework.stereotype.Component

@Component
class UserDAO(private val userRepository: UserRepository) {

    fun getUserById(userId: String): User? {
        return userRepository.findById(userId).orElse(null)
    }

    fun updateUser(user: User): User {
        return userRepository.save(user)
    }
}