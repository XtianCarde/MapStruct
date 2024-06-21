package com.riwi.biblioteca.infrastructure.mappers;

import com.riwi.biblioteca.api.dto.request.UserRequest;
import com.riwi.biblioteca.domain.entities.User;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-21T10:17:59-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 18.0.2.1 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public User requestToEntity(UserRequest request) {
        if ( request == null ) {
            return null;
        }

        User.UserBuilder user = User.builder();

        user.username( request.getUsername() );
        user.password( request.getPassword() );
        user.email( request.getEmail() );
        user.fullName( request.getFullName() );
        user.role( request.getRole() );

        return user.build();
    }
}
