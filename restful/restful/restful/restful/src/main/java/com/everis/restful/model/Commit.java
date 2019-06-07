package com.everis.restful.model;


import java.util.ArrayList;

import javax.persistence.Embedded;

import com.fasterxml.jackson.annotation.JsonProperty;


public class Commit {

	@JsonProperty("id")
	private String id;
	@JsonProperty("message")
    private String message;
	@JsonProperty("timestamp")
    private String timestamp; // "timestamp": "2011-12-12T14:27:31+02:00",
	@JsonProperty("url")
	private String url;       //"url": "http://example.com/mike/diaspora/commit/b6568db1bc1dcd7f8b4d5a946b0b91f9dacd7327",
	@Embedded
	@JsonProperty("author")
    private Author author;
	@JsonProperty("added")
	private ArrayList<String> added;
	@JsonProperty("modified")
	private ArrayList<String> modified;
	@JsonProperty("removed")
	private ArrayList<String> removed;
	
	
    
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public ArrayList<String> getAdded() {
		return added;
	}

	public void setAdded(ArrayList<String> added) {
		this.added = added;
	}

	public ArrayList<String> getModified() {
		return modified;
	}

	public void setModified(ArrayList<String> modified) {
		this.modified = modified;
	}

	public ArrayList<String> getRemoved() {
		return removed;
	}

	public void setRemoved(ArrayList<String> removed) {
		this.removed = removed;
	}
    

	
	
}
