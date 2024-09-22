package com.viegas.smartattence.api.services;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import com.viegas.smartattence.api.entities.Company;
import com.viegas.smartattence.api.repositories.CompanyRepository;

@SpringBootTest
@ActiveProfiles("test")
public class CompanyServiceTest {

    @MockBean
    private CompanyRepository companyRepository;

    @Autowired
    private CompanyService companyService;

    private static final String CNPJ = "51463645000100";

    @BeforeEach
    public void setUp() throws Exception {
        // Corrigindo para retornar Optional corretamente
        BDDMockito.given(this.companyRepository.findByCnpj(Mockito.anyString()))
                .willReturn(Optional.of(new Company()));

        // Para o save(), mantemos o retorno direto de um objeto Company
        BDDMockito.given(this.companyRepository.save(Mockito.any(Company.class)))
                .willReturn(new Company());
    }

    @Test
    public void testBuscarCompanyPorCnpj() {
        Optional<Company> company = this.companyService.buscarPorCnpj(CNPJ);
        assertTrue(company.isPresent());
    }

    @Test
    public void testPersistirCompany() {
        Company company = this.companyService.persistir(new Company());
        assertNotNull(company);
    }
}
