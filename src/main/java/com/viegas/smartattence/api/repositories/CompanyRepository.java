package com.viegas.smartattence.api.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.viegas.smartattence.api.entities.Company;

import org.springframework.transaction.annotation.Transactional;

public interface CompanyRepository extends JpaRepository<Company, Long> {
	
	Optional<Company> findByCnpj(String cnpj);

	//@Transactional(readOnly = true)
	//Company findByCnpj(String cnpj);
	
}
