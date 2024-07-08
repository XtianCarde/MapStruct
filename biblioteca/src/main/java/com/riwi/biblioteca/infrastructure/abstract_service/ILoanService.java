package com.riwi.biblioteca.infrastructure.abstract_service;

import com.riwi.biblioteca.api.dto.request.LoanRequest;
import com.riwi.biblioteca.api.dto.response.LoanResponse;

public interface ILoanService extends CrudService<LoanRequest, LoanResponse, Long> {
    
}
