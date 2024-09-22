package com.viegas.smartattence.api.repositories;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.ActiveProfiles;

import com.viegas.smartattence.api.entities.Company;
import com.viegas.smartattence.api.entities.Employee;
import com.viegas.smartattence.api.entities.Entrie;
import com.viegas.smartattence.api.enums.ProfileEnum;
import com.viegas.smartattence.api.enums.TypeEnum;
import com.viegas.smartattence.api.utils.PasswordUtils;

@SpringBootTest
@ActiveProfiles("test")
public class EntrieRepositoryTest {

    @Autowired
    private EntrieRepository entrieRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private CompanyRepository companyRepository;

    private Long employeeId;

    @BeforeEach
    public void setUp() throws Exception {
        Company company = this.companyRepository.save(obterDadosCompany());

        Employee employee = this.employeeRepository.save(obterDadosEmployee(company));
        this.employeeId = employee.getId();

        this.entrieRepository.save(obterDadosEntries(employee));
        this.entrieRepository.save(obterDadosEntries(employee));
    }

    @AfterEach
    public void tearDown() throws Exception {
        this.companyRepository.deleteAll();
    }

    @Test
    public void testBuscarEntriesPorEmployeeId() {
        List<Entrie> entries = this.entrieRepository.findByEmployeeId(employeeId);

        assertEquals(2, entries.size());
    }

    @Test
    public void testBuscarEntriesPorEmployeeIdPaginado() {
        PageRequest page = PageRequest.of(0, 10);
        Page<Entrie> entries = this.entrieRepository.findByEmployeeId(employeeId, page);

        assertEquals(2, entries.getTotalElements());
    }

    private Entrie obterDadosEntries(Employee employee) {
        Entrie lancamento = new Entrie();
        lancamento.setDate(new Date());
        lancamento.setType(TypeEnum.START_LUNCH);
        lancamento.setEmployee(employee);
        return lancamento;
    }

    private Employee obterDadosEmployee(Company company) throws NoSuchAlgorithmException {
        Employee employee = new Employee();
        employee.setName("Fulano de Tal");
        employee.setProfile(ProfileEnum.ROLE_USER);
        employee.setPassword(PasswordUtils.gerarBCrypt("123456"));
        employee.setCpf("24291173474");
        employee.setEmail("email@email.com");
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
