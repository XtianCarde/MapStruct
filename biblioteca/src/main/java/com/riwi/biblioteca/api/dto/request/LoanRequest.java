package com.riwi.biblioteca.api.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

import com.riwi.biblioteca.util.enums.Active;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoanRequest {
    @NotBlank(message = "La fecha es necesaria")
    private Date returnDate;
    @NotNull(message = "El estado es necesario")
    private Active status;
    @NotNull(message = "El id usuario es necesario")
    private Long user_id;
    @NotNull(message = "El id libro es necesario")
    private Long book_id;
}
