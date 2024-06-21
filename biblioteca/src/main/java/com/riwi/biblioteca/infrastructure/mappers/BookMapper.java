package com.riwi.biblioteca.infrastructure.mappers;

import com.riwi.biblioteca.api.dto.request.BookRequest;
import com.riwi.biblioteca.domain.entities.Book;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Mappings;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface BookMapper {

    @Mappings({
            @Mapping(target = "id", ignore = true)
    })
    Book requestToEntity(BookRequest request);
}
