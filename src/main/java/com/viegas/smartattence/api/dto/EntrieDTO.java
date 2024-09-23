package com.viegas.smartattence.api.dto;

import java.util.Date;

import com.viegas.smartattence.api.entities.Entrie;

public class EntrieDTO {

	private Long id;
	private Date date;
	private String type;
	private String description;
	private String location;
	private Long employeeId;
	
	public EntrieDTO() {
		super();
	}
	
	public EntrieDTO(Entrie obj) {
		this.id = obj.getId();
		this.date = obj.getDate();
		this.description = obj.getDescription();
		this.location = obj.getLocation();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}
	
	@Override
	public String toString() {
		return "EntrieDto [id=" + id + ", date=" + date + ", type=" + type + ", description=" + description
				+ ", location=" + location + ", employeeId=" + employeeId + "]";
	}
}
