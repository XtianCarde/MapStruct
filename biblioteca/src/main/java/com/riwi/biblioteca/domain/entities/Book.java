package com.riwi.biblioteca.domain.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "book")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 100,nullable = false)
    private String title;
    @Column(length = 100,nullable = false)
    private String author;
    @Column(nullable = false)
    private Long publicationYear;
    @Column(length = 50,nullable = false)
    private String genre;
    @Column(length = 20,nullable = false)
    private String isbn;

    @OneToMany(fetch = FetchType.LAZY,
    mappedBy = "bookEntity",
    cascade = CascadeType.ALL,
    orphanRemoval = false)
    private List<Reservation> userBooks;

    @OneToMany(fetch = FetchType.LAZY,
    mappedBy = "bookEntity",
    cascade = CascadeType.ALL,
    orphanRemoval = false)
    private List<Loan> loanBooks;
}
