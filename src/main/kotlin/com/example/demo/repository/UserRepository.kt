package com.example.demo.repository

import com.example.demo.document.User
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : MongoRepository<User, String> {
    // Add custom queries if needed
}