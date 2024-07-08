package com.riwi.biblioteca.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.riwi.biblioteca.api.dto.request.BookRequest;
import com.riwi.biblioteca.api.dto.response.BookResponse;
import com.riwi.biblioteca.infrastructure.abstract_service.IBookService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "books")
@AllArgsConstructor
public class BookController {
    
    @Autowired 
    private final IBookService bookService;

    @PostMapping
    private ResponseEntity<BookResponse> create(@Validated @RequestBody BookRequest bookRequest){
        return ResponseEntity.ok(this.bookService.create(bookRequest));
    }

    @GetMapping
    private ResponseEntity<Page<BookResponse>> getAll(@RequestParam (defaultValue = "1") int page, @RequestParam (defaultValue = "10") int size){
        return ResponseEntity.ok(this.bookService.getAll(page - 1, size));
    }

    @GetMapping(path = "/{id}")
    private ResponseEntity<BookResponse> byId(@PathVariable Long id){
        return ResponseEntity.ok(this.bookService.get(id));
    }

    @PutMapping(path = "/{id}")
    private ResponseEntity<BookResponse> update(@PathVariable Long id, @RequestBody BookRequest bookRequest){
        return ResponseEntity.ok(this.bookService.update(bookRequest, id));
    }

    @DeleteMapping(path = "/{id}")
    private ResponseEntity<Void> delete(@PathVariable Long id){
        this.bookService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
