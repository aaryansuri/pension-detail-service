package com.cognizant.details.model;


import com.opencsv.bean.CsvBindByName;
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
@ApiModel(description = "Details about the user's bank")
public class Bank {

    @CsvBindByName(column = "bank")
    @ApiModelProperty(notes = "e.g SBI, HDFC, PNB")
    private String name;

    @CsvBindByName(column = "acc_no")
    private String accountNumber;

    @CsvBindByName(column = "bankType")
    @ApiModelProperty(notes = "bank should private or public")
    private String type;


}
