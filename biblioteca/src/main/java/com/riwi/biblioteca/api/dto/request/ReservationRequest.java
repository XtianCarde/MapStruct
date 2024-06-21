package com.riwi.biblioteca.api.dto.request;

import com.riwi.biblioteca.util.enums.Status;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReservationRequest {
    private Status status;
    private Long user_id;
    private Long book_id;
}
