package com.cognizant.details.Service;

import com.cognizant.details.model.PensionerDetail;
import com.cognizant.details.Exception.UserAadhaarNotFoundException;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public interface PensionersDetailService {

    PensionerDetail findRecordByAadhaarNumber(long aadhaarNumber) throws IOException, UserAadhaarNotFoundException;

}
