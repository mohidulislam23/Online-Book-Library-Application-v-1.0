package com.bjitacademy.securityModule.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserRequestModel {
    @NotNull(message = "The first name field must not be empty.")
    private String firstName;
    private String lastName;
    @Email (message = "The provided email address is invalid.")
    private String email;
    @NotEmpty
    @Size (min = 3, message = "The password must be at least 3 characters long.")
    private String password;
    private String address;
    private String role;

}
