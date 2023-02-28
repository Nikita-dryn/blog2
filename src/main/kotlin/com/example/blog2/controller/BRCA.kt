package com.example.blog2.controller

import com.example.blog2.dto.blog.ArticleRequest
import com.example.blog2.pojo.Article
import com.example.blog2.repositories.RepoArticles
import com.example.blog2.repositories.RepoPerson
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.net.URI


@RestController
@RequestMapping("/api/v1/brca")
class BRCA(val repoPerson: RepoPerson, val repoArticles: RepoArticles)
{
    @GetMapping("/getAll")
    fun getAll() = repoArticles.findAll()

    @GetMapping("/getById")
    fun getById(@PathVariable id: Long) = repoArticles.findById(id)

    @DeleteMapping("/deleteArticle")
    fun deleteArticle(@PathVariable id:Long):ResponseEntity<Void>
    {
        val deleteArticle = repoArticles.findById(id)
        if(deleteArticle.isPresent)
        {
            repoArticles.delete(deleteArticle.get())
        } else { return ResponseEntity.notFound().build()}
        return ResponseEntity.status(204).build()
    }

    @PostMapping("/createArticle")
    fun createArticle(@RequestBody articleRequest: ArticleRequest):ResponseEntity<Void>
    {
        val newArticle: Article
        val person = repoPerson.findById(articleRequest.personId)
        if(person.isPresent)
        {
            val createArticle = Article(0, articleRequest.title, articleRequest.content, person.get())
            newArticle = repoArticles.saveAndFlush(createArticle)
        } else {return ResponseEntity.notFound().build()}
        return ResponseEntity.created(URI("/createArticle/${newArticle.id}")).build()
    }

    @PutMapping("/updateArticle")
    fun updateArticle(@PathVariable id: Long, @RequestBody articleDetails: Article)
    {
        val updateArticle = repoArticles.findById(id)
        if(updateArticle.isPresent)
        {
            val newArticle = updateArticle.get()
            newArticle.title = articleDetails.title
            newArticle.content = articleDetails.content
            newArticle.person = articleDetails.person
            repoArticles.saveAndFlush(newArticle)
        }
    }

}