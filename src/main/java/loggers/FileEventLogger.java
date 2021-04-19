package loggers;

import events.Event;
import events.EventType;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileEventLogger implements EventLogger{
    private final String fileName;
    private File file;

    public FileEventLogger(String fileName) {
        this.fileName = fileName;
    }

    public void init() throws IOException{
        this.file = new File(fileName);
        if (!file.canExecute()){
            throw new IOException();
        }
    }

    @Override
    public void logEvent(Event event, EventType eventType) {
        try(FileWriter fileWriter = new FileWriter(file, true)) {
            fileWriter.append(event.toString())
                    .append(System.lineSeparator());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
