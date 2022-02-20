package com.service.eventLogger;

public class Event {
	
    private String id;
	enum STATE {
		STARTED,
		FINISHED
	};
	private STATE state;	
	private long timestamp;	
	private String type;
	private String host;
	
	public Event(final String id, final STATE state,final long timestamp) {
		super();
		this.id = id;
		this.state = state;
		this.timestamp = timestamp;			
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public long getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
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
	public STATE getState() {
		return state;
	}
	public void setState(STATE state) {
		this.state = state;
	}
	
	
	}
	


