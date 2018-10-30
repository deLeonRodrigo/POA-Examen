package edu.salle.examen.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Entity
public class Task {
	@Id
	@GeneratedValue
	private long id;
	private long userId;
	private String title;
	private String description;
	
	public Task(long userId, String title, String description) {
		super();
		this.userId = userId;
		this.title = title;
		this.description = description;
	}
	
	public Task() {}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
