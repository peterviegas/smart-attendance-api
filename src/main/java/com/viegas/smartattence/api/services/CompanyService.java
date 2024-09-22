package com.viegas.smartattence.api.services;

import java.util.Optional;

import com.viegas.smartattence.api.entities.Company;

public interface  CompanyService {

	/**
	 * Return a company CNPJ.
	 * 
	 * @param cnpj
	 * @return Optional<Company>
	 */
	Optional<Company> buscarPorCnpj(String cnpj);
	
	/**
	 * Registers a new company in the database.
	 * 
	 * @param company
	 * @return Company
	 */
	Company persistir(Company company);
}
