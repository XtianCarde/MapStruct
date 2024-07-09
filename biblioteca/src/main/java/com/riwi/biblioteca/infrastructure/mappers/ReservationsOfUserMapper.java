package com.riwi.biblioteca.infrastructure.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import com.riwi.biblioteca.api.dto.response.ReservationOfUserResp;
import com.riwi.biblioteca.domain.entities.User;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ReservationsOfUserMapper {
    
    ReservationOfUserResp reservations(User user);
}
