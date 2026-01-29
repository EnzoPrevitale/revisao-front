package com.senai.revisao.controllers

import com.senai.revisao.dtos.create.BookDto
import com.senai.revisao.dtos.update.UpdateBookDto
import com.senai.revisao.models.Book
import com.senai.revisao.repositories.BookRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/books")
class BookController(private val repository: BookRepository) {

    @GetMapping
    fun getAll(): ResponseEntity<List<Book>> {
        return ResponseEntity.ok(repository.findAll())
    }

    @GetMapping("/{id}")
    fun get(@PathVariable id: String): ResponseEntity<Book> {
        return repository.findById(id).map { book ->
            ResponseEntity.ok(book)
        }.orElseGet { ResponseEntity.notFound().build() }
    }

    @PostMapping
    fun post(@RequestBody dto: BookDto): ResponseEntity<Book> {
        val book: Book = Book(
            title = dto.title,
            imageUrl = dto.imageUrl,
            author = dto.author,
            publisher = dto.publisher,
            year = dto.year,
            isbn = dto.isbn
        )

        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(book))
    }

    @PatchMapping("/{id}")
    fun patch(@PathVariable id: String, @RequestBody dto: UpdateBookDto): ResponseEntity<Book> {
        return repository.findById(id).map { book ->
            if (!dto.title.isNullOrEmpty()) book.title = dto.title
            if (!dto.imageUrl.isNullOrEmpty()) book.imageUrl = dto.imageUrl
            if (!dto.publisher.isNullOrEmpty()) book.publisher = dto.publisher
            if (dto.year != null) book.year = dto.year
            if (!dto.isbn.isNullOrEmpty()) book.isbn = dto.isbn

            ResponseEntity.accepted().body(repository.save(book))
        }.orElseGet { ResponseEntity.notFound().build() }
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: String): ResponseEntity<Void> {
        if (repository.existsById(id)) {
            repository.deleteById(id)
            return ResponseEntity.noContent().build()
        } else {
            return ResponseEntity.notFound().build()
        }
    }
}