package com.example.demo.document

import jakarta.persistence.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "users")
data class User(
    @Id
    val userId: String?,
    val name: String,
    val email: String
)