package com.viegas.smartattence.api.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.viegas.smartattence.api.enums.ProfileEnum;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;


@Entity
@Table(name = "employee")
public class Employee implements Serializable {

	private static final long serialVersionUID = -5754246207015712518L;
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(name = "name", nullable = false)
	private String name;
	
	@Column(name = "email", nullable = false)
	private String email;
	
	@Column(name = "password", nullable = false)
	private String password;
	
	@Column(name = "cpf", nullable = false)
	private String cpf;
	
	@Column(name = "hourlyRate", nullable = true)
	private BigDecimal hourlyRate;
	
	
	@Column(name = "workingHoursPerDay", nullable = true)
	private Float workingHoursPerDay;
	
	
	private Float lunchHours;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "profile", nullable = false)
	private ProfileEnum profile;
	
	@Column(name = "creationDate", nullable = false)
	private Date creationDate;
	
	@Column(name = "updateDate", nullable = false)
	private Date updateDate;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id", insertable = false, updatable = false)
	private Company company;
	
	@OneToMany(mappedBy = "employee", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Entrie> entries;
	
	public Employee() {
		super();
	}
	
	public Employee(Long id, String name, String email, String password,
			String cpf, BigDecimal hourlyRate, Float workingHoursPerDay, Float lunchHours, ProfileEnum profile,
			Date creationDate, Date updateDate, Company company) {
		
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.cpf = cpf;
		this.hourlyRate = hourlyRate;
		this.workingHoursPerDay = workingHoursPerDay;
		this.lunchHours = lunchHours;
		this.profile = profile;
		this.creationDate = creationDate;
		this.updateDate = updateDate;
		this.company = company;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public BigDecimal getHourlyRate() {
		return hourlyRate;
	}

	@Transient
	public Optional<BigDecimal> getHourlyRateOpt() {
		return Optional.ofNullable(hourlyRate);
	}
	
	public void setHourlyRate(BigDecimal hourlyRate) {
		this.hourlyRate = hourlyRate;
	}

	public Float getWorkingHoursPerDay() {
		return workingHoursPerDay;
	}
	
	@Transient
	public Optional<Float> getWorkingHoursPerDayOpt() {
		return Optional.ofNullable(workingHoursPerDay);
	}

	public void setWorkingHoursPerDay(Float workingHoursPerDay) {
		this.workingHoursPerDay = workingHoursPerDay;
	}

	public Float getLunchHours() {
		return lunchHours;
	}
	
	@Transient
	public Optional<Float> getLunchHoursOpt() {
		return Optional.ofNullable(lunchHours);
	}

	public void setLunchHours(Float lunchHours) {
		this.lunchHours = lunchHours;
	}

	public ProfileEnum getProfile() {
		return profile;
	}

	public void setProfile(ProfileEnum profile) {
		this.profile = profile;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public List<Entrie> getEntries() {
		return entries;
	}

	public void setEntries(List<Entrie> entries) {
		this.entries = entries;
	}
	
	@PreUpdate
    public void preUpdate() {
		updateDate = new Date();
    }
     
    @PrePersist
    public void prePersist() {
        final Date atual = new Date();
        creationDate = atual;
        updateDate = atual;
    }

	@Override
	public String toString() {
		return "Funcionario [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", cpf=" + cpf
				+ ", hourlyRate=" + hourlyRate + ", workingHoursPerDay=" + workingHoursPerDay + ", lunchHours="
				+ lunchHours + ", profile=" + profile + ", creationDate="
				+ creationDate + ", updateDate=" + updateDate + ", company=" + company + "]";
	}
}
