package com.cognizant.details.Exception;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@AllArgsConstructor
@Data
public class ExceptionResponse {

    private Date timeStamp;
    private String message;
    private String details;

}
