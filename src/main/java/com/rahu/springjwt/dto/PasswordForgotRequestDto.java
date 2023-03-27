package com.rahu.springjwt.dto;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Data
public class PasswordForgotRequestDto {

    @NotEmpty(message = "{email.invalid}")
    @Email(message = "{email.invalid}")
    private String email;
}
