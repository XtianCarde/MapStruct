package com.riwi.biblioteca.api.dto.request;

import com.riwi.biblioteca.util.enums.Role;

import jakarta.validation.constraints.Email;
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
public class UserRequest {
    @NotBlank(message = "El nombre de usuario es requerido")
    private String username;
    @NotBlank(message = "La contraseña es requerida")
    private String password;
    @Email
    private String email;
    @NotBlank(message = "El nombre completo es requerido")
    private String fullName;
    @NotNull(message = "El rol es necesario")
    private Role role;
}
