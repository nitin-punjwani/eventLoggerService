package com.service.eventLogger.processor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import com.service.eventLogger.model.Event;
import com.service.eventLogger.model.ProcessedEvent;

public class EventProcessor implements Processor {

	public List<ProcessedEvent> processEvents(final List<Event> events) {
		Map<String, List<Event>> groupByEventIdMap = events.stream().collect(Collectors.groupingBy(Event::getId));
		List<ProcessedEvent> processedEvents = extractListOfProcessedEvents(groupByEventIdMap);

		return processedEvents;
	}

	private List<ProcessedEvent> extractListOfProcessedEvents(Map<String, List<Event>> groupByEventIdMap) {
		Set<Map.Entry<String, List<Event>>> entrySet = groupByEventIdMap.entrySet();
		String eventId;
		List<ProcessedEvent> parsedEventList = new ArrayList<ProcessedEvent>();
		for (Map.Entry<String, List<Event>> entry : entrySet) {
			eventId = entry.getKey();
			List<Event> events = entry.getValue();
			ProcessedEvent parsedEvent = extractProcessedEvent(entry.getKey(), entry.getValue());
			parsedEventList.add(parsedEvent);
		}
		return parsedEventList;

	}

	private ProcessedEvent extractProcessedEvent(String eventId, List<Event> groupedEventsPerId) {
		ProcessedEvent parsedEvent = new ProcessedEvent();
		long startTime = 0;
		long endTime = 0;
		long duration = 0;
		if (CollectionUtils.isNotEmpty(groupedEventsPerId)) {
			for (Event event : groupedEventsPerId) {
				if (event.getState().equals(Event.STATE.STARTED)) {
					startTime = event.getTimestamp();
				}
				if (event.getState().equals(Event.STATE.FINISHED)) {
					endTime = event.getTimestamp();
				}
			}
			if (startTime != 0 && endTime != 0) {
				duration = endTime - startTime;
			}
			if (duration > 4) {
				parsedEvent.setLongRunning(true);
			} else {
				parsedEvent.setLongRunning(false);
			}
			parsedEvent.setEventId(eventId);
			parsedEvent.setEventDuration(duration);
			Event event = groupedEventsPerId.get(0);
			if (Objects.nonNull(event) && StringUtils.isNotEmpty(event.getHost())) {
				parsedEvent.setHost(event.getHost());
			}
			if (Objects.nonNull(event) && StringUtils.isNotEmpty(event.getType())) {
				parsedEvent.setType(event.getType());
			}
		}

		return parsedEvent;
	}

}
