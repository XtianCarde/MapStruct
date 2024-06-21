package com.riwi.biblioteca.domain.repositories;

import com.riwi.biblioteca.domain.entities.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Long> {
}
