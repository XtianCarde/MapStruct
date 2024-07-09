package com.riwi.biblioteca.api.dto.response;

import java.util.Date;

import com.riwi.biblioteca.util.enums.Status;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class ReservationsOfBookBasicResp {
    
    private Long id;
    private Date reservationDate;
    private Status status;
    private UserResponse userEntity;
}
