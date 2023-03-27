package com.rahu.springjwt.exception;

import com.rahu.springjwt.dto.DtoResponse;
import com.rahu.springjwt.dto.ValidationMessage;
import org.springframework.context.MessageSource;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Priority;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@ControllerAdvice
@Priority(10)
public class AppExceptionHandler {

    private final MessageSource messageSource;

    public AppExceptionHandler(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @ExceptionHandler(value = { Exception.class })
    @ResponseBody
    public DtoResponse handleAllExceptions(Exception ex) {
        return DtoResponse.builder().status("failed").message(ex.getMessage()).build();
    }

    @ExceptionHandler(value = { MethodArgumentNotValidException.class })
    @ResponseBody
    public DtoResponse handleValidationErrorsExceptions(MethodArgumentNotValidException ex, Locale locale) {
        List<ValidationMessage> errors = new ArrayList<>();
        ex.getBindingResult().getAllErrors().forEach(error -> errors.add(ValidationMessage.builder()
                .fieldName(((FieldError) error).getField()).error(messageSource.getMessage(error, locale)).build()));

        return DtoResponse.builder().status("failed")
                .message(messageSource.getMessage("validation_errors", null, locale)).validationErrors(errors).build();
    }

    @ExceptionHandler(value = { DisabledException.class })
    @ResponseBody
    public DtoResponse handleDisabledException(DisabledException ex, Locale locale) {
        return DtoResponse.builder().status("failed")
                .message(messageSource.getMessage("invalid_credentials", null, locale)).build();
    }

    @ExceptionHandler(value = { BadCredentialsException.class })
    @ResponseBody
    public DtoResponse handleBadCredentialsException(BadCredentialsException ex, Locale locale) {
        return DtoResponse.builder().status("failed")
                .message(messageSource.getMessage("invalid_credentials", null, locale)).build();
    }

}
