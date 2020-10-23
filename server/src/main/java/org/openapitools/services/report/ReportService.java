package org.openapitools.services.report;

import com.google.common.eventbus.Subscribe;
import org.openapitools.annotations.EventSubscriber;
import org.openapitools.event.RecordEvent;
import org.openapitools.persistence.nosql.mongo.model.ReportItem;
import org.openapitools.persistence.nosql.mongo.repository.ReportItemRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@EventSubscriber
public class ReportService implements IReportService {

    private static final Logger log = LoggerFactory.getLogger(ReportService.class);

    @Autowired
    ReportItemRepository reportRepository;

    @Subscribe
    public void processEvent(RecordEvent event) {
        log.info("ReportService got event {}", event);

        Object obj = event.getEventProperties().get(RecordEvent.RECORD_KEY);
        if (!ReportItem.class.isAssignableFrom(obj.getClass())){
            return;
        }

        ReportItem ri = ReportItem.class.cast(obj);
        reportRepository.save(ri);
    }
}
