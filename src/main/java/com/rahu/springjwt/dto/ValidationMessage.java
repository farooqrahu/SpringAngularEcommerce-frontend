package com.rahu.springjwt.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ValidationMessage {

    @JsonProperty(value = "field_name")
    private String fieldName;
    private String error;
}
