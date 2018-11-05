package it.zoologic.business.impl.repositories;

import java.util.List;

import org.springframework.data.domain.Sort;

import org.springframework.data.jpa.repository.JpaRepository;

import it.zoologic.domain.Argomento;

public interface ArgomentoRepository extends JpaRepository<Argomento, Long>{

	List<Argomento> findAll(Sort sort);

}
