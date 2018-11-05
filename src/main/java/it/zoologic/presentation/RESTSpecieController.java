package it.zoologic.presentation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.zoologic.business.ZoologyService;
import it.zoologic.domain.Specie;;

@RestController
@RequestMapping("/api/specie")
public class RESTSpecieController {
	
	@Autowired
	private ZoologyService service;
	
	@GetMapping
	public List<Specie> list() {
		return service.findAllSpecie();
	}
	
	

}
