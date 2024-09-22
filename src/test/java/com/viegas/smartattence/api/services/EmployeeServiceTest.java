package com.viegas.smartattence.api.services;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import com.viegas.smartattence.api.entities.Employee;
import com.viegas.smartattence.api.repositories.EmployeeRepository;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@ActiveProfiles("test")
public class EmployeeServiceTest {
	
	@MockBean
	private EmployeeRepository employeeRepository;

	@Autowired
	private EmployeeService employeeService;

	@BeforeEach
	public void setUp() {
		BDDMockito.given(this.employeeRepository.save(Mockito.any(Employee.class))).willReturn(new Employee());
		BDDMockito.given(this.employeeRepository.findById(Mockito.anyLong())).willReturn(Optional.of(new Employee()));
		BDDMockito.given(this.employeeRepository.findByEmail(Mockito.anyString())).willReturn(new Employee());
		BDDMockito.given(this.employeeRepository.findByCpf(Mockito.anyString())).willReturn(new Employee());
	}

	@Test
	public void testPersistirEmployee() {
		Employee employee = this.employeeService.persistir(new Employee());

		assertNotNull(employee);
	}

	@Test
	public void testBuscarEmployeePorId() {
		Optional<Employee> employee = this.employeeService.buscarPorId(1L);

		assertTrue(employee.isPresent());
	}

	@Test
	public void testBuscarEmployeePorEmail() {
		Optional<Employee> employee = this.employeeService.buscarPorEmail("email@email.com");

		assertTrue(employee.isPresent());
	}

	@Test
	public void testBuscarEmployeePorCpf() {
		Optional<Employee> employee = this.employeeService.buscarPorCpf("24291173474");

		assertTrue(employee.isPresent());
	}
}
