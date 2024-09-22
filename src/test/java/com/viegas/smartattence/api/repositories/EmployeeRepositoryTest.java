package com.viegas.smartattence.api.repositories;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.security.NoSuchAlgorithmException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.viegas.smartattence.api.entities.Company;
import com.viegas.smartattence.api.entities.Employee;
import com.viegas.smartattence.api.enums.ProfileEnum;
import com.viegas.smartattence.api.utils.PasswordUtils;

@SpringBootTest
@ActiveProfiles("test")
public class EmployeeRepositoryTest {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private CompanyRepository companyRepository;

    private static final String EMAIL = "email@email.com";
    private static final String CPF = "24291173474";

    @BeforeEach
    public void setUp() throws Exception {
        Company company = this.companyRepository.save(obterDadosCompany());
        this.employeeRepository.save(obterDadosEmployee(company));
    }

    @AfterEach
    public final void tearDown() {
        this.companyRepository.deleteAll();
    }

    @Test
    public void testBuscarEmployeePorEmail() {
        Employee employee = this.employeeRepository.findByEmail(EMAIL);
        assertEquals(EMAIL, employee.getEmail());
    }

    @Test
    public void testBuscarEmployeePorCpf() {
        Employee employee = this.employeeRepository.findByCpf(CPF);
        assertEquals(CPF, employee.getCpf());
    }

    @Test
    public void testBuscarEmployeePorEmailECpf() {
        Employee employee = this.employeeRepository.findByCpfOrEmail(CPF, EMAIL);
        assertNotNull(employee);
    }

    @Test
    public void testBuscarEmployeePorEmailOuCpfParaEmailInvalido() {
        Employee employee = this.employeeRepository.findByCpfOrEmail(CPF, "email@invalido.com");
        assertNotNull(employee);
    }

    @Test
    public void testBuscarEmployeePorEmailECpfParaCpfInvalido() {
        Employee employee = this.employeeRepository.findByCpfOrEmail("12345678901", EMAIL);
        assertNotNull(employee);
    }

    private Employee obterDadosEmployee(Company company) throws NoSuchAlgorithmException {
        Employee employee = new Employee();
        employee.setName("Fulano de Tal");
        employee.setProfile(ProfileEnum.ROLE_USER);
        employee.setPassword(PasswordUtils.gerarBCrypt("123456"));
        employee.setCpf(CPF);
        employee.setEmail(EMAIL);
        employee.setCompany(company);
        return employee;
    }

    private Company obterDadosCompany() {
        Company company = new Company();
        company.setLegalName("Company de exemplo");
        company.setCnpj("51463645000100");
        return company;
    }
}
