import events.Event;
import events.EventType;
import loggers.EventLogger;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

public class App {
    Client client;
    EventLogger eventLogger;
    Map<EventType, EventLogger> map;

    public App(Client client, Map<EventType, EventLogger> map) {
        this.client = client;
        this.map = map;
    }

    public void setEventLogger(Event event, EventType eventType){
        eventLogger = map.get(eventType);
        eventLogger.logEvent(event, eventType);
    }

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
        App app = (App) ctx.getBean("app");

        app.setEventLogger((Event)ctx.getBean("event"), EventType.INFO);
        app.setEventLogger((Event)ctx.getBean("event"), EventType.ERROR);
        app.setEventLogger((Event)ctx.getBean("event"), EventType.ERROR);

        ctx.close();

    }
}
