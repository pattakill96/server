package it.zoologic.business.impl.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import it.zoologic.domain.Articolo;

public interface ArticoloRepository extends JpaRepository<Articolo, Long>{

	Articolo findArticoloById(long id);

}
