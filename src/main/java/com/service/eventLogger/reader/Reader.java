package com.service.eventLogger.reader;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import com.service.eventLogger.model.Event;

public interface Reader {

	public List<Event> read(String fileName) throws FileNotFoundException,IOException; 
}
