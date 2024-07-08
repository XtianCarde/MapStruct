package com.riwi.biblioteca.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.riwi.biblioteca.api.dto.request.ReservationRequest;
import com.riwi.biblioteca.api.dto.response.ReservationResponse;
import com.riwi.biblioteca.infrastructure.abstract_service.IReservationService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "reservations")
@AllArgsConstructor
public class ReservationController {
    
    @Autowired
    private final IReservationService reservationService;

    @PostMapping
    public ResponseEntity<ReservationResponse> create(@Validated @RequestBody ReservationRequest request){
        return ResponseEntity.ok(this.reservationService.create(request));
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<ReservationResponse> get(@PathVariable Long id){
        return ResponseEntity.ok(this.reservationService.get(id));
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<ReservationResponse> update(@RequestBody ReservationRequest request, @PathVariable Long id){
        return ResponseEntity.ok(this.reservationService.update(request, id));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        this.reservationService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
