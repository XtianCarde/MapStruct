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
import com.riwi.biblioteca.api.dto.request.LoanRequest;
import com.riwi.biblioteca.api.dto.response.LoanResponse;
import com.riwi.biblioteca.infrastructure.abstract_service.ILoanService;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "loans")
@AllArgsConstructor
public class LoanController {
    
    @Autowired
    private final ILoanService loanService;

    @PostMapping
    public ResponseEntity<LoanResponse> create(@Validated @RequestBody LoanRequest loanRequest){
        return ResponseEntity.ok(this.loanService.create(loanRequest));
    }

    @GetMapping(path = "/{id}")
    private ResponseEntity<LoanResponse> getById(@PathVariable Long id){
        return ResponseEntity.ok(this.loanService.get(id));
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<LoanResponse> update(@Validated @RequestBody LoanRequest loanRequest, @PathVariable Long id){
        return ResponseEntity.ok(this.loanService.update(loanRequest, id));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        this.loanService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
