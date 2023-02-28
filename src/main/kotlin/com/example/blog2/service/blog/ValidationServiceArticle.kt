package com.example.blog2.service.blog

import com.example.blog2.dto.blog.ArticleRequest
import com.example.blog2.pojo.Article
import java.util.Optional

interface ValidationServiceArticle
{
    fun validateProperty(articleRequest: ArticleRequest)
    fun findAll():List<Article>
    fun findById(id: Long):Optional<Article>
    fun deleteById(id: Long)
}