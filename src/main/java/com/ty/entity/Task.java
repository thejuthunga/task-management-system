package com.ty.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
public class Task {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String description;
	@CreationTimestamp
	private LocalDateTime createdDateTime;

	private LocalDateTime CompletedDateTime;
	private String Status;
	@ManyToOne
	@JoinColumn(name ="emp_id")
	private Employee employee;
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public LocalDateTime getCreatedDateTime() {
		return createdDateTime;
	}
	public void setCreatedDateTime(LocalDateTime createdDateTime) {
		this.createdDateTime = createdDateTime;
	}
	public LocalDateTime getCompletedDateTime() {
		return CompletedDateTime;
	}
	public void setCompletedDateTime(LocalDateTime completedDateTime) {
		CompletedDateTime = completedDateTime;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	@Override
	public String toString() {
		return "Task [id=" + id + ", description=" + description + ", createdDateTime=" + createdDateTime
				+ ", CompletedDateTime=" + CompletedDateTime + ", Status=" + Status + "]";
	}
	
	
	
}
