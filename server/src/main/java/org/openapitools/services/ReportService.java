package org.openapitools.services;

import com.google.common.eventbus.Subscribe;
import org.openapitools.annotations.EventSubscriber;
import org.openapitools.event.RecordEvent;
import org.openapitools.report.model.RecordItem;
import org.openapitools.report.repo.ReportRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@EventSubscriber
public class ReportService implements IReportService {

    private static final Logger log = LoggerFactory.getLogger(ReportService.class);

    @Autowired
    ReportRepository reportRepository;

    @Subscribe
    public void processAdmission(RecordEvent event) {
        log.error("ReportService got event {}", event);

        Object obj = event.getEventProperties().get(RecordEvent.RECORD_KEY);
        if (!RecordItem.class.isAssignableFrom(obj.getClass())){
            return;
        }

        RecordItem ri = RecordItem.class.cast(obj);
        reportRepository.save(ri);
    }
}
