package com.riwi.biblioteca.api.dto.request;

import com.riwi.biblioteca.util.enums.Status;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReservationRequest {
    @NotNull(message = "El estado es necesario")
    private Status status;
    @NotNull(message = "El id usuario es necesario")
    private Long user_id;
    @NotNull(message = "El id libro es necesario")
    private Long book_id;
}
