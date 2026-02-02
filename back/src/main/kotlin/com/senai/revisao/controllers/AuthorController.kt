package com.senai.revisao.controllers

import com.senai.revisao.models.Author
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
@RequestMapping("/author")
class AuthorController(private val service: AuthorService) {

    @GetMapping
    fun getAll(): ResponseEntity<List<Author>> {
        return ResponseEntity.ok(service.readAll())
    }

    @GetMapping("/{id}")
    fun get(@PathVariable id: String): ResponseEntity<Author> {
        return service.readOne(id)
            .map { author -> ResponseEntity.ok(author) }
            .orElseGet { ResponseEntity.notFound().build() }
    }

    @PostMapping
    fun post(@RequestBody dto: AuthorDto): ResponseEntity<Author> {

        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(dto))
    }

    @PatchMapping("/{id}")
    fun patch(@PathVariable id: String, @RequestBody dto: UpdateAuthorDto): ResponseEntity<Author> {
        return service.update(id, dto)
            .map { author -> ResponseEntity.status(HttpStatus.ACCEPTED).body(author) }
            .orElseGet { ResponseEntity.notFound().build() }
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: String): ResponseEntity<Void> {
        return service.delete(id)
            .map { book -> ResponseEntity.noContent().build<Void>() }
            .orElseGet { ResponseEntity.notFound().build() }
    }
}