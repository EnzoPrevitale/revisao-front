package com.senai.revisao.services

import com.senai.revisao.dtos.create.BookDto
import com.senai.revisao.dtos.update.UpdateBookDto
import com.senai.revisao.models.Author
import com.senai.revisao.models.Book
import com.senai.revisao.repositories.AuthorRepository
import com.senai.revisao.repositories.BookRepository
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException
import java.util.ArrayList
import java.util.Optional

@Service
class BookService(private val repository: BookRepository,
                        private val authorRepository: AuthorRepository) {

    fun readAll(): List<Book> {
        return repository.findAll()
    }

    fun readOne(id: String): Optional<Book> {
        return repository.findById(id)
    }

    fun create(dto: BookDto): Book {
        val book = Book(
            title = dto.title,
            imageUrl = dto.imageUrl,
            publisher = dto.publisher,
            year = dto.year,
            isbn = dto.isbn,
            authors = ArrayList<Author>()
        )

        if (dto.authorsIds.isNotEmpty()) {
            dto.authorsIds.forEach { id ->
                authorRepository.findById(id)
                    .map { author -> book.authors.add(author)}
                    .orElseThrow{ ResponseStatusException(HttpStatus.BAD_REQUEST) }
            }
        }

        return book
    }

    fun update(id: String, dto: UpdateBookDto): Optional<Book> {
        return repository.findById(id)
            .map { book ->
                if(!dto.title.isNullOrEmpty()) book.title = dto.title
                if(!dto.imageUrl.isNullOrEmpty()) book.imageUrl = dto.imageUrl
                if(!dto.publisher.isNullOrEmpty()) book.publisher = dto.publisher
                if(dto.year != null) book.year = dto.year
                if(!dto.isbn.isNullOrEmpty()) book.isbn = dto.isbn
                if (dto.authorsIds.isNotEmpty()) {
                    dto.authorsIds.forEach { id ->
                        authorRepository.findById(id)
                            .map { author -> book.authors.add(author)}
                            .orElseThrow{ ResponseStatusException(HttpStatus.BAD_REQUEST) }
                    }
                }

                return@map book
            }
    }

    fun delete(id: String): Optional<Book> {
        val book = repository.findById(id)
        return book
            .map { book ->
                repository.delete(book)
                return@map book
            }
    }
}