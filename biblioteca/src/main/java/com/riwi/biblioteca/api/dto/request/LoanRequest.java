package com.riwi.biblioteca.api.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

import com.riwi.biblioteca.util.enums.Active;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoanRequest {
    private Date returnDate;
    private Active status;
    private Long user_id;
    private Long book_id;
}
