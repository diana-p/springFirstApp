package loggers;

import events.Event;
import events.EventType;

public interface EventLogger {
    void logEvent(Event event, EventType eventType);
}
