package it.zoologic.business.impl.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import it.zoologic.domain.Utente;

public interface UtenteRepository extends JpaRepository<Utente, Long> {

	Utente findByUsername(String username);
}
