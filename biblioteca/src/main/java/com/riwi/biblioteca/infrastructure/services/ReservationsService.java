package com.riwi.biblioteca.infrastructure.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.riwi.biblioteca.api.dto.request.ReservationRequest;
import com.riwi.biblioteca.api.dto.response.ReservationResponse;
import com.riwi.biblioteca.domain.entities.Reservation;
import com.riwi.biblioteca.domain.repositories.ReservationRepository;
import com.riwi.biblioteca.infrastructure.abstract_service.IReservationService;
import com.riwi.biblioteca.infrastructure.mappers.ReservationMapper;
import com.riwi.biblioteca.util.exceptions.BadRequestException;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ReservationsService implements IReservationService  {
    
    @Autowired
    private final ReservationRepository reservationRepository;

    @Autowired
    private final ReservationMapper reservationMapper;

    @Override
    public ReservationResponse create(ReservationRequest rq) {
        Reservation reservation = this.reservationMapper.requestToEntity(rq);
        return this.reservationMapper.entityToResponse(this.reservationRepository.save(reservation));
    }

    @Override
    public ReservationResponse get(Long id) {
        return this.reservationMapper.entityToResponse(this.find(id));
    }
    
    @Override
    public ReservationResponse update(ReservationRequest rq, Long id) {
        Reservation reservation = this.find(id);
        reservation = this.reservationMapper.requestToEntity(rq);
        reservation.setId(id);
        return this.reservationMapper.entityToResponse(this.reservationRepository.save(reservation));
    }
    
    @Override
    public void delete(Long id) {
        this.reservationRepository.delete(this.find(id));
    }
    
    @Override
    public Page<ReservationResponse> getAll(int page, int size) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAll'");
    }

    private Reservation find(Long id){
        return this.reservationRepository.findById(id)
                                            .orElseThrow(() -> new BadRequestException("La reserva por el id suministrado no existe"));
    }
}
