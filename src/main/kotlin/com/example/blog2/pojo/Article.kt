package com.example.blog2.pojo


import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.ManyToOne

import java.time.LocalDateTime

@Entity
data class Article
(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id:Long = 0,
    var title: String,
    var content: String,
    @ManyToOne
    var person: Person,
    var addedArticle: LocalDateTime = LocalDateTime.now()
)