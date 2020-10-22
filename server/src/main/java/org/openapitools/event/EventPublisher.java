package org.openapitools.event;

import com.google.common.eventbus.Subscribe;

import org.openapitools.annotations.EventSubscriber;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import java.lang.reflect.Method;

@Service
public class EventPublisher implements IEventPublisher, ApplicationContextAware {

    private static final Logger log = LoggerFactory.getLogger(EventPublisher.class);

    private ApplicationContext applicationContext;

    @Override
    public IEventPublisher raiseEvent(Object event) {
        applicationContext.getBeansWithAnnotation(EventSubscriber.class).values().forEach(subscribe -> {
                    try {
                        Method[] methods = subscribe.getClass().getMethods();
                        for (Method method : methods) {
                            if (method.getAnnotation(Subscribe.class) != null) {
                                Class parameter = method.getParameterTypes()[0];
                                if (parameter.isAssignableFrom(event.getClass())) {
                                    try {
                                        method.invoke(subscribe, event);
                                    } catch (Exception e) {
                                        log.error("Error on subscriber", e);
                                    }
                                }
                            }
                        }
                    } catch (Exception e) {
                        log.error("Eror on subscriber {} for event", subscribe, e);
                    }
                }
        );
        return this;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
