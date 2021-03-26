package com.cognizant.details.repository;

import com.cognizant.details.model.PensionerDetail;


import java.io.IOException;
import java.util.List;


public interface PensionersDetailsDao {

    List<PensionerDetail> retrieveDetailsThroughCSV(String path) throws IOException;

}
