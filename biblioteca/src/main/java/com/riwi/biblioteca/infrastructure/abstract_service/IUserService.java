package com.riwi.biblioteca.infrastructure.abstract_service;

import com.riwi.biblioteca.api.dto.request.UserRequest;
import com.riwi.biblioteca.api.dto.response.UserResponse;

public interface IUserService extends CrudService<UserRequest,UserResponse, Long> {
    
}
