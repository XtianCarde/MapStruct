package com.riwi.biblioteca.infrastructure.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import com.riwi.biblioteca.api.dto.request.LoanRequest;
import com.riwi.biblioteca.api.dto.response.LoanResponse;
import com.riwi.biblioteca.domain.entities.Loan;
import com.riwi.biblioteca.domain.repositories.LoanRepository;
import com.riwi.biblioteca.infrastructure.abstract_service.ILoanService;
import com.riwi.biblioteca.infrastructure.mappers.LoanMapper;
import com.riwi.biblioteca.util.exceptions.BadRequestException;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class LoanService implements ILoanService {
    
    @Autowired
    private final LoanRepository loanRepository;

    @Autowired
    private final LoanMapper loanMapper;

    @Override
    public LoanResponse create(LoanRequest rq) {
        Loan loan = loanMapper.requestToEntity(rq);
        
        return this.loanMapper.entityToResponse(this.loanRepository.save(loan));
    }

    @Override
    public LoanResponse get(Long id) {
        return this.loanMapper.entityToResponse(this.find(id));
    }

    @Override
    public LoanResponse update(LoanRequest rq, Long id) {
        Loan loan = this.find(id);
        loan = this.loanMapper.requestToEntity(rq);
        loan.setId(id);
        return this.loanMapper.entityToResponse(this.loanRepository.save(loan));
    }

    @Override
    public void delete(Long id) {
        this.loanRepository.delete(this.find(id));
    }

    @Override
    public Page<LoanResponse> getAll(int page, int size) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAll'");
    }

    private Loan find(Long id){
        return this.loanRepository.findById(id)
                            .orElseThrow(() -> new BadRequestException("El id suministrado no se encuentra en el sistema"));
    }
}
