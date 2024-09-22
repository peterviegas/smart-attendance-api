package com.viegas.smartattence.api.services;

import java.util.Optional;

import com.viegas.smartattence.api.entities.Employee;

public interface EmployeeService {

	/**
	 * Persist a new employee in the database.
	 * 
	 * @param employee
	 * @return Employee
	 */
	Employee persistir(Employee employee);
	
	/**
	 * Search and return an employee given a CPF.
	 * 
	 * @param cpf
	 * @return Optional<Employee>
	 */
	Optional<Employee> buscarPorCpf(String cpf);
	
	/**
	 * Search and return an employee given a email.
	 * 
	 * @param email
	 * @return Optional<Employee>
	 */
	Optional<Employee> buscarPorEmail(String email);
	
	/**
	 * Search and return an employee given a ID.
	 * 
	 * @param id
	 * @return Optional<Employee>
	 */
	Optional<Employee> buscarPorId(Long id);
}
