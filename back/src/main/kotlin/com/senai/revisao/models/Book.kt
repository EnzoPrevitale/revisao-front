package com.senai.revisao.models

import org.springframework.data.mongodb.core.mapping.Document

@Document("livros")
data class Book(
    val id: String? = null,
    var title: String,
    var imageUrl: String,
    var author: String,
    var publisher: String,
    var year: Integer,
    var isbn: String
)
