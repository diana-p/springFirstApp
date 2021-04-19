package loggers;

import events.Event;
import events.EventType;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CacheFileEventLogger extends FileEventLogger{
    private int cacheSize;
    private List<Event> cache = new ArrayList<>();
    private String fileName;

    public CacheFileEventLogger(String fileName) {
        super(fileName);
        this.fileName = fileName;
    }

    public void destroy(){
        if (!cache.isEmpty()){
            writeCache();
        }
    }

    @Override
    public void logEvent(Event event, EventType eventType){
        cache.add(event);

        if (cache.size() == cacheSize){
            writeCache();
            cache.clear();
        }
    }

    public void writeCache(){
        try(FileWriter fileWriter = new FileWriter(fileName)) {
            fileWriter.append(cache.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
