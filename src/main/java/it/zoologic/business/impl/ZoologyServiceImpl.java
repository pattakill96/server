package it.zoologic.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.domain.JpaSort;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.zoologic.business.BusinessException;
import it.zoologic.business.ZoologyService;
import it.zoologic.business.impl.repositories.*;
import it.zoologic.domain.*;

@Service
@Transactional
public class ZoologyServiceImpl implements ZoologyService {

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private UtenteRepository utenteRepository;

	@Autowired
	private SpecieRepository specieRepository;

	@Autowired
	private GenereRepository genereRepository;

	@Autowired
	private ArticoloRepository articoloRepository;
	
	@Autowired
	private ArgomentoRepository argomentoRepository;

	@Autowired
	private AreaGeograficaRepository areageograficaRepository;

	@Override
	public Utente findUtenteByUsername(String username) throws BusinessException {
		return utenteRepository.findByUsername(username);
	}

	@Override
	public List<Utente> findAllUtenti() throws BusinessException {
		return utenteRepository.findAll(JpaSort.unsafe(Direction.DESC, "id"));
	}

	@Override
	public List<Specie> findAllSpecie() throws BusinessException {
		return specieRepository.findAll(JpaSort.unsafe(Direction.DESC, "id"));
	}

	@Override
	public Utente updateProfilo(Utente profilo) throws BusinessException {
		Utente utente = utenteRepository.findByUsername(profilo.getUsername());
		utente.setEmail(profilo.getEmail());
		utente.setNome(profilo.getNome());
		utente.setPassword(passwordEncoder.encode(profilo.getPassword()));
		utente.setCognome(profilo.getCognome());
		utente.setTelefono(profilo.getTelefono());
		return utente;
	}

	@Override
	public List<AreaGeografica> findAllAreas() throws BusinessException{
		return areageograficaRepository.findAll(JpaSort.unsafe(Direction.ASC, "area"));
	}

	@Override
	public List<Genere> findAllGeneres() throws BusinessException {
		return genereRepository.findAll(JpaSort.unsafe(Direction.ASC, "id"));
	}

	@Override
	public List<Argomento> findAllArgomenti() throws BusinessException {
		return argomentoRepository.findAll(JpaSort.unsafe(Direction.ASC, "id"));
	}

	@Override
	public List<Articolo> findAllArticoli() throws BusinessException{
		return articoloRepository.findAll(JpaSort.unsafe(Direction.ASC, "id"));
	}

	@Override
	public List<Specie> findAllSpecies(long id) throws BusinessException {
		return specieRepository.findSpecieByGenereId(id);
	}

	@Override
	public void createArticolo(Articolo Articolo) throws BusinessException {
		articoloRepository.save(Articolo);		
	}

	@Override
	public void createUtente(Utente utente) throws BusinessException {
		utenteRepository.save(utente);		
	}

	@Override
	public Articolo findArticoloById(long id) throws BusinessException {
		return articoloRepository.findById(id).get();
	}

	@Override
	public void updateArticolo(Articolo Articolo) throws BusinessException {
		articoloRepository.save(Articolo);
	}

	@Override
	public void deleteArticolo(long idArticolo) throws BusinessException {
		articoloRepository.deleteById(idArticolo);
		
	}

}
