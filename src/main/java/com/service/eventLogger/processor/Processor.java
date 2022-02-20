package com.service.eventLogger.processor;

import java.util.List;

import com.service.eventLogger.model.Event;
import com.service.eventLogger.model.ProcessedEvent;

public interface Processor {

	public List<ProcessedEvent> processEvents(final List<Event> events);

}
