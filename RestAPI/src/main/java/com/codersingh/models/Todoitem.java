package com.codersingh.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Todoitem {
	
	private Long id;
	
	
	private String title;
	@NotBlank
	private boolean done;
	public Todoitem(Long id, String title, boolean done) {
		super();
		this.id = id;
		this.title = title;
		this.done = done;
	}
	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public boolean isDone() {
		return done;
	}
	public void setDone(boolean done) {
		this.done = done;
	}
	
	

}
