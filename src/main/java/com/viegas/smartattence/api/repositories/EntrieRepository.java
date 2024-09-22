package com.viegas.smartattence.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.viegas.smartattence.api.entities.Entrie;

import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

@Transactional(readOnly = true)
public interface EntrieRepository extends JpaRepository<Entrie, Long> {
	
	@NamedQueries({
		@NamedQuery(name = "EntrieRepository.findByFuncionarioId", 
				query = "SELECT lanc FROM Lancamento lanc WHERE lanc.funcionario.id = :funcionarioId") })
	public interface LancamentoRepository extends JpaRepository<Entrie, Long> {
	
		List<Entrie> findByFuncionarioId(@Param("funcionarioId") Long funcionarioId);
	
		Page<Entrie> findByFuncionarioId(@Param("funcionarioId") Long funcionarioId, Pageable pageable);
	}
}
