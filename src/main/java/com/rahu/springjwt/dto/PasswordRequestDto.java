package com.rahu.springjwt.dto;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Data
public class PasswordRequestDto {

    @NotEmpty(message = "{email.invalid}")
    @Email(message = "{email.invalid}")
    private String email;
    private String resetToken;
    private String password;
}
