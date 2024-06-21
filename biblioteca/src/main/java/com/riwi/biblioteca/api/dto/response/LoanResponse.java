package com.riwi.biblioteca.api.dto.response;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class LoanResponse {
    private Long id;
    private Date loanDate;
    private Date returnDate;
    private String status;
    private UserResponse userEntity;
    private BookResponse bookEntity;
}
