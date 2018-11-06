package it.zoologic.business;

import java.util.List;

import it.zoologic.domain.*;

public interface ZoologyService {

	List<Utente> findAllUtenti() throws BusinessException;

	Utente findUtenteByUsername(String username) throws BusinessException;

	Utente updateProfilo(Utente utente) throws BusinessException;

	List<Specie> findAllSpecie() throws BusinessException;

	// Specie findSpecieById(Long id) throws BusinessException;

	List<Genere> findAllGeneres() throws BusinessException;

	List<Specie> findAllSpecies(long id) throws BusinessException;

	List<AreaGeografica> findAllAreas() throws BusinessException;

	List<Argomento> findAllArgomenti() throws BusinessException;

	void createArticolo(Articolo articolo) throws BusinessException;

	Articolo findArticoloById(long id) throws BusinessException;

	List<Articolo> findAllArticoli() throws BusinessException;

	void updateArticolo(Articolo articolo) throws BusinessException;

	void deleteArticolo(long idArticolo) throws BusinessException;

}
