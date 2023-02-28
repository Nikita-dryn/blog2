package com.example.blog2.service.blog

import com.example.blog2.dto.blog.ArticleBuilder
import com.example.blog2.dto.blog.ArticleRequest
import com.example.blog2.pojo.Article
import com.example.blog2.repositories.RepoArticles
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException
import org.springframework.stereotype.Service
import java.util.*

@Service
class ValidationServiceImpl(private val repoArticles: RepoArticles):ValidationServiceArticle
{
    override fun validateProperty(articleRequest: ArticleRequest)
    {
        try {
            ArticleBuilder.Builder()
                .title(articleRequest.title)
                .content(articleRequest.content)
                .personId(articleRequest.personId)
                .build()
        } catch (n:NullPointerException){throw NullPointerException("Null")}
    }

    override fun findAll(): List<Article> = repoArticles.findAll()
    override fun findById(id: Long): Optional<Article> = repoArticles.findById(id)

    override fun deleteById(id: Long) = repoArticles.deleteById(id)


}