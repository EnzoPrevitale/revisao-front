package com.senai.revisao.dtos.create

data class BookDto(
    val title: String,
    val imageUrl: String?,
    val author: String,
    val publisher: String,
    val year: Int,
    val isbn: String,
    val authorsIds: List<String>
)