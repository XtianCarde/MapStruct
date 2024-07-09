package com.riwi.biblioteca.api.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookRequest {
    
    @NotBlank(message = "El titulo es necesario")
    private String title;
    @NotBlank(message = "El autor es necesario")
    private String author;
    @NotNull(message = "El año es necesario")
    private int publicationYear;
    @NotBlank(message = "El género es necesario")
    private String genre;
    @NotBlank(message = "El isbn es necesario")
    private String isbn;
}
