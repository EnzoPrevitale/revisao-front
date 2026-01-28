package com.senai.revisao.repositories

import com.senai.revisao.models.Book
import org.springframework.data.mongodb.repository.MongoRepository

interface BookRepository: MongoRepository<Book, String> {
}