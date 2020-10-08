package org.openapitools.services;

import org.openapitools.model.Record;

import java.util.Collection;
import java.util.List;

public interface IRecordService {

    List<Record> getRecords();

    void addRecord(Record record);

    Record getRecord(long id);

}
