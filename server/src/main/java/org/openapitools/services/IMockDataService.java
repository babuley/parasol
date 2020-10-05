package org.openapitools.services;

import org.openapitools.persistence.model.RecordDAO;

import java.util.List;

public interface IMockDataService {

    List<RecordDAO> generateRecordsOf(String resource);

}
