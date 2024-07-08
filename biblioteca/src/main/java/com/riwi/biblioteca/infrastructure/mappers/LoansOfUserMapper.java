package com.riwi.biblioteca.infrastructure.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import com.riwi.biblioteca.api.dto.response.LoansOfUserResponse;
import com.riwi.biblioteca.domain.entities.User;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface LoansOfUserMapper {

    LoansOfUserResponse loans(User user);
}
