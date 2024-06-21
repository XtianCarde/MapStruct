package com.riwi.biblioteca.domain.entities;

import java.util.List;

import com.riwi.biblioteca.util.enums.Role;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "user")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 50, nullable = false)
    private String username;
    @Column(length = 100, nullable = false)
    private String password;
    @Column(nullable = false)
    private String email;
    @Column(length = 100, nullable = false)
    private String fullName;
    @Column(nullable = false)
    private Role role;

    @OneToMany(fetch = FetchType.LAZY,
    mappedBy = "userEntity",
    cascade = CascadeType.ALL,
    orphanRemoval = false)
    private List<Reservation> userBooks;

    @OneToMany(fetch = FetchType.LAZY,
    mappedBy = "userEntity",
    cascade = CascadeType.ALL,
    orphanRemoval = false)
    private List<Loan> loanBooks;
}
