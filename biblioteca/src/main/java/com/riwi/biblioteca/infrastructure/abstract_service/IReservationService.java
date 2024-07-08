package com.riwi.biblioteca.infrastructure.abstract_service;

import com.riwi.biblioteca.api.dto.request.ReservationRequest;
import com.riwi.biblioteca.api.dto.response.ReservationResponse;

public interface IReservationService extends CrudService<ReservationRequest,ReservationResponse,Long> {
    
}
