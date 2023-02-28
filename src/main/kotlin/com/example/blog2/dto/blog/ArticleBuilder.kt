package com.example.blog2.dto.blog

import java.time.LocalDateTime

class ArticleBuilder private constructor
(
    val id:Long = 0,
    val title: String?,
    val content: String?,
    val personId: Long?,
    val addedArticle: LocalDateTime = LocalDateTime.now()
)
{
    data class Builder
        (
        var id:Long = 0,
        var title: String? = null,
        var content: String? = null,
        var personId: Long? = null,
        var addedArticle: LocalDateTime = LocalDateTime.now()
        )

        {
        fun title(title: String) = apply { this.title = title }
        fun content(content: String) = apply { this.content = content }
        fun personId(personId: Long) = apply { this.personId = personId }
        fun build() = ArticleBuilder(id, title, content, personId, addedArticle)
        }
}