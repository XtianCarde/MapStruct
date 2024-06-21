package com.riwi.biblioteca.infrastructure.mappers;

import com.riwi.biblioteca.api.dto.request.LoanRequest;
import com.riwi.biblioteca.domain.entities.Loan;
import com.riwi.biblioteca.domain.repositories.BookRepository;
import com.riwi.biblioteca.domain.repositories.UserRepository;
import com.riwi.biblioteca.util.exceptions.BadRequestException;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Mappings;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = {UserMapper.class})
public abstract class LoanMapper {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BookRepository bookRepository;

    @Mappings({
            @Mapping(target = "id", ignore = true)
    })
    Loan requestToEntity(LoanRequest request){
        if ( request == null ) {
            return null;
        }

        Loan.LoanBuilder loan = Loan.builder();

        loan.returnDate( request.getReturnDate() );
        loan.status( request.getStatus() );
        loan.userEntity(userRepository.findById(request.getUser_id()).orElseThrow(()-> new BadRequestException("El id suministrado para el usuario no se encuentra en la base de datos")));
        loan.bookEntity(bookRepository.findById(request.getBook_id()).orElseThrow(()-> new BadRequestException("El id suministrado para el libro no se encuentra en la base de datos")));


        return loan.build();
    }
}

