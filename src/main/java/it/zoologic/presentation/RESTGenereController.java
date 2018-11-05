package it.zoologic.presentation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.zoologic.business.ZoologyService;
import it.zoologic.domain.Genere;
import it.zoologic.domain.Specie;

@RestController
@RequestMapping("/api/genere")
public class RESTGenereController {

	@Autowired
	private ZoologyService service;
	
	@GetMapping
	public List<Genere> list() {
		return service.findAllGeneres();
	}
	
	@GetMapping("/{id}/specie")
	public List<Specie> list(@PathVariable long id) {
		return service.findAllSpecies(id);
	}
	
	
}
