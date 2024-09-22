package com.viegas.smartattence.api.repositories;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.viegas.smartattence.api.entities.Company;

@SpringBootTest
@ActiveProfiles("test")
public class CompanyRepositoryTest {

    @Autowired
    private CompanyRepository companyRepository;
    
    private static final String CNPJ = "51463645000100";

    @BeforeEach
    public void setUp() throws Exception {
        Company company = new Company();
        company.setLegalName("Empresa de exemplo");
        company.setCnpj(CNPJ);
        this.companyRepository.save(company);
    }
    
    @AfterEach
    public void tearDown() { 
        this.companyRepository.deleteAll();
    }

    @Test
    public void testBuscarPorCnpj() {
    	 Optional<Company> optionalEmpresa = this.companyRepository.findByCnpj(CNPJ);
         assertTrue(optionalEmpresa.isPresent(), "Company should be present");
         assertEquals(CNPJ, optionalEmpresa.get().getCnpj());
    }
}
