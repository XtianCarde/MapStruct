package com.riwi.biblioteca.infrastructure.mappers;

import com.riwi.biblioteca.api.dto.request.UserRequest;
import com.riwi.biblioteca.domain.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Mappings;


@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {
    @Mappings({
            @Mapping(target = "id", ignore = true)
    })
    User requestToEntity(UserRequest request);
}
