package com.example.blog2.controller

import com.example.blog2.dto.blog.ArticleRequest
import com.example.blog2.pojo.Article
import com.example.blog2.repositories.RepoPerson
import com.example.blog2.service.blog.ValidationServiceArticle
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException
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
@RequestMapping("/api/v1/article")
class BlogRestControllerArticle(val validationService: ValidationServiceArticle, val repoPerson: RepoPerson)
{
    @GetMapping("/getAll")
    fun getAll() = validationService.findAll()

    @GetMapping("/getById/{id}")
    fun getById(@PathVariable id: Long): ResponseEntity<Article> {
        return try {
            ResponseEntity.ok(validationService.findById(id).get())
        } catch (e: NullPointerException){
            ResponseEntity.badRequest().build()
        } catch (e:NotFoundException){
            ResponseEntity.notFound().build()
        }
    }

    @DeleteMapping("/{id}")
    fun deleteArticleById(@PathVariable id: Long):ResponseEntity<Void>
    {
        if(id.equals(null)) return ResponseEntity.badRequest().build()
        val deleteArticle = validationService.findById(id)
        if(deleteArticle.isEmpty)
        {
            return ResponseEntity.notFound().build()
        }
        validationService.deleteById(id)
        return ResponseEntity.status(204).build()
    }

//
//    @PostMapping("/createArticle")
//    fun createArticle(@RequestBody articleRequest: ArticleRequest):ResponseEntity<Void>
//    {
//        val newArticle:Article?
//        val person = repoPerson.findById(articleRequest.personId)
//        if(person.isPresent)
//        {
//            val createArticle = Article(0, articleRequest.title, articleRequest.content, person.get())
//            newArticle = repoArticles.saveAndFlush(createArticle)
//        } else {return ResponseEntity.notFound().build()}
//
//        return  ResponseEntity.created(URI("/createArticle/${newArticle.id}")).build()
//    }
//
//    @PutMapping("/updateArticle/{id}")
//    fun updateArticle(@PathVariable id: Long, @RequestBody articleDetails: Article)
//    {
//        val updateArticle = repoArticles.findById(id)
//        if(updateArticle.isPresent)
//        {
//            val newArticle = updateArticle.get()
//            newArticle.title = articleDetails.title
//            newArticle.content = articleDetails.content
//            newArticle.person = articleDetails.person
//            repoArticles.saveAndFlush(newArticle)
//        }
//    }

}