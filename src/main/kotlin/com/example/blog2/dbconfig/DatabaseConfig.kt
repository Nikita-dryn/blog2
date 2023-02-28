package com.example.blog2.dbconfig

import com.example.blog2.pojo.Article
import com.example.blog2.pojo.Person
import com.example.blog2.repositories.RepoArticles
import com.example.blog2.repositories.RepoPerson
import org.springframework.boot.ApplicationRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class DatabaseConfig
{
    @Bean
    fun DBInitializator(repoPerson: RepoPerson, repoArticles: RepoArticles) = ApplicationRunner{
        val richardGear = repoPerson.save(Person(0,"BigDaddy", "Richard", "Gear", "Fat", 33))
        repoArticles.save(Article(1, "Rumba", "Studying of Rumba", richardGear))
        repoArticles.save(Article(2, "Repair of chairs", "What we need to repair", richardGear))
    }
}