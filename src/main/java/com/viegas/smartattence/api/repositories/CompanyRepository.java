package com.viegas.smartattence.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.viegas.smartattence.api.entities.Company;

import org.springframework.transaction.annotation.Transactional;

public interface CompanyRepository extends JpaRepository<Company, Long> {

	@Transactional(readOnly = true)
	Company findByCnpj(String cnpj);
}
