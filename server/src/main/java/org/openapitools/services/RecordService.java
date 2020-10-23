package org.openapitools.services;

import org.openapitools.event.IEventPublisher;
import org.openapitools.event.RecordEvent;
import org.openapitools.model.Record;
import org.openapitools.persistence.model.RecordDAO;
import org.openapitools.persistence.nosql.mongo.model.ReportItem;
import org.openapitools.persistence.services.RecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.google.common.base.Preconditions.checkArgument;

@Service
public class RecordService implements IRecordService {

    @Autowired
    RecordRepository recordRepo;

    @Autowired
    IEventPublisher eventPublisher;

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    public List<Record> getRecords() {
        return toRecord(recordRepo.findAll());
    }

    @Override
    public void addRecord(Record record) {
        checkArgument(record != null);

        //TODO: sort out the name passing
        RecordDAO r = new RecordDAO.Builder().accountId(record.getAccountId())
                .readingType(record.getReadingType())
                .when(record.getWhen())
                .name("Fake name")
                .value(record.getValue())
                .build();
        r = this.recordRepo.saveAndFlush(r);

        raiseEvents(toReportItem(record, r));
    }

    private ReportItem toReportItem(Record record, RecordDAO r) {
        return new ReportItem.Builder()
                .id(r.getId())
                .name(r.getName())
                .accountId(record.getAccountId())
                .value(record.getValue())
                .readingType(record.getReadingType())
                .when(record.getWhen())
                .build();
    }

    private void raiseEvents(ReportItem item){
        if (item == null) return;

        Map<String, Object> properties = new HashMap<>();
        properties.put(RecordEvent.RECORD_KEY, item);
        RecordEvent event = new RecordEvent(properties);
        this.eventPublisher.raiseEvent(event);
    }

    private List<Record> toRecord(Collection<RecordDAO> records) {
        return records.stream().map( r-> {
            Record rr = new Record();
            rr.id(r.getId().toString());
            rr.accountId(r.getAccountId());
            rr.customerId("-1");
            rr.value(r.getValue());
            rr.readingType(r.getReadingType());
            rr.when(r.getWhenRecorded().toLocalDateTime());

            return rr;

        }).collect(Collectors.toList());

    }

    @Override
    public Record getRecord(long id) {
        RecordDAO r = this.recordRepo.getOne(id);
        //do the converstion to record

        //TODO: fixme
        return null;
    }
}
