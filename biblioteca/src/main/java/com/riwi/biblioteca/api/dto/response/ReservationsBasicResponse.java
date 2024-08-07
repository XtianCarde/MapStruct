package com.riwi.biblioteca.api.dto.response;

import java.util.Date;
import com.riwi.biblioteca.util.enums.Status;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReservationsBasicResponse {
    private Long id;
    private Date reservationDate;
    private Status status;
    private BookResponse bookEntity;
}
