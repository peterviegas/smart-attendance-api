package com.viegas.smartattence.api.services;

import java.util.ArrayList;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.ActiveProfiles;

import com.viegas.smartattence.api.entities.Entrie;
import com.viegas.smartattence.api.repositories.EntrieRepository;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@ActiveProfiles("test")
public class EntrieServiceTest {

	@MockBean
	private EntrieRepository entrieRepository;

	@Autowired
	private EntrieService entrieService;

	@BeforeEach
	public void setUp() throws Exception {
		BDDMockito
			.given(this.entrieRepository.findByEmployeeId(Mockito.anyLong(), Mockito.any(PageRequest.class)))
			.willReturn(new PageImpl<>(new ArrayList<>()));
		BDDMockito.given(this.entrieRepository.findById(Mockito.anyLong())).willReturn(Optional.of(new Entrie()));
		BDDMockito.given(this.entrieRepository.save(Mockito.any(Entrie.class))).willReturn(new Entrie());
	}

	@Test
	public void testBuscarEntriePorFuncionarioId() {
		Page<Entrie> entrie = this.entrieService.buscarPorFuncionarioId(1L, PageRequest.of(0, 10));

		assertNotNull(entrie);
	}

	@Test
	public void testBuscarEntriePorId() {
		Optional<Entrie> entrie = this.entrieService.buscarPorId(1L);

		assertTrue(entrie.isPresent());
	}

	@Test
	public void testPersistirEntrie() {
		Entrie entrie = this.entrieService.persistir(new Entrie());

		assertNotNull(entrie);
	}
}
