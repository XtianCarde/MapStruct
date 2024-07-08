package com.riwi.biblioteca.infrastructure.abstract_service;

import com.riwi.biblioteca.api.dto.request.BookRequest;
import com.riwi.biblioteca.api.dto.response.BookResponse;

public interface IBookService extends CrudService<BookRequest, BookResponse, Long>{
    
}
