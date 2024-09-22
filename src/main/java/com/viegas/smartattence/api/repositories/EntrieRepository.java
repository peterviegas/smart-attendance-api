package com.viegas.smartattence.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.viegas.smartattence.api.entities.Entrie;

import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

@Transactional(readOnly = true)

	
@NamedQueries({
		@NamedQuery(name = "EntrieRepository.findByEmployeeId", 
				query = "SELECT lanc FROM Entrie lanc WHERE lanc.employee.id = :employeeId") })
public interface EntrieRepository extends JpaRepository<Entrie, Long> {
	
		List<Entrie> findByEmployeeId(@Param("employeeId") Long EmployeeId);
	
		Page<Entrie> findByEmployeeId(@Param("employeeId") Long EmployeeId, Pageable pageable);
}