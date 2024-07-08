package com.riwi.biblioteca.infrastructure.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.riwi.biblioteca.api.dto.request.BookRequest;
import com.riwi.biblioteca.api.dto.response.BookResponse;
import com.riwi.biblioteca.domain.entities.Book;
import com.riwi.biblioteca.domain.repositories.BookRepository;
import com.riwi.biblioteca.infrastructure.abstract_service.IBookService;
import com.riwi.biblioteca.infrastructure.mappers.BookMapper;
import com.riwi.biblioteca.util.exceptions.BadRequestException;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BookService implements IBookService {

    @Autowired
    private final BookRepository bookRepository;
    @Autowired
    private final BookMapper bookMapper;
    
    @Override
    public BookResponse create(BookRequest rq) {
        Book book = this.bookMapper.requestToEntity(rq);
        return this.bookMapper.entityToResponse(this.bookRepository.save(book));
    }

    @Override
    public BookResponse get(Long id) {
        return this.bookMapper.entityToResponse(this.find(id));
    }

    @Override
    public BookResponse update(BookRequest rq, Long id) {
        Book book = this.find(id);
        book = this.bookMapper.requestToEntity(rq);
        book.setId(id);
        return this.bookMapper.entityToResponse(this.bookRepository.save(book));
    }

    @Override
    public void delete(Long id) {
        this.bookRepository.delete(this.find(id));
    }

    @Override
    public Page<BookResponse> getAll(int page, int size) {
        if (page < 0) page = 0;

        PageRequest pagination = PageRequest.of(page, size);

        return this.bookRepository.findAll(pagination).map(this.bookMapper::entityToResponse);
    }
    
    private Book find(Long id){
        return this.bookRepository.findById(id).orElseThrow(() -> new BadRequestException("El libro por el id suministrado no se encuentra"));
    }
}
