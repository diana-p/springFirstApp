package loggers;

import events.Event;
import events.EventType;

public class ConsoleEventLogger implements EventLogger {

    @Override
    public void logEvent(Event event, EventType eventType) {
        System.out.println(event.toString());
    }
}
