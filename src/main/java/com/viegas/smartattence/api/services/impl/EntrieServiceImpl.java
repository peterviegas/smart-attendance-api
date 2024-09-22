package com.viegas.smartattence.api.services.impl;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.viegas.smartattence.api.entities.Entrie;
import com.viegas.smartattence.api.repositories.EntrieRepository;
import com.viegas.smartattence.api.services.EntrieService;

@Service
public class EntrieServiceImpl implements EntrieService {

    private static final Logger log = LoggerFactory.getLogger(EntrieServiceImpl.class);

    @Autowired
    private EntrieRepository entrieRepository;

    @Override
    public Page<Entrie> buscarPorFuncionarioId(Long funcionarioId, PageRequest pageRequest) {
        log.info("Fetching entries for employee ID {}", funcionarioId);
        return this.entrieRepository.findByEmployeeId(funcionarioId, pageRequest);
    }
    
    @Override
    @Cacheable("entriePorId")
    public Optional<Entrie> buscarPorId(Long id) {
        log.info("Fetching entry for ID {}", id);
        return this.entrieRepository.findById(id);  
    }
    
    @Override
    @CachePut("entriePorId")
    public Entrie persistir(Entrie entrie) {
        log.info("Persisting an entry: {}", entrie);
        return this.entrieRepository.save(entrie);
    }
    
    @Override
    public void remover(Long id) {
        log.info("Removing entry ID {}", id);
        this.entrieRepository.deleteById(id);  
    }
}
