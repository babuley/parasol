package org.openapitools.event;

import java.util.Map;

public class RecordEvent {

    public static final String RECORD_KEY = "record";

    public final Map<String, Object> processItems;

    public RecordEvent(Map<String, Object> processItems) {
        this.processItems = processItems;
    }

    public String getName() {
        return getClass().getSimpleName();
    }

    public Map<String, Object> getEventProperties() {
        return processItems;
    }
}
