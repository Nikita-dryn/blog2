package com.example.blog2.service.blog

import com.example.blog2.dto.blog.Banner
import com.example.blog2.pojo.Article
import com.example.blog2.pojo.Person


interface BlogService
{
    fun buildBanner(): Banner
    fun findAllUsers():List<Person>
    fun findAllArticles():List<Article>
}



