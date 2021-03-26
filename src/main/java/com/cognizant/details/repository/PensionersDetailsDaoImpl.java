package com.cognizant.details.repository;

import com.cognizant.details.model.PensionerDetail;
import com.opencsv.bean.CsvToBeanBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@Repository
@Slf4j
public class PensionersDetailsDaoImpl implements PensionersDetailsDao {

    @Override
    public List<PensionerDetail> retrieveDetailsThroughCSV(String path) throws IOException {

        Reader reader = Files.newBufferedReader(Paths.get(path));

        log.info("STARTED parsing csv file");

        List<PensionerDetail> pensionerDetailList = new CsvToBeanBuilder<PensionerDetail>(reader).withType(PensionerDetail.class)
                .build().parse();

        log.info("FINISHED parsing csv file and returned list of pensionerDetails");

        return pensionerDetailList;
    }
}
