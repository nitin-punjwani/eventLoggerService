package com.service.eventLogger;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import com.service.eventLogger.model.Event;
import com.service.eventLogger.model.ProcessedEvent;
import com.service.eventLogger.processor.EventProcessor;
import com.service.eventLogger.processor.Processor;
import com.service.eventLogger.reader.EventReader;
import com.service.eventLogger.reader.Reader;

/**
 * Event Logger Service to read events from log file, process it and write it to a data store 
 *
 */
public class EventLoggerServiceApp 
{
    public static void main( String[] args ) throws FileNotFoundException, IOException
    {    	
    	Reader reader = new EventReader();
    	List<Event> events = reader.read(args[0]);
    	display(events);
    	
    	Processor processor = new EventProcessor();
    	List<ProcessedEvent> processedEvents = processor.processEvents(events);    	
    	displayParsedEvents(processedEvents);
    	             
    }

	private static void displayParsedEvents(List<ProcessedEvent> parsedEventList) {
		for(ProcessedEvent event:parsedEventList) {
			System.out.println(event);
		}
		
	}
	
	
	private static void display(List<Event> eventList) {
		for(Event event:eventList) {
			System.out.println(event);
		}
		
	}

	
	
	
}
