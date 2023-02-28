package com.example.blog2.repositories

import com.example.blog2.pojo.Article
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface RepoArticles:JpaRepository<Article, Long>