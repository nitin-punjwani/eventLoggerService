package com.service.eventLogger.reader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.service.eventLogger.model.Event;

public class EventReader implements Reader {

	public List<Event> read(String fileName) throws FileNotFoundException, IOException {
		List<Event> eventList = new ArrayList<Event>();
		try {
			BufferedReader reader = new BufferedReader(new FileReader(fileName));
			String singleLogRecord;
			while ((singleLogRecord = reader.readLine()) != null) {
				try {
					Event parsedLogEvent = parse(singleLogRecord);
					eventList.add(parsedLogEvent);
				} catch (JsonSyntaxException jsonSyntaxException) {
					jsonSyntaxException.printStackTrace();
				}

			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return eventList;

	}

	private Event parse(final String singleLogRecord) throws JsonSyntaxException {
		Gson gson = new Gson();
		Event event = gson.fromJson(singleLogRecord, Event.class);
		return event;
	}
}
