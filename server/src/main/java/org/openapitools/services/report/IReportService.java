package org.openapitools.services.report;

import org.openapitools.event.RecordEvent;

public interface IReportService {

    void processEvent(RecordEvent event);
}
