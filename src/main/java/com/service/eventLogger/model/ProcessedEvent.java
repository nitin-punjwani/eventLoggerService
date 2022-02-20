package com.service.eventLogger.model;

public class ProcessedEvent  {
	private String eventId;
	private long eventDuration;
	private String type;
	private String host;
	private boolean longRunning;
	
	public String getEventId() {
		return eventId;
	}
	public void setEventId(String eventId) {
		this.eventId = eventId;
	}
	public long getEventDuration() {
		return eventDuration;
	}
	public void setEventDuration(long eventDuration) {
		this.eventDuration = eventDuration;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public boolean isLongRunning() {
		return longRunning;
	}
	public void setLongRunning(boolean longRunning) {
		this.longRunning = longRunning;
	}
	@Override
	public String toString() {
		return "ProcessedEvent [eventId=" + eventId + ", eventDuration=" + eventDuration + ", type=" + type + ", host="
				+ host + ", longRunning=" + longRunning + "]";
	}
	

}
