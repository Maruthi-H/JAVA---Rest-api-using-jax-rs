package org.maruthi.learn.messanger.model;

import java.util.Date;

public class Comment {
	
	private long id;
	private String message;
	private Date createdAt;
	private String author;
	public Comment(){
		
	}
	public Comment(long id, String message, String author) {
		
		this.id = id;
		this.message = message;
		this.author = author;
		this.createdAt = new Date();
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	
}
