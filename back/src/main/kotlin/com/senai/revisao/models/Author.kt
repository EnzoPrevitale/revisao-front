package com.senai.revisao.models

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDate

@Document("authors")
data class Author (
    @Id val id: String? = null,
    var name: String,
    var birthday: LocalDate,
    var biography: String,
    )
