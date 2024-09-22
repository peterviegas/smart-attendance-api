package com.viegas.smartattence.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.viegas.smartattence.api.entities.Employee;

@Transactional(readOnly = true)
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	
	Employee findByCpf(String cpf);
	
	Employee findByEmail(String email);
	
	Employee findByCpfOrEmail(String cpf, String email);
}
