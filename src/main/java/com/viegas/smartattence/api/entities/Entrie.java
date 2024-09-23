package com.viegas.smartattence.api.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Optional;

import com.viegas.smartattence.api.dto.EntrieDTO;
import com.viegas.smartattence.api.enums.TypeEnum;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "entrie")
public class Entrie	implements Serializable {
		
		private static final long serialVersionUID = 6524560251526772839L;

		@Id
	    @GeneratedValue(strategy=GenerationType.AUTO)
		private Long id;
		
		@Temporal(TemporalType.TIMESTAMP)
		@Column(name = "date", nullable = false)
		private Date date;
		
		@Column(name = "description", nullable = true)
		private String description;
		
		@Column(name = "location", nullable = true)
		private String location;
		
		@Column(name = "creationDate", nullable = false)
		private Date creationDate;
		
		@Column(name = "updateDate", nullable = false)
		private Date updateDate;
		
		@Enumerated(EnumType.STRING)
		@Column(name = "type", nullable = false)
		private TypeEnum type;
		
		@ManyToOne(fetch = FetchType.EAGER)
		private Employee employee;
		
		public Entrie() {
			super();
		}

		public Entrie(Long id, String description, String location, Date creationDate, 
				Date updateDate, Employee employee) {
			this.id = id;
			this.description = description;
			this.location = location;
			this.creationDate = creationDate;
			this.updateDate = updateDate;
			this.employee = employee;
		}
		
		public Entrie(EntrieDTO obj) {
			this.id = obj.getId();
			this.date = obj.getDate();
			this.description = obj.getDescription();
			this.location = obj.getLocation();
			this.employee.setId(obj.getEmployeeId());
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

		public TypeEnum getType() {
			return type;
		}

		public void setType(TypeEnum type) {
			this.type = type;
		}

		public Employee getEmployee() {
			return employee;
		}

		public void setEmployee(Employee employee) {
			this.employee = employee;
		}
		
		@PreUpdate
	    public void preUpdate() {
			updateDate = new Date();
	    }
	     
	    @PrePersist
	    public void prePersist() {
	        final Date actual = new Date();
	        creationDate = actual;
	        updateDate = actual;
	    }

		@Override
		public String toString() {
			return "Lancamento [id=" + id + ", date=" + date + ", description=" + description + ", location=" + location
					+ ", creationDate=" + creationDate + ", updateDate=" + updateDate + ", type=" + type
					+ ", employee=" + employee + "]";
		}
}
