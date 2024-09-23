package com.viegas.smartattence.api.dto;

import java.math.BigDecimal;
import java.util.Optional;

import org.hibernate.validator.constraints.Length;

import com.viegas.smartattence.api.entities.Employee;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

public class EmployeeDTO {
	
	private Long id;
	private String name;
	private String email;
	private String password;
	private Optional<BigDecimal> hourlyRate = Optional.empty();
	private Optional<Float> workingHoursPerDay = Optional.empty();
	private Optional<Float> lunchHours = Optional.empty();
	
	public EmployeeDTO() {
		super();
	}

	public EmployeeDTO(Employee obj) {
		this.id = obj.getId();
		this.name = obj.getName();
		this.email = obj.getEmail();
		this.password = obj.getPassword();
		this.hourlyRate = obj.getHourlyRateOpt();
		this.workingHoursPerDay = obj.getWorkingHoursPerDayOpt();
		this.lunchHours = obj.getLunchHoursOpt();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@NotEmpty(message = "Name can't to be empty.")
	@Length(min = 3, max = 200, message = "Name must between 3 e 200 characteres.")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@NotEmpty(message = "Email cannot to be empty.")
	@Length(min = 5, max = 200, message = "Email must between 5 e 200 characteres.")
	@Email(message="Email not valid.")
	public String getEmail() {
		return email;
	}


	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Optional<BigDecimal> getHourlyRate() {
		return hourlyRate;
	}

	public void setHourlyRate(Optional<BigDecimal> hourlyRate) {
		this.hourlyRate = hourlyRate;
	}

	public Optional<Float> getWorkingHoursPerDay() {
		return workingHoursPerDay;
	}

	public void setWorkingHoursPerDay(Optional<Float> workingHoursPerDay) {
		this.workingHoursPerDay = workingHoursPerDay;
	}

	public Optional<Float> getLunchHours() {
		return lunchHours;
	}

	public void setLunchHours(Optional<Float> lunchHours) {
		this.lunchHours = lunchHours;
	}
}
