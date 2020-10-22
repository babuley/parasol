package org.openapitools.event;

public interface IEventPublisher {
    IEventPublisher raiseEvent(Object event);
}
