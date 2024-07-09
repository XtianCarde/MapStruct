package com.riwi.biblioteca.infrastructure.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import com.riwi.biblioteca.api.dto.response.ReservationsOfBookResp;
import com.riwi.biblioteca.domain.entities.Book;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ReservationsOfBookMapper {
    
    ReservationsOfBookResp reservationsOfBook(Book book);
}
