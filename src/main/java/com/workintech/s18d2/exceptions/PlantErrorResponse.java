package com.workintech.s18d2.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
@Data
@AllArgsConstructor
public class PlantErrorResponse {
    private String message;
}
