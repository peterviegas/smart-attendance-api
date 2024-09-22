package com.viegas.smartattence.api.services;


import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.viegas.smartattence.api.entities.Entrie;

public interface EntrieService {

	/**
	 * Returns a paginated list of entries for a specific employee.
	 * 
	 * @param employeeId
	 * @param pageRequest
	 * @return Page<Entrie>
	 */
	Page<Entrie> buscarPorFuncionarioId(Long funcionarioId, PageRequest pageRequest);
	
	/**
	 * Return a entrie for ID.
	 * 
	 * @param id
	 * @return Optional<Entrie>
	 */
	Optional<Entrie> buscarPorId(Long id);
	
	/**
	 * Persists an entry in the database.
	 * 
	 * @param entrie
	 * @return Entrie
	 */
	Entrie persistir(Entrie entrie);
	
	/**
	 * Removes an entry from the database.
	 * 
	 * @param id
	 */
	void remover(Long id);
}
