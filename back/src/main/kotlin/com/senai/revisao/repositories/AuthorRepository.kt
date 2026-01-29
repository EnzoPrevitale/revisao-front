package com.senai.revisao.repositories

import com.senai.revisao.models.Author
import org.springframework.data.mongodb.repository.MongoRepository

interface AuthorRepository: MongoRepository<Author, String> {
}