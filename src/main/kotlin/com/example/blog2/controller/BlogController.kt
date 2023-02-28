package com.example.blog2.controller

import com.example.blog2.service.blog.BlogService

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping

@Controller
class BlogController(private val blogService: BlogService)
{

    @GetMapping("/")
    fun blog(model: Model): String {
        val banner = blogService.buildBanner()
        model["title"] = banner.title
        model["banner"] = banner
        return "blog"

    }

    @GetMapping("/user")
    fun showUser(model: Model):String
    {
        model["title"] = blogService.findAllUsers()
        model["art"] = blogService.findAllArticles()
        return "blog"
    }

}