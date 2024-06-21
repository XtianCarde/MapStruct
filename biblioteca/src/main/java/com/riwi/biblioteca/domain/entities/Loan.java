package com.riwi.biblioteca.domain.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

import com.riwi.biblioteca.util.enums.Active;

@Entity(name = "loan")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Builder.Default
    private Date loanDate = new Date();
    private Date returnDate;
    private Active status;
    private User userEntity;
    private Book bookEntity;
}
