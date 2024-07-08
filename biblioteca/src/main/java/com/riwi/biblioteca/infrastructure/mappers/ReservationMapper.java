package com.riwi.biblioteca.infrastructure.mappers;

import com.riwi.biblioteca.api.dto.request.ReservationRequest;
import com.riwi.biblioteca.api.dto.response.ReservationResponse;
import com.riwi.biblioteca.domain.entities.Reservation;
import com.riwi.biblioteca.domain.repositories.BookRepository;
import com.riwi.biblioteca.domain.repositories.UserRepository;
import com.riwi.biblioteca.util.exceptions.BadRequestException;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Mappings;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = {UserMapper.class})
public abstract class ReservationMapper {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BookRepository bookRepository;
    
    @Mappings({
            @Mapping(target = "id", ignore = true)
    })
    public Reservation requestToEntity(ReservationRequest request){
        if ( request == null ) {
            return null;
        }

        Reservation.ReservationBuilder reservation = Reservation.builder();

        reservation.status( request.getStatus());
        reservation.userEntity(userRepository.findById(request.getUser_id()).orElseThrow(()-> new BadRequestException("El id suministrado para el usuario no se encuentra en la base de datos")));
        reservation.bookEntity(bookRepository.findById(request.getBook_id()).orElseThrow(()-> new BadRequestException("El id suministrado para el libro no se encuentra en la base de datos")));

        return reservation.build();
    };

    abstract public ReservationResponse entityToResponse(Reservation reservation);
}
