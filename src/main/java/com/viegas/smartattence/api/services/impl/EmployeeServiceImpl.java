package com.viegas.smartattence.api.services.impl;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.viegas.smartattence.api.entities.Employee;
import com.viegas.smartattence.api.repositories.EmployeeRepository;
import com.viegas.smartattence.api.services.EmployeeService;


@Service
public class EmployeeServiceImpl implements EmployeeService {

	private static final Logger log = LoggerFactory.getLogger(EmployeeServiceImpl.class);

	@Autowired
	private EmployeeRepository employeeRepository;
	
	public Employee persistir(Employee employee) {
		log.info("Persist a new employee in the database: {}", employee);
		return this.employeeRepository.save(employee);
	}
	
	public Optional<Employee> buscarPorCpf(String cpf) {
		log.info("Search and return an employee given a CPF {}", cpf);
		return Optional.ofNullable(this.employeeRepository.findByCpf(cpf));
	}
	
	public Optional<Employee> buscarPorEmail(String email) {
		log.info("Search and return an employee given a email {}", email);
		return Optional.ofNullable(this.employeeRepository.findByEmail(email));
	}
	
	public Optional<Employee> buscarPorId(Long id) {
		log.info("Search and return an employee given a ID {}", id);
		return this.employeeRepository.findById(id);
	}

}
