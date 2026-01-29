package com.senai.revisao.models

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.index.Indexed


@Document("books")
data class Book(
    @Id val id: String? = null,
    var title: String,
    var imageUrl: String?,
    var publisher: String,
    var year: Int,
    @Indexed(unique = true) var isbn: String,
    var authors: MutableList<Author>
    )
