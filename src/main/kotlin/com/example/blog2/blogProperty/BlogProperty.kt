package com.example.blog2.blogProperty

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties("blog")
data class BlogProperty(val title: String, val banner: Banner )
{
    data class Banner(val title: String? = null, val content: String)
}
