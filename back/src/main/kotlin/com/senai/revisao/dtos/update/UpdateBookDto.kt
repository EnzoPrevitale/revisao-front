package com.senai.revisao.dtos.update

data class UpdateBookDto(
    val title: String?,
    val imageUrl: String?,
    val publisher: String?,
    val year: Int?,
    val isbn: String?,
    val authorsIds: List<String>
)
