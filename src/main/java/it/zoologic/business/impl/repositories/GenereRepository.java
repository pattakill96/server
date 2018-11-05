package it.zoologic.business.impl.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import it.zoologic.domain.Genere;

public interface GenereRepository extends JpaRepository<Genere, Long>{

	List<Genere> findAll();

}
