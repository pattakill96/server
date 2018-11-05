package it.zoologic.business.impl.repositories;

import java.util.List;

import org.springframework.data.domain.Sort;

import org.springframework.data.jpa.repository.JpaRepository;

import it.zoologic.domain.Specie;;

public interface SpecieRepository extends JpaRepository<Specie, Long>{
	
    List<Specie> findAll(Sort sort);

    List<Specie> findSpecieByGenereId(Long id);

}
