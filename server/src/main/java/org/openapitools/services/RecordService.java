package org.openapitools.services;

import org.openapitools.model.Record;
import org.openapitools.persistence.model.RecordDAO;
import org.openapitools.persistence.services.RecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RecordService implements IRecordService {

    @Autowired
    RecordRepository recordRepo;

    @Override
    public List<Record> getRecords() {
        return toRecord(recordRepo.findAll());
    }

    private List<Record> toRecord(Collection<RecordDAO> records) {
        return records.stream().map( r-> {
            Record rr = new Record();
            rr.id(r.getId().toString());
            rr.accountId(r.getAccountId());
            rr.customerId("-1");
            rr.value(r.getValue());
            rr.readingType(r.getReadingType());
            rr.when(r.getWhen());

            return rr;

        }).collect(Collectors.toList());

    }
}
