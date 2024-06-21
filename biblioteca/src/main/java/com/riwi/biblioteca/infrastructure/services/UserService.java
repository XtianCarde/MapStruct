package com.riwi.biblioteca.infrastructure.services;

import org.springframework.data.domain.Page;

import com.riwi.biblioteca.api.dto.request.UserRequest;
import com.riwi.biblioteca.api.dto.response.UserResponse;
import com.riwi.biblioteca.infrastructure.abstract_service.IUserService;

public class UserService implements IUserService {

    @Override
    public UserResponse create(UserRequest rq) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    @Override
    public UserResponse get(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'get'");
    }

    @Override
    public UserResponse update(UserRequest rq, Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void delete(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public Page<UserResponse> getAll(int page, int size) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAll'");
    }
    
}
