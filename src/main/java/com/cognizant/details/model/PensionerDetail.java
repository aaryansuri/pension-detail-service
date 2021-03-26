package com.cognizant.details.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.opencsv.bean.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode
@ApiModel(description = "All details about the user")
public class PensionerDetail {

    @CsvBindByName(column = "aadhaarNumber")
    @ApiModelProperty(notes = "should be of fixed length 12 (only numbers allowed)")
    private long aadhaarNumber;

    @CsvBindByName(column = "name")
    private String name;

    @CsvDate("dd/MM/yyyy")
    @CsvBindByName(column = "dob")
    @ApiModelProperty(notes = "should be in past")
    private Date dob;

    @CsvBindByName(column = "pan")
    private String pan;

//    private String dateOfBirth;

    @CsvBindByName(column = "salary")
    private double salaryEarned;

    @CsvBindByName(column = "allowance")
    private double allowances;

    @CsvBindByName(column = "pensionType")
    private String pension_type;

    // self or family
    @CsvRecurse
    private Bank bank;

}
