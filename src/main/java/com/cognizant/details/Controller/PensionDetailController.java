package com.cognizant.details.Controller;

import com.cognizant.details.model.PensionerDetail;

import com.cognizant.details.Exception.UserAadhaarNotFoundException;

import com.cognizant.details.Service.PensionersDetailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.text.SimpleDateFormat;


@RestController
@Slf4j
public class PensionDetailController {


    @Autowired
    private PensionersDetailService pensionersDetailService;



    @GetMapping("/PensionerDetailByAadhaar/{aadhaarNumber}")
    public ResponseEntity<PensionerDetail> retrieveDetailByAadhaar(@PathVariable final long aadhaarNumber) throws IOException {

        log.info("pension-details/retrieveDetailByAadhaar - called");
        log.debug("/PensionerDetailByAadhaar/{}", aadhaarNumber);

        PensionerDetail pensionerDetail = null;

        try {
            pensionerDetail = pensionersDetailService.findRecordByAadhaarNumber(aadhaarNumber);
        }catch (UserAadhaarNotFoundException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }

//        pensionerDetail.setDateOfBirth(new SimpleDateFormat("dd/MM/yyyy").format(pensionerDetail.getDob()));


        log.debug("returning details of {}", aadhaarNumber);
        log.info("pension-details/retrieveDetailByAadhaar - exit success");

        return ResponseEntity.status(HttpStatus.OK).body(pensionerDetail);

    }
}
