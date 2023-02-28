package com.example.blog2.service.blog

import com.example.blog2.dto.blog.Banner
import com.example.blog2.pojo.Article
import com.example.blog2.pojo.Person
import com.example.blog2.repositories.RepoArticles
import com.example.blog2.repositories.RepoPerson
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service

@Service
class BlogServiceImpl(private val repoArticles: RepoArticles, private  val repoPerson: RepoPerson):BlogService
{

    @Value("\${blog.title}")
    lateinit var blogTitle:String
    @Value("\${blog.banner.title}")
    lateinit var blogBannerTitle:String
    @Value("\${blog.banner.content}")
    lateinit var blogContent:String


    override fun buildBanner(): Banner = Banner(blogTitle, blogBannerTitle, blogContent)

    override fun findAllUsers(): List<Person> = repoPerson.findAll()

    override fun findAllArticles(): List<Article> = repoArticles.findAll()


}