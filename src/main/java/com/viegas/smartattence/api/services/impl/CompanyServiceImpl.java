package com.viegas.smartattence.api.services.impl;


import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.viegas.smartattence.api.entities.Company;
import com.viegas.smartattence.api.repositories.CompanyRepository;
import com.viegas.smartattence.api.services.CompanyService;


@Service
public class CompanyServiceImpl implements CompanyService {

	private static final Logger log = LoggerFactory.getLogger(CompanyServiceImpl.class);

	@Autowired
	private CompanyRepository empresaRepository;

	@Override
	public Optional<Company> buscarPorCnpj(String cnpj) {
		log.info("Searching for a company by CNPJ {}", cnpj);
		return Optional.ofNullable(empresaRepository.findByCnpj(cnpj));
	}

	@Override
	public Company persistir(Company company) {
		log.info("Persisting company: {}", company);
		return this.empresaRepository.save(company);
	}
}
