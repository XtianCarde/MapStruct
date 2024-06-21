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

import com.riwi.biblioteca.util.enums.Status;

@Entity(name = "reservation")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Builder.Default
    private Date reservationDate = new Date();
    private Status status;
    private User userEntity;
    private Book bookEntity;
}
