package org.openapitools.services;

import org.openapitools.event.IEventPublisher;
import org.openapitools.event.RecordEvent;
import org.openapitools.model.Record;
import org.openapitools.persistence.model.RecordDAO;
import org.openapitools.persistence.services.RecordRepository;
import org.openapitools.report.model.RecordItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.*;
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
        this.recordRepo.saveAndFlush(r);

        raiseEvents(toRecordItem(record, r));
    }

    private RecordItem toRecordItem(Record record, RecordDAO r) {
        return new RecordItem.Builder()
                .id(r.getId())
                .name(r.getName())
                .accountId(record.getAccountId())
                .value(record.getValue())
                .readingType(record.getReadingType())
                .when(record.getWhen())
                .build();
    }

    private void raiseEvents(RecordItem item){
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
        Optional<RecordDAO> present = this.recordRepo.findById(id);
        if (!present.isPresent()){
            return null;
        }

        RecordDAO recordDAO = present.get();

        //do the converstion to record

        //TODO: fixme
        return null;
    }
}
