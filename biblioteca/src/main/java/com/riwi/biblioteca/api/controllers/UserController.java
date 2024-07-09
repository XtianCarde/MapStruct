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
import com.riwi.biblioteca.api.dto.request.UserRequest;
import com.riwi.biblioteca.api.dto.response.LoansOfUserResponse;
import com.riwi.biblioteca.api.dto.response.ReservationOfUserResp;
import com.riwi.biblioteca.api.dto.response.UserResponse;
import com.riwi.biblioteca.infrastructure.abstract_service.IUserService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "users")
@AllArgsConstructor
public class UserController {

    @Autowired
    private final IUserService userService;

    @PostMapping
    public ResponseEntity<UserResponse> create(@Validated @RequestBody UserRequest user){
        return ResponseEntity.ok(this.userService.create(user));
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<UserResponse> getById(@PathVariable Long id){
        return ResponseEntity.ok(this.userService.get(id));
    }

    @GetMapping(path = "/{id}/loans")
    public ResponseEntity<LoansOfUserResponse> loans(@PathVariable Long id){
        return ResponseEntity.ok(this.userService.loansOfUser(id));
    }

    @GetMapping(path = "/{id}/reservations")
    public ResponseEntity<ReservationOfUserResp> reservations(@PathVariable Long id){
        return ResponseEntity.ok(this.userService.reservationsOfUser(id));
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<UserResponse> update(@Validated @RequestBody UserRequest user,@PathVariable Long id){
        return ResponseEntity.ok(this.userService.update(user, id));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        this.userService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
