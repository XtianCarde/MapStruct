package com.riwi.biblioteca.infrastructure.abstract_service;

import com.riwi.biblioteca.api.dto.request.UserRequest;
import com.riwi.biblioteca.api.dto.response.LoansOfUserResponse;
import com.riwi.biblioteca.api.dto.response.ReservationOfUserResp;
import com.riwi.biblioteca.api.dto.response.UserResponse;

public interface IUserService extends CrudService<UserRequest,UserResponse, Long> {
    LoansOfUserResponse loansOfUser(Long id);
    ReservationOfUserResp reservationsOfUser(Long id);
}
