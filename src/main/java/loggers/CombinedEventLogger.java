package loggers;

import events.Event;
import events.EventType;

import java.util.List;

public class CombinedEventLogger implements EventLogger{
    private final List<EventLogger> loggers;

    public CombinedEventLogger(List<EventLogger> loggers) {
        this.loggers = loggers;
    }

    @Override
    public void logEvent(Event event, EventType eventType) {
        for (EventLogger eventLogger : loggers){
            eventLogger.logEvent(event, eventType);
        }

    }
}
