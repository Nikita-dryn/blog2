package com.example.blog2.dto.blog

data class ArticleRequest
    (
    val title: String,
    val content: String,
    val personId: Long
    )