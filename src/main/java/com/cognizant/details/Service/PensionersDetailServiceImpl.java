package com.cognizant.details.Service;

import com.cognizant.details.model.PensionerDetail;
import com.cognizant.details.Exception.UserAadhaarNotFoundException;
import com.cognizant.details.repository.PensionersDetailsDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
@Slf4j
@PropertySource("classpath:configuration.properties")
public class PensionersDetailServiceImpl implements PensionersDetailService {

    @Autowired
    private PensionersDetailsDao repository;

    @Autowired
    private Environment environment;

    @Override
    public PensionerDetail findRecordByAadhaarNumber(long aadhaarNumber) throws IOException, UserAadhaarNotFoundException {

        String path = environment.getProperty("csv.file.path");

        List<PensionerDetail> pensionerDetailList = repository.retrieveDetailsThroughCSV(path);

        log.info("finding pension record with aadhaar Number {}", aadhaarNumber);

        PensionerDetail pensionerDetail = pensionerDetailList.stream()
                .filter(p -> p.getAadhaarNumber() == aadhaarNumber)
                .findAny().orElse(null);

        if( pensionerDetail == null ) {
            throw new UserAadhaarNotFoundException("user not found");
        }

        log.info("returning pension record with aadhaar Number {}", aadhaarNumber);

        return pensionerDetail;
    }
}
