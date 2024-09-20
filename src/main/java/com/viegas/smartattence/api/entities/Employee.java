package com.viegas.smartattence.api.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.AssertFalse.List;


@Entity
@Table(name = "employee")
public class Employee implements Serializable {

	private static final long serialVersionUID = -5754246207015712518L;
	
	private Long id;
	private String name;
	private String email;
	private String password;
	private String cpf;
	private BigDecimal hourlyRate;
	private Float workingHoursPerDay;
	private Float lunchHours;
	private ProfileEnum profile;
	private Date creationDate;
	private Date updateDate;
	private Company company;
	private List<Entrie> entries;
}
