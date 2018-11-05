package it.zoologic.presentation;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.zoologic.business.ZoologyService;
import it.zoologic.domain.Articolo;

@RestController
@RequestMapping("/api/articoli")
public class RESTArticoliController {

	
	@Autowired
	private ZoologyService service;
	
	@GetMapping
	public List<Articolo> list() {
		return service.findAllArticoli();
	}

	@GetMapping("/{idArticolo}")
	public Articolo findArticoloById(@PathVariable long idArticolo) {
		return service.findArticoloById(idArticolo);
	}

	@PostMapping
	public void createArticolo(@RequestBody Articolo Articolo) {
		service.createArticolo(Articolo);
	}
	
	@PutMapping
	public void updateArticolo(@RequestBody Articolo Articolo) {
		service.updateArticolo(Articolo);
	}
	
	@DeleteMapping("/{idArticolo}")
	public void deleteArticolo( @PathVariable long idArticolo) {
		service.deleteArticolo(idArticolo);
	}
}
