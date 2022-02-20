package com.service.eventLogger.writer;

import java.util.List;

import com.service.eventLogger.model.ProcessedEvent;

public interface Writer {

	public void write(List<ProcessedEvent> processedEvents);
}
